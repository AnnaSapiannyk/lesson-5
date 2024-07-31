import io.qameta.allure.testng.AllureTestNg;
import org.example.pages.ComparisonPage;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;



import java.time.Duration;
import java.util.List;

import static org.example.pages.ComparisonPage.getSelectedProducts;
import static org.testng.AssertJUnit.assertEquals;




@Listeners({AllureTestNg.class})

public class ComparisonPageTest {
        public static WebDriver driver;
        public static WebDriverWait wait;


    @BeforeTest
        public void SetupDriver() {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver.get("https://rozetka.com.ua/ua/");
            wait = new WebDriverWait(driver, Duration.ofSeconds(25));
            new ComparisonPage(driver);
            driver.manage().window().maximize();
            JavascriptExecutor js = (JavascriptExecutor) driver;
        }


    @Test
    public void comparisonPageTest(){

        ComparisonPage.navigateTo("https://rozetka.com.ua/ua/notebooks/c80004/");
        ComparisonPage.chooseProduct1();
        ComparisonPage.chooseProduct2();
        ComparisonPage.comparePage.click();
        List<WebElement> selectedProducts = getSelectedProducts();
        System.out.println("Number of selected products: " + selectedProducts.size());
        assertEquals(String.valueOf(selectedProducts.size()), "2", "Size of selection is not equal 2" );
    }
}
