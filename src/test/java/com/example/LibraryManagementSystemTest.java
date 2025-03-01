package com.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class LibraryManagementSystemTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String URL = "https://applicationforlibrarymanagementsystem.onrender.com/";
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    @Test
    public void openLibraryManagementSystemAndLogin() {
        driver.get("https://applicationforlibrarymanagementsystem.onrender.com/login");
        boolean isDisplayed = driver.findElement(By.id("login-heading")).isDisplayed();
        Assertions.assertTrue(isDisplayed, "User is NOT on the login page");
        driver.findElement(usernameField).sendKeys("admin1");
        driver.findElement(passwordField).sendKeys("securePassword");
        driver.findElement(By.xpath("//button[@id='login-button']")).click();
        WebElement welcomeMessage = driver.findElement(By.xpath("//h2[contains(text(), 'Welcome, Admin!')]"));
        Assertions.assertTrue(welcomeMessage.isDisplayed(), "User is NOT on the login page");
        WebElement addBookButton = driver.findElement(By.cssSelector(".add-book-button"));
        addBookButton.click();
        // Locate the heading element on the Add Book page
        WebElement addBookHeading = driver.findElement(By.id("add-book-heading"));
        // Verify that the heading is displayed
        Assertions.assertTrue(addBookHeading.isDisplayed(), "User is NOT on the login page");
        WebElement titleField = driver.findElement(By.id("title"));
        titleField.sendKeys("Atomic Habits");
        // Enter Author
        WebElement authorField = driver.findElement(By.id("author"));
        authorField.sendKeys("James Clear");
        // Select Genre from Dropdown
        Select genreDropdown = new Select(driver.findElement(By.id("genre")));
        genreDropdown.selectByVisibleText("Fiction");
        // Enter ISBN
        WebElement isbnField = driver.findElement(By.id("isbn"));
        isbnField.sendKeys("453674937453");
        // Enter Publication Date
        WebElement pubDateField = driver.findElement(By.id("publicationDate"));
        pubDateField.sendKeys("25-04-1990");
        // Enter Price
        WebElement priceField = driver.findElement(By.id("price"));
        priceField.sendKeys("10.00");
        WebElement addBookButton1 = driver.findElement(By.className("add-book-button"));
        addBookButton1.click();
        try {
            // Locate the book in the list using XPath with the given title
            WebElement bookElement = driver.findElement(By.xpath("//td[contains(text(), '" + "Atomic Habits" + "')]"));
            bookElement.isDisplayed();
            System.out.println("Book found");
        } catch (NoSuchElementException e) {
            System.out.println("Book not found");
        }
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}