package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CategoryPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//rz-filter-section-autocomplete//a[contains(@href,\"asus\")]")
    private WebElement applyFilterButton;

    @FindBy(xpath = "//rz-products-list-item")
    private List<WebElement> productItems;

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public void applyFilter() {
        wait.until(ExpectedConditions.visibilityOf(applyFilterButton)).click();
        applyFilterButton.click();
    }

    public int getNumberOfProducts() {
        return productItems.size();
    }
}
