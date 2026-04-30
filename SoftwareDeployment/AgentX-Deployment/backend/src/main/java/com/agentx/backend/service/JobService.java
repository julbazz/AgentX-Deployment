package com.agentx.backend.service;

import com.agentx.domain.model.*;
import com.agentx.domain.port.JobRepository;
import com.agentx.infrastructure.queue.JobQueue;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class JobService {

    private final JobRepository repository;
    private final JobQueue queue;

    public JobService(JobRepository repository, JobQueue queue) {
        this.repository = repository;
        this.queue = queue;
    }

    public Job createJob(List<String> softwareNames) {

        List<Software> list = softwareNames.stream()
                .map(Software::new)
                .toList();

        Job job = new Job(UUID.randomUUID().toString(), list);

        repository.save(job);

        try {
            queue.enqueue(job);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Queue interrupted", e);
        }

        return job;
    }

    public List<Job> getAllJobs() {
        return repository.findAll();
    }
}