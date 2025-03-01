package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import utils.DriverFactory;
public class HomePageSteps {
    WebDriver driver = DriverFactory.getDriver();
    HomePage homePage = new HomePage(driver);

    @Then("the user should be redirected to the home page")
    public void the_user_should_be_redirected_to_the_home_page() {
        homePage.verifyUserIsOnHomePage();
    }
    @When("the user clicks on the Add Book button")
    public void theUserClicksOnTheButton() {
        homePage.clickAddBookButton();
    }

    @When("the user clicks the Logout button")
    public void theUserClicksTheLogoutButton() {
        homePage.clickLogOutButton();
    }

    @Then("the user is logged out but remains on the home page")
    public void theUserIsLoggedOutButRemainsOnTheHomePage() {
        homePage.isBookListDisplayed();
    }

    @When("the user tries to update a book via the edit button")
    public void theUserTriesToUpdateABookViaTheEditButton() {
        homePage.clickEditButton();
    }

    @Then("the user should receive an error message")
    public void theUserShouldReceiveAnErrorMessage() {
        homePage.verifyEditDetailsPage_isnotDisplayed();
    }

    @When("user clicks on the delete button")
    public void userClicksOnTheDeleteButton() {
        homePage.deleteBook();
    }

    @Then("the book should be removed from the list")
    public void theBookShouldBeRemovedFromTheList() {
        homePage.deleteBookAndVerify();
    }

    @Then("{string} should be displayed in the publication date field")
    public void shouldBeDisplayedInThePublicationDateField(String InvalidDate) {
        homePage.verifyInvalidDateMessage(InvalidDate);
    }
}
