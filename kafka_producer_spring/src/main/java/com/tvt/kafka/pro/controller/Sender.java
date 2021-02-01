package com.tvt.kafka.pro.controller;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.Properties;

/**
 * @author TX
 * @date 2021/1/12 20:09
 */
@RestController
public class Sender {

    private Logger logger = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate producer;

    private String topic = "DemoTp3";

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public String bindDevice(String key, String value) {
        ListenableFuture future = producer.send(topic, key.getBytes(), value.getBytes());
        future.addCallback(o -> logger.info(String.format("send: %s, key: %s, data: %s", topic, key, value)),
                e -> logger.error(String.format("send error: %s, key: %s, data: %s，原因：%s", topic, key, value, e.getCause())));
        return "[" + key + "]" + value;
    }
}
