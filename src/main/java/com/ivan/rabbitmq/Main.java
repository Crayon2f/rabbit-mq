package com.ivan.rabbitmq;

import com.google.common.collect.Maps;
import com.ivan.rabbitmq.pojo.Producer;
import com.ivan.rabbitmq.pojo.QueueConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public Main() throws Exception {

        QueueConsumer consumer = new QueueConsumer("queue");
        Thread consumerThread = new Thread(consumer);
        consumerThread.start();
        Producer producer = new Producer("queue");

        for (int i = 0; i < 100; i++) {
            if (i % 10 == 0) {
                System.out.println(i);
            }
            HashMap<String, Object> message = Maps.newHashMap();
            message.put("message number", i);
            producer.sendMessage(message);
            logger.info("Message Number " + i + " sent.");
        }
    }

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new Main();
    }
}