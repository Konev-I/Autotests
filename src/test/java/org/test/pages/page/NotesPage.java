package org.test.pages.page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.test.pages.page.BasePage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NotesPage extends BasePage {
    private By optionList = By.xpath("//span[contains(@class,'new_topic_icodown')]");
    private By deleteButton = By.xpath("(//div[contains(@id,'hook_Block_ShortcutMenu')]//a[contains(@class,'u-menu')])[last()]");

    public NotesPage() {
        isLoaded();
    }

    @Override
    public void isLoaded() {
        $(optionList).shouldBe(visible.because("Не дождались загрузки кнопки дествий!"));
    }

    public void deleteLastNote(){
        SelenideElement optionListElem = $(optionList).shouldBe(visible.because("Элемент для вызова меню не отображается!"));
        optionListElem.click();
        SelenideElement deleteButtonElem = $(deleteButton).shouldBe(visible.because("Кнопка для удаления не отображается!"));
        deleteButtonElem.click();
    }
}
