package com.mkalaimalai.product_service;

import com.mkalaimalai.product_service.domain.event.ProductCreateEvent;
import org.apache.http.HttpHost;
import org.apache.kafka.clients.admin.NewTopic;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.UUID;

@SpringBootApplication
@EnableElasticsearchRepositories
public class ProductServiceApplication  implements CommandLineRunner {

    @Value("${spring.kafka.topic}")
    public String topic;

    @Autowired
    KafkaTemplate kafkaTemplate;

    @Bean
    public NewTopic productEvents() {
        return TopicBuilder.name(topic).partitions(3).replicas(3).build();
    }

    @Bean
    public RestHighLevelClient client() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("localhost", 9200, "http")));
    }


    public void run(String... args) throws Exception {
        System.out.println("topic-->"+topic);
        this.kafkaTemplate.send("product-events", "productId", new ProductCreateEvent(UUID.randomUUID(),  null));
        this.kafkaTemplate.send("product-events", "productId", new ProductCreateEvent(UUID.randomUUID(), null));
    }

    public static void main(String[] args) {

        SpringApplication.run(ProductServiceApplication.class, args);
    }

}
