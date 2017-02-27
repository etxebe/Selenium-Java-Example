package AutomationPracticeTests.tests;

import AutomationPracticeTests.pages.CartPage;
import AutomationPracticeTests.pages.HomePage;
import AutomationPracticeTests.pages.ProductPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPageTests {
    private WebDriver driver;
    private HomePage homePage;
    private CartPage cartPage;
    private ProductPage productPage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(driver);
        homePage.open();
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test(enabled = false)
    public void checkCartWhenEmpty() {
        cartPage = homePage.getHeader().navigateToCartPage();
        Assert.assertEquals(cartPage.getAlertMessage(), "Your shopping cart is empty.");
    }

    @Test
    public void addItemToCartFromHomePage() {
        String productName = homePage.getProductNameFromList(0);
        productPage = homePage.clickProductFromList(0);
        Assert.assertEquals(productPage.getProductName(), productName);
        cartPage = productPage.addProductToCart();
        Assert.assertEquals(cartPage.getProductName(), productName);
    }
}
