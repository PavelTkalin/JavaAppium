package lib.ui;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import lib.Platform;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.List;
import java.util.regex.Pattern;

public class MainPageObject {


    protected RemoteWebDriver driver;

    public MainPageObject(RemoteWebDriver driver) {

        this.driver = driver;

    }

    public void clickElementToTheRightUpCorner(String locator, String error_message) {


        if (driver instanceof AppiumDriver) {


            WebElement element = this.waitForElementPresent(locator + "/..", error_message, 15);
            int right_x = element.getLocation().getX();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;
            int width = element.getSize().getWidth();

            int point_to_click_x = (right_x + width) - 3;
            int point_to_click_y = middle_y;

            TouchAction action = new TouchAction((AppiumDriver) driver);
            //        action.tap(point_to_click_x, point_to_click_y);
        } else {
            System.out.println("Method rotateScreenPortrait() does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }


    }

    @Step("Swipe up fast")
    protected void swipeUpQuick() {
        swipeUp(2000);

    }

    @Step("Swipe up to find element")
    public void swipeUptToFindElement(String locator, String error_message, int max_swipes) {

        By by = getLocatorByString(locator);
        int already_swiped = 0;
        while (driver.findElements(by).size() == 0) {

            if (already_swiped > max_swipes) {
                waitForElementPresent(by.toString(), "Cannot find", 15);
                return;
            }

            swipeUp(2000);
            ++already_swiped;
        }
    }

    @Step("Swipe up till element appear")
    public void swipeUpTillElementAppear(String locator, String error_message, int max_swipes) {
        int already_swiped = 0;

        while (this.isElementLocatedOnTheScreen(locator)) {

            if (already_swiped > max_swipes) {
                Assert.assertTrue(error_message, this.isElementLocatedOnTheScreen(locator));
            }

            swipeUpQuick();
            ++already_swiped;
        }
    }

    @Step("Wait for element to be presented")
    public WebElement waitForElementPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    @Step("Swipe up fast")
    public WebElement waitForElementAndClick(String locator, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.click();
        return element;

    }

    @Step("Wait for elenebt and send keys")
    public WebElement waitForElementAndSendKeys(String locator, String value, String error_message, long timeoutInSeconds) {

        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.sendKeys(value);
        return element;

    }


    @Step("Verfication of whether element is located on the screen")

    public boolean isElementLocatedOnTheScreen(String locator) {
        int element_location_by_y = this.waitForElementPresent(locator, "Cannot find element by locator", 1).getLocation().getY();
        if (Platform.getInstance().isMw()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            Object js_result = JSExecutor.executeScript("return window.pageYOffset");
            element_location_by_y -= Integer.parseInt(js_result.toString());

        }

        int screen_size_by_y = driver.manage().window().getSize().getHeight();
        return element_location_by_y < screen_size_by_y;
    }

    @Step("Swipe element to left")
    public void swipeElementToLeft(String locator, String error_message) {

        if (driver instanceof AppiumDriver) {


            WebElement element = waitForElementPresent(locator, error_message, 10);

            int left_x = element.getLocation().getX();
            int right_x = left_x + element.getSize().getWidth();
            int upper_y = element.getLocation().getY();
            int lower_y = upper_y + element.getSize().getHeight();
            int middle_y = (upper_y + lower_y) / 2;

            TouchAction action = new TouchAction((AppiumDriver) driver);

            action.press(PointOption.point(right_x, middle_y));
            action.waitAction(WaitOptions.waitOptions(Duration.ofMillis(300)));
            ;


            if (Platform.getInstance().isAndroid()) {
                action.moveTo(PointOption.point(left_x, middle_y));
            } else {

                int offset_x = (-1 * element.getSize().getWidth());
                action.moveTo(PointOption.point(offset_x, 0));
            }
            action.release();
            action.perform();
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }


    }


    public boolean waitForElementNotPresent(String locator, String error_message, long timeoutInSeconds) {

        By by = getLocatorByString(locator);
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
        wait.withMessage(error_message + " \n");
        return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
    }


    public WebElement waitForElementAndClear(String locator, String error_message, long timeoutInSeconds) {
        WebElement element = waitForElementPresent(locator, error_message, timeoutInSeconds);
        element.clear();
        return element;
    }

    @Step("Scroll web psge up")
    public void scrollWebPageUp() {

        if (Platform.getInstance().isMw()) {
            JavascriptExecutor JSExecutor = (JavascriptExecutor) driver;
            JSExecutor.executeScript("window.scrollBy(0,250)");
        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }

    }

    @Step("Scroll till element is not visible")
    public void scrollTillElementNotVisible(String locator, String error_message, int max_swipes) {

        int already_swiped = 0;
        WebElement element = this.waitForElementPresent(locator, error_message, 15);

        while (!this.isElementLocatedOnTheScreen(locator)) {

            scrollWebPageUp();
            ++already_swiped;
            if (already_swiped > max_swipes) {
                Assert.assertTrue(error_message, element.isDisplayed());
            }

        }

    }


    @Step("Assert element has text")
    public void assertElementHasText(String locator, String error_message, long timeoutInSeconds) {

        WebElement title_element = waitForElementPresent(locator, "Page not found", 5);
        String article_title = title_element.getText();

    }


    @Step("Get amount of elements")
    public int getAmountOfElements(String locator) {

        By by = getLocatorByString(locator);
        List elements = driver.findElements(by);
        return elements.size();
    }

    //   System.out.println("First test run");

    @Step("Verification of whether element is present")
    public boolean isElementPresent(String locator) {

        return getAmountOfElements(locator) > 0;
    }

    @Step("Trying to click element with few attempts")
    public void tryClickElementWithFewAttempts(String locator, String error_message, int amount_of_attempts) {

        int current_attempts = 0;
        boolean need_more_attempts = true;

        while (need_more_attempts) {

            try {
                this.waitForElementAndClick(locator, error_message, 1);
                need_more_attempts = false;
            } catch (Exception e) {
                if (current_attempts > amount_of_attempts) {
                    this.waitForElementAndClick(locator, error_message, 1);
                }
            }

            ++current_attempts;
        }

    }

    @Step("Assert element is not present")
    public void assertElementNotPresent(String locator, String error_message) {

        int amount_of_elements = getAmountOfElements(locator);
        if (amount_of_elements > 0) {
            String default_message = "An element" + locator + "supposed to be not present";
            throw new AssertionError(default_message + " " + error_message);


        }


    }

    @Step("Wait for elenent and get attribute")

    public String waitForElementAndGetAttribute(String locator, String attribute, String error_message, long timeOutInSeconds) {


        WebElement element = waitForElementPresent(locator, attribute, timeOutInSeconds);
        return element.getAttribute(attribute);


    }

    @Step("Asset element is present")
    public void assertElementIsPresenting(String locator, String error_message, long timeoutInSeconds) {
        By by = getLocatorByString(locator);
        boolean isTrue = driver.findElement(by).isDisplayed();
        Assert.assertTrue(isTrue);


    }

    @Step("Swipe up")
    public void swipeUp(int timeOfSwipe) {


        if (driver instanceof AppiumDriver) {

            TouchAction action = new TouchAction((AppiumDriver) driver);
            Dimension size = driver.manage().window().getSize();

            int x = size.width / 2;
            int start_y = (int) (size.height * 0.8);
            int end_y = (int) (size.height * 0.2);

            action
                    .press(PointOption.point(x, start_y))
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(timeOfSwipe)))
                    .moveTo(PointOption.point(x, end_y))
                    .release()
                    .perform();

        } else {
            System.out.println("This method does nothing for Platform" + Platform.getInstance().getPlatformVar());
        }

    }


    @Step("Get location by string")
    private By getLocatorByString(String locator_with_type) {

        String[] exploded_locator = locator_with_type.split(Pattern.quote("s"), 2);
        String by_type = exploded_locator[0];
        String locator = exploded_locator[1];


        if (by_type.equals("xpath")) {
            return By.xpath(locator);
        } else if (by_type.equals("id")) {
            return By.id(locator);

        } else if (by_type.equals("css")) {
            return By.cssSelector(locator);
        } else {
            throw new IllegalArgumentException("Cannot get type of locator.Locator" + locator_with_type);
        }

    }


    @Step("Taking screenshot")

    public String takeScreenshot(String name) {

        TakesScreenshot ts = (TakesScreenshot) this.driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = System.getProperty("user.dir") + "/" + name + "_screenshot.png";
        try {

            FileUtils.copyFile(source, new File(path));
            System.out.println("The screenshot was taken" + path);
        } catch (Exception e) {
            System.out.println("Cannot take screenshot.Error" + e.getMessage());
        }
        return path;

    }

    @Attachment
    public static byte[] screenshot(String path) {

        byte[] bytes = new byte[0];

        try {
            bytes = Files.readAllBytes(Paths.get(path));
        } catch (IOException e) {
            System.out.println("Cannot get bytes from screenshot. Error: " + e.getMessage());
        }

        return bytes;

    }

}


