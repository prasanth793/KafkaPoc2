package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Speaker;
import com.kafka.KafkaPoc2.repos.SessionRepository;
import com.kafka.KafkaPoc2.repos.SpeakerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class SpeakerService {

    private SpeakerRepository speakerRepository;
    private SessionRepository sessionRepository;

    public SpeakerService(SpeakerRepository speakerRepository, SessionRepository sessionRepository) {
        this.speakerRepository = speakerRepository;
        this.sessionRepository = sessionRepository;
    }

    public Flux<Speaker> findAllSpeakers(){
        return speakerRepository.findAll().flatMap(speaker -> sessionRepository.findBySpeakerId(speaker.getId())
                .collectList()
                .map(sessions -> {
                    speaker.setSessions(sessions);
                    return speaker;
                }));
    }
}
