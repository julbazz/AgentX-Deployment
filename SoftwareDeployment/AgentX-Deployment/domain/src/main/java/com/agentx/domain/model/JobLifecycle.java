package com.agentx.domain.model;

public class JobLifecycle {

    public static JobStatus start(Job job) {
        job.setStatus(JobStatus.RUNNING);
        return JobStatus.RUNNING;
    }

    public static JobStatus finish(Job job) {

        boolean failed = job.getResults().stream()
            .anyMatch(r -> r.getStatus() == JobStatus.FAILED);

        JobStatus result = failed ? JobStatus.FAILED : JobStatus.SUCCESS;

        job.setStatus(result);
        return result;
    }
}