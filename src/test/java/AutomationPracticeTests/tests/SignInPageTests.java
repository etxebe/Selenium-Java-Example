package AutomationPracticeTests.tests;

import AutomationPracticeTests.pages.HomePage;
import AutomationPracticeTests.pages.NewAccountFormPage;
import AutomationPracticeTests.pages.SignInPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SignInPageTests {
    private WebDriver driver;

    private HomePage homePage;
    private SignInPage signInPage;
    private NewAccountFormPage newAccountFormPage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void openHomePage() {
        homePage = new HomePage(driver);
        homePage.open();
    }

    @Test
    public void createNewAccount() throws InterruptedException {
        signInPage = homePage.getHeader().navigateToSignInPage();
        newAccountFormPage = signInPage.createNewAccount("a@wp.pl");
        newAccountFormPage.fillRequiredFields(new String[]{"Bart", "Simpson", "passw", "Moon 23", "Los Angeles"});
//        newAccountFormPage.fillRequiredFields(new String[]{"Bart", "Simpson", "passw", "Moon 23", "Los Angeles", "12345"});
        Thread.sleep(3000);
    }
}
