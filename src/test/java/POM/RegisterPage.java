package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver webDriver;
    private By fisrtName = By.id("firstname");
    private By middleName = By.id("middlename");
    private By lastName = By.id("lastname");
    private By emailAddress = By.id("email_address");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmation");
    public WebElement firstname() {
        return webDriver.findElement(fisrtName);
    }
    public WebElement middlename() {
        return  webDriver.findElement(middleName);
    }
    public WebElement lastname() {
        return webDriver.findElement(lastName);
    }
    public WebElement emailaddress() {
        return webDriver.findElement(emailAddress);
    }
    public WebElement password() {
        return webDriver.findElement(password);
    }
    public WebElement confirmation() {
        return webDriver.findElement(confirmPassword);
    }
    public void inputFirstname(String firstname1) {
        WebElement name1 = webDriver.findElement(fisrtName);
        name1.sendKeys(firstname1);
    }
    public void inputLastname(String lastname1) {
        WebElement name1 = webDriver.findElement(lastName);
        name1.sendKeys(lastname1);
    }
    public void inputMiddlename(String middlename1) {
        WebElement name1 = webDriver.findElement(middleName);
        name1.sendKeys(middlename1);
    }
    public void inputEmail(String email1) {
        WebElement name1 = webDriver.findElement(emailAddress);
        name1.sendKeys(email1);
    }
    public void inputPassword(String password1) {
        WebElement name1 = webDriver.findElement(password);
        name1.sendKeys(password1);
    }
    public void inputConfirm(String confirm) {
        WebElement name1 = webDriver.findElement(confirmPassword);
        name1.sendKeys(confirm);
    }
    public RegisterPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

}
