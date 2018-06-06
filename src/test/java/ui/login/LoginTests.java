package ui.login;

import base.Base;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testUser.TestUser;

@Feature("Авторизация")
public class LoginTests extends Base {

    @Story("Smoke тесты")
    @Test(description = "Авторизация в интернет банке (Позитивный тест)")
    public void positiveLogin() {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        HEADER_BLOCK.checkLogin();
    }

    @Story("Smoke тесты")
    @Test(description = "Авторизация в интернет банке (Негативный тест)")
    public void negativeLogin() {
        TestUser testUser = new TestUser("неправильный");
        LOGIN_PAGE.login(testUser);
        LOGIN_PAGE.checkErrorMessage();
    }
}
