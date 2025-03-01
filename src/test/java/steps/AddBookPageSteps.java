package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.AddBookPage;
import utils.DriverFactory;


public class AddBookPageSteps {
    WebDriver driver = DriverFactory.getDriver();
    AddBookPage addBookPage = new AddBookPage(driver);

    @Then("the user should be navigated to the Add Book page")
    public void theUserShouldBeNavigatedToTheAddBookPage() {
        addBookPage.verifyUserIsOnAddBookPage();
    }

    @When("the user enters the book details: {string}, {string}, {string}, {string}, {string}, {string}")
    public void theUserEntersBookDetails(String title, String author, String genre, String isbn, String publicationDate, String price) {
        addBookPage.enterBookDetailsAndSubmit(title, author, genre, isbn, publicationDate, price);
    }

    @And("clicks on the {string} button")
    public void clicksOnTheButton(String arg0) {
        addBookPage.addBook();
    }

    @Then("the newly added book {string} should be displayed on the home page")
    public void theNewlyAddedBookShouldBeDisplayedOnTheHomePage(String title) {
        addBookPage.isBookDisplayed(title);
    }

    @Then("error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        addBookPage.isErrorDisplayed();
    }


}
