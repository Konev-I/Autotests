package org.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    String xPathNameEmail = "st.email";
    String xPathNamePassword = "st.password";
    String xPathButton = "//*[contains(@class,\"button-pro __wide\")]";

    public void login(User user){
        $(By.name(xPathNameEmail)).shouldBe(visible.because("Не отображается поле для вводя логина!")).setValue(user.getLogin());
        $(By.name(xPathNamePassword)).shouldBe(visible.because("Не отображается поле для вводя пароля!")).setValue(user.getPassword());
        $(By.xpath(xPathButton)).shouldBe(visible.because("Не отображается кнопка \"Войти в Одноклассники\"!")).click();
    }
}
