package org.test.tests;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.test.pages.LoginPage;
import org.test.pages.MainPage;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostReactionTest extends BaseTest{
    private static User user;

    @BeforeAll
    public static void init(){
        user = new User("Иван Конев", "", "");
    }

    @DisplayName("Test of setting reaction on post")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    public void reactionTest(int numOfReaction) {
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(user);

        FeedElemWrapper post = mainPage.getFeedList().get(0);
        String selectedReactionName = post.setReaction(numOfReaction);
        assertEquals(selectedReactionName, post.getReactionName(), "Установлена не та реакция, которую мы выбирали");
    }
}
