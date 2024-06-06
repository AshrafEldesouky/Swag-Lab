package Testcases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC05_CheckoutOverview extends TestBase {

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void CheckoutOverview() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P05_CheckoutOverview(getDriver()).GetTotalprice().Get_Taxes().Get_PriceAndTaxes().CheckThe_TotalAmountbyuser_CalcAmount().CheckThe_TotalAmountbySysAndTax_withFinalCalcAmount()
                .Click_FINISH_BUTTON() ;

        Assert.assertTrue(new P05_CheckoutOverview(getDriver()).VerifYourFINISHPageSucessfully());
        Assert.assertFalse(!new P05_CheckoutOverview(getDriver()).VerifYourFINISHPageSucessfully());
        Assert.assertEquals(new P05_CheckoutOverview(getDriver()).VerifYYourFINISH_ByAssertEqual(),"Finish");
        Assert.assertEquals(getDriver().getCurrentUrl(),"https://www.saucedemo.com/v1/checkout-complete.html");
        Assert.assertTrue(new P05_CheckoutOverview(getDriver()).VerifYourFINISH_isVisible());
    }
    @Test(priority = 2, description = "NavigateBack")
    public void CheckNavigateBack_TwoTimes() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P05_CheckoutOverview(driver).ClickNavigateBack().ClickNavigateBack();
    }
    @Test(priority = 3, description = "Check_Delete_RandomProducts")
    public void Check_Delete_RandomProduct() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P02_Products(getDriver()).DeleteProduct2().Click_AddToFinal_Cart();
        new P03_YourCartPage(getDriver()).Click_CheckOut_BUTTON();

    }
//    @Test(priority = 3, description = "Click_AddToFinal_Cart")
//    public void Check_Click_AddToFinal_Cart() throws InterruptedException {
////        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
//        new P02_Products(getDriver()).Click_AddToFinal_Cart();
//    }
}