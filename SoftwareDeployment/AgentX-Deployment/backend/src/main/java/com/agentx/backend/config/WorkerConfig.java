package com.agentx.backend.config;

import com.agentx.infrastructure.queue.JobQueue;
import com.agentx.infrastructure.worker.JobWorkerPool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkerConfig {

    @Bean
    public JobWorkerPool jobWorkerPool(JobQueue queue) {
        return new JobWorkerPool(queue, 3);
    }
}