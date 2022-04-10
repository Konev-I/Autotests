package org.test.pages.wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;

public class FeedElemWrapper {
    private SelenideElement element;
    private By feedAuthor = By.xpath(".//a[contains(@class, 'user-link o')]");
    private By feedGroup = By.xpath(".//a[contains(@class, 'group-link o')]");
    private By feedText = By.xpath(".//div[contains(@class, 'media-text_cnt_tx')]");

    public FeedElemWrapper(SelenideElement elem){
        this.element = elem;
    }

    public boolean isByUser(){
        return element.$(feedAuthor).is(visible);
    }

    public boolean isByGroup(){
        return element.$(feedGroup).is(visible);
    }

    public String getAuthor(){
        return element.$(feedAuthor).shouldBe(visible.because("Имя автора не отображается!")).getText();
    }

    public String getText(){
        return element.$(feedText).getText();
    }
}
