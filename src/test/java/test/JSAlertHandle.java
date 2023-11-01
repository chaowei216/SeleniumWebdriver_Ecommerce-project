package test;

import driver.driverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class JSAlertHandle {
    public static void testJSAlertHandle() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/javascript_alerts");
//            driver.manage().window().maximize();

            final By jsAlertBtnSelector = By.cssSelector("[onclick=\"jsAlert()\"]");
            final By jsConfirmBtnSelector = By.cssSelector("[onclick=\"jsConfirm()\"]");
            final By jsPromptBtnSelector = By.cssSelector("[onclick=\"jsPrompt()\"]");
            final By resultSelector = By.id("result");

            driver.findElement(jsAlertBtnSelector).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content: " + alert.getText());
            //debug purpose only
            Thread.sleep(2000);

            alert.accept();
            System.out.println(driver.findElement(resultSelector).getText());
            //debug purpose only
            Thread.sleep(2000);


            // Play with JS Confirm Alert
            driver.findElement(jsConfirmBtnSelector).click();
            alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println("Alert content: " + alert.getText());
            //debug purpose only
            Thread.sleep(2000);

            alert.dismiss();
            System.out.println(driver.findElement(resultSelector).getText());
            //debug purpose only
            Thread.sleep(2000);

            // Play with Js Prompt alert
            driver.findElement(jsPromptBtnSelector).click();
            alert = wait.until(ExpectedConditions.alertIsPresent());

            alert.sendKeys("SDET PRO");
            alert.accept();
            System.out.println(driver.findElement(resultSelector).getText());

            //debug purpose only
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
