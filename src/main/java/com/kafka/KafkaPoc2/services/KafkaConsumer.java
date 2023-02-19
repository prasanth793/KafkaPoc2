package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Speaker;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {


    @KafkaListener(topics = "speakers-json",groupId = "speakers-group")
    public void consume(Message<Speaker> speakerMessage){


        System.out.println("Message received: "+speakerMessage.getPayload());

        var res = speakerMessage.getPayload();

        System.out.println(res.toString());

    }

}
