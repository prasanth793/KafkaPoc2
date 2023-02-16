package com.kafka.KafkaPoc2.repos;

import com.kafka.KafkaPoc2.model.Session;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface SessionRepository extends ReactiveMongoRepository<Session,Integer> {

    Flux<Session> findBySpeakerId(int speakerId);
}
