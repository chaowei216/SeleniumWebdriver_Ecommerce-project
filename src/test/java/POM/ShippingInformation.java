package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShippingInformation {
    private WebDriver webDriver;
    private By firstname = By.id("shipping:firstname");
    private By middlename = By.id("shipping:middlename");
    private By lastname = By.id("shipping:lastname");
    private By company = By.id("shipping:company");
    private By address = By.id("shipping:street1");
    private By street2 = By.id("shipping:street2");
    private By city = By.id("shipping:city");
    private By region = By.id("shipping:region_id");
    private By zip = By.id("shipping:postcode");
    private By country = By.id("shipping:country_id");
    private By fax = By.id("shipping:fax");
    private By telephone = By.id("shipping:telephone");
    public ShippingInformation(WebDriver driver) {
        this.webDriver = driver;
    }
    public void inputCompany(String company1) {
        WebElement name1 = webDriver.findElement(company);
        name1.clear();
        name1.sendKeys(company1);
    }
    public void inputAddress(String address1) {
        WebElement name1 = webDriver.findElement(address);
        name1.clear();
        name1.sendKeys(address1);
    }
    public void inputStreet2(String street) {
        WebElement name1 = webDriver.findElement(street2);
        name1.clear();
        name1.sendKeys(street);
    }
    public void inputCity(String city1) {
        WebElement name1 = webDriver.findElement(city);
        name1.clear();
        name1.sendKeys(city1);
    }
    public void inputRegion(String region1) {
        WebElement name1 = webDriver.findElement(region);
        name1.clear();
        name1.sendKeys(region1);
    }
    public void inputZip(String zip1) {
        WebElement name1 = webDriver.findElement(zip);
        name1.clear();
        name1.sendKeys(zip1);
    }
    public void inputCountry(String country1) {
        WebElement name1 = webDriver.findElement(country);
        name1.clear();
        name1.sendKeys(country1);
    }
    public void inputFax(String fax1) {
        WebElement name1 = webDriver.findElement(fax);
        name1.clear();
        name1.sendKeys(fax1);
    }
    public void inputFirstname(String firstname1) {
        WebElement name1 = webDriver.findElement(firstname);
        name1.clear();
        name1.sendKeys(firstname1);
    }
    public void inputMiddlename(String middlenam1) {
        WebElement name1 = webDriver.findElement(middlename);
        name1.clear();
        name1.sendKeys(middlenam1);
    }
    public void inputLastname(String lastnam1) {
        WebElement name1 = webDriver.findElement(lastname);
        name1.clear();
        name1.sendKeys(lastnam1);
    }

    public void inputTelephone(String telephone1) {
        WebElement phone = webDriver.findElement(telephone);
        phone.clear();
        phone.sendKeys(telephone1);
    }

}
