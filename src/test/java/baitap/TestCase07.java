package baitap;
import driver.driverFactory;
import org.openqa.selenium.*;
import org.testng.annotations.Test;

@Test
public class TestCase07 {
    public void testCase07() {
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

        //Step 4: Click on MY ORDER
        WebElement myOrder = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[1]/div/div[2]/ul/li[4]/a"));
        myOrder.click();

        //Step 5: Click on 'View Order'
        WebElement viewOrder = driver.findElement((By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td[6]/span/a[1]")));
        viewOrder.click();

        //Step 6: Click on 'Print Order' link
        WebElement printOrder = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div/div[2]/div/div[1]/a[2]"));
        printOrder.click();

        //Step 7: Quit browser
        driver.quit();
    }
}
