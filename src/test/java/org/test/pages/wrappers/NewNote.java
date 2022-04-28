package org.test.pages.wrappers;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NewNote {
    private String header;
    private String text;
    private String quizQuestion;
    private ArrayList<String> answers;

    private By moreOptionsButton = By.xpath("//span[contains(@class,'posting_itx_ac_menu')]");
    private By headerAddButton = By.xpath("//div[contains(@data-action,'add_header')]");
    private By headerField = By.xpath("//textarea[contains(@data-id,'adHeader')]");
    private By textField = By.xpath("//div[contains(@class, 'ok-posting-handler')]");
    private By addQuizButton = By.xpath("//div[contains(@data-l,'t,button.poll')]");
    private By questionField = By.xpath("//textarea[contains(@data-id,'question')]");
    private By answerFieldFirst = By.xpath("(//div[contains(@class,'js-poll-answers')]//div[contains(@class,'visible')])[1]//textarea");
    private By answerFieldLast = By.xpath("(//div[contains(@class,'js-poll-answers')]//div[contains(@class,'visible')])[last()]//textarea");
    private By submitButton = By.xpath("//div[contains(@class, 'posting_submit')]");

    public NewNote(String header, String text, String quizQuestion, ArrayList<String> answers){
        this.header = header;
        this.text = text;
        this.quizQuestion = quizQuestion;
        this.answers = answers;
    }

    public static NewNoteBuilder builder(){
        return new NewNoteBuilder();
    }

    private void makeHeader(){
        SelenideElement moreOptionsButtonElem = $(moreOptionsButton).shouldBe(visible.because("Не отображается кнопка дополнительных действий!"));
        moreOptionsButtonElem.click();
        SelenideElement headerAddButtonElem = $(headerAddButton).shouldBe(visible.because("Не отображается кнопка добавления заголовка!"));
        headerAddButtonElem.click();
        SelenideElement headerFieldElem = $(headerField).shouldBe(visible.because("Не отображается поле для ввода заголовка!"));
        headerFieldElem.setValue(header);
    }

    private void makeText(){
        SelenideElement textFieldElem = $(textField).shouldBe(visible.because("Не отображается поле для ввода текста!"));
        textFieldElem.setValue(text);
    }

    private void makeQuiz(){
        SelenideElement addQuizButtonElem = $(addQuizButton).shouldBe(visible.because("Не отображается кнопка добавления опроса!"));
        addQuizButtonElem.click();
        SelenideElement questionFieldElem = $(questionField).shouldBe(visible.because("Не отображается поле для ввода вопроса!"));
        questionFieldElem.setValue(quizQuestion);
        SelenideElement answerFieldFirstElem = $(answerFieldFirst).shouldBe(visible.because("Не отображается поле для ввода ответа!"));
        answerFieldFirstElem.setValue(answers.get(0));

        SelenideElement answerFieldLastElem;
        for (int i = 1; i < answers.size(); i++){
            answerFieldLastElem = $(answerFieldLast).shouldBe(visible.because("Не отображается поле для ввода ответа!"));
            answerFieldLastElem.setValue(answers.get(i));
        }
    }

    public void send(){
        if (header != null){
            makeHeader();
        }

        if (text != null){
            makeText();
        }

        if (quizQuestion != null){
            makeQuiz();
        }

        SelenideElement submitButtonElem = $(submitButton).shouldBe(visible.because("Кнопка для отправки поста не отображается!"));
        submitButtonElem.click();
        $(textField).shouldNot(visible.because("Не дождались автоматического закрытия окна!"));
    }
}
