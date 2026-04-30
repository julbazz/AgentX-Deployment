package com.agentx.backend.api.dto;

import java.util.List;

public class CreateJobRequest {

    private List<String> software;

    public List<String> getSoftware() {
        return software;
    }

    public void setSoftware(List<String> software) {
        this.software = software;
    }
}