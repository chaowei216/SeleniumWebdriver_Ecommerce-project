package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

@Test
public class HandleCheckboxes {
    public static void testHandleCheckboxes() {
        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page - Login Form
            driver.get("https://the-internet.herokuapp.com/checkboxes");
            //3. Find a list of checkboxes element

            // Check that the checkboxes are selected or not
            List<WebElement> checkboxesElms = driver.findElements(By.cssSelector("input[type='checkbox']"));
            WebElement chcbx1Elem = checkboxesElms.get(0);
            WebElement chcbx2Elem = checkboxesElms.get(1);

            //debug purpose only to view checkbox1 is unchecked and checkbox2 is checked
            Thread.sleep(2000);

            System.out.println("Is checkbox 1 selected: " + chcbx1Elem.isSelected());
            System.out.println("Is checkbox 2 selected: " + chcbx2Elem.isSelected());

            // Try to select the first one
            System.out.println("====01====");
            chcbx1Elem.click();
            System.out.println("Is checkbox 1 selected: " + chcbx1Elem.isSelected());

            // Try to unselect the second one
            System.out.println("=======02======");
            chcbx2Elem.click();
            System.out.println("Is checkbox 2 selected: " + chcbx2Elem.isSelected());

            //debug purpose only to view checkbox1 is checked and checkbox2 is unchecked
            Thread.sleep(2000);

            //Select All
            for(WebElement checkboxElm:checkboxesElms)
            if (!checkboxElm.isSelected())
                checkboxElm.click();
            System.out.println("====01-02====");
            System.out.println("Is checkbox 1 selected: " + chcbx1Elem.isSelected());
            System.out.println("Is checkbox 2 selected: " + chcbx2Elem.isSelected());

            //debug purpose only to view both of checkbox1 and checkbox2 is checked
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
