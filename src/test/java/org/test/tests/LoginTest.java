package org.test.tests;

import org.junit.jupiter.api.*;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest{
    private static User user;

    @BeforeAll
    public static void init(){
        user = new User("Иван Конев", "", "");
    }

    @DisplayName("Test of login on ok.ru")
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user);
        assertEquals(mainPage.getName(), user.getFullName(), "Попытка входа провалилась!");
    }
}
