package org.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.pages.MessagePage;
import org.test.pages.wrappers.MessageWrapper;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageSendingTest extends BaseTest{
    private static User user;

    @BeforeAll
    public static void init(){
        user = new User("Иван Конев", "", "");
    }

    @DisplayName("Test of message sending")
    @ParameterizedTest
    @ValueSource(strings = {"test", "Hello!", "¯\\_(ツ)_/¯"})
    public void sendMessageTest(String message) {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user);

        MessagePage messagePage = mainPage.openMessagePage();
        messagePage.openChat("Спутник").sendMessage(message);

        MessageWrapper lastSendMsg = messagePage.getLastSendMessage();
        assertEquals(lastSendMsg.getMessageText(), message, "Текст сообщения не совпадает с отправленным!");
    }

    @AfterEach
    public void end(){
        new MessagePage().getLastSendMessage().deleteMessage();
    }
}
