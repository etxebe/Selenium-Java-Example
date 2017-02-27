package AutomationPracticeTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    private WebDriver driver;

    private static final By LOC_MSG_ALERT = By.className("alert");
    private static final By LOC_PRODUCT_NAME = By.xpath("//*[@id=\"product_1_1_0_0\"]/td[2]/p/a");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAlertMessage() {
        return driver.findElement(LOC_MSG_ALERT).getText();
    }

    public String getProductName() {
        return driver.findElement(LOC_PRODUCT_NAME).getText();
    }
}
