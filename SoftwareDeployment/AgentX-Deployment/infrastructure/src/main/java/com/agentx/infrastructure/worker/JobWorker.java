package com.agentx.infrastructure.worker;

import com.agentx.domain.model.*;
import com.agentx.infrastructure.queue.JobQueue;

public class JobWorker implements Runnable {

    private final JobQueue queue;

    public JobWorker(JobQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Job job = queue.take();
                job.setStatus(JobStatus.RUNNING);

                for (Software s : job.getSoftwareList()) {
                    job.addResult(new InstallResult(s.getName(), JobStatus.SUCCESS));
                }

                job.setStatus(JobStatus.SUCCESS);

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}