package ui.login;

import base.Base;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

@Features("Авторизация")
public class LoginTests extends Base {

    @Stories("Smoke тесты")
    @Test
    @Title("Авторизация в интернет банке (Позитивный тест)")
    public void positiveLogin() {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        HEADER_BLOCK.checkLogin();
    }

    @Stories("Smoke тесты")
    @Test
    @Title("Авторизация в интернет банке (Негативный тест)")
    public void negativeLogin() {
        TestUser testUser = new TestUser("неправильный");
        LOGIN_PAGE.login(testUser);
        LOGIN_PAGE.checkErrorMessage();
    }


}
