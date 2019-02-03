package page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import steps.Utils;

import java.time.Duration;
import java.util.List;

public class DrawerPage extends Utils {
    @AndroidFindBy(xpath = "//*[contains(@text, '//*[@resource-id=\"com.google.android.keep:id/drawer_navigation_archive\"]/android.widget.TextView[1]')]")
    WebElement archive;

    @AndroidFindBy(accessibility = "Open navigation drawer")
    WebElement navDrawer;

    @AndroidFindBy(id = "menu_switch_to_list_view")
    WebElement listViewIcon;




    public DrawerPage(){
        PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(getTimeout())), this);
    }

    public accessArchiveScreen(){
        navDrawer.click();

    }
}