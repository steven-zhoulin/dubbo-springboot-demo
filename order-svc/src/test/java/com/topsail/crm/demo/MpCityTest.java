package com.topsail.crm.demo;

import com.asiainfo.areca.framework.database.service.IDualService;
import com.topsail.crm.order.OrderApplication;
import com.topsail.crm.order.cell.demo.sequence.ImpExpLogSeq;
import com.topsail.crm.order.cell.demo.sequence.OmOrderSeq;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Steven
 * @date 2020-01-08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MpCityTest {

    @Autowired
    private ImpExpLogSeq impExpLogSeq;

    @Autowired
    private OmOrderSeq omOrderSeq;

    @Autowired
    private IDualService dualService;

    @Test
    public void testSaveRandomCity() {

        for (int i = 0; i < 10; i++) {
            // 业务自己实现序列类，自定义序列格式规则
            log.info("SEQ_IMPEXP_LOG => {}", impExpLogSeq.nextval());
            log.info("OM_ORDER$SEQ   => {}", omOrderSeq.nextval());
        }

        for (int i = 0; i < 10; i++) {
            // 业务自己实现序列类，自定义序列格式规则
            log.info("SEQ_IMPEXP_LOG => {}", dualService.nextval(ImpExpLogSeq.class));
            log.info("OM_ORDER$SEQ   => {}", dualService.nextval(OmOrderSeq.class));
        }

        for (int i = 0; i < 10; i++) {
            // 获取原始数据库序列
            log.info("OM_ORDER$SEQ:   {}", dualService.nextval("base", "SEQ_IMPEXP_LOG"));
            log.info("OM_ORDER$SEQ:   {}", dualService.nextval("crm1", "OM_ORDER$SEQ"));
        }
    }

}
