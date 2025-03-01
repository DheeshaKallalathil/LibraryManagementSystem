package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import io.qameta.allure.*;

public class EditBookDetailsPage {
    WebDriver driver;

    public EditBookDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickEditButton() {
        WebElement editButton = driver.findElement(By.id("edit-book-1")); // Locate by ID
        editButton.click(); // Click the button
    }

    public void verifyEditDetailsPage_isDisplayed() {
        WebElement heading = driver.findElement(By.xpath("//h2[@class='text-3xl font-bold mb-6']"));
        Assertions.assertTrue(heading.isDisplayed(), "Edit book details page is NOT displayed!");
        Assertions.assertEquals("Edit book details", heading.getText(), "Heading text does not match!");
    }

    public void enterNewTitle(String title) {
        WebElement titleField = driver.findElement(By.id("edit-title"));

        // Click on the title field
        titleField.click();

        // Clear the existing text
        titleField.clear();

        // Enter the new title
        titleField.sendKeys(title);
    }

    public void clickSaveChanges() {
        driver.findElement(By.id("save-changes")).click();
    }

    public void verifyNewTitle_isDisplayed(String title) {
        String displayedTitle = driver.findElement(By.xpath("(//td[@class='border-b border-gray-300 p-4 text-left'])[1]")).getText();
        Assertions.assertEquals(title, displayedTitle, "The displayed title does not match the expected title.");
    }


}
