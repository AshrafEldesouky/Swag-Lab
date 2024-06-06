package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static drivers.DriverHolder.getDriver;

public class P01_LoginPage {

    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;
    public P01_LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver==null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }
    private final By UserNAME_TXT = By.xpath("//input[@id='user-name']");
    private final By PassWord_TXT = By.xpath("//input[@id='password']");
    private final By LOGIN_BUTTON = By.xpath("//input[@id='login-button']");
    private final By Product_Title = By.xpath("//div[@class='product_label']");


    public P01_LoginPage Insert_UserNAME_TXT(String email) {
        driver.findElement(this.UserNAME_TXT).sendKeys(email);
        return this;
    }
    public P01_LoginPage Insert_PassWord_TXT(String Paswword) {
        driver.findElement(this.PassWord_TXT).sendKeys(Paswword);
        return this;
    }
    public P01_LoginPage clickLOGIN_BUTTON() {
        driver.findElement(this.LOGIN_BUTTON).click();
        return this;
    }
    public boolean VerifyLoginSucessfully() throws InterruptedException {
        return driver.findElement(this.Product_Title).getText().contains("Products");
//        return driver.findElement(this.Product_Title).isDisplayed();
    }

    public String  VerifyLogin_ByAssertEqual() {
        return driver.findElement(this.Product_Title).getText();
    }
    public boolean  VerifyADDtoCart_isVisible() {
        return getDriver().findElement(this.Product_Title).isDisplayed();
//        return driver.findElement(this.ADD_TO_CART_Button1).isEnabled();
//        return driver.findElement(this.ADD_TO_CART_Button1).isSelected();//Checkbox
    }
}
