package lib;

import io.appium.java_client.AppiumDriver;
import junit.framework.TestCase;
import lib.ui.WelcomePageObject;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;


public class CoreTestCase extends TestCase {


    protected RemoteWebDriver driver;

    protected void setUp() throws Exception {

        super.setUp();
        driver = Platform.getInstance().getDriver();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();


    }

    @Override
    protected void tearDown() throws Exception {

        driver.quit();
        super.tearDown();
    }


    protected void rotateScreenPortrait() {

        if (driver instanceof AppiumDriver) {

            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }

    }

    protected void rotateScreenLandscape() {

        if (driver instanceof AppiumDriver) {

            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());

        }
    }

    protected void openWikiWebPageForMobileWeb() {

        if (Platform.getInstance().isiOS()) {
            driver.get("https://en.m.Wikipedia.org");
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }
    }


    private void skipWelcomePageForIOSApp() {
        if (Platform.getInstance().isiOS()) {

            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();


        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }


    }


}
