package steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.DrawerPage;
import page.NotePage;

import static org.testng.AssertJUnit.assertTrue;

public class NoteSteps {
    NotePage notePage = new NotePage();
    DrawerPage drawerPage = new DrawerPage();
    String noteTitle, noteBody;

    @Given("^The user in the notes screen$")
    public void theUserInTheNotesScreen() {
        assertTrue(notePage.searchYourNotes().isDisplayed());
    }

    @And("^The notes are in List View$")
    public void theNotesAreInListView() {
        notePage.ListView();
    }

    @When("^The user starts a new note$")
    public void theUserStartsANewNote() {
        notePage.openNoteEditor();
    }

    @And("^Assign \"([^\"]*)\" to title$")
    public void assignToTitle(String title) {
        noteTitle = title;
        notePage.assignTitle(title);
    }

    @And("^Assign \"([^\"]*)\" to description$")
    public void assignToDescription(String body) {
        noteBody = body;
        notePage.assignBody(body);
    }

    @Then("^The note is created$")
    public void theNoteIsCreated() {
        notePage.createNote();
        assertTrue(notePage.checkLastNoteByItsTitle(noteTitle).isDisplayed());
    }

    @Given("^A note with the title \"([^\"]*)\" is created$")
    public void aNoteWithTheTitleIsCreated(String title) {
        noteTitle = title;
        assertTrue(notePage.checkLastNoteByItsTitle(noteTitle).isDisplayed());
    }

    @And("^The last created note has the title \"([^\"]*)\"$")
    public void theLastCreatedNoteHasTheTitle(String title) {
        noteTitle = title;
        assertTrue(notePage.checkLastNoteByItsTitle(noteTitle).isDisplayed());
    }

    @When("^The user archives the note$")
    public void theUserArchivesTheNote() {
        notePage.archiveLastNote();
    }

    @Then("^The note is archived$")
    public void theNoteIsArchived() {
        drawerPage.accessArchiveScreen();
        assertTrue(notePage.checkLastNoteByItsTitle(noteTitle).isDisplayed());
    }


}
