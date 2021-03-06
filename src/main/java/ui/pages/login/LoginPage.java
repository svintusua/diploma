package ui.pages.login;

import base.Base;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;
import testUser.TestUser;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement fldUsername = $(By.xpath("//*[@id=\"username\"]"));
    private SelenideElement fldPassword = $(By.xpath("//*[@id=\"password\"]"));
    private SelenideElement btnLogin = $(By.xpath("//*[@id=\"login-standart\"]/form/div[5]/div[1]/button"));
    private SelenideElement divErrorMessage = $(By.xpath("//*[@id=\"login-standart\"]/form/div[6]"));

    @Step("Открыть браузер на странице: {url}")
    public void openHomePage(String url) {
        Selenide.open(url);
    }

    @Step("Ввести \"{username}\" в поле \"Логин\"")
    public void inputToFldUsername(String username) {
        try {
            fldUsername.setValue(username);
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось ввести значение в поле \"Логин\": " + e);
        }
    }

    @Step("Ввести значение в поле \"Пароль\"")
    public void inputToFldPassword(String password) {
        try {
            fldPassword.setValue(password);
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось ввести значение в поле \"Пароль\": " + e);
        }
    }

    @Step("Нажать кнопку \"Войти\"")
    public void pressBtnLogin() {
        try {
            btnLogin.click();
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось произвести нажатие на кнопку \"Войти\": " + e);
        }
    }

    @Step("Проверить сообщение об ошибке \"Неверная пара логин/пароль\"")
    public void checkErrorMessage() {
        try {
            Assert.assertEquals(divErrorMessage.waitUntil(Condition.visible, 2000).getText(), "Неверная пара логин/пароль");
        } catch (Throwable e) {
            throw new IllegalStateException("Не удалось проверить сообщение об ошибке: " + e);
        }
    }

    public void login(TestUser testUser) {
        login(testUser.getUsername(), testUser.getPassword());
    }

    @Step("Логинимься пользователем: {username}")
    private void login(String username, String password) {
        openHomePage(Base.url);
        inputToFldUsername(username);
        inputToFldPassword(password);
        pressBtnLogin();
    }
}
