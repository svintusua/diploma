package api.login;

import api.requests.Authorization;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

@Features("Авторизация")
public class LoginTests extends Authorization {

    @Stories("Smoke тесты")
    @Test
    @Title("Успешная авторизация в интернет банке")
    public void positiveLogin() {
        TestUser testUser = new TestUser("основной");
        login(testUser);
    }
}
