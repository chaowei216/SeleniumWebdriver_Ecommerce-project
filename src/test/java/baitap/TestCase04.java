package baitap;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.with;
import static org.junit.Assert.assertEquals;
/*

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on �MOBILE� menu

3. In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)

4. Click on �COMPARE� button. A popup window opens

5. Verify the pop-up window and check that the products are reflected in it

Heading "COMPARE PRODUCTS" with selected products in it.

6. Close the Popup Windows

*/
@Test
public class TestCase04 {
    public static void test04() {
        //Step 1: Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on -> MOBILE -> menu
        By optionSelector = By.className("nav-1");

        WebElement option = driver.findElement(optionSelector);
        option.click();
        //Step 3:  In mobile products list , click on �Add To Compare� for 2 mobiles (Sony Xperia & Iphone)
        By addCompareSonySelector = By.className("link-compare");
        By imgSonySelector = By.id("product-collection-image-1");
        By imgIphoneSelector = By.id("product-collection-image-2");

        WebElement sony = driver.findElement(with(addCompareSonySelector).below(imgSonySelector));
        sony.click();
        WebElement iphone = driver.findElement(with(addCompareSonySelector).below(imgIphoneSelector));
        iphone.click();

        //Step 4: Click on �COMPARE� button. A popup window opens
        WebElement compareButton = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[3]/div[1]/div[2]/div/button"));
        compareButton.click();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        //Step 5: Verify the pop-up window and check that the products are reflected in it
        //Heading "COMPARE PRODUCTS" with selected products in it.
        By headingSelector = By.tagName("h1");

        WebElement heading = driver.findElement(headingSelector);
        assertEquals("COMPARE PRODUCTS", heading.getText());

        WebElement item1 = driver.findElement(By.className("product-name"));
        WebElement item2 = driver.findElement(with(By.className("product-name")).near(By.className("last")));
        assertEquals("SONY XPERIA", item1.getText());
        assertEquals("IPHONE", item2.getText());

        //Step  6: Close the Popup Windows
        driver.close();

        //Step 7: Quit browser session
        driver.quit();
    }
}
