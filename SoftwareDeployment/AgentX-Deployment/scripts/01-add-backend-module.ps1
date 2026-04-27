# create backend module
New-Item -ItemType Directory -Force -Path "backend/src/main/java/com/agentx/backend"

# settings.gradle erweitern
Add-Content settings.gradle "`ninclude 'backend'"

# build.gradle backend
@"
plugins {
    id 'org.springframework.boot' version '3.2.0'
    id 'io.spring.dependency-management' version '1.1.4'
    id 'java'
}

dependencies {
    implementation project(':domain')
    implementation project(':application')
    implementation project(':infrastructure')
    implementation project(':interfaces')

    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-websocket'
}
"@ | Out-File backend/build.gradle -Encoding utf8

# Main App
@"
package com.agentx.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgentXApplication {
    public static void main(String[] args) {
        SpringApplication.run(AgentXApplication.class, args);
    }
}
"@ | Out-File backend/src/main/java/com/agentx/backend/AgentXApplication.java