package com.kafka.KafkaPoc2.repos;

import com.kafka.KafkaPoc2.model.Speaker;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SpeakerRepository extends ReactiveMongoRepository<Speaker,Integer> {

}
