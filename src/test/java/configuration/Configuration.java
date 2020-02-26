package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static configuration.AppConstants.*;

public class Configuration {
    private static final Map<String, String> properties = new HashMap<>();

    private static void putProperty(String key, String value) {
        properties.put(key, value);
    }

    public static String getProperty(String key) throws IllegalAccessException {
        String property = properties.get(key);
        if (property == null) {
            throw new IllegalAccessException(String.format("Property %s was not found, was it provided in configuration?", key));
        }
        return property;
    }

    public static String getDownloadPath() throws IllegalAccessException {
        String path = getProperty(DOWNLOAD_PATH);
        if (path.lastIndexOf(File.separator) < path.length() - 1) {
            return path + File.separator;
        }
        return path;
    }

    public static void readConfiguration() throws IOException {
        InputStream configurationStream;
        InputStream credentialsStream;
        try {
            configurationStream = new FileInputStream(System.getProperty(IDM_CONFIGURATION_FILE_PATH));
        } catch (NullPointerException ex) {
            throw new IOException("Configuration file not found");
        }
        try {
            credentialsStream = new FileInputStream(System.getProperty(IDM_CREDENTIALS_FILE_PATH));
        } catch (NullPointerException ex) {
            throw new IOException("Credentials file not found");
        }
        Properties configurationProperties = new Properties();
        configurationProperties.load(configurationStream);

        for (Object key : configurationProperties.keySet()) {
            String propertyKey = key.toString();
            putProperty(propertyKey, configurationProperties.getProperty(propertyKey));
        }

        Properties credentialsProperties = new Properties();
        credentialsProperties.load(credentialsStream);

        for (Object key : credentialsProperties.keySet()) {
            String propertyKey = key.toString();
            if (propertyKey.equals(IDM_USER) || propertyKey.equals(IDM_PASSWORD)) {
                putProperty(propertyKey, credentialsProperties.getProperty(propertyKey));
            }
        }
    }

    public static Map<String, String> buildEnvironmentUrls() {
        Map<String, String> urls = new HashMap<>();
        String idmHost = System.getenv(IDM_HOST_ENV);
        urls.put("grid", String.format("https://%s:25000/grid/login", idmHost));
        urls.put("client", String.format("https://%s:25000/ca/client/documents", idmHost));
        return urls;
    }
}
