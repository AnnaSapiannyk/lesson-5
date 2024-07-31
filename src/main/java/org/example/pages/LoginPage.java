package org.example.pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class LoginPage {

        private WebDriver driver;
        private static WebDriverWait wait;

        @FindBy (xpath = "//li//button[contains (@class,\"header__button\")]")
        private WebElement loginButton;

        @FindBy (xpath = "//button[text()=\"Увійти через пошту\"]")
        private WebElement emailButton;

        @FindBy (id = "email")
        private WebElement loginField;

        @FindBy(xpath = "//input[contains (@id,\"password\")]")
        private WebElement passwordField;

        @FindBy(xpath = "//button[contains(@type, \"submit\")]")
        private WebElement submitButton;

        @FindBy(xpath = "//div[contains(@class, 'warning')]")
        private WebElement errorMessage;

        public LoginPage(WebDriver driver) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
    }

        public void login(String username, String password) {
            wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(emailButton)).click();
            loginField.sendKeys("invalidEmail@gmail.com");
            passwordField.sendKeys("invalidPassword");
            submitButton.click();
        }


        public boolean isErrorDisplayed() {
            return wait.until(ExpectedConditions.visibilityOf(errorMessage)).isDisplayed();
        }

    }

