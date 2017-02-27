package AutomationPracticeTests.tests;

import AutomationPracticeTests.components.Footer;
import AutomationPracticeTests.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class FooterTests {
    private WebDriver driver;
    private Footer footer;

    @BeforeClass
    public void setUp () {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void openHomePage() {
        HomePage homepage = new HomePage(driver);
        footer = new Footer(driver);
        homepage.open();
    }

    @Test(enabled = false)
    public void signInForNewsletter() {
        footer.signInForNewsletter("a@wp.pl");
        Assert.assertEquals(footer.getAlertText(), "Newsletter : This email address is already registered.");
    }

    @Test(enabled = false)
    public void signInForNewsletterWithInvalidMail() {
        footer.signInForNewsletter("");
        Assert.assertEquals(footer.getAlertText(), "Newsletter : Invalid email address.");
    }

    @Test
    public void checkFooterLinks() {
        // First block of links
        Assert.assertEquals(footer.getFirstBlockTitle(), "Categories");
        Assert.assertEquals(footer.getLiCategoriesLinks().size(), 1);

        // Second block of links
        String secondLinks[] = {"Specials", "New products", "Best sellers", "Our stores", "Contact us", "Terms and conditions of use", "About us", "Sitemap"};
        Assert.assertEquals(footer.getSecondBlockTitle(), "Information");
        Assert.assertEquals(footer.getSecondBlockLinks().size(), 8);
        for (int i=0; i<8; i++) {
            Assert.assertEquals(footer.getSecondBlockLinks().get(i).getText(), secondLinks[i]);
        }

        // Third block of links
        String thirdLinks[] = {"My orders", "My credit slips", "My addresses", "My personal info"};
        Assert.assertEquals(footer.getThirdBlockTitle(), "My account");
        Assert.assertEquals(footer.getThirdBlockLinks().size(), 4);
        for (int i=0; i<4; i++) {
            Assert.assertEquals(footer.getThirdBlockLinks().get(i).getText(), thirdLinks[i]);
        }
    }
}
