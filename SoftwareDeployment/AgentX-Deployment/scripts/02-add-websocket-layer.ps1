New-Item -ItemType Directory -Force -Path "backend/src/main/java/com/agentx/backend/ws"

@"
package com.agentx.backend.ws;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.*;

@Configuration
@EnableWebSocketMessageBroker
public class WSConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").setAllowedOrigins("*");
    }
}
"@ | Out-File backend/src/main/java/com/agentx/backend/ws/WSConfig.java

@"
package com.agentx.backend.ws;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class EventPublisher {

    private final SimpMessagingTemplate ws;

    public EventPublisher(SimpMessagingTemplate ws) {
        this.ws = ws;
    }

    public void publish(String msg) {
        ws.convertAndSend("/topic/events", msg);
    }
}
"@ | Out-File backend/src/main/java/com/agentx/backend/ws/EventPublisher.java
