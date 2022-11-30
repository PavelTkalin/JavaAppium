package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class SearchPageObject extends MainPageObject {

    protected static String
            SEARCH_INIT_ELEMENT,
            SEARCH_INPUT,
            SEARCH_RESULT_BY_SUBSTRING_TPL,
            SEARCH_CANCEL_BUTTON,
            SEARCH_BUTTON,
            SEARCH_RESULT_ELEMENT,
            SEARCH_MAIN_ARTICLE,
            SEARCH_EMPTY_RESULT_ELEMENT;

    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);

    }

    /*TEMPLATES METHODS */
    private static String getResultSearchElement(String substring) {
        return SEARCH_RESULT_BY_SUBSTRING_TPL.replace("{substring}", substring);
    }

    /*TEMPLATES METHODS */
    public void initSearchInput() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 15);
        this.waitForElementAndClick(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 15);
    }


    public void verifyStartPage() {
        this.waitForElementPresent(SEARCH_INIT_ELEMENT, "Cannot find search input after clicking search init element", 15);
    }

    public void waitForCancelButtonToAppear() {
        this.waitForElementPresent(SEARCH_CANCEL_BUTTON, "cannot find search Button", 15);

    }

    public void waitForCancelButtonToDisAppear() {
        this.waitForElementNotPresent(SEARCH_CANCEL_BUTTON, "cannot find search Button", 15);

    }

    public void clickCancelSearch() {

        this.waitForElementAndClick(SEARCH_CANCEL_BUTTON, "Cannot find and click cancel button", 5);

    }

    public void typeSearchLine(String line_search) {

        this.waitForElementAndSendKeys(SEARCH_INPUT, line_search, "Cannot type input", 15);
        this.waitForElementAndClick(SEARCH_BUTTON, "Cannot type input", 15);


    }

    public void waitForSearchResult(String substring) {

        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(search_result_xpath, "Cannot find search result" + substring, 5);

    }


    public void clickByArticleWithSubstring(String substring) {
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementAndClick(search_result_xpath, "error" + substring, 15);


    }


    public void clickByArticle() {
        this.waitForElementAndClick(
                SEARCH_MAIN_ARTICLE, "error", 15);


    }


    public int getAmountOfFoundArticles() {

        this.waitForElementPresent(SEARCH_RESULT_ELEMENT,
                "Cannot find anything by request", 15);


        String search_resource_locator = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView";

        this.waitForElementPresent(search_resource_locator,
                "Cannot find anything by request",
                15);

        return this.getAmountOfElements(SEARCH_RESULT_ELEMENT);


    }


    public void waitForEmptyResultsLabel() {

        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT, "", 15);


        String empty_result_label = "//*[contains(@text,'No results found')]";

        this.waitForElementPresent(SEARCH_EMPTY_RESULT_ELEMENT,
                "Cannot find empty results label by the request",
                15

        );

    }


    public void assertThereIsNoResultOfSearch() {

        this.assertElementNotPresent(SEARCH_RESULT_ELEMENT, "We supposed to find no results");

    }


}


