package page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.Utils;

import java.time.Duration;
import java.util.List;

public class NotePage extends Utils {
    @AndroidFindBy(xpath = "//*[contains(@text, 'Search your notes')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"screenTitle\"")
    WebElement searchYourNotes;

    @AndroidFindBy(id = "new_note_button")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Take a note...\"")
    WebElement takeANote;

    @AndroidFindBy(id = "editable_title")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Take a note...\"")
    WebElement noteTitle;

    @AndroidFindBy(id = "edit_note_text")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"Take a note...\"")
    WebElement noteBody;

    @AndroidFindBy(id = "menu_switch_to_list_view")
    WebElement listViewIcon;

    @AndroidFindBy(id = "browse_text_note")
    List<WebElement> notesList;

    @AndroidFindBy(id = "menu_archive")
    WebElement archive;

    public NotePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(getTimeout())), this);
    }

    public WebElement searchYourNotes(){
        return searchYourNotes;
    }

    public void ListView(){
        if(listViewIcon.isDisplayed())
            listViewIcon.click();
    }

    public void openNoteEditor(){
        takeANote.click();
    }

    public void assignTitle(String title){
        noteTitle.sendKeys(title);
    }

    public void assignBody(String body){
        noteBody.sendKeys(body);
    }

    public void createNote(){
        getDriver().navigate().back();
    }

    public WebElement checkLastNoteByItsTitle(String noteTitle){
        return notesList.get(0).findElement(By.xpath("//*[contains(@text, '"+noteTitle+"')]"));
    }

    public void archiveLastNote(){
        notesList.get(0).click();
        archive.click();
    }

}