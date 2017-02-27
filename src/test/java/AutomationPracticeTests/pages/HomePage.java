package AutomationPracticeTests.pages;

import AutomationPracticeTests.components.Header;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private static final String AUTOMATIONPRACTICE_HOME_PAGE_URL = "http://automationpractice.com/index.php";

    private final Header header;
    private WebDriver driver;

    private static final By LOC_PRODUCTS_LIST = By.id("homefeatured");
    private static final By LOC_BTN_WOMEN = By.cssSelector("a[title='Women']");
    private static final By LOC_BTN_DRESSES = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
    private static final By LOC_BTN_TSHIRTS = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[3]/a");

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
    }

    public HomePage open() {
        driver.get(AUTOMATIONPRACTICE_HOME_PAGE_URL);
        return this;
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

    public Header getHeader() {
        return header;
    }

    private List<WebElement> getAllProducts() {
        return driver.findElement(LOC_PRODUCTS_LIST).findElements(By.cssSelector("li"));
    }

    public ProductPage clickProductFromList(int idx) {
        getAllProducts().get(idx).click();
        return new ProductPage(driver);
    }

    public String getProductNameFromList(int idx) {
        return getAllProducts().get(idx).findElement(By.className("product-name")).getText();
    }

    public CatalogPage clickWomenButton() {
        driver.findElement(LOC_BTN_WOMEN).click();
        return new CatalogPage(driver);
    }

    public CatalogPage clickDressesButton() {
        driver.findElement(LOC_BTN_DRESSES).click();
        return new CatalogPage(driver);
    }

    public CatalogPage clickTShirtsButton() {
        driver.findElement(LOC_BTN_TSHIRTS).click();
        return new CatalogPage(driver);
    }
}
