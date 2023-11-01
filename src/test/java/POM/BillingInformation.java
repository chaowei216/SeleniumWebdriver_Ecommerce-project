package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillingInformation {
    private WebDriver webDriver;
    private By company = By.id("billing:company");
    private By address = By.id("billing:street1");
    private By street2 = By.id("billing:street2");
    private By city = By.id("billing:city");
    private By region = By.id("billing:region_id");
    private By zip = By.id("billing:postcode");
    private By country = By.id("billing:country_id");
    private By fax = By.id("billing:fax");
    private By telephone = By.id("billing:telephone");
    public BillingInformation(WebDriver driver) {
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
    public void inputTelephone(String telephone1) {
        WebElement name1 = webDriver.findElement(telephone);
        name1.clear();
        name1.sendKeys(telephone1);
    }

}
