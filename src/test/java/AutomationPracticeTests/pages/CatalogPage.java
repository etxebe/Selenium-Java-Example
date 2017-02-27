package AutomationPracticeTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage {
    private WebDriver driver;

    private static final By LOC_TXT_TITLE = By.cssSelector("p.title_block");
    private static final By LOC_TXT_CATEGORY = By.cssSelector("span.cat-name");

    public CatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForCatalogPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOC_TXT_TITLE)));
    }

    public String getCategory() {
        return driver.findElement(LOC_TXT_CATEGORY).getText();
    }
}
