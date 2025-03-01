package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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

    public void clickLogOutButton() {
        WebElement logoutButton = driver.findElement(By.cssSelector(".logout-button"));
        logoutButton.click();
    }
    public void isBookListDisplayed() {
        WebElement bookListCaption = driver.findElement(By.xpath("//h2[contains(text(),'Book List')]"));
        Assertions.assertTrue(bookListCaption.isDisplayed(), "Book List caption is not displayed!");

    }
    public void clickEditButton() {
        WebElement editButton = driver.findElement(By.id("edit-book-1")); // Locate by ID
        editButton.click(); // Click the button
    }
    public void verifyEditDetailsPage_isnotDisplayed() {
        List<WebElement> headingElements = driver.findElements(By.xpath("//h2[@class='text-3xl font-bold mb-6']"));
        Assertions.assertTrue(headingElements.isEmpty(), "Test Failed: User is on the edit book details page!");
    }
    public void deleteBook(){
        WebElement deleteButton = driver.findElement(By.id("delete-book-1"));
        deleteButton.click();
    }

    public void deleteBookAndVerify() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isDeleted = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//td[contains(text(), 'The Very Busy Spider')]")));
        Assertions.assertTrue(isDeleted, "Test Failed: The book was not deleted!");
    }
}
