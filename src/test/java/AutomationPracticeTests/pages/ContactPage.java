package AutomationPracticeTests.pages;

import AutomationPracticeTests.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ContactPage {
    public static final String AUTOMATIONPRACTICE_CONTACT_PAGE_URL = "http://automationpractice.com/index.php?controller=contact";
    private WebDriver driver;
    private HomePage homePage;
    private Header header;

    private static final By LOC_FLD_MESSAGE = By.id("message");
    private static final By LOC_FLD_EMAIL = By.id("email");
    private static final By LOC_FLD_ORDER = By.id("id_order");
    private static final By LOC_BTN_SEND = By.id("submitMessage");
    private static final By LOC_POP_ALERT = By.className("alert");
    private static final By LOC_BTN_ATTACH = By.id("fileUpload");

    public ContactPage(WebDriver driver) {
        this.driver = driver;
        this.homePage = new HomePage(driver);
        this.header = new Header(driver);
    }

    public ContactPage openContactPage() {
        driver.get(AUTOMATIONPRACTICE_CONTACT_PAGE_URL);
        return this;
    }

    public void openContactPageByHomePage() {
        homePage.open();
        header.selectContactUs();
    }

    public void close() {
        driver.quit();
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void sendMessage(String mail, String text) {
        driver.findElement(LOC_FLD_EMAIL).sendKeys(mail);
        driver.findElement(LOC_FLD_MESSAGE).sendKeys(text);
        driver.findElement(LOC_BTN_SEND).click();
    }

    public String getAlertText() {
        return driver.findElement(LOC_POP_ALERT).findElement(By.tagName("li")).getText();
    }

    public Boolean getAlertStatus() {
        return driver.findElement(LOC_POP_ALERT).isDisplayed();
    }

    public void waitForAlert() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(LOC_POP_ALERT)));
    }

    public void attachFile(String filepath) {
        driver.findElement(LOC_BTN_ATTACH).sendKeys(filepath);
    }
}