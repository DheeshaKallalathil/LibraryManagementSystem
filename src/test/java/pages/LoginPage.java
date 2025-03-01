package pages;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.qameta.allure.*;


public class LoginPage {
    WebDriver driver;



    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[@id='login-button']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Page Actions
    @Test
    @Story("User logs in with valid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("This test verifies that the user can log in with valid credentials")
    @Step("User enters username and password, then clicks login")
    public void verify_the_user_is_on_the_login_page() {
        boolean isDisplayed = driver.findElement(By.id("login-heading")).isDisplayed();
        Assertions.assertTrue(isDisplayed, "User is NOT on the login page");
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        try {
            // Check if error message is displayed
            WebElement errorMessage = driver.findElement(By.xpath("//li[contains(text(), 'Invalid username or password. Please try again.')]"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Success");
        }
    }

    public void verifyErrorMessageDisplayed() {

        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        try {
            // Check if error message is displayed
            WebElement errorMessage = driver.findElement(By.xpath("//li[contains(text(), 'Invalid username or password. Please try again.')]"));
            if (errorMessage.isDisplayed()) {
                System.out.println("Invalid username or password. Please try again.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Success");
        }

    }
}
