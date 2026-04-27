package com.agentx.infrastructure.executor;

import com.agentx.domain.model.Software;
import com.agentx.domain.port.InstallerPort;
import com.agentx.infrastructure.executor.InstallerFactory;
import com.agentx.infrastructure.strategy.InstallerStrategy;

public class Installer implements InstallerPort {

    private final InstallerFactory factory;

    public Installer(InstallerFactory factory) {
        this.factory = factory;
    }

    @Override
    public void install(Software software) throws Exception  {
        InstallerStrategy strategy = factory.get(software);
        strategy.install(software);
    }

    public void uninstall(Software software) throws Exception  {
        InstallerStrategy strategy = factory.get(software);
        strategy.uninstall(software);
    }
}











