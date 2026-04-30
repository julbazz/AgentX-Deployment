package com.agentx.backend.config;

import com.agentx.domain.port.JobRepository;
import com.agentx.infrastructure.queue.JobQueue;
import com.agentx.infrastructure.repository.InMemoryJobRepository;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CoreConfig {

    @Bean
    public JobRepository jobRepository() {
        return new InMemoryJobRepository();
    }

    @Bean
    public JobQueue jobQueue() {
        return new JobQueue();
    }
}