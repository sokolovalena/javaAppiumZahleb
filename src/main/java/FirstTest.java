import lib.CoreTestCase;
import lib.ui.MainPageObject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FirstTest extends CoreTestCase {

    private MainPageObject MainPageObject;

    protected void setUp() throws Exception
    {
        super.setUp();

        MainPageObject = new MainPageObject(driver);
    }


    @Test
    public void testSearch() throws InterruptedException {
        Thread.sleep(3000);
        MainPageObject.waitForElementForClick(
                By.id("zahleb.me:id/toolbar_title"),
                "Cannot find start story",
                15
        );

        WebElement element_to_back = driver.findElementByAccessibilityId("Перейти вверх");
        element_to_back.click();
        Thread.sleep(1000);

        MainPageObject.waitForElementForClick(
                By.id("zahleb.me:id/toolbar_search"),
                "Cannot find element searсh toolbar",
                2
        );
        MainPageObject.waitForElementForSendKeys(
                By.id("zahleb.me:id/search_field"),
                "друг",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementPresent(
                By.xpath("//*[@resource-id='zahleb.me:id/story_title' and contains(@text, 'друг')]"),
                "Cannot find 'друг' topic searching",
                3
        );
  //  }
        MainPageObject.waitForElementAndClear(
                By.id("zahleb.me:id/back"),
                "Cannot find cancel search button",
                3
        );

        MainPageObject.waitForElementForClick (
                By.id("zahleb.me:id/clear"),
                "Cannot find close search button",
                3
        );

        MainPageObject.waitForElementNotPresent (
            By.id("zahleb.me:id/clear"),
            "Cannot find close search button",
            3
        );
    }

    @Test
    public void TestCompareArticleTitle() throws InterruptedException {
        MainPageObject.waitForElementForClick(
                By.xpath("//*[contains(@text, 'Страж')]"),
                "Cannot find start story",
                15
        );

        WebElement element_to_back = driver.findElementByAccessibilityId("Перейти вверх");
        element_to_back.click();
        Thread.sleep(1000);

        MainPageObject.waitForElementForClick(
                By.id("zahleb.me:id/toolbar_search"),
                "Cannot find element searсh toolbar",
                2
        );

        MainPageObject.waitForElementForSendKeys(
                By.id("zahleb.me:id/search_field"),
                "друг",
                "Cannot find search input",
                5
        );

        MainPageObject.waitForElementForClick(
                By.xpath("//*[@resource-id='zahleb.me:id/story_title' and contains(@text, 'друг')]"),
                "Cannot find 'друг' topic searching",
                5
        );

        WebElement title_element = MainPageObject.waitForElementPresent(
                By.id("zahleb.me:id/story_title"),
                "Cannot find title story",
                15
        );

        String article_title = title_element.getText();
        Assert.assertEquals(
                "We see unexpected title",
                "Мы – отражение друг друга",
                article_title
        );


    }





}

