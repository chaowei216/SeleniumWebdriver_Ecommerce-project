package baitap;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/*
1. Go to http://live.techpanda.org/index.php/backendlogin
2. Login the credentials provided
3. Go to Sales-> Orders menu
4. Input OrderId and FromDate -> ToDate
5. Click Search button
6. Screenshot capture.

Expected results:
1) File is downloaded successfully with full information.
*/
@Test
public class TestCase10 {
    public void testCase10() throws InterruptedException {
        //1. Go to http://live.techpanda.org/index.php/backendlogin
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/index.php/backendlogin");

        //2. Login the credentials provided
        WebElement username = driver.findElement(By.id("username"));
        username.sendKeys("user01");
        WebElement password = driver.findElement(By.id("login"));
        password.sendKeys("guru99com");
        WebElement login = driver.findElement(By.xpath("/html/body/div[1]/div/form/div/div[5]/input"));
        login.click();

        WebElement close = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div[1]/a"));
        close.click();
        //3. Go to Sales-> Orders menu
        WebElement sale = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/a"));
        sale.click();
        WebElement order = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[3]/ul/li[1]/ul/li[1]/a"));
        order.click();

        //4. Input OrderId and FromDate -> ToDate
        WebElement orderId = driver.findElement(By.id("sales_order_grid_filter_real_order_id"));
        orderId.sendKeys("100021115");

        WebElement from = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[1]/input"));
        from.sendKeys("11/7/2023");

        WebElement to = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/div[2]/div/table/thead/tr[2]/th[3]/div/div[2]/input"));
        to.sendKeys("11/8/2023");

        WebElement searchButton = driver.findElement(By.xpath("/html/body/div[1]/div[4]/div/div[3]/div/table/tbody/tr/td[3]/button[2]"));
        searchButton.click();
        Thread.sleep(5000);
        //Step 6. Screenshot capture.

        TakesScreenshot screenshot =((TakesScreenshot)driver);
        File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "D:\\Major5\\SWT301_Software_Testing\\selenium-webdriver-java\\src\\test\\java\\ScreenShot\\verifySearch.png";
        try {
            FileHandler.copy(srcFile, new File(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Step 7: Quit
        driver.quit();
    }
}
