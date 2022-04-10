package org.test.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.test.pages.*;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.pages.wrappers.MessageWrapper;
import org.test.pages.wrappers.NewNote;
import org.test.pages.wrappers.NewNoteBuilder;
import org.test.utils.User;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Autotests {

    private static User user;

    @BeforeAll
    static void init(){
        user = new User("Иван Конев", "", "");
    }

    @Test
    public void loginTest() {
        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = lp.login(user);
        assertEquals(mp.getName(), user.getFullName(), "Попытка входа провалилась!");

        closeWindow();
    }

    @Test
    public void makeNoteTest() {
        String noteTestHeader = "Header";
        String noteTestText = "Test";

        String checkString = noteTestHeader + "\n" + noteTestText;

        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = lp.login(user);

        //Использую паттерн Builder для настройки элементов, которые будут в заметке
        NewNoteBuilder builder = NewNote.builder().addHeader(noteTestHeader).addText(noteTestText);
        mp.makeNote(builder.build());

        refresh(); //Обновление для того чтобы заметка стала постом в ленте, а не недавно созданной заметкой
        //Проверку на создание записи можно было сделать проще, но я решил пойти таким путём для реализации паттерна Page Element для элементов отображающих посты
        Optional<FeedElemWrapper> note = mp.getLastFeedByUsername(user.getFullName());
        assertTrue(note.isPresent(), "Не удалось найти пост!");
        assertEquals(checkString, note.get().getText(), "Текст не совпадает с отправленным через тест!");

        NotesPage np = mp.openNotePage();
        np.deleteLastNote();

        closeWindow();
    }

    @Test
    public void sendMessageTest() {
        String testMessageText = "test";

        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = lp.login(user);

        MessagePage messagePage = mp.openMessagePage();
        messagePage.openChat("Спутник").sendMessage(testMessageText);

        MessageWrapper lastSendMsg = messagePage.getLastSendMessage();
        assertEquals(lastSendMsg.getMessageText(), testMessageText, "Текст сообщения не совпадает с отправленным!");

        lastSendMsg.deleteMessage();
        closeWindow();
    }
}
