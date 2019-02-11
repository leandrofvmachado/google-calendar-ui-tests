package page;

import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.Utils;

import java.time.Duration;
import java.util.List;

public class ListPage extends Utils {
    WebDriverWait wait = new WebDriverWait(getDriver(), 10);

    @AndroidFindBy(id = "editable_title")
    WebElement noteTitle;

    @AndroidFindBy(id = "new_list_button")
    WebElement newList;

    @AndroidFindBy(id = "description")
    List<WebElement> listElementsList;

    @AndroidFindBy(id = "deleteButton")
    WebElement closeEditTextListElement;

    @AndroidFindBy(id = "browse_list_note")
    List<WebElement> listNotesList;

    @AndroidFindBy(id = "add_item_text_view")
    WebElement addListElement;

    @AndroidFindBy(id = "editor_list_item_container")
    List<WebElement> listElements;

    public ListPage(){
        PageFactory.initElements(new AppiumFieldDecorator(getDriver(), Duration.ofSeconds(getTimeout())), this);
    }

    public void newList(){
        newList.click();
    }

    public void addItemsToAList(List<List<String>> itemList){
        listElementsList.get(0).click();
        for(int i = 0; i < itemList.get(1).size(); i++){
            listElementsList.get(i).sendKeys(itemList.get(1).get(i));
            addListElement.click();
        }
        //removing empty edit text
        closeEditTextListElement.click();
    }

    public void remoteLastListElement(){
        closeEditTextListElement.click();
    }

    public boolean checkMostRecentList(List<List<String>> itemList){
        listNotesList.get(0).click();

        return listElements.size() == 2 &&
                listElements.get(0).findElement(By.xpath("//*[contains(@text, '"+ itemList.get(1).get(0) +"')]\"")).isDisplayed() &&
                listElements.get(1).findElement(By.xpath("//*[contains(@text, '"+ itemList.get(1).get(1) +"')]\"")).isDisplayed() &&
                wait.until(ExpectedConditions.stalenessOf(getDriver().findElement(By.xpath("//*[contains(@text, '"+ itemList.get(1).get(3) +"')]\""))));
    }
}
