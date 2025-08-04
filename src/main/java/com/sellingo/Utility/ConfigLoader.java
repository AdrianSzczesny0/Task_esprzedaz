package com.sellingo.Utility;
import java.io.InputStream;
import java.util.Properties;

class ConfigLoader {

    private Properties properties;
    public ConfigLoader() {
        loadConfig();
    }

    private void loadConfig() {
        try {
            String env = System.getProperty("env", "demo").toLowerCase();
            String fileName = String.format("config/config_%s.properties", env);

            InputStream input = getClass().getClassLoader().getResourceAsStream(fileName);

            if (input == null) {
                throw new RuntimeException("Unable to find config file: " + fileName);
            }

            properties = new Properties();
            properties.load(input);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load config", e);
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}