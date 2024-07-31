import io.qameta.allure.testng.AllureTestNg;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureTestNg.class})

public class LoginPageTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;

    @BeforeClass
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://rozetka.com.ua/ua/");
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testLoginWithInvalidCredentials() {
        loginPage.login("dhdkflgh@gmail.com","1278");
        Assert.assertTrue(loginPage.isErrorDisplayed(), "Користувач з таким логіном не зареєстрований ");
    }

    @AfterClass
    public void closeDriver() {
            driver.quit();
    }
}
