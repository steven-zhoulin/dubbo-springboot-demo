package com.topsail.crm.demo;

import com.topsail.crm.UpcApplication;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Steven
 * @date 2020-01-08
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UpcApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MpCityTest {

    @Test
    public void testSaveRandomCity() {

    }

}
