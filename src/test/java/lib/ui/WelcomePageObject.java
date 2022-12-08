package lib.ui;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);

    }


    private static final String

            STEP_LEARN_MORE_LINK = "Learn more about Wikipedia",
            STEP_NEW_WAYS_TO_EXPLORE_TEXT = "New ways to explore",
            STEP_ADD_OR_EDIT_PREFERRED_LANG_TEXT = "Add or edit preferred languages",
            STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK = "Learn more about data collected",
            NEXT_LINK = "Next",
            GET_STARTED_BUTTON = "Get started",

    SKIP = "id:Skip";


    @Step("Wait for 'learn more' link")
    public void waitForLearnMoreLink() {
        this.waitForElementPresent(STEP_LEARN_MORE_LINK, "cannot find Element", 15);

    }
    @Step("Wait for add or edit preffered lang text")
    public void waitForAddOrEditPreferredLangText() {
        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFERRED_LANG_TEXT, "cannot find Add or edit preferred languages link", 15);

    }

    @Step("Wait for learn more about data collected text")
    public void waitForLearnMoreAboutDataCollectedText() {
        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK, "cannot find Add or edit preferred languages link", 15);

    }


    @Step("Wait for new way to explore text")
    public void waitForNewWayToExploreText() {
        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT, "cannot find and click new ways to explore link", 15);

    }


    @Step("Click next button")
    public void clickNextButton() {
        this.waitForElementAndClick(NEXT_LINK, "cannot find and click next link", 15);

    }

    @Step("Click get started button")

    public void clickGetStartedButton() {
        this.waitForElementAndClick(GET_STARTED_BUTTON, "cannot find and click Get started button link", 15);

    }


    @Step("Click skip")

    public void clickSkip() {

        this.waitForElementAndClick(SKIP, "Cannot find and skip click button", 5);
    }
}
