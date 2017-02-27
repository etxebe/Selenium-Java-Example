package AutomationPracticeTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.lang.reflect.Array;

public class NewAccountFormPage {
    private WebDriver driver;

    // REQUIRED FIELDS
    private static final By LOC_FLD_FIRSTNAME = By.id("customer_firstname");
    private static final By LOC_FLD_LASTNAME = By.id("customer_lastname");
    private static final By LOC_FLD_PASSWORD = By.id("passwd");
    private static final By LOC_FLD_ADDRESS = By.id("address1");
    private static final By LOC_FLD_CITY = By.id("city");
    private static final By LOC_FLD_ZIP_CODE = By.id("postcode");

    public NewAccountFormPage(WebDriver driver) {
        this.driver = driver;
    }

    public void fillRequiredFields(String[] formValues) {
        driver.findElement(LOC_FLD_FIRSTNAME).sendKeys(formValues[0]);
        driver.findElement(LOC_FLD_LASTNAME).sendKeys(formValues[1]);
        driver.findElement(LOC_FLD_PASSWORD).sendKeys(formValues[2]);
        driver.findElement(LOC_FLD_ADDRESS).sendKeys(formValues[3]);
        driver.findElement(LOC_FLD_CITY).sendKeys(formValues[4]);
//        driver.findElement(LOC_FLD_ZIP_CODE).sendKeys(formValues[5]);
    }
}
