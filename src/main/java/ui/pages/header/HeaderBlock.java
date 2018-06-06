package ui.pages.header;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;

public class HeaderBlock {

    private SelenideElement divHeaderInner = $(By.xpath("//div[contains(@class, 'wocb-sticky-header__inner-container')]/div[contains(@class, 'wocb-sticky-header__inner')]"));
    private SelenideElement aTransfersHeaderInner = $(By.xpath("//ul[contains(@class, 'wocb-menu')]//li[3]/a"));

    @Step("Проверить, что произведен успешный вход в интернет банк")
    public void checkLogin() {
        try {
            divHeaderInner.shouldBe(Condition.visible);
        } catch (Throwable e) {
            throw new IllegalStateException("Вход в интернет банк не выполнен: " + e);
        }
    }

    @Step("Нажать на кнопку \"Переводы\"")
    public void clickTransfers() {
        try {
            aTransfersHeaderInner.shouldBe(Condition.visible).click();
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось нажать на кнопку \"Переводы\": " + e);
        }
    }
}
