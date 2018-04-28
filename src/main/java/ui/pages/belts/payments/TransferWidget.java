package ui.pages.belts.payments;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TransferWidget {

    private SelenideElement divTransferWidget = $(By.xpath("//div[contains(@class, 'wocb-grid wocb-widget-transfer')]"));
    private SelenideElement divPaymentFrom = $(By.xpath("//div[contains(@class, 'wocb-select-product-item wocb-select-product-item_selected wocb-select-product-item_card')]"));
    private SelenideElement divPaymentFromTitle = $(By.xpath("//div[contains(@class, 'wocb-select-product-item wocb-select-product-item_selected wocb-select-product-item_card')]/div[contains(@class, 'wocb-select-product-item__caption')]/div[contains(@class, 'wocb-select-product-item__product-title')]"));
    private SelenideElement divPaymentFromCurrency = $(By.xpath("//div[contains(@class, 'wocb-select-product-item wocb-select-product-item_selected wocb-select-product-item_card')]/div[contains(@class, 'wocb-select-product-item__amount')]/div[contains(@class, 'wocb-amount')]/span[contains(@class, 'wocb-amount__currency')]"));
    private SelenideElement divPaymentFromAmount = $(By.xpath("//div[contains(@class, 'wocb-select-product-item wocb-select-product-item_selected wocb-select-product-item_card')]/div[contains(@class, 'wocb-select-product-item__amount')]/div[contains(@class, 'wocb-amount')]/span[contains(@class, 'wocb-amount__integer')]"));
    private ElementsCollection divPaymentFromList = $$(By.xpath("//div/div[contains(@class, 'wocb-select-product-item wocb-select-product-item_card')]"));


    @Step("Проверка виджета платежей на видимость")
    public void checkPaymentWidget() {
        try {
            divTransferWidget.shouldBe(Condition.visible);
        } catch (Throwable e) {
            throw new IllegalStateException("Проверка на  видимость прошла не успешно: " + e);
        }
    }

    @Step("Выбрать продукт с названием \"{0}\", балансом больше \"{3}\" и валютой \"{1}\"")
    public void selectPaymentCategory(String name, String currency, Integer amount) {
        try {
            if (!divPaymentFromTitle.getText().equals(name) && !(Integer.parseInt(divPaymentFromAmount.getText().replaceAll("\\s", "")) > amount) && !divPaymentFromCurrency.getText().equals(currency)) {
                divPaymentFrom.click();

            }

        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось выбрать категорию платежа: " + e);
        }
    }
}
