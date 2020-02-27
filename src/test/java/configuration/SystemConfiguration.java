package configuration;

public class SystemConfiguration {
    public static String environment;
    public static String documentType;
    public static String filePath;
    public static String password;
    public static String url;
    public static String user;

    public static void readConfiguration() {
        environment = System.getenv("E2E_ENVIRONMENT");
        documentType = System.getenv("E2E_DOCUMENT_TYPE");
        filePath = System.getenv("E2E_FILE_PATH");
        password = System.getenv("E2E_PASSWORD");
        url = System.getenv("E2E_BASE_URL");
        user = System.getenv("E2E_USER");
    }
}
