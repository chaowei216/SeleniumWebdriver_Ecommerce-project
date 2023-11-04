package baitap;
import POM.BillingInformation;
import POM.ShippingInformation;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Test
public class TestCase08 {
    public void testCase08() throws InterruptedException {
        //Step 1: Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on my account link
        WebElement accountOption = driver.findElement(By.className("account-cart-wrapper"));
        accountOption.click();
        WebElement option = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[1]/a"));
        option.click();

        //Step 3: Login in application using previously created credential
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("luutrieuvi2003@gmail.com");

        WebElement passwordInput = driver.findElement(By.id("pass"));
        passwordInput.sendKeys("123456");

        WebElement loginButton = driver.findElement(By.id("send2"));
        loginButton.click();

        //Step 4: Click on 'REORDER' link , change QTY & click Update
        WebElement reOrderButton = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div/div[3]/table/tbody/tr[1]/td[6]/span/a[2]"));
        reOrderButton.click();

        String newQuantity = "10";
        WebElement quantiyText = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/input"));
        quantiyText.clear();
        quantiyText.sendKeys(newQuantity);

        WebElement updateButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[4]/button"));
        updateButton.click();

        //Step 5: Verify Grand Total is changed
        try {
            WebElement price = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[3]/span/span"));
            double newPrice = Double.parseDouble(price.getText().replace(",", "").substring(1)) * Double.parseDouble(newQuantity);
            WebElement realPrice = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/div/form/table/tbody/tr/td[5]/span/span"));
            String rPrice = realPrice.getText().replace(",", "");
            assertEquals(newPrice, Double.parseDouble(rPrice.substring(1)), 1);
        } catch(NumberFormatException ex) {
            System.out.println("Fail to parse");
        } catch(Exception ex) {
            ex.printStackTrace();
        }

        //Step 6: Complete Billing & Shipping Information
        WebElement selectItem = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/form[1]/ul/li[1]/div/select")));
        Select select = new Select(selectItem);
        select.selectByValue("US");


        WebElement inputState = driver.findElement((By.xpath("/html/body/div/div/div[2]/div/div/div/div[2]/div/div/form/ul/li[2]/div/select")));
        Select select1State = new Select(inputState);
        select1State.selectByValue("9");

        WebElement inputZip = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/form[1]/ul/li[3]/div/input")));
        inputZip.sendKeys("123456");

        WebElement estimateBtn = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/form[1]/div/button")));
        estimateBtn.click();

        WebElement shippingCheck = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/div/div/form[2]/dl/dd/ul/li/label/span"));
        boolean checked = shippingCheck.isDisplayed();
        assertTrue(checked);

        WebElement chooseShippingCost = driver.findElement((By.id("s_method_flatrate_flatrate")));
        boolean flag = chooseShippingCost.isSelected();

        if(!flag){
            chooseShippingCost.click();
            flag = true;
        }

        try{
            assertTrue(flag);
        }catch(Exception e){
            e.printStackTrace();
        }

        WebElement btnUpdateTotal = driver.findElement(By.xpath("//*[@id=\"co-shipping-method-form\"]/div/button"));
        btnUpdateTotal.click();

        WebElement subTotal = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[1]/td[2]/span"));
        String subTotalValue = subTotal.getText();

        WebElement shipping = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tbody/tr[2]/td[2]/span"));
        String shippingValue = shipping.getText();

        WebElement totalCost = driver.findElement(By.xpath("//*[@id=\"shopping-cart-totals-table\"]/tfoot/tr/td[2]/strong/span"));
        String totalCostValue = totalCost.getText();

        double realPrice = Double.parseDouble(subTotalValue.substring(1).replace(",", ""));
        double shipPrice = Double.parseDouble(shippingValue.substring(1).replace(",", ""));
        double totalPrice = Double.parseDouble(totalCostValue.substring(1).replace(",", ""));
        assertEquals(realPrice + shipPrice, totalPrice,1);

        WebElement btnCheckout = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div[1]/div/div[2]/div/div/div/div[3]/div/ul/li[1]/button"));
        btnCheckout.click();

        WebElement nAddress = driver.findElement(By.id("billing-address-select"));
        Select newAddress = new Select(nAddress);
        newAddress.selectByIndex(newAddress.getOptions().size()-1);

        BillingInformation bill = new BillingInformation(driver);
        bill.inputCompany("ABC");
        bill.inputAddress("ABC");
        bill.inputStreet2("ABC");
        bill.inputCity("ABC");
        WebElement selectCountry = driver.findElement((By.id("billing:country_id")));
        Select selectCountry1 = new Select(selectCountry);
        selectCountry1.selectByValue("US");
        WebElement selectRegion = driver.findElement((By.id("billing:region_id")));
        Select selectRegion1 = new Select(selectRegion);
        selectRegion1.selectByValue("9");
        bill.inputZip("3000");

        bill.inputTelephone("01282312319");
        bill.inputFax("1000");
        WebElement selectItem1 = driver.findElement((By.id("billing:use_for_shipping_no")));
        boolean flag1 = selectItem1.isSelected();
        if(!flag1) {
            selectItem1.click();
        }
        WebElement selectCon = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/ol/li[1]/div[2]/form/div/div/button")));
        selectCon.click();

        Thread.sleep(2000);

        WebElement sAddress = driver.findElement(By.id("shipping-address-select"));
        Select shipAddress = new Select(sAddress);
        shipAddress.selectByIndex(shipAddress.getOptions().size() - 1);
        ShippingInformation shipping1 = new ShippingInformation(driver);
        shipping1.inputFirstname("Luu");
        shipping1.inputMiddlename("Trieu");
        shipping1.inputLastname("Vi");
        shipping1.inputCompany("ABC");
        shipping1.inputAddress("ABC");
        shipping1.inputStreet2("ABC");
        shipping1.inputCity("ABC");
        WebElement selectCountry2 = driver.findElement((By.id("shipping:country_id")));
        Select selectCountry3 = new Select(selectCountry2);
        selectCountry3.selectByValue("US");
        WebElement selectRegion2 = driver.findElement((By.id("shipping:region_id")));
        Select selectRegion3 = new Select(selectRegion2);
        selectRegion3.selectByValue("9");
        shipping1.inputZip("3000");

        shipping1.inputTelephone("01282312319");
        shipping1.inputFax("1000");
        WebElement selectContinue2 = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[2]/div[2]/form/div/button"));
        selectContinue2.click();

        Thread.sleep(2000);

        WebElement selectContinue3 = driver.findElement((By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[3]/div[2]/form/div[3]/button")));
        selectContinue3.click();

        Thread.sleep(2000);

        WebElement selectCheck = driver.findElement((By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/form/div/dl/dt[2]/input")));
        boolean flag2 = selectCheck.isSelected();
        if(!flag2) {
            selectCheck.click();
        }
        WebElement selectContinue4 = driver.findElement((By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[4]/div[2]/div[2]/button")));
        selectContinue4.click();

        Thread.sleep(2000);

        //Step 15: Click 'PLACE ORDER' button
        WebElement selectPlace = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/ol/li[5]/div[2]/div/div[2]/div/button"));
        selectPlace.click();

        Thread.sleep(2000);

        //Step 7: Verify Oder is generated. Note the order number
        WebElement orderId = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div/p[1]/a"));
        System.out.println(orderId.getText());
        orderId.click();

        TakesScreenshot screenshot =((TakesScreenshot)driver);
        File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "D:\\Major5\\SWT301_Software_Testing\\selenium-webdriver-java\\src\\test\\java\\ScreenShot\\verifyReOrder.png";
        try {
            FileHandler.copy(srcFile, new File(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Step 8: Quit Browser
        driver.quit();
    }
}
