package AutomationPracticeTests.components;

import AutomationPracticeTests.pages.CartPage;
import AutomationPracticeTests.pages.SignInPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Header {
    //LOCATORS
    private static final By LOC_LNK_CONTACT_US = By.linkText("Contact us");
    private static final By LOC_FLD_SEARCH = By.id("search_query_top");
    private static final By LOC_LNK_CART = By.className("shopping_cart");
    private static final By LOC_LNK_SIGN_IN = By.cssSelector("a[title='Log in to your customer account']");

    private WebDriver driver;

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void selectContactUs() {
        driver.findElement(LOC_LNK_CONTACT_US).click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("submitMessage"))));
    }

    public CartPage navigateToCartPage() {
        driver.findElement(LOC_LNK_CART).findElement(By.tagName("a")).click();
        return new CartPage(driver);
    }

    public SignInPage navigateToSignInPage() {
        driver.findElement(LOC_LNK_SIGN_IN).click();
        return new SignInPage(driver);
    }
}
