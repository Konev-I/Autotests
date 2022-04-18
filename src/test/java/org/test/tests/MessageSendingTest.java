package org.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.pages.MessagePage;
import org.test.pages.wrappers.MessageWrapper;
import org.test.utils.User;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSendingTest {
    private User user;

    @BeforeEach
    public void init(){
        user = new User("Иван Конев", "", "");
    }

    @DisplayName("Test of message sending")
    @ParameterizedTest
    @ValueSource(strings = {"test", "Hello!", "¯\\_(ツ)_/¯"})
    public void sendMessageTest(String message) {
        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = lp.login(user);

        MessagePage messagePage = mp.openMessagePage();
        messagePage.openChat("Спутник").sendMessage(message);

        MessageWrapper lastSendMsg = messagePage.getLastSendMessage();
        assertEquals(lastSendMsg.getMessageText(), message, "Текст сообщения не совпадает с отправленным!");
    }

    @AfterEach
    public void end(){
        new MessagePage().getLastSendMessage().deleteMessage();
        closeWindow();
    }
}
