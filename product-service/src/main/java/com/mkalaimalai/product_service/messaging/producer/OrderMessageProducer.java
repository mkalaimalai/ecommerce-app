package com.mkalaimalai.product_service.messaging.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mkalaimalai.product_service.domain.event.ProductCreateEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


@Component
@Slf4j
public class OrderMessageProducer {

    @Value("${spring.kafka.topic}")
    public String topic;

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public OrderMessageProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public CompletableFuture<SendResult<String, String>> sendLibraryEvent(ProductCreateEvent productCreateEvent) throws JsonProcessingException {
        var key = productCreateEvent.getProductId().toString();
        var value = objectMapper.writeValueAsString(productCreateEvent);

        // 1. blocking call - get metadata about the kafka cluster
        //2.Send message happens - Returns a CompletableFuture
        var completableFuture = kafkaTemplate.send(topic, key, value);

        return completableFuture
                .whenComplete((sendResult, throwable) -> {
                    if (throwable != null) {
                        handleFailure(key, value, throwable);
                    } else {
                        handleSuccess(key, value, sendResult);
                    }
                });

    }

    public CompletableFuture<SendResult<String, String>> sendLibraryEvent_approach3(ProductCreateEvent productCreateEvent) throws JsonProcessingException {
        var key = productCreateEvent.getProductId().toString();
        var value = objectMapper.writeValueAsString(productCreateEvent);

        var producerRecord = buildProducerRecord(key, value);
        // 1. blocking call - get metadata about the kafka cluster
        //2.Send message happens - Returns a CompletableFuture
        var completableFuture = kafkaTemplate.send(producerRecord);

        return completableFuture
                .whenComplete((sendResult, throwable) -> {
                    if (throwable != null) {
                        handleFailure(key, value, throwable);
                    } else {
                        handleSuccess(key, value, sendResult);
                    }
                });

    }

    private ProducerRecord<String, String> buildProducerRecord(String key, String value) {

        List<Header> recordHeaders = List.of(new RecordHeader("event-source", "scanner".getBytes()));

        return new ProducerRecord<>(topic, null, key, value, recordHeaders);
    }

    public SendResult<String, String> sendLibraryEvent_approach2(ProductCreateEvent productCreateEvent)
            throws JsonProcessingException, ExecutionException, InterruptedException, TimeoutException {
        var key = productCreateEvent.getProductId().toString();
        var value = objectMapper.writeValueAsString(productCreateEvent);

        // 1. blocking call - get metadata about the kafka cluster
        //2. Block and wait until the message is sent to the Kafka
        var sendResult = kafkaTemplate.send(topic, key, value)
                //.get();
                .get(3, TimeUnit.SECONDS);
        handleSuccess(key, value, sendResult);
        return sendResult;

    }

    private void handleSuccess(String key, String value, SendResult<String, String> sendResult) {
        log.info("Message Sent Successfully for the key : {} and the value : {} , partition is {} ",
                key, value, sendResult.getRecordMetadata().partition());
    }

    private void handleFailure(String key, String value, Throwable ex) {
        log.error("Error sending the message and the exception is {} ", ex.getMessage(), ex);
    }
}

