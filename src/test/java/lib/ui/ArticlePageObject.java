package lib.ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {

    protected static String

            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            ADD_TO_MY_EXISTING_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            CLOSE_ARTICLE_BUTTON;


    public ArticlePageObject(RemoteWebDriver driver) {

        super(driver);

    }

    @Step("Wait for title with name '{TITLE}'")
    public WebElement waitForTitleElement() {

        return this.waitForElementPresent(TITLE, "Cannot find article title on page", 15);

    }

    @Step("Get article title")
    public String getArticleTitle() {

        WebElement title_element = waitForTitleElement();
        screenshot(this.takeScreenshot("Get article title"));
        if (Platform.getInstance().isAndroid()) {

            return title_element.getText();
        } else {
            return title_element.getAttribute("name");

        }
    }

    @Step("Swipe to footer")
    public void swipeToFooter() {

        if (Platform.getInstance().isAndroid()) {
            this.swipeUptToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    100);

        } else {
            this.swipeUpTillElementAppear(FOOTER_ELEMENT, "Cannot find the end of article", 100);


        }
    }

    @Step("Add article to my list")
    public void addArticleTitleToMyList(String name_of_folder) {

        this.waitForElementAndClick(OPTIONS_BUTTON, "cannot open", 5);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 15);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY, "Cannot got it tip overlay", 15);
        this.waitForElementAndClear(MY_LIST_NAME_INPUT, "Cannot find input to set name on articles folder", 15);
        this.waitForElementAndSendKeys(MY_LIST_NAME_INPUT, name_of_folder, "Cannot input article folder", 16);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON, "Cannot find input to set name on articles folder", 15);

    }


    @Step("Add article to existing list")
    public void addArticleTitleToMyExistingList() {

        this.waitForElementAndClick(OPTIONS_BUTTON, "cannot open", 5);
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find option to add article to reading list", 15);
        this.waitForElementAndClick(ADD_TO_MY_LIST_OVERLAY, "Cannot got it tip overlay", 15);
        this.waitForElementAndClick(ADD_TO_MY_EXISTING_LIST_OVERLAY, "Cannot got it tip overlay", 15);
        this.waitForElementAndClick(MY_LIST_OK_BUTTON, "Cannot find input to set name on articles folder", 15);

    }

    @Step("Add articles to my saved")
    public void addArticlesToMySaved() {

        if (Platform.instance.isMw()) {
            this.removeArticleFromMySavedIfAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "cannot find options to add article to reading list", 5);

    }


    @Step("Remove article from my saved")
    public void removeArticleFromMySavedIfAdded() {


        if (this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)) {
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON, "Cannot click button to remove article from lists", 15);
            this.waitForElementPresent(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find a button to save article after removing", 15);
        }


    }

    @Step("Close article")

    public void closeArticle() {

        if ((Platform.getInstance().isiOS()) || (Platform.getInstance().isAndroid())) {

            this.waitForElementAndClick(CLOSE_ARTICLE_BUTTON, "Cannot close article", 5);

        } else {
            System.out.println("This method do nothing for platform" + Platform.getInstance().getPlatformVar());

        }
    }


}
