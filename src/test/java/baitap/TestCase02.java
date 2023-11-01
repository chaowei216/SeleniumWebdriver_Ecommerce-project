package baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
/*

Test Steps:

1. Goto http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)

4. Click on Sony Xperia mobile

5. Read the Sony Xperia mobile from detail page.

6. Compare Product value in list and details page should be equal ($100).

*/
@Test
public class TestCase02 {
    public static void testCase2() {
        //Step 1: Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on -> MOBILE -> menu
        By optionSelector = By.className("nav-1");

        WebElement option = driver.findElement(optionSelector);
        option.click();

        //Step 3: In the list of all mobile , read the cost of Sony Xperia mobile (which is $100)
        By phoneSelector = By.id("product-price-1");

        WebElement phone = driver.findElement(phoneSelector);
        String phonePrice = phone.getText();

        //Step 4: Click on Sony Xperia mobile
        By imageSelector = By.id("product-collection-image-1");

        WebElement image = driver.findElement(imageSelector);
        image.click();

        //Step 5: Read the Sony Xperia mobile from detail page.
        By phoneDetailSelector = By.id("product-price-1");

        WebElement actualPhone = driver.findElement(phoneDetailSelector);
        String realPrice = actualPhone.getText();

        //Step 6: Compare Product value in list and details page should be equal ($100).
        try {
            assertEquals("$100.00", phonePrice);
            assertEquals("$100.00", realPrice);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        driver.quit();
    }
}
