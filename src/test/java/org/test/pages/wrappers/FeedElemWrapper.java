package org.test.pages.wrappers;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.CollectionCondition.sizeNotEqual;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;

public class FeedElemWrapper {
    private SelenideElement element;
    private By feedAuthor = By.xpath(".//a[contains(@class, 'user-link o')]");
    private By feedGroup = By.xpath(".//a[contains(@class, 'group-link o')]");
    private By feedText = By.xpath(".//div[contains(@class, 'media-text_cnt_tx')]");

    private By reactionButton = By.xpath(".//span[contains(@class,'js-klass-action')]");
    private By reactionsTypeButtons = By.xpath("//span[@data-reaction-id]");
    private String reactionName = "data-reaction-text";
    private By selectReactText = By.xpath(".//span[contains(@class,'widget_tx')]");

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
        SelenideElement feedAuthorElem = element.$(feedAuthor).shouldBe(visible.because("Имя автора не отображается!"));
        return feedAuthorElem.getText();
    }

    public String getText(){
        SelenideElement feedTextElem = element.$(feedText).shouldBe(visible.because("Текст поста не отображается!"));
        return feedTextElem.getText();
    }

    public String setReaction(int numOfReaction){
        SelenideElement reactionButtonElem = element.$(reactionButton).shouldBe(visible.because("Кнопка для реакции не отображается!"));
        reactionButtonElem.hover();
        ElementsCollection reactionsTypeButtonsElems = $$(reactionsTypeButtons).shouldBe(sizeNotEqual(0).because("Реакции не отображаются"));
        SelenideElement react = reactionsTypeButtonsElems.get(numOfReaction);
        react = react.shouldBe(visible.because("Выбранная реакиция не отображается!"));
        String reactName = react.getAttribute(reactionName);
        react.click();

        return reactName;
    }

    public String getReactionName(){
        SelenideElement reactionButtonElem = element.$(reactionButton);
        SelenideElement selectReactTextElem = reactionButtonElem.$(selectReactText);
        return selectReactTextElem.getText();
    }
}
