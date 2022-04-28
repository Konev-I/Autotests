package org.test.pages.wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MessageWrapper {
    private SelenideElement message;
    private By msgText = By.xpath(".//msg-parsed-text");
    private By optionsButton = By.xpath(".//msg-button[contains(@data-l,'t,messageActionmore')]");
    private By deleteButton = By.xpath("//msg-menu-item[contains(@data-l, 't,messageActionremove')]");
    private By confirmDeleteButton = By.xpath("//msg-button[contains(@data-tsid,'confirm-primary')]");

    public MessageWrapper(SelenideElement message){
        message.shouldBe(visible.because("Сообщение не отображается!"));
        this.message = message;
    }

    public String getMessageText(){
        message.shouldBe(visible.because("Сообщение не отображается!"));
        SelenideElement msgTextElem = message.$(msgText).shouldBe(visible.because("Текст сообщения не отображается!"));
        return msgTextElem.getText();
    }

    public void deleteMessage(){
        message.shouldBe(visible.because("Сообщение не отображается!")).click();
        SelenideElement optionsButtonElem = message.$(optionsButton).shouldBe(visible.because("Кнопка дополнительных действий не отображается!"));
        optionsButtonElem.click();
        SelenideElement deleteButtonElem = $(deleteButton).shouldBe(visible.because("Кнопка удаления сообщения не отображается!"));
        deleteButtonElem.click();
        SelenideElement confirmDeleteButtonElem = $(confirmDeleteButton).shouldBe(visible.because("Кнопка подтверждения удаления не отображается!"));
        confirmDeleteButtonElem.click();
    }
}
