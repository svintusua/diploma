package ui.pages.transfers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class TransferWidget {

    private SelenideElement btnTransfer = $(By.xpath("//div[contains(@class, 'wocb-button wocb-button_confirmable')]"));
    private SelenideElement divMessageSuccess = $(By.xpath("//div[contains(@class, 'wocb-message wocb-message_success')]"));
    private SelenideElement divInput = $(By.xpath("//div[contains(@class, 'wocb-amount-from')]/div[contains(@class, 'wocb-input')]/input[contains(@class, 'wocb-input__input')]"));


    @Step("Нажать на кнопку \"Перевести\" и кноку \"Подтвердить\"")
    public void clickBtnTransfer() {
        try {
            divInput.shouldBe(Condition.not(Condition.empty));
            btnTransfer.click();
            btnTransfer.click();
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось нажать на кнопку \"Перевести\" и кноку \"Подтвердить\": " + e);
        }
    }

    @Step("Проверить сообщение \"Перевод выполнен успешно\"")
    public void checkTransferSuccess() {
        try {
            boolean check = divMessageSuccess.shouldBe(Condition.visible).getText().contains("Перевод выполнен успешно");
            Assert.assertTrue(check, "Сообщение не соответсвует условию");
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось проверить сообщение \"Перевод выполнен успешно\": " + e);
        }
    }
}
