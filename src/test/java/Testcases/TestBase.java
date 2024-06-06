package Testcases;

import drivers.DriverFactory;
import drivers.DriverHolder;
//import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class TestBase {
  protected static WebDriver driver;

    @BeforeTest
    public void setupDriver() {
//        WebDriverManager.chromedriver().setup();
        driver = DriverFactory.getNewInstance(" ");
        DriverHolder.setDriver(driver);
        driver.get("https://www.saucedemo.com/v1/");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
//        Thread.currentThread().interrupt();
    }
}