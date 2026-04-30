package com.agentx.backend.lifecycle;

import com.agentx.infrastructure.worker.JobWorkerPool;

import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component
public class WorkerLifecycle {

    private final JobWorkerPool pool;

    public WorkerLifecycle(JobWorkerPool pool) {
        this.pool = pool;
    }

    @PreDestroy
    public void shutdown() {
        pool.shutdown();
    }
}