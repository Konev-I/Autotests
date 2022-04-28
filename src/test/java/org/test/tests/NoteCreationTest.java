package org.test.tests;

import org.junit.jupiter.api.*;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.pages.wrappers.NewNote;
import org.test.pages.wrappers.NewNoteBuilder;
import org.test.utils.User;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.*;

public class NoteCreationTest extends BaseTest{
    private static User user;
    private static String noteTestHeader;
    private static String noteTestText;

    @BeforeAll
    public static void init(){
        user = new User("Иван Конев", "", "");
        noteTestHeader = "Header";
        noteTestText = "Test";
    }

    @DisplayName("Test of note creation")
    @Test
    public void makeNoteTest() {
        String checkString = noteTestHeader + "\n" + noteTestText;

        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user);

        //Использую паттерн Builder для настройки элементов, которые будут в заметке
        NewNoteBuilder builder = NewNote.builder().addHeader(noteTestHeader).addText(noteTestText);
        mainPage.makeNote(builder.build());

        refresh(); //Обновление для того чтобы заметка стала постом в ленте, а не недавно созданной заметкой
        //Проверку на создание записи можно было сделать проще, но я решил пойти таким путём для реализации паттерна Page Element для элементов отображающих посты
        Optional<FeedElemWrapper> note = mainPage.getLastFeedByUsername(user.getFullName());
        assertAll("note check",
                () -> assertTrue(note.isPresent(), "Не удалось найти пост!"),
                () -> assertEquals(checkString, note.get().getText(), "Текст не совпадает с отправленным через тест!"));
    }

    @AfterEach
    public void end(){
        new MainPage().openNotePage().deleteLastNote();
    }
}
