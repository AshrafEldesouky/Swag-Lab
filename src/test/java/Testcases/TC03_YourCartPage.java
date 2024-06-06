package Testcases;

import Pages.P02_Products;
import Pages.P03_YourCartPage;
import Pages.P04_CheckoutYourInformation;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC03_YourCartPage extends TestBase{

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void Click_CheckOutFromYpurCart() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P03_YourCartPage(getDriver()).Click_CheckOut_BUTTON();
        //Hard Assertion After successfully login
        Assert.assertTrue(new P03_YourCartPage(getDriver()).VerifyYourInformationPageSucessfully());
        Assert.assertFalse(!new P03_YourCartPage(getDriver()).VerifyYourInformationPageSucessfully());
        Assert.assertEquals(new P03_YourCartPage(getDriver()).VerifyourInformation_ByAssertEqual(),"Checkout: Your Information");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/v1/checkout-step-one.html");
        Assert.assertTrue(new P03_YourCartPage(getDriver()).VerifyourInformation_isVisible());
    }
}
