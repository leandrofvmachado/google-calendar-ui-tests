package steps;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
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
        assertTrue(listPage.checkMostRecentList(itemList));
    }
}
