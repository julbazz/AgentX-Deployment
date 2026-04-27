package com.agentx.backend.ws;

import com.agentx.domain.port.EventPort;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher implements EventPort {

    private final SimpMessagingTemplate ws;

    public EventPublisher(SimpMessagingTemplate ws) {
        this.ws = ws;
    }

    @Override
    public void publish(String msg) {
        ws.convertAndSend("/topic/events", msg);
    }
}









