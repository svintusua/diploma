package base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import testConfig.TestConfig;
import testListeners.TestListeners;
import ui.pages.header.HeaderBlock;
import ui.pages.login.LoginPage;
import ui.utils.Screenshot;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.logging.Logger;

@Listeners(TestListeners.class)
public class Base {

    public static final Logger LOGGER = Logger.getLogger("TEST LOGGER");
    public Screenshot screenshot = new Screenshot();
    public static String url;

    protected final LoginPage LOGIN_PAGE = new LoginPage();
    protected final HeaderBlock HEADER_BLOCK = new HeaderBlock();


    @BeforeSuite
    public void setConfiguration() throws IOException {
        TestConfig testConfiguration = new TestConfig();
        url = testConfiguration.getUrl();
        Configuration.browser = testConfiguration.getBrowser();
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", testConfiguration.getDriver());
    }

    @BeforeMethod
    public void initSteps(Method method) {
        LOGGER.info("TEST NAME: " + method.getName());
    }


    public String getUrl() {
        return url;
    }


}
