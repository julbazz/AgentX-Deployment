package com.agentx.domain.port;

import com.agentx.domain.model.Job;

import java.util.List;

public interface JobRepository {

    void save(Job job);

    List<Job> findAll();
}