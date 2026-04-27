package com.agentx.application.usecase;

import com.agentx.domain.model.Software;
import com.agentx.domain.port.EventPort;

import java.util.List;

public class InstallPipeline {

    private final InstallUseCase installUseCase;
    private final EventPort eventPort;

    public InstallPipeline(InstallUseCase installUseCase, EventPort eventPort) {
        this.installUseCase = installUseCase;
        this.eventPort = eventPort;
    }

    public void run(List<Software> softwareList) throws Exception {

        for (Software software : softwareList) {

            try {
                eventPort.publish("Installing: " + software.getName());

                installUseCase.install(software);

                eventPort.publish("SUCCESS: " + software.getName());

            } catch (Exception e) {
                eventPort.publish("FAILED: " + software.getName() + " - " + e.getMessage());
            }
        }
    }
}










