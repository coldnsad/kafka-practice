package org.example.kafkapractice.controller;

import lombok.AllArgsConstructor;
import org.example.kafkapractice.message.UserEvent;
import org.example.kafkapractice.producer.UserEventProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
public class UserEventController {

    private final UserEventProducer userEventProducer;

    @PostMapping("/event")
    public String createEvent(@RequestBody UserEvent userEvent) {
        userEvent.setTimestamp(LocalDateTime.now());
        userEventProducer.sendEvent(userEvent);
        return "Event sent to Kafka";
    }
}
