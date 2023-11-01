package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class DynamicContentHandle {
    public static void testDynamicContentHandle() {
        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/dynamic_controls");

            By removeButtonSelector = By.cssSelector("#checkbox-example button");
            By checkBoxSelector = By.id("checkbox");
            By inputSelector = By.cssSelector("#input-example input");
            By enableInputBtnSelector = By.cssSelector("#input-example button");

            System.out.println("Is the checkbox displayed: " + driver.findElement(checkBoxSelector).isDisplayed());

            driver.findElement(removeButtonSelector).click();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBoxSelector));
            try {
                driver.findElement(checkBoxSelector);
            } catch (Exception e) {
                System.out.println("The checkbox was removed:");
            }


            // Handle the input form
            System.out.println("Is the Input form enabled: " + driver.findElement(inputSelector).isEnabled());
            driver.findElement(enableInputBtnSelector).click();
            wait.until(ExpectedConditions.textToBe(enableInputBtnSelector, "Disable"));
            System.out.println("Is the Inout form enabled: " + driver.findElement(inputSelector).isEnabled());

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
