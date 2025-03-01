package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.qameta.allure.*;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUserIsOnHomePage() {
        WebElement welcomeMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Welcome, Admin!')]"));
        Assertions.assertTrue(welcomeMessage.isDisplayed(), "User is NOT on the login page");

    }

    public void clickAddBookButton() {
        WebElement addBookButton = driver.findElement(By.cssSelector(".add-book-button"));
        addBookButton.click();
    }
}
