package com.ivan.rabbitmq.pojo;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang3.SerializationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class QueueConsumer extends EndPoint implements Runnable, Consumer {

    private static final Logger logger = LoggerFactory.getLogger(QueueConsumer.class);

    public QueueConsumer(String endPointName) throws IOException, TimeoutException {
        super(endPointName);
    }

    public void run() {
        try {
            //start consuming messages. Auto acknowledge messages.
            channel.basicConsume(endPointName, true, this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Called when consumer is registered.
     */
    public void handleConsumeOk(String consumerTag) {

        System.out.println("Consumer " + consumerTag + " registered");
    }

    public void handleCancel(String consumerTag) {
    }

    public void handleCancelOk(String consumerTag) {
    }

    public void handleRecoverOk(String consumerTag) {
    }

    public void handleDelivery(String s, Envelope envelope, AMQP.BasicProperties basicProperties, byte[] bytes) throws IOException {

        Map<String, Object> map = SerializationUtils.deserialize(bytes);
    }

    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {

    }
}