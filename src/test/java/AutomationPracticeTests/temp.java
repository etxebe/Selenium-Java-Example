

//package automationpractice.com.AutomationPractice;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//
//public class HomePage {
//    //LOCATORS
//    //tabs
//    public static final By LOC_TAB_BESTSELLER = By.className("blockbestsellers");
//    private WebDriver driver;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public HomePage open() {
//        driver.get("http://automationpractice.com/index.php");
//        return this;
//    }
//
//    public void close() {
//        this.driver.quit();
//    }
//
//    public String getTitle() {
//        return this.driver.getTitle();
//    }
//
//    public String getCurrentUrl() {
//        return this.driver.getCurrentUrl();
//    }
//}















//package AutomationPracticeTests;
//
//import static org.junit.Assert.*;
//
//import automationpractice.com.AutomationPractice.HomePage;
//import org.junit.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.BeforeMethod;
//
//public class HomePageTests {
//    private static WebDriver driver;
//    private static HomePage homePage;
//
//    @BeforeClass
//    public static void setUp() {
//        driver = new FirefoxDriver();
//    }
//
//    @AfterClass
//    public static void tearDown() {
//        homePage.close();
//    }
//
//    @BeforeMethod
//    public void openBrowser() {
//        homePage = new HomePage(driver);
//        homePage.open();
//    }
//
//    @Test
//    public void checkTitle() {
//        String actualTitle = homePage.getTitle();
//        assertEquals("The title is: ", "My Store", actualTitle);
////        System.out.println(actualTitle.contentEquals("My Store") ? "Test passed" : "Test failed");
//    }
//
//    @Test
//    public void checkUrl() {
//        String currentUrl = homePage.getCurrentUrl();
//        assertEquals("The current url is:", "http://automationpractice.com/index.php", currentUrl);
////        System.out.println(currentUrl.contentEquals("aa") ? "Test passed" : "Test failed");
//    }
//
////    @Test
////    public void bestSellerTab() {
////        WebElement bestSeller =
////    }
//
//
//
////        WebElement bestseller = driver.findElement(By.className("blockbestsellers"));
////        bestseller.click();
////        System.out.println(bestseller.getTagName());
//////        System.out.println(bestseller);
////        driver.quit();
////    }
//}
