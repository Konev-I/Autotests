package org.test.tests;

import org.junit.jupiter.api.*;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.utils.User;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private User user;

    @BeforeEach
    public void init(){
        user = new User("Иван Конев", "", "");
    }

    @DisplayName("Test of login on ok.ru")
    @Test
    public void loginTest() {
        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = lp.login(user);
        assertEquals(mp.getName(), user.getFullName(), "Попытка входа провалилась!");

    }

    @AfterEach
    public void end(){
        closeWindow();
    }
}
