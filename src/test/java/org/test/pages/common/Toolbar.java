package org.test.pages.common;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.test.pages.page.MainPage;
import org.test.pages.page.MessagePage;

import static com.codeborne.selenide.Condition.visible;

public class Toolbar {
    private SelenideElement toolbar;
    private By feedButton = By.xpath(".//a[contains(@id,'toolbar_logo_id')]");
    private By messageButton = By.xpath(".//li[contains(@data-l,'t,messages')]");
    private By discussionsButton = By.xpath(".//li[contains(@data-l,'t,discussions')]");
    private By notificationsButton = By.xpath(".//li[contains(@data-l,'t,notifications')]");
    private By guestsButton = By.xpath(".//li[contains(@data-l,'t,guests')]");
    private By marksButton = By.xpath(".//li[contains(@data-l,'t,marks')]");
    private By videoButton = By.xpath(".//li[contains(@data-l,'t,video')]");
    private By musicButton = By.xpath(".//li[contains(@data-l,'t,music')]");
    private By toolbarSearch = By.xpath(".//input[contains(@type,'text')]");
    private By userMenuButton = By.xpath(".//div[contains(@class,'toolbar_ucard')]");

    public Toolbar(SelenideElement tb){
        this.toolbar = tb;
    }

    public MainPage goToFeed(){
        SelenideElement FeedButtonElem = toolbar.$(feedButton).shouldBe(visible.because("Кнопка с лого не отображается!"));
        FeedButtonElem.click();
        return new MainPage();
    }

    public MessagePage goToMessages(){
        SelenideElement messageButtonElem = toolbar.$(messageButton).shouldBe(visible.because("Кнопка \"сообщения\" не отображается!"));
        messageButtonElem.click();
        return new MessagePage();
    }

    public void goToDiscussions(){
        SelenideElement discussionsButtonElem = toolbar.$(discussionsButton).shouldBe(visible.because("Кнопка \"обсуждения\" не отображается!"));
        discussionsButtonElem.click();
    }

    public void goToNotifications(){
        SelenideElement notificationsButtonElem = toolbar.$(notificationsButton).shouldBe(visible.because("Кнопка \"оповещения\" не отображается!"));
        notificationsButtonElem.click();
    }

    public void goToGuests(){
        SelenideElement guestsButtonElem = toolbar.$(guestsButton).shouldBe(visible.because("Кнопка \"гости\" не отображается!"));
        guestsButtonElem.click();
    }

    public void goToMarks(){
        SelenideElement marksButtonElem = toolbar.$(marksButton).shouldBe(visible.because("Кнопка \"события\" не отображается!"));
        marksButtonElem.click();
    }

    public void goToVideo(){
        SelenideElement videoButtonElem = toolbar.$(videoButton).shouldBe(visible.because("Кнопка \"видео\" не отображается!"));
        videoButtonElem.click();
    }

    public void goToMusic(){
        SelenideElement musicButtonElem = toolbar.$(musicButton).shouldBe(visible.because("Кнопка \"музыка\" не отображается!"));
        musicButtonElem.click();
    }

    public void doToolbarSearch(String text){
        SelenideElement toolbarSearchElem = toolbar.$(toolbarSearch).shouldBe(visible.because("Поле поиска в тулбаре не отображается!"));
        toolbarSearchElem.setValue(text).pressEnter();
    }

    public void goToUserMenu(){
        SelenideElement userMenuButtonElem = toolbar.$(userMenuButton).shouldBe(visible.because("Кнопка для пользовательского меню не отображается!"));
        userMenuButtonElem.click();
    }
}
