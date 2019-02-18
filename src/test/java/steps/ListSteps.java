package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import page.ListPage;
import page.NotePage;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class ListSteps {
    ListPage listPage = new ListPage();
    NotePage notePage = new NotePage();
    List<List<String>> itemList;

    @When("^The user starts a new list$")
    public void theUserStartsANewList() {
        listPage.newList();
    }

    @And("^Assign the following items to the list$")
    public void assignTheFollowingItemsToTheList(DataTable data) {
        itemList = data.raw();
        listPage.addItemsToAList(itemList);
    }

    @And("^Removes the last one$")
    public void removesTheLastOne() {
        listPage.remoteLastListElement();
    }

    @Then("^The note list is created with the correct items$")
    public void theNoteListIsCreatedWithTheCorrectItems() {
        notePage.createNote();
        //Nesse caso não foi possível trazer a lógica de negócio
        List<WebElement> listElements = listPage.checkMostRecentList(itemList);
        assertTrue(listElements.size() == 2 &&
                listElements.get(0).findElement(By.xpath("//*[contains(@text, '"+ itemList.get(1).get(0) +"')]\"")).isDisplayed() &&
                listElements.get(1).findElement(By.xpath("//*[contains(@text, '"+ itemList.get(1).get(1) +"')]\"")).isDisplayed());
        assertTrue(listPage.checkStaleness(itemList.get(1).get(2)));
    }
}
