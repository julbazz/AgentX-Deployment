package com.agentx.domain.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Job {

    private final String id;
    private final List<Software> softwareList;
    private final List<InstallResult> results = new CopyOnWriteArrayList<>();

    private JobStatus status;

    public Job(String id, List<Software> softwareList) {
        this.id = id;
        this.softwareList = softwareList;
        this.status = JobStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public List<Software> getSoftwareList() {
        return softwareList;
    }

    public List<InstallResult> getResults() {
        return results;
    }

    public void addResult(InstallResult result) {
        results.add(result);
    }

    public JobStatus getStatus() {
        return status;
    }

    public void setStatus(JobStatus status) {
        this.status = status;
    }
}