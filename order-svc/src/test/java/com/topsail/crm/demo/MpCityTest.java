package com.topsail.crm.demo;

import com.asiainfo.areca.framework.database.service.IDualService;
import com.topsail.crm.order.OrderApplication;
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
    private IDualService dualService;

    @Test
    public void testSaveRandomCity() {
        for (int i = 0; i < 20; i++) {
            log.info("OM_ORDER$SEQ:   {}", dualService.nextval("crm1", "OM_ORDER$SEQ"));
            log.info("SEQ_IMPEXP_LOG: {}", dualService.nextval("base", "SEQ_IMPEXP_LOG"));
        }
    }

}
