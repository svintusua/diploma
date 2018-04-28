package ui.transfer;

import base.Base;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

@Features("Переводы")
public class TransferTests extends Base {

    @Stories("Critical тесты")
    @Test
    @Title("Перевод между своими продуктами (ГО RUR - Моя копилка RUR)")
    public void positiveLogin() {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        PAYMENTS_WIDGET.checkPaymentWidget();
        PAYMENTS_WIDGET.selectPaymentCategory("Моя копилка", "\u0584", 100);
    }
}
