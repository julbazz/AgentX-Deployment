package com.agentx.infrastructure.strategy;

import com.agentx.domain.model.Software;

public class WingetInstallerStrategy implements InstallerStrategy {

    @Override
    public void install(Software software) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
            "winget", "install", "-e", "--id", software.getName()
        );
        int exit = pb.start().waitFor();
        if (exit != 0) throw new RuntimeException("Winget install failed");
    }

    @Override
    public void uninstall(Software software) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
            "winget", "uninstall", "-e", "--id", software.getName()
        );
        int exit = pb.start().waitFor();
        if (exit != 0) throw new RuntimeException("Winget uninstall failed");
    }

    @Override
    public boolean supports(Software software) {
        return System.getProperty("os.name").toLowerCase().contains("win");
    }
}










