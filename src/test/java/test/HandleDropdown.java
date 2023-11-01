package test;

import driver.driverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class HandleDropdown {
    public static void testHandleDropdown() {

        //1. Init web-driver session
        WebDriver driver = driverFactory.getChromeDriver();
        try {
            //2. Open target page - Login Form
            driver.get("https://the-internet.herokuapp.com/dropdown");
            //3. Locate dropdown element
            WebElement dropdownElement = driver.findElement(By.id("dropdown"));
            //4. Init a Select Option instance
            Select selectOption = new Select(dropdownElement);

            //select options in dropdown list by Text
            selectOption.selectByVisibleText("Option 1");
            selectOption.selectByVisibleText("Option 2");

            //Or select option in dropdown list by value
            //debug purpose only
            Thread.sleep(2000);
            selectOption.selectByValue("1");
            selectOption.selectByValue("2");
            
            //debug purpose only
            Thread.sleep(2000);

        }catch (Exception e){
            e.printStackTrace();
        }
        //7. Quit browser session
        driver.quit();
    }
}
