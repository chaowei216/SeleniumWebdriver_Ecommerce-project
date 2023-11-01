package test;

import driver.driverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
@Test
public class RightClickHandle {
    public static void testRightClickHandle() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/context_menu");

            By rightClickPlace = By.id("hot-spot");
            Actions actions = new Actions(driver);
            WebElement rightClickPlaceElem = driver.findElement(rightClickPlace);
            actions.contextClick(rightClickPlaceElem).perform();

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            System.out.println(alert.getText());
            //debug purpose only
            Thread.sleep(2000);

            alert.accept();

            // This is to refresh the page and remove the triggered context menu
            driver.navigate().refresh();

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
