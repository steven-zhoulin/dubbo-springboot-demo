package com.topsail.crm.order.framework.harley.factory;

import com.asiainfo.areca.framework.scan.ClassFinder;
import com.asiainfo.areca.framework.scan.IClassGenerator;
import com.asiainfo.areca.framework.util.ArrayUtils;
import com.asiainfo.areca.framework.util.SpringContextUtils;
import com.topsail.crm.order.framework.harley.annotation.Plus;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.interfaces.IPlus;
import com.topsail.crm.order.framework.harley.utils.SPELExecutor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @program: crm-V0
 * @description: 插件工厂类
 * @author: jinnian
 * @create: 2020-01-19 18:40
 **/
@Slf4j
@Component
public class PlusFactory {

    private static Map<String, IPlus> cache = new HashMap<>();

    static {
        try {
            ClassFinder classFinder = SpringContextUtils.getBean(ClassFinder.class);
            classFinder.loadClasses("com.topsail.crm.order.business.order", "file:*Plus", new IClassGenerator() {

                @Override
                public void create(String className) throws Exception {
                    if (cache.containsKey(className)) {
                        return;
                    }

                    Class clazz = Class.forName(className);
                    if (!IPlus.class.isAssignableFrom(clazz)) {
                        return;
                    }
                    Plus plusAnnotation = (Plus) clazz.getDeclaredAnnotation(Plus.class);
                    if (plusAnnotation == null) {
                        return;
                    }

                    IPlus instance = (IPlus) clazz.newInstance();
                    cache.put(className, instance);
                }

                /**
                 * 指定模糊匹配的jar文件名，开发模式不需要
                 *
                 * @return
                 */
                @Override
                public String[] getJars() {
                    return null;
                }
            });
        } catch (Exception e) {
            log.error("plus config load error", e);
        }

    }

    /**
     * 获取处理器运行之后的插件
     *
     * @param jobContext
     * @return
     * @throws Exception
     */
    public static List<IPlus> getPluses(JobContext jobContext, Plus.PlusType type) throws Exception {
        List<IPlus> pluses = new ArrayList<IPlus>();

        Collection<IPlus> plugins = cache.values();
        if (plugins == null || plugins.size() <= 0) {
            return pluses;
        }

        Databus databus = DatabusManager.getDatabus();
        String currentBusiItemCode = jobContext.getBusiItemConfig().getBusiItemCode();
        String currentBusiCode = databus.getBusiCode();

        SPELExecutor executor = new SPELExecutor();
        executor.parse(jobContext);

        for (IPlus plugin : plugins) {
            Plus plusAnnotation = plugin.getClass().getDeclaredAnnotation(Plus.class);

            String busiItemCode = plusAnnotation.busiItemCode();
            String busiCode = plusAnnotation.busiCode();
            String spel = plusAnnotation.spel();

            if ((StringUtils.equals("-1", busiItemCode) || StringUtils.equals(currentBusiItemCode, busiItemCode)) && (StringUtils.equals("-1", busiCode) || StringUtils.equals(currentBusiCode, busiCode))) {
                if (StringUtils.isNotBlank(spel)) {
                    boolean isMatch = executor.executeBool(spel);
                    if (!isMatch) {
                        continue;
                    }
                }

                pluses.add(plugin);
            }
        }

        if (ArrayUtils.isNotEmpty(pluses)) {
            Collections.sort(pluses, new Comparator<IPlus>() {
                @Override
                public int compare(IPlus one, IPlus another) {
                    Plus plusAnnotation = one.getClass().getDeclaredAnnotation(Plus.class);
                    Plus anotherPlusAnnotation = another.getClass().getDeclaredAnnotation(Plus.class);

                    int execNo = plusAnnotation.execNo();
                    int anotherExecNo = anotherPlusAnnotation.execNo();

                    if (execNo > anotherExecNo) {
                        return 1;
                    } else if (execNo < anotherExecNo) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        }
        return pluses;
    }
}
