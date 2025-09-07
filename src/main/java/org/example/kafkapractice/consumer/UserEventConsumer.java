package org.example.kafkapractice.consumer;

import lombok.extern.slf4j.Slf4j;
import org.example.kafkapractice.message.UserEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserEventConsumer {

    @KafkaListener(topics = "user-events", groupId = "group1")
    public void consumeUserEvent(UserEvent userEvent,
                                 @Header(KafkaHeaders.RECEIVED_KEY) String key,
                                 @Header(KafkaHeaders.RECEIVED_PARTITION) int partition) {
        log.info("Received event from user {} (partition {}): {}", key, partition, userEvent.toString());
    }
}
