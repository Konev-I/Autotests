package org.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private By emailField = By.name("st.email");
    private By passwordField = By.name("st.password");
    private By loginButton = By.xpath("//*[contains(@class,\"button-pro __wide\")]");

    public void login(User user){
        $(emailField).shouldBe(visible.because("Не отображается поле для вводя логина!")).setValue(user.getLogin());
        $(passwordField).shouldBe(visible.because("Не отображается поле для вводя пароля!")).setValue(user.getPassword());
        $(loginButton).shouldBe(visible.because("Не отображается кнопка \"Войти в Одноклассники\"!")).click();
    }
}
