package AutomationPracticeTests.components;

import AutomationPracticeTests.pages.CartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProceedWindow {
    private WebDriver driver;

    private static final By LOC_BTN_PROCEED = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a");

    public ProceedWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForProceedWindow() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOC_BTN_PROCEED)));
    }

    public void proceedToCheckout() {
        driver.findElement(LOC_BTN_PROCEED).click();
    }
}
