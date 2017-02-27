package AutomationPracticeTests.tests;

import AutomationPracticeTests.pages.ContactPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class ContactPageTests {
    private WebDriver driver;
    private ContactPage contactPage;

    @BeforeClass
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        contactPage.close();
    }

    @BeforeMethod
    public void openContactPage() {
        contactPage = new ContactPage(driver);
        contactPage.openContactPage();
//        contactPage.openContactPageByHomePage();
    }

    @Test(enabled = false)
    public void checkTitle() {
        Assert.assertEquals(contactPage.getTitle(), "Contact us - My Store");
    }

    @Test(enabled = false)
    public void checkUrl() {
        Assert.assertEquals(contactPage.getUrl(), ContactPage.AUTOMATIONPRACTICE_CONTACT_PAGE_URL);
    }

    @Test(enabled = false)
    public void sendMessage() {
        contactPage.sendMessage("a@wp.pl", "This message is about to send.");
        contactPage.waitForAlert();
        Assert.assertTrue(contactPage.getAlertStatus());
        Assert.assertEquals(contactPage.getAlertText(), "Please select a subject from the list provided.");
    }

    @Test
    public void attachFile() {
        contactPage.attachFile("C:\\aaa.jpg");
    }
}
