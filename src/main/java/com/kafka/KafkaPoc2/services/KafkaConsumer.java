package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "products-topic-json-new",groupId = "product-group")
    public void consume(Message<Product> productMessage){

        System.out.println("Message received: "+productMessage.getPayload());

        var res = productMessage.getPayload();

        System.out.println(res.toString());

    }

}
