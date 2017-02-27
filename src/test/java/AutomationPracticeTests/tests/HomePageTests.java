package AutomationPracticeTests.tests;

import AutomationPracticeTests.pages.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HomePageTests {
    private WebDriver driver;
    private HomePage homePage;
    private CatalogPage catalogPage;
    private SignInPage signInPage;
//    private ContactPage contactPage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(driver);
//        contactPage = new ContactPage(driver);
        homePage.open();
    }

    @AfterClass
    public void tearDown() {
        homePage.close();
    }

    @Test(enabled = false)
    public void checkTitle() {
        Assert.assertEquals(homePage.getTitle(), "My Store");
    }

    @Test(enabled = false)
    public void checkUrl() {
        Assert.assertEquals(homePage.getUrl(), "http://automationpractice.com/index.php");
    }

    @Test(enabled = false)
    public void clickContactUs() {
        homePage.getHeader().selectContactUs();
    }

    @Test(enabled = false)
    public void selectWomanButton() {
        catalogPage = homePage.clickWomenButton();
        catalogPage.waitForCatalogPage();
        Assert.assertEquals(catalogPage.getCategory(), "WOMEN ");
    }

    @Test(enabled = false)
    public void selectDressesButton() {
        catalogPage = homePage.clickDressesButton();
        catalogPage.waitForCatalogPage();
        Assert.assertEquals(catalogPage.getCategory(), "DRESSES ");
    }

    @Test(enabled = false)
    public void selectTShirtsButton() {
        catalogPage = homePage.clickTShirtsButton();
        catalogPage.waitForCatalogPage();
        Assert.assertEquals(catalogPage.getCategory(), "T-SHIRTS ");
    }

    @Test
    public void goToSignInPage() {
        signInPage = homePage.getHeader().navigateToSignInPage();
        signInPage.waitForSignInPage();
    }
}
