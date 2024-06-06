package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;


import static Utilities.Utility.getRandomNumberBetween1and6;
import static Utilities.Utility.getRandomNumberBetween1andN;
import static drivers.DriverHolder.getDriver;

public class P02_Products {
    WebDriver driver;

    public P02_Products(WebDriver driver) {
        // Initialize elements
        PageFactory.initElements(driver, this);
        this.driver = driver;

        if (this.driver == null)
            System.out.println("Driver is null");
        else
            System.out.println("Driver is not null");
    }

    private final By Final_Cart = By.xpath("//a[@href='./cart.html']");
    private final By YourCart_Title = By.xpath("//div[@class='subheader']");
    public P02_Products Click_AddToFinal_Cart() {
        driver.findElement(Final_Cart).click();
        return this;
    }

    public boolean VerifyYourCartProducts_Sucessfully() {
        return driver.findElement(this.YourCart_Title).getText().contains("Your Cart");
    }
    public boolean  VerifyYourCartProducts_isVisible() {
        return getDriver().findElement(this.YourCart_Title).isDisplayed();
//        return driver.findElement(this.ADD_TO_CART_Button1).isEnabled();
//        return driver.findElement(this.ADD_TO_CART_Button1).isSelected();//Checkbox
    }
    public String  VerifyYourCartProducts_ByAssertEqual() {
        return getDriver().findElement(this.YourCart_Title).getText();
    }

    public P02_Products Select_Random_Product_56() throws InterruptedException {
        System.out.println("------------------------------------------------------------");

//        WebDriverWait wait = new WebDriverWait(driver, 30);

        try {

            WebElement priceElement = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[5]"));
            WebElement nameElement = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[5]"));
            WebElement addToCartBtn = driver.findElement(By.xpath("(//button[text()='ADD TO CART'])[5]"));


            String price = priceElement.getText();
            String name = nameElement.getText();
            addToCartBtn.click();

            System.out.println("Product Id: 5 , name: " + name + " , price: " + price);
        } catch (org.openqa.selenium.NoSuchElementException e) {
            System.out.println("Unable to locate element: " + e.getMessage());
        }
        return this;

    }

    public static float Total_Price_SelectedAmountByuser;
    ArrayList<Integer> ArrayProducts;
    private int NumberOfConvert_AddToCartTO_remove;
    private int numberOfproducts;
   public String sizeOfRemovedItems ;
    public int numberofitemAbleToRemove ;
    public P02_Products Select_Random_Product_1To6() throws InterruptedException {
        By addToCartBtn;
        By nameElement;
        By priceElement;
//          WebDriverWait wait= new WebDriverWait(driver, 10); // يمكن تعديل الوقت حسب الحاجة;
        numberOfproducts = getRandomNumberBetween1and6();
        ArrayProducts = new ArrayList<>();
        int product_ID;
        System.out.println("The number of selected Random products : " + numberOfproducts);
//         wait = new WebDriverWait(driver, 30);

        for (int i = 0; i < numberOfproducts; i++) {
            System.out.println("------------------------------------------------------------");
            PageBase.ThreadSleep500();
            product_ID = getRandomNumberBetween1andN(numberOfproducts);

            while (ArrayProducts.contains(product_ID)) {
                System.out.println("      ---- > " + product_ID + " product is a duplicate");
                product_ID = getRandomNumberBetween1andN(numberOfproducts);
            }
            ArrayProducts.add(product_ID);
            System.out.println("product_ID : " + product_ID);
            System.out.print("Array list of products : ");
            for (int item : ArrayProducts) {
                System.out.print(item + " , ");
            }
            System.out.println();

            addToCartBtn = By.xpath("//div[@class='inventory_list']//div[" + product_ID + "]//div[3]//button");
            nameElement = By.xpath("(//div[@class='inventory_item_name'])[" + product_ID + "]");
            priceElement = By.xpath("(//div[@class='inventory_item_price'])[" + product_ID + "]");
//            PageBase.ThreadSleep200();

            String price = driver.findElement(priceElement).getText();
            String name = driver.findElement(nameElement).getText();
            getDriver().findElement(addToCartBtn).click();

System.out.println(getDriver().findElement(addToCartBtn).getText());
            if (getDriver().findElement(addToCartBtn).getText().equals("REMOVE")) {
                System.out.println("Yes converted");
                NumberOfConvert_AddToCartTO_remove++;
            }

            String[] parts = price.split("\\$");
            String currencySymbol = parts[0]; // Currency symbol
            String amount = parts[1]; // Amount without the symbol
            Total_Price_SelectedAmountByuser += Float.parseFloat(amount);
            System.out.println("Product Id:" + product_ID + " , name:" + name + " , Total_Price_SelectedAmountByuser:" + amount);
            System.out.println("------------------------------------------------------------");

        }
        System.out.println("NumberOfConvert_AddToCartTO_remove :"+NumberOfConvert_AddToCartTO_remove);
        System.out.println("numberOfproducts :"+numberOfproducts);
        System.out.println("The Total price is " + Total_Price_SelectedAmountByuser);


        List<WebElement> removedItems = driver.findElements(By.xpath("//button[@class='btn_secondary btn_inventory']"));
        // Get the count of removed items
        int numberofitemAbleToRemove = removedItems.size();
        System.out.println("Number of items able to remove: " + numberofitemAbleToRemove);

        return this;
    }
    public boolean Check_NumberAddCart_ConvertedTo_Remove()
    {
//        System.out.println(" --- - - - > "+NumberOfConvert_AddToCartTO_remove+" = "+ numberOfproducts);
//        return NumberOfConvert_AddToCartTO_remove == numberOfproducts;

        return numberofitemAbleToRemove==numberOfproducts;
    }

    double insteadtotal = 0.0;

    public void DeleteProduct() throws InterruptedException {

        PageBase.ThreadSleep1000();

        String sizeOfRemovedItems = String.valueOf(driver.findElement(By.xpath("//button[@class='btn_secondary btn_inventory']")).getSize());
        int numberofitemAbleToRemove = Integer.parseInt(sizeOfRemovedItems);
        int removeRandomItem_id = getRandomNumberBetween1andN(numberofitemAbleToRemove);

        String removedItem_Price = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + removeRandomItem_id + "]")).getText();
        driver.findElement(By.xpath("(//button[@class='btn_secondary btn_inventory'][" + removeRandomItem_id + "])")).click();


        String[] parts = removedItem_Price.split("\\$");
        String currencySymbol = parts[0]; // Currency symbol
        String amount = parts[1]; // Amount without the symbol
        Total_Price_SelectedAmountByuser -= Float.parseFloat(amount);


        System.out.println("Total_Price_SelectedAmountByuser after removed" + Total_Price_SelectedAmountByuser);

    }

    public P02_Products DeleteProduct2() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, 10);
        // Wait for the buttons to be present
        PageBase.ThreadSleep2000();
//        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[@class='btn_secondary btn_inventory']")));
        // Get the size of elements
        int numberOfItemsAbleToRemove = driver.findElements(By.xpath("//button[@class='btn_secondary btn_inventory']")).size();
//        if (numberOfItemsAbleToRemove == 0) {
//            System.out.println("No items available to remove.");
//            return;
//        }

        int removeRandomItem_id = getRandomNumberBetween1andN(numberOfItemsAbleToRemove);
        // Wait for the specific item price to be visible
        WebElement itemPriceElement = driver.findElement(By.xpath("(//div[@class='inventory_item_price'])[" + removeRandomItem_id + "]"));
        String removedItem_Price = itemPriceElement.getText();

        WebElement itemNameElement = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[" + removeRandomItem_id + "]"));
        String removedItem_Name = itemPriceElement.getText();


        // Wait for the specific remove button to be clickable
        WebElement removeButton = driver.findElement(By.xpath("(//button[@class='btn_secondary btn_inventory'])[" + removeRandomItem_id + "]"));
        removeButton.click();

        // Parsing the price
        String[] parts = removedItem_Price.split("\\$");
        String amount = parts[1]; // Amount without the symbol
        System.out.println("Total_Price_SelectedAmountByuser before removed: " + Total_Price_SelectedAmountByuser);
        Total_Price_SelectedAmountByuser -= Float.parseFloat(amount);

        System.out.println("The deleted Product name:" + removedItem_Name + " ,price:" + amount);
        System.out.println("Total_Price_SelectedAmountByuser after removed: " + Total_Price_SelectedAmountByuser);
        return this;
    }

}
