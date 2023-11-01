package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

@Test
public class JSExecutor {
    public static void testJSExecutor() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/floating_menu");

            // Scroll to the bottom of the page
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
