package baitap;

import driver.driverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


/*

Test Steps

Step 1. Go to http://live.techpanda.org/

Step 2. Verify Title of the page

Step 3. Click on -> MOBILE -> menu

Step 4. In the list of all mobile , select SORT BY -> dropdown as name

Step 5. Verify all products are sorted by name

*/
@Test
public class TestCase01 {
    public static void test() {
        //Step 1: Go to http://live.techpanda.org/
        WebDriver driver = driverFactory.getChromeDriver();
        driver.get("http://live.techpanda.org/");

        //Step 2: Verify Title of the page
        By titleSelector = By.tagName("h2");

        WebElement title = driver.findElement(titleSelector);
        String innerText = title.getText().trim();
        try {
            assertEquals("THIS IS DEMO SITE FOR", innerText);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        //Step 3: Click on -> MOBILE -> menu
        By optionSelector = By.className("nav-1");

        WebElement option = driver.findElement(optionSelector);
        option.click();

        //Step 4:  In the list of all mobile , select SORT BY -> dropdown as name
        By sortDivSelector = By.className("sort-by");
        By sortSelector = By.tagName("select");

        WebElement sortDiv = driver.findElement(sortDivSelector);
        WebElement sort = driver.findElement(with(sortSelector).below(sortDiv));
        Select select = new Select(sort);
        select.selectByIndex(1);

        //Step 5: Verify all products are sorted by name
        TakesScreenshot screenshot =((TakesScreenshot)driver);
        File srcFile= screenshot.getScreenshotAs(OutputType.FILE);
        String fileName = "E:\\Sem5\\SWT301\\selenium-webdriver-java\\src\\test\\java\\ScreenShot\\verifyName.png";
        try {
            FileHandler.copy(srcFile, new File(fileName));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }
}
