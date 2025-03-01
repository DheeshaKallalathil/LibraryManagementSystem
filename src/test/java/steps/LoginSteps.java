package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginSteps {
    WebDriver driver = DriverFactory.getDriver();
    LoginPage loginPage = new LoginPage(driver);

    @Given("the user is on the Login page")
    public void the_user_is_on_the_login_page() {
        driver.get("https://applicationforlibrarymanagementsystem.onrender.com/login");
        loginPage.verify_the_user_is_on_the_login_page();
    }

    @When("the user enters username {string} and password {string}")
    public void the_user_enters_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
       loginPage.clickLogin();
    }

    @Then("the user should not be redirected to the home page")
    public void the_user_should_not_be_redirected_to_the_home_page() {
        loginPage.verifyErrorMessageDisplayed();
    }




}