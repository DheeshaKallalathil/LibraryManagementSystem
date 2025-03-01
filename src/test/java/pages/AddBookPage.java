package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import io.qameta.allure.*;

public class AddBookPage {
    WebDriver driver;

    public AddBookPage(WebDriver driver) {
        this.driver = driver;
    }

    public void verifyUserIsOnAddBookPage() {
        // Locate the heading element on the Add Book page
        WebElement addBookHeading = driver.findElement(By.id("add-book-heading"));
        // Verify that the heading is displayed
        Assertions.assertTrue(addBookHeading.isDisplayed(), "User is NOT on the login page");
    }

    public void enterBookDetailsAndSubmit(String title, String author, String genre, String isbn, String publicationDate, String price) {
        // Enter Title
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys(title);

        // Enter Author
        WebElement authorField = driver.findElement(By.id("author"));
        authorField.sendKeys(author);

        // Select Genre from Dropdown
        Select genreDropdown = new Select(driver.findElement(By.id("genre")));
        genreDropdown.selectByVisibleText(genre);

        // Enter ISBN
        WebElement isbnField = driver.findElement(By.id("isbn"));
        isbnField.sendKeys(isbn);

        // Enter Publication Date
        WebElement pubDateField = driver.findElement(By.id("publicationDate"));
        pubDateField.sendKeys(publicationDate);

        // Enter Price
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
