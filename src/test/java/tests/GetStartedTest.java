package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.WelcomePageObject;
import org.junit.Test;


@Epic("Start tests for different platform")
public class GetStartedTest extends CoreTestCase {


    @Test
    @Features(value = {@Feature(value = "Start tests"), @Feature(value = "Pages")})
    @DisplayName("Test pass through welcome page")
    @Description("We verify whether it is possible to pass through welcome page")
    @Step("Starting test passThroughWelcome")
    @Severity(value = SeverityLevel.MINOR)


    public void passThroughWelcome() {

        if ((Platform.getInstance().isAndroid()) || (Platform.getInstance().isMw())) {
            return;
        }

        WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
        WelcomePageObject.waitForLearnMoreLink();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForNewWayToExploreText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForAddOrEditPreferredLangText();
        WelcomePageObject.clickNextButton();

        WelcomePageObject.waitForLearnMoreAboutDataCollectedText();
        WelcomePageObject.clickGetStartedButton();

    }
}
