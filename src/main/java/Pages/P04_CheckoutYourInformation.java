package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static drivers.DriverHolder.getDriver;

public class P04_CheckoutYourInformation {
    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;
    public P04_CheckoutYourInformation(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver==null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }
    private final By FIRSTName_TXT = By.xpath("//input[@id='first-name']");
    private final By LastName_TXT = By.xpath("//input[@id='last-name']");
    private final By PostalCode_TXT = By.xpath("//input[@id='postal-code']");
    private final By Continue_BUTTON = By.xpath("//input[@type='submit']");

    private final By YourCheckoutOverView_Title = By.xpath("//div[@class='subheader']");
    public P04_CheckoutYourInformation Insert_FIRSTName_TXT() {
        driver.findElement(this.FIRSTName_TXT).sendKeys("ashraf");
        return this;
    }
    public P04_CheckoutYourInformation Insert_LastName_TXT() {
        driver.findElement(this.LastName_TXT).sendKeys("ashraf");
        return this;
    }
    public P04_CheckoutYourInformation Insert_PostalCode_TXT() {
        driver.findElement(this.PostalCode_TXT).sendKeys("11011");
        return this;
    }
    public P04_CheckoutYourInformation Click_Continue_BUTTON() {
        driver.findElement(this.Continue_BUTTON).click();
        return this;
    }
    public void NavigateBack(WebDriver driver) {
        driver.navigate().back();
    }
    public boolean VerifyYourCheckoutOverViewPageSucessfully() {
        return driver.findElement(this.YourCheckoutOverView_Title).getText().contains("Checkout: Overview");
    }
    public boolean  VerifYourCheckoutOverView_isVisible() {
        return getDriver().findElement(this.YourCheckoutOverView_Title).isDisplayed();
//        return driver.findElement(this.ADD_TO_CART_Button1).isEnabled();
//        return driver.findElement(this.ADD_TO_CART_Button1).isSelected();//Checkbox
    }
    public String  VerifYourCheckoutOverView_ByAssertEqual() {
        return getDriver().findElement(this.YourCheckoutOverView_Title).getText();
    }

}
