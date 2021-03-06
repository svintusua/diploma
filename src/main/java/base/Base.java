package base;

import api.requests.GetRequests;
import api.requests.PostRequests;
import api.steps.account.accumulation.AccumulationSteps;
import api.steps.card.CardSteps;
import api.steps.transfer.internal.InternalSteps;
import com.codeborne.selenide.Configuration;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import testConfig.TestConfig;
import testListeners.TestListeners;
import ui.pages.header.HeaderBlock;
import ui.pages.login.LoginPage;
import ui.pages.transfers.TemplateWidget;
import ui.pages.transfers.TransferWidget;
import ui.utils.Screenshot;

import java.lang.reflect.Method;
import java.util.logging.Logger;

@Listeners(TestListeners.class)
public class Base {

    public static final Logger LOGGER = Logger.getLogger("TEST LOGGER");
    public static String url;
    protected final LoginPage LOGIN_PAGE = new LoginPage();
    protected final HeaderBlock HEADER_BLOCK = new HeaderBlock();
    protected final GetRequests GET_REQUEST = new GetRequests();
    protected final PostRequests POST_REQUEST = new PostRequests();
    protected final CardSteps CARD_STEPS = new CardSteps();
    protected final AccumulationSteps ACCUMULATION_STEPS = new AccumulationSteps();
    protected final InternalSteps INTERNAL_STEPS = new InternalSteps();
    protected final TemplateWidget TEMPLATE_WIDGET = new TemplateWidget();
    protected final TransferWidget TRANSFER_WIDGET = new TransferWidget();
    public Screenshot screenshot = new Screenshot();

    @BeforeSuite(description = "Установка тестовой конфигурации")
    public void setConfiguration() {
        TestConfig testConfiguration = new TestConfig();
        url = testConfiguration.getUrl();
        Configuration.browser = testConfiguration.getBrowser();
        Configuration.timeout = 10000;
        Configuration.startMaximized = true;
        System.setProperty("webdriver.chrome.driver", testConfiguration.getDriver());
    }

    @BeforeMethod(description = "Вывод сообщения о начале теста")
    public void initSteps(Method method) {
        LOGGER.info("Test \"" + method.getName() + "\" STARTED");
    }

    @AfterMethod(description = "Вывод результата теста")
    public void finishSteps(Method method, ITestResult iTestResult) {
        switch (iTestResult.getStatus()) {
            case 1:
                LOGGER.info("Test \"" + method.getName() + "\" SUCCESS");
                break;
            case 2:
                LOGGER.info("Test \"" + method.getName() + "\" FAILED");
                break;
        }
    }

    public String getUrl() {
        return url;
    }


}
