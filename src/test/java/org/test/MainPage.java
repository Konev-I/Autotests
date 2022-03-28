package org.test;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    String xPathFullName = "//*[contains(@class,\"tico ellip\")]";

    public String getName(){
        return $(By.xpath(xPathFullName)).shouldBe(visible.because("Имя пользователя не отображается!")).getText();
    }
}
