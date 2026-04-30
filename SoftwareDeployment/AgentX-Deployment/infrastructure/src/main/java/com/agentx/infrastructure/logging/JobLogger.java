package com.agentx.infrastructure.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JobLogger {

    private static final Logger log = LoggerFactory.getLogger(JobLogger.class);

    public void started(String jobId) {
        log.info("[JOB STARTED] {}", jobId);
    }

    public void software(String jobId, String sw) {
        log.info("[INSTALL] {} -> {}", jobId, sw);
    }

    public void failed(String jobId, String sw, String err) {
        log.error("[FAILED] {} -> {} : {}", jobId, sw, err);
    }

    public void finished(String jobId, String status) {
        log.info("[DONE] {} -> {}", jobId, status);
    }
}
