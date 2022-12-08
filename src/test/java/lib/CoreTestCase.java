package lib;

import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import lib.ui.WelcomePageObject;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileOutputStream;
import java.util.Properties;


public class CoreTestCase {


    protected RemoteWebDriver driver;


    @Before
    @Step("Run driver and session")

    public void setUp() throws Exception {


        driver = Platform.getInstance().getDriver();
        this.createAllurePropertyFile();
        this.rotateScreenPortrait();
        this.skipWelcomePageForIOSApp();
        this.openWikiWebPageForMobileWeb();


    }

    @After
    @Step("Remove driver and session")
    public void tearDown() throws Exception {

        driver.quit();

    }


    @Step("Rotate screen to portrait mode")
    protected void rotateScreenPortrait() {

        if (driver instanceof AppiumDriver) {

            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.PORTRAIT);
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }

    }

    @Step("Rotate screen to landscape mode")
    protected void rotateScreenLandscape() {

        if (driver instanceof AppiumDriver) {

            AppiumDriver driver = (AppiumDriver) this.driver;
            driver.rotate(ScreenOrientation.LANDSCAPE);
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());

        }
    }

    @Step("this method doesn't work for Android and iOS")
    protected void openWikiWebPageForMobileWeb() {

        if (Platform.getInstance().isiOS()) {
            driver.get("https://en.m.Wikipedia.org");
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }
    }


    @Step("Step skip welcome to screen iOS")
    private void skipWelcomePageForIOSApp() {
        if (Platform.getInstance().isiOS()) {

            AppiumDriver driver = (AppiumDriver) this.driver;
            WelcomePageObject WelcomePageObject = new WelcomePageObject(driver);
            WelcomePageObject.clickSkip();


        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }


    }

    @Step("Create allure property file")
    private void createAllurePropertyFile() {

        String path = System.getProperty("allure.results.directory");
        try {
            Properties props = new Properties();
            FileOutputStream fos = new FileOutputStream(path + "/environment.properties");
            props.setProperty("Environment", Platform.getInstance().getPlatformVar());
            props.store(fos, "See https://github.com/allure-framework/allure-app/wiki/Environment");
            fos.close();
        } catch (Exception e) {
            System.err.println("IO problem when writing Allure properties file");
            e.printStackTrace();
        }
    }


}
