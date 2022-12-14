package lib.ui;

import io.qameta.allure.Step;
import lib.Platform;
import org.openqa.selenium.remote.RemoteWebDriver;


abstract public class NavigationUI extends MainPageObject {

    protected static String
            MY_LISTS_LINK,
            OPEN_NAVIGATION;


    public NavigationUI(RemoteWebDriver driver) {

        super(driver);
    }


    @Step("Open navigation")
    public void openNavigation() {

        if (lib.Platform.getInstance().isMw()) {

            this.waitForElementAndClick(OPEN_NAVIGATION, "Cannot find and click open navigation button", 5);
        } else {
            System.out.println("This method do nothing for platform" + Platform.getInstance().getPlatformVar());
        }
    }


    @Step("Click my lists")
    public void clickMyLists() {
        if (lib.Platform.getInstance().isMw()) {
            this.tryClickElementWithFewAttempts(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        } else {
            this.waitForElementAndClick(
                    MY_LISTS_LINK,
                    "Cannot find navigation button to My list",
                    5
            );
        }

    }


}
