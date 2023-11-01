package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

@Test
public class IFrameHandle {
    public static void testIFrameHandle() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/iframe");

            By iframeNodeSelector = By.id("mce_0_ifr");
            By iframeBodySelector = By.id("tinymce");

            WebElement iframeElem = driver.findElement(iframeNodeSelector);
            driver.switchTo().frame(iframeElem);

            WebElement iframeBodyElem = driver.findElement(iframeBodySelector);
            iframeBodyElem.clear();
            iframeBodyElem.sendKeys("This is my new content!");

            // Switch BACK to the main frame
            driver.switchTo().defaultContent();

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
