package com.agentx.infrastructure.strategy;

import com.agentx.domain.model.Software;

public interface InstallerStrategy {
    void install(Software software) throws Exception;
    void uninstall(Software software) throws Exception;
    boolean supports(Software software);
}










