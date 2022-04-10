package org.test.pages;

import org.openqa.selenium.By;
import org.test.utils.User;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage{
    private By emailField = By.name("st.email");
    private By passwordField = By.name("st.password");
    private By loginButton = By.xpath("//*[contains(@class,'button-pro __wide')]");

    public LoginPage(){
        isLoaded();
    }

    public MainPage login(User user){
        $(emailField).shouldBe(visible.because("Не отображается поле для вводя логина!")).setValue(user.getLogin());
        $(passwordField).shouldBe(visible.because("Не отображается поле для ввода пароля!")).setValue(user.getPassword());
        $(loginButton).shouldBe(visible.because("Не отображается кнопка \"Войти в Одноклассники\"!")).click();
        return new MainPage();
    }

    @Override
    public void isLoaded() {
        $(emailField).shouldBe(visible.because("Не дождались загрузки поля для ввода логина!"));
        $(passwordField).shouldBe(visible.because("Не дождались загрузки поля для ввода пароля!"));
        $(loginButton).shouldBe(visible.because("Не дождались загрузки кнопки для входа!"));
    }
}
