package Testcases;

import Pages.P01_LoginPage;
import Pages.P02_Products;
import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static drivers.DriverHolder.driver;
import static drivers.DriverHolder.getDriver;

public class TC01_Login extends TestBase {

    //define Test Data
    String email = " ";
    String Password = " ";

    @Test(priority = 1, description = "Login With Vaild Email and Password")
    public void LoginWithValidData_P() throws InterruptedException {
         email = "standard_user";
         Password = "secret_sauce";
        new P01_LoginPage(driver).Insert_UserNAME_TXT(email).Insert_PassWord_TXT(Password).clickLOGIN_BUTTON();
//        PageBase.ThreadSleep200();

        //Hard Assertion After successfully login
        Assert.assertTrue(new P01_LoginPage(getDriver()).VerifyLoginSucessfully());
        Assert.assertFalse(!new P01_LoginPage(getDriver()).VerifyLoginSucessfully());
        Assert.assertEquals(new P01_LoginPage(getDriver()).VerifyLogin_ByAssertEqual(),"Products");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
        Assert.assertTrue(new P01_LoginPage(getDriver()).VerifyADDtoCart_isVisible());

        //------------------------------Hard Assertion------------------------------------------//
//        WebDriverWait wait = new WebDriverWait(getDriver(), 50); // wait up to 10 seconds
        WebElement body = driver.findElement(By.tagName("body"));
        // Optionally, print the body text for debugging
//        System.out.println("Body text: " + body.getText());
        Assert.assertTrue(body.getText().contains("Products")); //not working
        System.out.println("====================================");

        //------------------------------Soft Assertion------------------------------------------//
        SoftAssert soft = new SoftAssert();
        soft.assertFalse(!new P01_LoginPage(getDriver()).VerifyLoginSucessfully());
        soft.assertEquals(new P01_LoginPage(getDriver()).VerifyLogin_ByAssertEqual(),"Products");
        soft.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/v1/inventory.html");
        soft.assertTrue(new P01_LoginPage(getDriver()).VerifyADDtoCart_isVisible());

//        soft.assertTrue(getDriver().findElement(By.tagName("body")).toString().contains("Products"));
        // Verify 'Products' text in body element
        String bodyText = driver.findElement(By.tagName("body")).getText();
//        System.out.println("Body text: " + bodyText);
        soft.assertTrue(bodyText.contains("Products"), "The body text does not contain 'Products'.");

        soft.assertAll();// we have to write this line to fire the softassertion
    }
    @Test(priority = 2, description = "Login With Invalid Email and Password")
    public void LoginWith_InVaildUsername_N(){
        new P01_LoginPage(getDriver()).Insert_UserNAME_TXT(email).Insert_PassWord_TXT(Password).clickLOGIN_BUTTON();
    }
    @Test(priority = 3, description = "Login With Vaild Email and Invalid Password")
    public void LoginWithInVaildPassword_N() {
        new P01_LoginPage(getDriver()).Insert_UserNAME_TXT(email).Insert_PassWord_TXT(Password).clickLOGIN_BUTTON();
    }
    @Test(priority = 4, description = "Login With InVaild Email and Invalid Password")
    public void LoginWithInVaild_UsernameAndPassword_N() {
        new P01_LoginPage(getDriver()).Insert_UserNAME_TXT(email).Insert_PassWord_TXT(Password).clickLOGIN_BUTTON();
    }

}
