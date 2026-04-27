package com.agentx.infrastructure.strategy;

import com.agentx.domain.model.Software;

public class LinuxInstallerStrategy implements InstallerStrategy {

    @Override
    public void install(Software software) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
            "sudo", "apt-get", "install", "-y", software.getName()
        );
        int exit = pb.start().waitFor();
        if (exit != 0) throw new RuntimeException("APT install failed");
    }

    @Override
    public void uninstall(Software software) throws Exception {
        ProcessBuilder pb = new ProcessBuilder(
            "sudo", "apt-get", "remove", "-y", software.getName()
        );
        int exit = pb.start().waitFor();
        if (exit != 0) throw new RuntimeException("APT uninstall failed");
    }

    @Override
    public boolean supports(Software software) {
        return System.getProperty("os.name").toLowerCase().contains("linux");
    }
}










