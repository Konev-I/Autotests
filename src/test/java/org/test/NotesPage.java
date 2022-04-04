package org.test;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class NotesPage {
    private By optionList = By.xpath("//span[contains(@class,'new_topic_icodown')]");
    private By deleteButton = By.xpath("(//div[contains(@id,'hook_Block_ShortcutMenu')]//a[contains(@class,'u-menu')])[last()]");

    public void deleteLastNote(){
        $(optionList).shouldBe(visible.because("Элемент для вызова меню не отображается!")).click();
        $(deleteButton).shouldBe(visible.because("Кнопка для удаления не отображается!")).click();
    }
}
