package baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@Test
public class TestCase09 {
        public static void testCase09() throws InterruptedException {
            //Step 1: Go to http://live.techpanda.org/
            WebDriver driver = driverFactory.getChromeDriver();
            driver.get("http://live.techpanda.org/");

            //Step 2: Click on Mobile link
            WebElement btntMoble = driver.findElement(By.xpath("/html/body/div[1]/div/header/div/div[3]/nav/ol/li[1]/a"));
            btntMoble.click();
            //Step 3 : Click on Add To Cart link
            WebElement btnAddToCart = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div[1]/div[3]/ul/li[1]/div/div[3]/button"));
            btnAddToCart.click();

            //Step 4: Enter the input guru50 to discount input
            WebElement discountInput = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div/div/div/input"));
            discountInput.sendKeys("GURU50");

            //Step 5: Click button Apply
            WebElement btnApply = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[2]/form/div/div/div/div/button"));
            btnApply.click();

            //Step 6: Take the totalPrice
            WebElement totalPrice = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[1]/td[2]/span"));
            double a = Double.parseDouble(totalPrice.getText().replaceAll("[^\\d.]", ""));

            //Step 7: Take the discount price
            WebElement discountPrice = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[3]/div/table/tbody/tr[2]/td[2]/span")));
            double b = Double.parseDouble(discountPrice.getText().replaceAll("[^\\d.]", ""));
            //Step 8: Take the grantTotal
            WebElement grandTotal = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div/div/div[3]/div/table/tfoot/tr/td[2]/strong/span")));
            double c = Double.parseDouble(grandTotal.getText().replaceAll("[^\\d.]", ""));

            //Step 9: Check
            assertEquals(a-b,c,1);

            //Step 10: Quit browser
            driver.quit();
        }

}
