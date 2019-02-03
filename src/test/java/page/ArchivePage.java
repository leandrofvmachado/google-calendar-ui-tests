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

public class ArchivePage extends Utils {
    @AndroidFindBy(xpath = "//*[contains(@text, 'Search your notes')]")
    @iOSXCUITFindBy(iOSNsPredicate = "label == \"screenTitle\"")
    WebElement searchYourNotes;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    WebElement navDrawer;

    @AndroidFindBy(id = "menu_switch_to_list_view")
    WebElement listViewIcon;

    @AndroidFindBy(id = "browse_text_note")
    List<WebElement> notesList;

    @AndroidFindBy(id = "menu_archive")
    WebElement archive;



    public ArchivePage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(getTimeout())), this);
    }

    public accessArchiveScreen(){
        navDrawer.click();

    }
}