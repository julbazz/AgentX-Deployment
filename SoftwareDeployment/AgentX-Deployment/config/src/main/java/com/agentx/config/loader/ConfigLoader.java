package com.agentx.config.loader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigLoader {

    public Map<String, String> loadIni() {

        Map<String, String> config = new HashMap<>();

        try (InputStream input =
                     getClass().getClassLoader().getResourceAsStream("config.ini")) {

            if (input == null) {
                throw new RuntimeException("config.ini not found");
            }

            Properties props = new Properties();
            props.load(input);

            for (String key : props.stringPropertyNames()) {
                config.put(key, props.getProperty(key));
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.ini", e);
        }

        return config;
    }
}









