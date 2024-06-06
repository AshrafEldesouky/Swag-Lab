package Testcases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC04_CheckoutYourInformation extends TestBase{

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void CheckoutYourInformation() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P04_CheckoutYourInformation(getDriver()).Insert_FIRSTName_TXT().Insert_LastName_TXT().Insert_PostalCode_TXT().Click_Continue_BUTTON();
        Assert.assertTrue(new P04_CheckoutYourInformation(getDriver()).VerifyYourCheckoutOverViewPageSucessfully());
        Assert.assertFalse(!new P04_CheckoutYourInformation(getDriver()).VerifyYourCheckoutOverViewPageSucessfully());
        Assert.assertEquals(new P04_CheckoutYourInformation(getDriver()).VerifYourCheckoutOverView_ByAssertEqual(),"Checkout: Overview");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/v1/checkout-step-two.html");
        Assert.assertTrue(new P04_CheckoutYourInformation(getDriver()).VerifYourCheckoutOverView_isVisible());
    }

    @Test(priority = 2, description = "Check_Get_RandomProducts")
    public void CheckClickFinishbtn() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P05_CheckoutOverview(getDriver()).Click_FINISH_BUTTON() ;

    }
}
