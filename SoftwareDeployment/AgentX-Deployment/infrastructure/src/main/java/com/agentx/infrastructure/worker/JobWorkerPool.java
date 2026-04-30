package com.agentx.infrastructure.worker;

import com.agentx.infrastructure.queue.JobQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobWorkerPool {

    private final ExecutorService executor;

    public JobWorkerPool(JobQueue queue, int size) {
        this.executor = Executors.newFixedThreadPool(size);

        for (int i = 0; i < size; i++) {
            executor.submit(new JobWorker(queue));
        }
    }

    public void shutdown() {
        executor.shutdownNow();
    }
}