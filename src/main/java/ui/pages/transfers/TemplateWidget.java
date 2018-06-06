package ui.pages.transfers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TemplateWidget {

    private SelenideElement divTemplateWidget = $(By.xpath("//div[contains(@class, 'wocb-wrapper-section wocb-grid wocb-grid-middle wocb-grid-wide')]/div[contains(@class, 'wocb-header__templates')]"));
    private SelenideElement divMore = $(By.xpath("//a[contains(@class, 'wocb-more-link')]"));
    private ElementsCollection divTemplateList = $$(By.xpath("//div[contains(@class, 'wocb-shortcut wocb-shortcut_template')]/div[contains(@class, 'wocb-shortcut__container')]"));


    @Step("Проверка виджета шаблонов на видимость")
    public void checkTemplateWidget() {
        try {
            divTemplateWidget.shouldBe(Condition.visible);
        } catch (Throwable e) {
            throw new IllegalStateException("Проверка на  видимость прошла не успешно: " + e);
        }
    }

    @Step("Нажатие на кнопку \"...\"")
    public void clickDivMore() {
        try {
            divMore.shouldBe(Condition.visible).click();
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось нажать на кнопку \"...\": " + e);
        }
    }

    @Step("Выбрать шаблон с названием {0}")
    public void findTemplate(String name) {
        try {
            wait(2000);
            for (SelenideElement element : divTemplateList) {
                if (element.shouldBe(Condition.visible).getText().contains(name)) {
                    element.shouldBe(Condition.visible).click();
                    break;
                }
            }
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось выбрать шаблон с нужным названием: " + e);
        }
    }


    public void wait(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
