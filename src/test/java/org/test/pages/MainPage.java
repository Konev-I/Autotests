package org.test.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.test.pages.wrappers.FeedElemWrapper;
import org.test.pages.wrappers.NewNote;
import org.test.pages.wrappers.ToolbarWrapper;

import java.util.ArrayList;
import java.util.Optional;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage extends BasePage{
    private By userFullName = By.xpath("//*[contains(@class,\"tico ellip\")]");

    private By textNoteStarter = By.xpath("//a[contains(@class, 'pf-head_itx_a')]");
    private By feedElems = By.xpath("//div[contains(@class, 'feed-w')]");
    private By notePageButton = By.xpath("//a[contains(@data-l,'t,userStatuses')]");
    private ToolbarWrapper toolbar = new ToolbarWrapper($(By.xpath("//div[contains(@data-module,'ToolbarManager')]")));

    public MainPage(){
        isLoaded();
    }

    @Override
    public void isLoaded() {
        $(userFullName).shouldBe(visible.because("Не дождались загрузки элемента с именем пользователя!"));
        $(textNoteStarter).shouldBe(visible.because("Не дождались загрузки кнопки для создания постов!"));
    }

    public String getName(){
        return $(userFullName).shouldBe(visible.because("Имя пользователя не отображается!")).getText();
    }

    public MainPage makeNote(NewNote note){
        $(textNoteStarter).shouldBe(visible.because("Кнопка начала создания заметки не отображается!")).click();
        note.send();
        return this;
    }

    public ArrayList <FeedElemWrapper> getFeedList() {
        ArrayList<FeedElemWrapper> feedList = new ArrayList<>();
        for (SelenideElement elem : $$(feedElems)) {
            feedList.add(new FeedElemWrapper(elem));
        }
        return feedList;
    }

    public Optional<FeedElemWrapper> getLastFeedByUsername(String username){
        for (FeedElemWrapper elem: getFeedList()){
            if (elem.isByUser() && elem.getAuthor().equals(username)){
                return Optional.of(elem);
            }
        }
        return Optional.empty();
    }

    public NotesPage openNotePage(){
        $(notePageButton).shouldBe(visible.because("Кнопка перехода на траницу заметок не отображается!")).click();
        return new NotesPage();
    }

    public MessagePage openMessagePage(){
        toolbar.openMessages();
        return new MessagePage();
    }
}