package com.mkalaimalai.product_service.message.consumer;


import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductMessageConsumer {

//    @Autowired
//    ProductSearchRepository productSearchRepositoryroductSearchRepository;

    @KafkaListener(
            topics = {"product-events"}
            , autoStartup = "${libraryListener.startup:true}"
            , groupId = "product-events-listener-group")
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
//        productSearchRepositoryroductSearchRepository.save(null);

        log.info("Consumer Product Record : {} ", consumerRecord);
    }

}
