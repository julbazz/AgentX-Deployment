package com.agentx.app;

import com.agentx.application.usecase.*;
import com.agentx.config.loader.ConfigLoader;
import com.agentx.domain.model.Software;
import com.agentx.domain.port.EventPort;
import com.agentx.domain.port.InstallerPort;
import com.agentx.infrastructure.executor.Installer;
import com.agentx.infrastructure.executor.InstallerFactory;

import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        ConfigLoader loader = new ConfigLoader();
        Map<String, String> config = loader.load();

        List<Software> softwareList = config.entrySet().stream()
                .filter(e -> e.getKey().startsWith("software."))
                .map(e -> new Software(e.getValue()))
                .toList();

        InstallerFactory factory = new InstallerFactory();
        InstallerPort installerPort = new Installer(factory);
        InstallUseCase useCase = new InstallUseCaseImpl(installerPort);

        EventPort eventPort = msg -> System.out.println("[EVENT] " + msg);

        InstallPipeline pipeline = new InstallPipeline(useCase, eventPort);
        pipeline.run(softwareList);
    }
}











