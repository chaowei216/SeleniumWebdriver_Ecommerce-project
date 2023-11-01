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

3. In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile

4. Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed

"The requested quantity for "Sony Xperia" is not available.

5. Verify the error message

6. Then click on �EMPTY CART� link in the footer of list of all mobiles. A message "SHOPPING CART IS EMPTY" is shown.

7. Verify cart is empty

 */
@Test
public class TestCase03 {


    public static void test03() {
        //Step 1: Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on -> MOBILE -> menu
        By optionSelector = By.className("nav-1");

        WebElement option = driver.findElement(optionSelector);
        option.click();

        //Step 3: In the list of all mobile , click on �ADD TO CART� for Sony Xperia mobile
        By imgSelector = By.id("product-collection-image-1");
        By addSelector = By.className("btn-cart");

        WebElement addToCart = driver.findElement(with(addSelector).below(imgSelector));
        addToCart.click();

        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
        }

        //Step 4: Change �QTY� value to 1000 and click �UPDATE� button. Expected that an error is displayed
        WebElement qtyInput = driver.findElement(By.cssSelector("input[title='Qty']"));
        qtyInput.clear();
        qtyInput.sendKeys("1000");

        WebElement updateBtn = driver.findElement(By.cssSelector("button[title='Update']"));
        updateBtn.click();

        // Step 5: Verify the error message
        WebElement errorMessage = driver.findElement(By.cssSelector(".error-msg"));
        String expectedErrorMessage = "The requested quantity for \"Sony Xperia\" is not available.";
        String actualErrorMessage = errorMessage.getText();

        if (actualErrorMessage.equals(expectedErrorMessage)) {
            System.out.println("Error message is displayed correctly: " + actualErrorMessage);
        } else {
            System.out.println("Error message is not displayed correctly. Expected: " + expectedErrorMessage);
        }

        // Step 6: Click on "EMPTY CART" link
        WebElement emptyCartLink = driver.findElement(By.linkText("EMPTY CART"));
        emptyCartLink.click();

        // Step 7: Verify cart is empty
        WebElement emptyCartMessage = driver.findElement(By.cssSelector(".cart-empty"));
        String expectedEmptyCartMessage = "SHOPPING CART IS EMPTY";
        String actualEmptyCartMessage = emptyCartMessage.getText();

        if (actualEmptyCartMessage.equals(expectedEmptyCartMessage)) {
            System.out.println("Cart is empty: " + actualEmptyCartMessage);
        } else {
            System.out.println("Cart is not empty. Expected: " + expectedEmptyCartMessage);
        }
        //Step 8: Quit browser session
        driver.quit();
    }
}
