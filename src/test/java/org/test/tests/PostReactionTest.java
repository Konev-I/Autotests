package org.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.utils.User;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostReactionTest {
    private static User user;

    @BeforeAll
    public static void init(){
        user = new User("Иван Конев", "", "");
    }

    @DisplayName("Test of setting reaction on post")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6})
    public void reactionTest(int numOfReaction) {
        open("https://ok.ru");
        LoginPage lp = new LoginPage();
        MainPage mp = lp.login(user);

        FeedElemWrapper post = mp.getFeedList().get(0);
        String selectedReactionName = post.setReaction(numOfReaction);
        assertEquals(selectedReactionName, post.getReactionName(), "Установлена не та реакция, которую мы выбирали");
    }

    @AfterEach
    public void end(){
        closeWindow();
    }
}
