package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.EditBookDetailsPage;
import utils.DriverFactory;
public class EditBookSteps {
    WebDriver driver = DriverFactory.getDriver();
    EditBookDetailsPage editbookdetailspage = new EditBookDetailsPage(driver);

    @When("the user clicks on the edit button for a specific book")
    public void theUserClicksOnTheButtonForASpecificBook() {
         editbookdetailspage.clickEditButton();

    }

    @Then("the user is navigated to the Edit Book Details page")
    public void theUserIsNavigatedToThePage() {
        editbookdetailspage.verifyEditDetailsPage_isDisplayed();
    }

    @And("enters a new title {string} in the title field")
    public void entersANewTitleInTheTitleField(String title) {
        editbookdetailspage.enterNewTitle(title);
    }

    @And("clicks on the Save Changes button")
    public void clicksOnTheSaveChangesButton() {
        editbookdetailspage.clickSaveChanges();

    }

    @Then("the updated book title {string} is displayed on the home page")
    public void theUpdatedBookTitleIsDisplayedOnTheHomePage(String title) {
        editbookdetailspage.verifyNewTitle_isDisplayed(title);
    }
}