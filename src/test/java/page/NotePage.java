package page;

import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Utils;

import java.time.Duration;
import java.util.List;

public class NotePage extends Utils {
    @AndroidFindBy(xpath = "//*[contains(@text, 'Search your notes')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"screenTitle\"")
    WebElement searchYourNotes;
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @AndroidFindBy(id = "new_note_button")
    WebElement takeANote;

    @AndroidFindBy(id = "editable_title")
    WebElement noteTitle;

    @AndroidFindBy(id = "edit_note_text")
    WebElement noteBody;

    @AndroidFindBy(id = "menu_switch_to_list_view")
    WebElement listViewIcon;

    @AndroidFindBy(id = "browse_text_note")
    List<WebElement> notesList;

    @AndroidFindBy(id = "menu_archive")
    WebElement archive;

    @AndroidFindBy(id = "menu_reminder")
    WebElement reminder;

    @AndroidFindBy(id = "date_spinner")
    WebElement reminderDate;

    @AndroidFindBy(id = "time_spinner")
    WebElement reminderTime;

    public NotePage(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(getTimeout())), this);
    }

    public WebElement searchYourNotes(){
        int centerX = ((getDriver().manage().window().getSize().getWidth())/2);
        int centerY = (int) ((getDriver().manage().window().getSize().getHeight())/2);
        TouchAction touch = new TouchAction(getDriver());
        PointOption initialPoint = new PointOption();
        PointOption finalPoint = new PointOption();
        initialPoint.withCoordinates(centerX, centerY);
        finalPoint.withCoordinates(centerX, (int)(centerY-200));
        touch.longPress(initialPoint).moveTo(finalPoint).release().perform();
        return searchYourNotes;
    }

    public void ListView(){
        try{
            if(listViewIcon.isDisplayed())
                listViewIcon.click();
        }
        catch (Exception e){
            //TODO
        }
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
        wait.until(ExpectedConditions.visibilityOf(noteBody));
        getDriver().navigate().back();
    }

    public WebElement checkLastNoteByItsTitle(String noteTitle){
        return notesList.get(0).findElement(By.xpath("//*[contains(@text, '"+noteTitle+"')]"));
    }

    public void archiveLastNote(){
        notesList.get(0).click();
        archive.click();
    }

    public void setReminder(String day, String time){
        reminder.click();
        reminderDate.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '"+day+"')]"))).click();
        reminderTime.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, '"+time+"')]"))).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, 'Save')]"))).click();
    }

    public boolean checkLastNoteByItsTitleAndReminder(String noteTitle, String day, String time){
        String hourlyTime = "";
        if(time.equals("Night"))
            hourlyTime = "8:00 PM";

        WebElement firstNote = notesList.get(0);

        return firstNote.findElement(By.xpath("//*[contains(@text, '"+noteTitle+"')]")).isDisplayed() &&
                firstNote.findElement(By.xpath("//*[contains(@text, '"+day+", "+ hourlyTime+"')]")).isDisplayed();
    }
}