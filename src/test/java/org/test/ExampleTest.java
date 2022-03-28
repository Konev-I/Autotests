package org.test;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExampleTest {

    @Test
    public void LoginTest() {
        User user = new User("Иван Конев", "login", "pass");
        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = new MainPage();
        lp.login(user);
        assertEquals(mp.getName(), user.getFullName());
    }
}
