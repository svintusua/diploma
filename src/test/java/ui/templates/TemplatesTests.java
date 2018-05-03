package ui.templates;

import base.Base;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import testUser.TestUser;

@Features("Шаблоны")
public class TemplatesTests extends Base {

    @Stories("Critical тесты")
    @Test
    @Title("Применение шаблона по переводу между своими продуктами")
    public void transfer() {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        TEMPLATE_WIDGET.checkTemplateWidget();
        TEMPLATE_WIDGET.clickDivMore();
        TEMPLATE_WIDGET.findTemplate("Между своими");
        TRANSFER_WIDGET.clickBtnTransfer();
        TRANSFER_WIDGET.checkTransferSuccess();
    }
}
