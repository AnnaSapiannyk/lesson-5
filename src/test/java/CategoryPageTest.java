import io.qameta.allure.testng.AllureTestNg;
import org.example.pages.CategoryPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;

@Listeners({AllureTestNg.class})

public class CategoryPageTest {

    @Test
    public void testSingleProductAfterFilter() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");

        CategoryPage categoryPage = new CategoryPage(driver);
        categoryPage.applyFilter();

        Assert.assertEquals(1, categoryPage.getNumberOfProducts());

        driver.quit();
    }
}
