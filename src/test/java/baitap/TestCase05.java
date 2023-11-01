package baitap;

import POM.RegisterPage;
import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
/* Verify can create an account in e-Commerce site and can share wishlist to other poeple using email.

Test Steps:

1. Go to http://live.techpanda.org/

2. Click on my account link

3. Click Create an Account link and fill New User information excluding the registered Email ID.

4. Click Register

5. Verify Registration is done. Expected account registration done.

6. Go to TV menu

7. Add product in your wish list - use product - LG LCD

8. Click SHARE WISHLIST

9. In next page enter Email and a message and click SHARE WISHLIST

10.Check wishlist is shared. Expected wishlist shared successfully.

 */
@Test
public class TestCase05 {
    public static void test05() {
        //Step 1: Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        //Step 2: Click on my account link
        WebElement accountOption = driver.findElement(By.className("account-cart-wrapper"));
        accountOption.click();
        WebElement option = driver.findElement(By.xpath("//*[@id=\"header-account\"]/div/ul/li[1]/a"));
        option.click();

        //Step 3: Click Create an Account link and fill New User information excluding the registered Email ID.
        WebElement createAccount = driver.findElement(By.xpath("//*[@id=\"login-form\"]/div/div[1]/div[2]/a"));
        createAccount.click();

        RegisterPage register = new RegisterPage(driver);
        register.inputFirstname("Nguyen");
        register.inputMiddlename("Viet");
        register.inputLastname("Map");
        register.inputEmail("mapmapzoofpt@gmail.com");
        register.inputPassword("111111");
        register.inputConfirm("111111");

        //Step 4: Click Register
        WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button"));
        registerButton.click();

        //Step 5: Verify Registration is done. Expected account registration done.
        String successNotify = "";
        try {
            WebElement notifySuccess = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div/ul/li/ul/li/span"));
            successNotify = notifySuccess.getText();
        } catch(Exception e) {
            System.out.println("Login fail");
            successNotify = "Fail";
        }
        assertEquals("Thank you for registering with Main Website Store.", successNotify);

        //Step 6: Go to TV menu
        WebElement tvOption = driver.findElement(By.xpath("//*[@id=\"nav\"]/ol/li[2]/a"));
        tvOption.click();

        //Step 7: Add product in your wish list - use product - LG LCD
        WebElement LGTV = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div[1]/div[2]/ul/li[1]/div/div[3]/ul/li[1]/a"));
        LGTV.click();

        //Step 8: Click SHARE WISHLIST
        WebElement shareWL = driver.findElement(By.xpath("//*[@id=\"wishlist-view-form\"]/div/div/button[1]"));
        shareWL.click();

        //Step 9: In next page enter Email and a message and click SHARE WISHLIST
        WebElement emailAddress = driver.findElement(By.id("email_address"));
        emailAddress.sendKeys("mapmapzoo@gmail.com");
        WebElement message = driver.findElement(By.id("message"));
        message.sendKeys("Share to everyone");
        WebElement shareWL2 = driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div[2]/button"));
        shareWL2.click();

        //Step 10: Check wishlist is shared. Expected wishlist shared successfully.
        try {
            WebElement successWL = driver.findElement(By.xpath("//*[@id=\"top\"]/body/div/div/div[2]/div/div[2]/div/div[1]/ul/li/ul/li/span"));
            successNotify = successWL.getText();
        } catch(Exception e) {
            System.out.println("Fail to share wish list");
            successNotify = "Fail";
        }
        assertEquals("Your Wishlist has been shared.", successNotify);

        //Step 11: Quit browser session
        driver.quit();
    }
}
