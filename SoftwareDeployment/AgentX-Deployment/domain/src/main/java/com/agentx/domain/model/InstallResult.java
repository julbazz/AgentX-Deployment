package com.agentx.domain.model;

import java.time.LocalDateTime;

public class InstallResult {

    private final String software;
    private final JobStatus status;
    private final LocalDateTime timestamp;

    public InstallResult(String software, JobStatus status) {
        this.software = software;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getSoftware() {
        return software;
    }

    public JobStatus getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}