package org.test.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.open;

public abstract class BaseTest {
    private String urlOK = "https://ok.ru";

    @BeforeEach
    public void initBase(){
        open(urlOK);
    }

    @AfterEach
    public void endBase(){
        closeWindow();
    }
}
