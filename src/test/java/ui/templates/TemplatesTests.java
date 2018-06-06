package ui.templates;

import base.Base;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import testUser.TestUser;

@Feature("Шаблоны")
public class TemplatesTests extends Base {

    @Story("Critical тесты")
    @Test(description = "Применение шаблона по переводу между своими продуктами")
    public void templateTest() {
        TestUser testUser = new TestUser("основной");
        LOGIN_PAGE.login(testUser);
        HEADER_BLOCK.clickTransfers();
        TEMPLATE_WIDGET.checkTemplateWidget();
        TEMPLATE_WIDGET.clickDivMore();
        TEMPLATE_WIDGET.findTemplate("Между своими");
        TRANSFER_WIDGET.clickBtnTransfer();
        TRANSFER_WIDGET.checkTransferSuccess();
    }
}
