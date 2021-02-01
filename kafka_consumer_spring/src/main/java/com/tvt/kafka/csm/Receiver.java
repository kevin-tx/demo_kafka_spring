package com.tvt.kafka.csm;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Properties;


/**
 * @author TX
 * @date 2021/1/13 9:40
 */

@Component
public class Receiver {

    private Logger logger = LoggerFactory.getLogger(Receiver.class);

    @KafkaListener(topics = {"DemoTp2", "DemoTp3"})
    public void receiveFromNat(ConsumerRecord<byte[], byte[]> record) {
        try {
            String data = new String(record.value(), StandardCharsets.UTF_8);
            String topic = record.topic();
            logger.debug(String.format("Received: topic=%s, partition=%s, offset=%d, key=%s, value=%s",
                    record.topic(),
                    record.partition(),
                    record.offset(),
                    new String(record.key(), StandardCharsets.UTF_8),
                    new String(record.value(), StandardCharsets.UTF_8)));
        } catch (Exception ex) {
            logger.error("", ex);
        }
    }
}
