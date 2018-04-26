package testConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestConfig {

    private String browser;
    private String url;
    private String driver;

    public TestConfig() throws IOException {
        String configurationPath = new File("").getAbsolutePath() + "\\src\\main\\resources\\testConfig.properties";
        Properties configuration = new Properties();
        configuration.load(new FileInputStream(configurationPath));
        this.url = configuration.getProperty("url");
        this.browser = configuration.getProperty("browser");
        this.driver = configuration.getProperty("driver");
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getDriver() {
        return driver;
    }
}
