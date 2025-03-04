package pages;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class AddBookPage {
    WebDriver driver;
    TakesScreenshot ts = (TakesScreenshot) driver;
    File src = ts.getScreenshotAs(OutputType.FILE);

    public AddBookPage(WebDriver driver) {

        this.driver = driver;
    }

    public void verifyUserIsOnAddBookPage() {
        WebElement addBookHeading = driver.findElement(By.id("add-book-heading"));
        Assertions.assertTrue(addBookHeading.isDisplayed(), "User is NOT on the correct page");
        try {
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(FileUtils.readFileToByteArray(src)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void enterBookDetailsAndSubmit(String title, String author, String genre, String isbn, String publicationDate, String price) {
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(title);
        WebElement authorField = driver.findElement(By.id("author"));
        authorField.sendKeys(author);
        Select genreDropdown = new Select(driver.findElement(By.id("genre")));
        genreDropdown.selectByVisibleText(genre);
        WebElement isbnField = driver.findElement(By.id("isbn"));
        isbnField.sendKeys(isbn);
        WebElement pubDateField = driver.findElement(By.id("publicationDate"));
        pubDateField.sendKeys(publicationDate);
        WebElement priceField = driver.findElement(By.id("price"));
        priceField.sendKeys(price);

    }

    public void addBook(){
        WebElement addBookButton = driver.findElement(By.className("add-book-button"));
        addBookButton.click();
    }

    public void isBookDisplayed(String title) {
        try {
            // Locate the book in the list using XPath with the given title
            WebElement bookElement = driver.findElement(By.xpath("//td[contains(text(), '" + title + "')]"));
            bookElement.isDisplayed();
            System.out.println("Book found");
        } catch (NoSuchElementException e) {
            System.out.println("Book not found");
        }
    }

    public void isErrorDisplayed() {
        WebElement errorElement = driver.findElement(By.cssSelector("h3.font-bold"));
        Assertions.assertNotNull(errorElement, "Element should not be null");
        Assertions.assertTrue(errorElement.isDisplayed(), "Element is not visible on the page!");
        Assertions.assertEquals("Please correct the following errors:", errorElement.getText(), "Text does not match expected");

    }




}
