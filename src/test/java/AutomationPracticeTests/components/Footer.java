package AutomationPracticeTests.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Footer {
    private WebDriver driver;

    private static final By LOC_TXT_INP_NEWSLETTER = By.id("newsletter-input");
    private static final By LOC_BTN_NEWSLETTER = By.name("submitNewsletter");
    private static final By LOC_MSG_ALERT = By.className("alert");
    private static final By LOC_BLOCK_CATEGORIES = By.className("blockcategories_footer");
    private static final By LOC_BLOCK_INFORMATION = By.id("block_various_links_footer");
    private static final By LOC_BLOCK_ACCOUNT = By.className("footer-block");

    public Footer(WebDriver driver) {
        this.driver = driver;
    }

    public void signInForNewsletter(String mail) {
        driver.findElement(LOC_TXT_INP_NEWSLETTER).sendKeys(mail);
        driver.findElement(LOC_BTN_NEWSLETTER).click();
    }

    public String getAlertText() {
        return driver.findElement(LOC_MSG_ALERT).getText();
    }

    public String getFirstBlockTitle() {
        return driver.findElement(LOC_BLOCK_CATEGORIES).findElement(By.tagName("h4")).getText();
    }

    public List<WebElement> getLiCategoriesLinks() {
        List<WebElement> elements = driver.findElement(LOC_BLOCK_CATEGORIES).findElements(By.tagName("ul"));
        List<WebElement> li_elements = new ArrayList<WebElement>();

        for ( WebElement elem : elements ) {
            if (elem.getAttribute("style").equals("display: block;")) {
                li_elements.add(elem.findElement(By.tagName("li")));
            }
        }
        return li_elements;
    }

    public String getSecondBlockTitle() {
        return driver.findElement(LOC_BLOCK_INFORMATION).findElement(By.tagName("h4")).getText();
    }

    public List<WebElement> getSecondBlockLinks() {
        return driver.findElement(LOC_BLOCK_INFORMATION).findElements(By.tagName("li"));
    }

    public String getThirdBlockTitle() {
        return driver.findElements(LOC_BLOCK_ACCOUNT).get(2).findElement(By.tagName("h4")).getText();
    }

    public List<WebElement> getThirdBlockLinks() {
        return driver.findElements(LOC_BLOCK_ACCOUNT).get(2).findElements(By.tagName("li"));
    }
}
