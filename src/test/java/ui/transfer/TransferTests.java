package ui.transfer;

import base.Base;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

import java.io.IOException;

@Features("Переводы")
public class TransferTests extends Base {

    @Stories("Critical тесты")
    @Test
    @Title("Перевод между своими продуктами (ГО RUR - Моя копилка RUR)")
    public void positiveLogin() throws IOException {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        HEADER_BLOCK.checkLogin();
    }
}
