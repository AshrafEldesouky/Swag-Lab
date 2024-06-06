package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static drivers.DriverHolder.getDriver;

public class PageBase {

    public static void hoverElement(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
    }


    public static void SCrollDown(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)", "");
    }

    public static void SCroll_deepTill_Down(WebDriver driver) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    public static void ThreadSleep2000() throws InterruptedException {
        Thread.sleep(2000);
    }
    public static void ThreadSleep1000() throws InterruptedException {
        Thread.sleep(1000);
    }
    public static void ThreadSleep500() throws InterruptedException {
        Thread.sleep(500);
    }

    public static void NavigateBackmethod() {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        getDriver().navigate().back();
        System.out.println("Back Dooooooooooone");
    }
}
