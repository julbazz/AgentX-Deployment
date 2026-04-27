package com.agentx.domain.port;

import com.agentx.domain.model.Software;

public interface InstallerPort {
    void install(Software software) throws Exception;
}









