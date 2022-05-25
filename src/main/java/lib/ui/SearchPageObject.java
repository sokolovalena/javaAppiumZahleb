package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class SearchPageObject extends MainPageObject {

    private static final String
    SEARCH_INIT_STARTSTORY = "//*[contains(@text, 'Страж')]",
    SEARCH_INPUT = "//*[contains(@text, 'друг')]";

    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void initSearchInput()
    {
        this.waitForElementForClick(By.xpath(SEARCH_INIT_STARTSTORY), "cannot find and click init element", 5);
        this.waitForElementPresent(By.xpath(SEARCH_INIT_STARTSTORY), "cannot find search input after clicking", 5);
    }

    public void typeSearchLine()
    {
        this.waitForElementForSendKeys(By.xpath(SEARCH_INPUT), "друг", "cannot find and type search input", 5);
    }
}
