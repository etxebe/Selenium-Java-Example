package AutomationPracticeTests.pages;

import AutomationPracticeTests.components.ProceedWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage {
    private WebDriver driver;
    private final ProceedWindow proceedWindow;

    private static final By LOC_PRODUCT_NAME = By.className("pb-center-column h1");
    private static final By LOC_BTN_ADD_TO_CART = By.name("Submit");

    //

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.proceedWindow = new ProceedWindow(driver);
    }

    public String getProductName() {
        return driver.findElement(LOC_PRODUCT_NAME).getText();
    }

    public CartPage addProductToCart() {
        driver.findElement(LOC_BTN_ADD_TO_CART).click();
        proceedWindow.waitForProceedWindow();
        proceedWindow.proceedToCheckout();
        return new CartPage(driver);
    }
}
