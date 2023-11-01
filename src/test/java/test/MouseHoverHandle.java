package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class MouseHoverHandle {
    public static void testMouseHoverHandle() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            driver.get("https://the-internet.herokuapp.com/hovers");

            By avatarSelector = By.cssSelector(".figure");
            By usernameSelector = By.cssSelector(".figcaption h5");
            By usernameHyperlink = By.cssSelector(".figcaption a");
            final int USER_1_INDEX = 0;
            final int USER_2_INDEX = 1;
            final int USER_3_INDEX = 2;

            List<WebElement> userAvatarElems = driver.findElements(avatarSelector);
            List<WebElement> usernameElems = driver.findElements(usernameSelector);
            List<WebElement> userHyperlinkElems = driver.findElements(usernameHyperlink);

            // Move mouse on the first user
            Actions actions = new Actions(driver);
            actions.moveToElement(userAvatarElems.get(USER_1_INDEX)).perform();
            System.out.println(usernameElems.get(USER_1_INDEX).getText());
            System.out.println(userHyperlinkElems.get(USER_1_INDEX).getAttribute("href"));
            //debug purpose only
            Thread.sleep(2000);

            // User 2
            actions.moveToElement(userAvatarElems.get(USER_2_INDEX)).perform();
            System.out.println(usernameElems.get(USER_2_INDEX).getText());
            System.out.println(userHyperlinkElems.get(USER_2_INDEX).getAttribute("href"));
            //debug purpose only
            Thread.sleep(2000);

            // User 3
            actions.moveToElement(userAvatarElems.get(USER_3_INDEX)).perform();
            System.out.println(usernameElems.get(USER_3_INDEX).getText());
            System.out.println(userHyperlinkElems.get(USER_3_INDEX).getAttribute("href"));

            //debug purpose only
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //7. Quit browser session
        driver.quit();
    }
}
