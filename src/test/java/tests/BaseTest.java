package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import steps.LoginSteps;
import steps.ProductsSteps;

import java.time.Duration;
import static tests.Config.BROWSER;
import static tests.Config.IMPLICIT_WAIT;

public abstract class BaseTest {
    private static WebDriver driver;
    LoginSteps loginSteps;
    ProductsSteps productsSteps;

    @BeforeClass
    public void setUp(){
        switch (BROWSER){
            case"Chrome":
            System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
            driver = new ChromeDriver();
            break;
            case("Edge"):
                System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
                driver = new EdgeDriver();
                break;
            default: Assert.fail("Incorrect browser name");
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_WAIT));
        loginSteps = new LoginSteps();
        productsSteps = new ProductsSteps();
    }

     @AfterClass
     public void tearDown(){
      driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
