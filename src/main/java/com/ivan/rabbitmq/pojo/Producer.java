package com.ivan.rabbitmq.pojo;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.concurrent.TimeoutException;

/**
 * Created by feiFan.gou on 2017/9/15 15:25.
 */
public class Producer extends EndPoint {

    public Producer(String endpointName) throws IOException, TimeoutException {

        super(endpointName);
    }

    public void sendMessage(Serializable object) throws IOException {

        channel.basicPublish("",endPointName, null,
                SerializationUtils.serialize(object));
    }
}
