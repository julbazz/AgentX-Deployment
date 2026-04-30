package com.agentx.application.usecase;

import com.agentx.domain.model.Software;
import com.agentx.domain.port.InstallerPort;

public class InstallUseCaseImpl implements InstallUseCase {

    private final InstallerPort installerPort;

    public InstallUseCaseImpl(InstallerPort installerPort) {
        this.installerPort = installerPort;
    }

    @Override
    public void install(Software software) throws Exception {
        installerPort.install(software);
    }
}










