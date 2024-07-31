package org.example.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

    public class ComparisonPage {

        private static WebDriver driver;
        private static WebDriverWait wait;

        public ComparisonPage(WebDriver driver) {
            ComparisonPage.driver = driver;
            wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            PageFactory.initElements(driver, this);

        }

        public static void navigateTo(String url) {
            driver.get("https://rozetka.com.ua/ua/notebooks/c80004/");
        }

        @FindBy(xpath = "(//button[contains(@class, \"compare-button\")]")
        public static WebElement product1;

        public static void chooseProduct1() {
            wait.until(ExpectedConditions.elementToBeClickable(product1)).click();
        }

        @FindBy(xpath = "//button[contains(@class, \"compare-button\")]")
        public static WebElement product2;


        public static void chooseProduct2() {
            wait.until(ExpectedConditions.elementToBeClickable(product2)).click();
        }

        @FindBy(xpath = "//a[contains(@title,\"Списки порівнянь\")]")
        public static WebElement comparePage;

        public static void clickComparePage() {
            wait.until(ExpectedConditions.elementToBeClickable(comparePage)).click();
        }

        public static List<WebElement> getSelectedProducts() {
            By selectedProductsLocator = By.xpath("//rz-products-list-item");
            wait.until(ExpectedConditions.visibilityOfElementLocated(selectedProductsLocator));
            return driver.findElements(selectedProductsLocator);
        }

    }

