package com.agentx.infrastructure.queue;

import com.agentx.domain.model.Job;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class JobQueue {

    private final BlockingQueue<Job> queue = new LinkedBlockingQueue<>();

    public void enqueue(Job job) throws InterruptedException {
        queue.put(job);
    }

    public Job take() throws InterruptedException {
        return queue.take();
    }
}