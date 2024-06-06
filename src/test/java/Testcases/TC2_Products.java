package Testcases;

import Pages.P01_LoginPage;
import Pages.P02_Products;
import Pages.P03_YourCartPage;
import Pages.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import static drivers.DriverHolder.getDriver;

public class TC2_Products extends TestBase {

    @Test(priority = 1, description = "Check_Get_RandomProducts")
    public void  Check_Get_RandomProducts() throws InterruptedException {

//        new P02_Products(getDriver()).Select_Random_Product_56().Click_AddToFinal_Cart();
//        P02_Products productsPage = new P02_Products(getDriver());
        new P02_Products(getDriver()).Select_Random_Product_1To6().Click_AddToFinal_Cart();

        //Hard Assertion After successfully login
        Assert.assertTrue(new P02_Products(getDriver()).VerifyYourCartProducts_Sucessfully());
        Assert.assertFalse(!new P02_Products(getDriver()).VerifyYourCartProducts_Sucessfully());
        Assert.assertEquals(new P02_Products(getDriver()).VerifyYourCartProducts_ByAssertEqual(), "Your Cart");
        Assert.assertEquals(getDriver().getCurrentUrl(), "https://www.saucedemo.com/v1/cart.html");
        Assert.assertTrue(new P02_Products(getDriver()).VerifyYourCartProducts_isVisible());
//        Assert.assertTrue(new P02_Products(getDriver()).Check_NumberAddCart_ConvertedTo_Remove());
        Assert.assertTrue(new P02_Products(getDriver()).Check_NumberAddCart_ConvertedTo_Remove());
        //------------------------------Soft Assertion------------------------------------------//


    }

    @Test(priority = 2, description = "Click_AddToFinal_Cart")
    public void Check_DeleteItem() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P02_Products(getDriver()).DeleteProduct2().Click_AddToFinal_Cart();
 
    }

    @Test(priority = 3, description = "Click_AddToFinal_Cart")
    public void Check_Click_AddToFinal_Cart() throws InterruptedException {
//        WebDriver driver = getDriver(); // Assuming getDriver() method returns the WebDriver instance
        new P02_Products(getDriver()).Click_AddToFinal_Cart();
    }

    public void Assert_removeTitleBtn() {
//        WebDriverWait wait = new WebDriverWait(getDriver(), 50); // wait up to 10 seconds
        WebElement body = driver.findElement(By.tagName("body"));
        Assert.assertTrue(body.getText().contains("REMOVE"));
    }

}
