package AutomationPracticeTests.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    private WebDriver driver;

    private static final By LOC_TXT_AUTHENTICATION = By.cssSelector("#center_column .page-heading");
    private static final By LOC_FLD_EMAIL = By.id("email_create");
    private static final By LOC_BTN_CREATE = By.id("SubmitCreate");
    // ALREADY REGISTERED
    private static final By LOC_FLD_REGISTERED_MAIL = By.id("email");
    private static final By LOC_FLD_REGISTERED_PASSWORD = By.id("passwd");
    private static final By LOC_BTN_LOGIN = By.id("SubmitLogin");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForSignInPage() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOC_TXT_AUTHENTICATION)));
    }

    public NewAccountFormPage createNewAccount(String mail) {
        driver.findElement(LOC_FLD_EMAIL).sendKeys(mail);
        driver.findElement(LOC_BTN_CREATE).click();
        return new NewAccountFormPage(driver);
    }
}
