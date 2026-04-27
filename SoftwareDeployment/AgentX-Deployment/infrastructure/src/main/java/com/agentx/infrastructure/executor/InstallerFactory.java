package com.agentx.infrastructure.executor;

import com.agentx.domain.model.Software;
import com.agentx.infrastructure.strategy.*;

import java.util.List;

public class InstallerFactory {

    private final List<InstallerStrategy> strategies;

    public InstallerFactory() {
        this.strategies = List.of(
            new WingetInstallerStrategy(),
            new LinuxInstallerStrategy()
        );
    }

    public InstallerStrategy get(Software software) {
        return strategies.stream()
                .filter(s -> s.supports(software))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(
                        "No installer strategy found for: " + software.getName()
                ));
    }
}










