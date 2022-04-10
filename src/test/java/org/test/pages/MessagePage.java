package org.test.pages;

import org.openqa.selenium.By;
import org.test.pages.wrappers.MessageWrapper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MessagePage extends BasePage{
    private By searchUserField = By.xpath("//input[contains(@name,'chat-search')]");
    private By messageInputField = By.xpath("//msg-input");
    private By sendButton = By.xpath("//msg-button[contains(@data-tsid,'button_send')]");
    private By lastSendMessage = By.xpath("(//msg-message[@mine])[last()]");
    private By botButtonsMsg = By.xpath("(//msg-message)[last()]//msg-keyboard-button");

    public MessagePage(){
        isLoaded();
    }

    @Override
    public void isLoaded() {
        $(searchUserField).shouldBe(visible.because("Не дождались загрузки поля для поиска чатов!"));
    }

    public MessagePage openChat(String chatName){
        $(searchUserField).shouldBe(visible.because("Поле для поиска чатов не отображается!")).setValue(chatName);
        $(By.xpath("//msg-search-results-item[//span[text() = '"+chatName+"']]")).shouldBe(visible.because("Чат не найден!")).click();
        return this;
    }

    public MessagePage sendMessage(String msgText){
        $(messageInputField).shouldBe(visible.because("Поле для ввода сообщения не отображается!")).setValue(msgText);
        $(sendButton).shouldBe(visible.because("Кнопка для отправки сообщения не отображается!")).click();
        return this;
    }

    public MessagePage sendMessage(int botButton){
        $$(botButtonsMsg).get(botButton).shouldBe(visible.because("В сообщении не найдена кнопка для ответа!")).click();
        return this;
    }

    public MessageWrapper getLastSendMessage(){
        return new MessageWrapper($(lastSendMessage).shouldBe(visible.because("Последнее отправленное сообщение не отображается!")));
    }
}
