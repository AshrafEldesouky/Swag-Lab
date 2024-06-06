package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P03_YourCartPage {
    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;
    public P03_YourCartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver==null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }
    private final By CheckOut_BUTTON = By.xpath("//a[text()='CHECKOUT']");
    private final By ContinueShopping_BUTTON = By.xpath("//a[@class='btn_secondary']");
    private final By YourInformation_Title = By.xpath("//div[@class='subheader']");
    public P03_YourCartPage Click_CheckOut_BUTTON() {
        driver.findElement(this.CheckOut_BUTTON).click();
        return this;
    }
    public P03_YourCartPage Click_ContinueShopping_BUTTON() {
        driver.findElement(this.ContinueShopping_BUTTON).click();
        return this;
    }
    public boolean VerifyYourInformationPageSucessfully() {
        return driver.findElement(this.YourInformation_Title).getText().contains("Checkout: Your Information");
    }
    public boolean  VerifyourInformation_isVisible() {
        return getDriver().findElement(this.YourInformation_Title).isDisplayed();
//        return driver.findElement(this.ADD_TO_CART_Button1).isEnabled();
//        return driver.findElement(this.ADD_TO_CART_Button1).isSelected();//Checkbox
    }
    public String  VerifyourInformation_ByAssertEqual() {
        return getDriver().findElement(this.YourInformation_Title).getText();
    }

}
