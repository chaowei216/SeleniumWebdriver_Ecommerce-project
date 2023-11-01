package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

@Test
public class UrlPageTitleHandle {
    public static void testUrlPageTitleHandle() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/login");
            String pageURL = driver.getCurrentUrl();
            String pageTitle = driver.getTitle();

            System.out.println(pageURL);
            System.out.println(pageTitle);

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
