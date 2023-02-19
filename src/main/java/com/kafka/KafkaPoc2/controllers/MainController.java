package com.kafka.KafkaPoc2.controllers;

import com.kafka.KafkaPoc2.model.Session;
import com.kafka.KafkaPoc2.model.Speaker;
import com.kafka.KafkaPoc2.repos.SessionRepository;
import com.kafka.KafkaPoc2.repos.SpeakerRepository;
import com.kafka.KafkaPoc2.services.SessionService;
import com.kafka.KafkaPoc2.services.SpeakerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MainController {

    private SpeakerRepository speakerRepository;
    private SessionRepository sessionRepository;
    private SpeakerService speakerService;
    private SessionService sessionService;

    public MainController(SpeakerRepository speakerRepository, SessionRepository sessionRepository, SpeakerService speakerService, SessionService sessionService) {
        this.speakerRepository = speakerRepository;
        this.sessionRepository = sessionRepository;
        this.speakerService = speakerService;
        this.sessionService = sessionService;
    }

    @GetMapping("/speakers/all")
    Flux<Speaker> findAllSpeakers(){
        return speakerService.findAllSpeakers();
    }

    @GetMapping("/speakers")
    Mono<Speaker> findSpeakerById(@RequestParam int id) {
        return speakerService.findSpeakerAndSessionById(id);
    }

    @GetMapping("sessions/all")
    Flux<Session> findAllSessions(){
        return sessionRepository.findAll();
    }

    @GetMapping("sessions/{id}")
    Mono<Session> findSessionById(@PathVariable int id){
        return sessionRepository.findById(id);
    }

    @PostMapping("speakers/create")
    Mono<Speaker> createSpeaker(@RequestBody Speaker speaker){
        return speakerService.createSpeaker(speaker);
    }
}
