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
}
