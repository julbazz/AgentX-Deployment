package com.agentx.infrastructure.repository;

import com.agentx.domain.model.Job;
import com.agentx.domain.port.JobRepository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class InMemoryJobRepository implements JobRepository {

    private final Map<String, Job> store = new ConcurrentHashMap<>();

    @Override
    public void save(Job job) {
        store.put(job.getId(), job);
    }

    @Override
    public List<Job> findAll() {
        return new ArrayList<>(store.values());
    }
}