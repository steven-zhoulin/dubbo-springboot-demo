package com.topsail.crm.order.framework.harley.runtime.workstation;

import com.asiainfo.areca.framework.data.BaseEntity;
import com.asiainfo.areca.framework.util.ArrayUtils;
import com.asiainfo.areca.framework.util.MapUtils;
import com.asiainfo.areca.framework.util.SpringContextUtils;
import com.asiainfo.areca.framework.util.TimeUtils;
import com.topsail.crm.order.cell.order.entity.dto.OrderRequestDTO;
import com.topsail.crm.order.cell.order.entity.dto.OrderResponseDTO;
import com.topsail.crm.order.cell.order.entity.po.OmLine;
import com.topsail.crm.order.cell.order.entity.po.OmOrder;
import com.topsail.crm.order.cell.order.service.IOmOrderService;
import com.topsail.crm.order.cell.order.service.impl.OmOrderServiceImpl;
import com.topsail.crm.order.framework.harley.annotation.Workstation;
import com.topsail.crm.order.framework.harley.context.Databus;
import com.topsail.crm.order.framework.harley.context.DatabusManager;
import com.topsail.crm.order.framework.harley.context.Environment;
import com.topsail.crm.order.framework.harley.context.JobContext;
import com.topsail.crm.order.framework.harley.domain.cust.Customer;
import com.topsail.crm.order.framework.harley.domain.order.LineData;
import com.topsail.crm.order.framework.harley.domain.order.OrderData;
import com.topsail.crm.order.framework.harley.domain.user.ScaKernel;
import com.topsail.crm.order.framework.harley.interfaces.IWorkstation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: crm
 * @description: 数据库工位，将订单数据入库
 * @author: jinnian
 * @create: 2020-01-20 10:26
 **/
@Slf4j
@Workstation
public class OrderDatabaseWorkstation implements IWorkstation {

    @Override
    public void operate(OrderRequestDTO request, OrderResponseDTO response) {
        Databus databus = DatabusManager.getDatabus();
        this.saveOrder(databus);

    }

    /**
     * 保存订单
     * @param databus
     */
    public void saveOrder(Databus databus) {
        OmOrder order = this.processOrder(databus);
        IOmOrderService orderService = SpringContextUtils.getBean(OmOrderServiceImpl.class);
        orderService.save(order);
        this.saveOrderItems(databus);
    }

    public <T extends BaseEntity> void saveOrderItems(Databus databus) {
        OrderData orderData = databus.getOrderData();
        List<LineData> lines = orderData.getLines();
        if (ArrayUtils.isEmpty(lines)) {
            return;
        }

        for (LineData line : lines) {
            Map<String, List<T>> orderItems = line.getOrderItems();
            if (MapUtils.isEmpty(orderItems)) {
                continue;
            }
            Set<String> keys = orderItems.keySet();
            for (String key : keys) {
                List<T> items = orderItems.get(key);

                if (ArrayUtils.isEmpty(items)) {
                    continue;
                }
                this.fillLineMetaData(line, items, key);
                this.invokeSaveMethod(key, items);
            }
        }
    }

    /**
     * 客户订单保存
     * @param databus
     * @throws Exception
     */
    private OmOrder processOrder(Databus databus) {
        List<JobContext> jobContexts = databus.getJobContexts();
        if (ArrayUtils.isEmpty(jobContexts)) {
            return null;
        }
        Environment env = databus.getEnvironment();
        JobContext firstJobContext = jobContexts.get(0);
        OmOrder orderData = databus.getOrderData().getOrder();

        ScaKernel sca = firstJobContext.getSca();
        String channel = env.getChannel();

        orderData.setPartitionId(1);
        orderData.setBusiCode("1");
        orderData.setOrderStatus("0");
        orderData.setPriority(0);

        orderData.setInModeCode(channel);
        orderData.setApplyChannel(channel);
        orderData.setPartitionId(1);

        orderData.setValidDate(databus.getAcceptTime());
        orderData.setExpireDate(TimeUtils.stringToLocalDateTime("2050-12-31 23:59:59", TimeUtils.TIME_PATTERN));

        orderData.setBatchId(new Long(0));

        Customer customer = sca.getCustomer();
        if (customer == null) {
            orderData.setPartyRoleId(new Long(0));
        } else {
            orderData.setPartyRoleId(sca.getCustId());
        }
        orderData.setPartyName(customer.getCustName());
        orderData.setMgmtDistrict(sca == null ? env.getDistrict() : sca.getSubscriber().getMgmtDistrict());
        orderData.setMgmtCounty(sca == null ? env.getCountry(): sca.getSubscriber().getMgmtCounty());
        orderData.setDataStatus("1");
        orderData.setOmItemId(1L);

        //设置orderType
        orderData.setOrderType("0");
        orderData.setCancelFlag("0");
        return orderData;
    }

    private <T extends BaseEntity> void invokeSaveMethod(String poClassName, List<T> items) {
        String serviceClassName = poClassName.replaceAll(".entity.po.", ".service.impl.")+"ServiceImpl";
        try {
            Class clazz = Class.forName(serviceClassName);
            Class poClass = Class.forName(poClassName);
            Object object = SpringContextUtils.getBean(clazz);

            Method method = clazz.getMethod("saveBatch", Collection.class);
            method.invoke(object, items);
        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            //todo 抛异常
            log.error("error", e);
        }
    }

    private <T extends BaseEntity> void fillLineMetaData(LineData data, List<T> items, String entityClassName) {
        if (StringUtils.equals("com.topsail.crm.order.cell.order.entity.po.OmLine", entityClassName)) {
            return;
        }

        try {
            T first = items.get(0);
            for (T item : items) {
                Method method = first.getClass().getMethod("setOrderLineId", Long.class);
                method.invoke(item, data.getOrderLineId());

                method = first.getClass().getMethod("setOrderId", Long.class);
                method.invoke(item, data.getLine().getOrderId());

                method = first.getClass().getMethod("setOmItemId", Long.class);
                method.invoke(item, data.getLine().getOrderId());

                method = first.getClass().getMethod("setDataStatus", Long.class);
                method.invoke(item, 1L);
            }
        } catch (Exception e) {
            //todo 处理异常
        }
    }
}
