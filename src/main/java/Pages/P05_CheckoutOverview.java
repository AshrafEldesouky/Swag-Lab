package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import static Pages.P02_Products.Total_Price_SelectedAmountByuser;
import static Pages.PageBase.NavigateBackmethod;
import static drivers.DriverHolder.getDriver;

public class P05_CheckoutOverview {

    //1.define webdriver
    //2.define constructor and initialize webdriver
    //3.define locators using By
    //4.define action method for each locator because it is fluent design

    WebDriver driver;

    public P05_CheckoutOverview(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
        if (this.driver == null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }

    private final By Total_AllPrice = By.xpath("//div[@class='summary_subtotal_label']");
    private final By Taxes = By.xpath("//div[@class='summary_tax_label']");
    private final By PriceAndTaxes = By.xpath("//div[@class='summary_total_label']");
    private final By FINISH_BUTTON = By.xpath("//a[text()='FINISH']");
    private final By YourFinish_Title = By.xpath("//div[@class='subheader']");
    public static float Total_Price_calcbySystem;

    public P05_CheckoutOverview GetTotalprice() {
        String TotalpriceText = driver.findElement(this.Total_AllPrice).getText();

        String[] parts = TotalpriceText.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        Total_Price_calcbySystem = Float.parseFloat(amount);
        System.out.println("Total_Price_calcbySystem : " + Total_Price_calcbySystem);
        return this;
    }

    public static float Total_Taxes;

    public P05_CheckoutOverview Get_Taxes() {
        String TaxesText = driver.findElement(this.Taxes).getText();

        String[] parts = TaxesText.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        Total_Taxes = Float.parseFloat(amount);
        System.out.println("Total_Taxes only : " + Total_Taxes);
        return this;
    }

    public static float PriceAndTaxesAmount;

    public P05_CheckoutOverview Get_PriceAndTaxes() {
        String PriceAndTaxesText = driver.findElement(this.PriceAndTaxes).getText();

        String[] parts = PriceAndTaxesText.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        PriceAndTaxesAmount = Float.parseFloat(amount);
        System.out.println("PriceAndTaxesAmount : " + PriceAndTaxesAmount);
        return this;
    }

    public P05_CheckoutOverview CheckThe_TotalAmountbyuser_CalcAmount() {
        if (Total_Price_SelectedAmountByuser == Total_Price_calcbySystem) {
            System.out.println(Total_Price_SelectedAmountByuser + "==" + Total_Price_calcbySystem);
            System.out.println("Yes The_TotalAmountbyuser equal the CalcAmount by system");
        }
        else
            System.out.println("NO The_TotalAmountbyuser equal the CalcAmount by system");
        return this;
    }

    public P05_CheckoutOverview CheckThe_TotalAmountbySysAndTax_withFinalCalcAmount() {
        if (PriceAndTaxesAmount == (Total_Taxes + Total_Price_calcbySystem)) {
            System.out.println(PriceAndTaxesAmount + "==" + "(" + Total_Taxes + "+" + Total_Price_calcbySystem + ")");
            System.out.println("Yes The_Total Final amount equal the CalcAmount by system and taxes");
        } else
            System.out.println("NO The_Total Final amount equal the CalcAmount by system and taxes");
        return this;
    }

    public P05_CheckoutOverview Click_FINISH_BUTTON() {
        driver.findElement(this.FINISH_BUTTON).click();
        return this;
    }
    public P05_CheckoutOverview ClickNavigateBack() {
        NavigateBackmethod();
        return this;
    }
    public boolean VerifYourFINISHPageSucessfully() {
        return driver.findElement(this.YourFinish_Title).getText().contains("Finish");
    }
    public boolean  VerifYourFINISH_isVisible() {
        return getDriver().findElement(this.YourFinish_Title).isDisplayed();
//        return driver.findElement(this.ADD_TO_CART_Button1).isEnabled();
//        return driver.findElement(this.ADD_TO_CART_Button1).isSelected();//Checkbox
    }
    public String  VerifYYourFINISH_ByAssertEqual() {
        return getDriver().findElement(this.YourFinish_Title).getText();
    }
}
