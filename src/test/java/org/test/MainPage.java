package org.test;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.Optional;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {
    private By userFullName = By.xpath("//*[contains(@class,\"tico ellip\")]");

    private By textNoteStarter = By.xpath("//a[contains(@class, 'pf-head_itx_a')]");
    private By textNoteInput = By.xpath("//div[contains(@class, 'ok-posting-handler')]");
    private By textNoteSubmitButton = By.xpath("//div[contains(@class, 'posting_submit')]");
    private By feedElems = By.xpath("//div[contains(@class, 'feed-w')]");
    private By notePageButton = By.xpath("//a[contains(@data-l,'t,userStatuses')]");

    public String getName(){
        return $(userFullName).shouldBe(visible.because("Имя пользователя не отображается!")).getText();
    }

    public void makeNote(String text){
        $(textNoteStarter).click();
        $(textNoteInput).setValue(text);
        $(textNoteSubmitButton).click();
        sleep(1000);
    }

    public ArrayList <FeedElem> getFeedList() {
        ArrayList<FeedElem> feedList = new ArrayList<>();
        for (SelenideElement elem : $$(feedElems)) {
            feedList.add(new FeedElem(elem));
        }
        return feedList;
    }

    public Optional<FeedElem> getLastFeedByUsername(String username){
        for (FeedElem elem: getFeedList()){
            if (elem.isByUser() && elem.getAuthor().equals(username)){
                return Optional.of(elem);
            }
        }
        return Optional.empty();
    }

    public void openNotePage(){
        $(notePageButton).click();
    }
}