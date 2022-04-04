package org.test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExampleTest {

    private static User user;

    @BeforeAll
    static void init(){
        user = new User("Иван Конев", "konev.ivan.a@gmail.com", "wuwcuc3");
    }

    @Test
    public void LoginTest() {
        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = new MainPage();
        lp.login(user);
        assertEquals(mp.getName(), user.getFullName());

        closeWindow();
    }

    @Test
    public void MakeNoteTest() {
        String noteTestText = "test";

        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = new MainPage();
        lp.login(user);

        mp.makeNote(noteTestText);
        //Проверку на создание записи можно было сделать проще, но я решил пойти таким путём для реализации паттерна Page Element для элементов отображающих посты
        refresh(); //Обновление для того чтобы заметка стала постом в ленте, а не недавно созданной заметкой
        Optional<FeedElem> note = mp.getLastFeedByUsername(user.getFullName());
        assertTrue(note.isPresent());
        assertEquals(note.get().getText(), noteTestText);

        mp.openNotePage();
        NotesPage np = new NotesPage();
        np.deleteLastNote();

        closeWindow();
    }
}
