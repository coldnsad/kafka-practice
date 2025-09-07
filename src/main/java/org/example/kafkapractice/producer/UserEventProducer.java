package org.example.kafkapractice.producer;

import lombok.RequiredArgsConstructor;
import org.example.kafkapractice.message.UserEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserEventProducer {
    private final KafkaTemplate<String, UserEvent> kafkaTemplate;
    private static final String TOPIC = "user-events";

    public void sendEvent(UserEvent userEvent) {
        // Используем userId как ключ для гарантии порядка событий одного пользователя
        kafkaTemplate.send(TOPIC, userEvent.getUserId(), userEvent);
    }
}
