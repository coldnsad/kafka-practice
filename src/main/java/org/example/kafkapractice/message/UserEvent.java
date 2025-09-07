package org.example.kafkapractice.message;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserEvent {
    public enum EventType{ CLICK, VIEW, IMPRESSION}
    private String userId;
    private EventType type;
    private String pageUrl;
    private LocalDateTime timestamp;
}
