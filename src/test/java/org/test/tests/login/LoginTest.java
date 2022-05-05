package org.test.tests.login;

import org.junit.jupiter.api.*;
import org.test.pages.page.LoginPage;
import org.test.pages.page.MainPage;
import org.test.tests.BaseTest;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends BaseTest {
    private static User user;
    private static String userFullName = "Иван Конев";
    private static String userLogin = "";
    private static String userPassword = "";

    @BeforeAll
    public static void init(){
        user = new User(userFullName, userLogin, userPassword);
    }

    @DisplayName("Test of login on ok.ru")
    @Test
    public void loginTest() {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user);
        assertEquals(mainPage.getName(), user.getFullName(), "Попытка входа провалилась!");
    }
}
