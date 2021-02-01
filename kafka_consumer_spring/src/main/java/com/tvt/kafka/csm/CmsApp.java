package com.tvt.kafka.csm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author TX
 * @date 2021/1/12 19:39
 */
@SpringBootApplication
public class CmsApp {
    private static Logger logger = LoggerFactory.getLogger(CmsApp.class);
    public static void main(String[] args) {
        SpringApplication.run(CmsApp.class, args);
    }
}
