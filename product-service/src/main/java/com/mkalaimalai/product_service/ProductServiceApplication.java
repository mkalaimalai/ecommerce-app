package com.mkalaimalai.product_service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.TopicBuilder;

@SpringBootApplication
public class ProductServiceApplication {

    @Value("${spring.kafka.topic}")
    public String topic;

    @Bean
    public NewTopic productEvents() {

        return TopicBuilder.name(topic).partitions(3).replicas(3).build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
