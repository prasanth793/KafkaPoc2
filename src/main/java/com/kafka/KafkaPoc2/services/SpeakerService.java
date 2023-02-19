package com.kafka.KafkaPoc2.services;

import com.kafka.KafkaPoc2.model.Session;
import com.kafka.KafkaPoc2.model.Speaker;
import com.kafka.KafkaPoc2.repos.SessionRepository;
import com.kafka.KafkaPoc2.repos.SpeakerRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.stream.Collectors;

@Service
public class SpeakerService {

    private SpeakerRepository speakerRepository;
    private SessionRepository sessionRepository;
    private SessionService sessionService;

    public SpeakerService(SpeakerRepository speakerRepository, SessionRepository sessionRepository, SessionService sessionService) {
        this.speakerRepository = speakerRepository;
        this.sessionRepository = sessionRepository;
        this.sessionService = sessionService;
    }

    public Flux<Speaker> findAllSpeakers(){
        return speakerRepository.findAll().flatMap(speaker -> sessionService.findAllSessionsBySpeakerId(speaker.getId())
                .collectList()
                .map(sessions -> {
                    speaker.setSessions(sessions.stream().peek(Session::build).collect(Collectors.toList()));
                    return speaker;
                }));
    }

    public Mono<Speaker> findSpeakerAndSessionById(int speakerId){
        return speakerRepository.findById(speakerId).flatMap(speaker -> sessionService.findAllSessionsBySpeakerId(speakerId)
                .collectList()
                .map(sessions -> {
                    speaker.setSessions(sessions.stream().peek(Session::build).collect(Collectors.toList()));
                    return speaker;
                }));
    }

    public Mono<Speaker> createSpeaker(Speaker speaker){
        return speakerRepository.save(speaker).switchIfEmpty(Mono.just(new Speaker()));
    }
}
