package com.ivan.rabbitmq.slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.junit.Test;

/**
 * Created by feiFan.gou on 2017/9/15 17:23.
 */
public class LogTest {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {

        if (logger.isDebugEnabled()) {
            logger.debug("1 + 1 = {},2+2={}", 1 + 1, 2 + 2);
        }
        logger.info("info level ");
    }


}
