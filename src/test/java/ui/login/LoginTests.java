package ui.login;

import base.Base;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

import java.io.IOException;

@Features("Авторизация")
public class LoginTests extends Base {

    @Stories("Smoke тесты")
    @Test
    @Title("Успешная авторизация в интернет банке")
    public void positiveLogin() throws IOException {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        HEADER_BLOCK.checkLogin();
    }

    @Stories("Smoke тесты")
    @Test
    @Title("Авторизация в интернет банке (Негативная)")
    public void negativeLogin() throws IOException {
        TestUser testUser = new TestUser("неправильный");
        LOGIN_PAGE.login(testUser);
        LOGIN_PAGE.checkErrorMessage();
    }
}
