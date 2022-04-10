package org.test.pages.wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class ToolbarWrapper {
    private SelenideElement toolbar;
    private By messageButton = By.xpath(".//li[contains(@data-l,'t,messages')]");

    public ToolbarWrapper(SelenideElement tb){
        this.toolbar = tb;
    }

    public void openMessages(){
        toolbar.$(messageButton).shouldBe(visible.because("Кнопка \"сообщения\" не отображается!")).click();
    }
}
