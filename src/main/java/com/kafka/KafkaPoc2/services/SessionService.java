package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Session;
import com.kafka.KafkaPoc2.repos.SessionRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SessionService {

    private SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public Flux<Session> findAllSessionsBySpeakerId(int speakerId){
        return sessionRepository.findBySpeakerId(speakerId);
    }
}
