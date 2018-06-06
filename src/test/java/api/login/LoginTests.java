package api.login;

import api.requests.Authorization;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testUser.TestUser;

@Feature("Авторизация")
public class LoginTests extends Authorization {

    @Story("Smoke тесты")
    @Test(description = "Успешная авторизация в интернет банке")
    public void positiveLogin() {
        TestUser testUser = new TestUser("основной");
        login(testUser);
    }
}
