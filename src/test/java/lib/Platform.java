package lib;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class Platform {

    private static final String PLATFORM_IOS = "ios";
    private static final String PLATFORM_ANDROID = "android";

    private static final String PLATFORM_MOBILE_WEB = "mobile_web";
    private static final String APPIUM_URL = "http://127.0.0.1:4723/wd/hub";

    public static Platform instance;

    public static Platform getInstance() {

        if (instance == null) {
            instance = new Platform();

        }

        return instance;
    }

    public RemoteWebDriver getDriver() throws Exception {

        URL URL = new URL(APPIUM_URL);
        if (this.isAndroid()) {
            return new AndroidDriver(URL, this.getAndroidDesiredCapabilities());
        } else if (this.isiOS()) {
            return new IOSDriver(URL, this.getIOSDesiredCapabilities());
        } else if (this.isMw()) {
            return new ChromeDriver(this.getMVChromeOptions());
        }

        else throw new Exception("Cannot detect type of the Driver. Platform value" + this.getPlatformVar());


    }

    public boolean isAndroid() {

        return isPlatform(PLATFORM_ANDROID);
    }

    public boolean isiOS() {

        return isPlatform(PLATFORM_IOS);
    }

    public boolean isMw() {

        return isPlatform(PLATFORM_MOBILE_WEB);
    }


    private DesiredCapabilities getAndroidDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "AndroidTestDevice");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "Appium");
        capabilities.setCapability("appPackage", "org.wikipedia");
        capabilities.setCapability("appActivity", ".main.MainActivity");
        capabilities.setCapability("app", "C:\\Pavel_data\\STUDY\\JavaAppiumAutomation\\JavaAppiumAutomation\\apks\\org.wikipedia.apk");
        return capabilities;

    }


    private DesiredCapabilities getIOSDesiredCapabilities() {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "iOS");
        capabilities.setCapability("deviceName", "iPhone SE");
        capabilities.setCapability("platformVersion", "16.1");
        capabilities.setCapability("app", "/Users/paveltkalin/Desktop/Wikipedia.app");
        return capabilities;
    }


    private ChromeOptions getMVChromeOptions() {

        Map<String, Object> devicemetrics = new HashMap<String, Object>();
        devicemetrics.put("width", 360);
        devicemetrics.put("pixelRatio", 3.0);

        Map<String, Object> mobileEmulation = new HashMap<String, Object>();
        mobileEmulation.put("devicemetrics", devicemetrics);
        mobileEmulation.put("UserAgent", "Mozilla/5.0 (Linux; Android 4.2.1; en-us; Nexus 5 Build/JOP40D) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.166 Mobile Safari/535.19))");

        ChromeOptions ChromeOptions = new ChromeOptions();
        ChromeOptions.addArguments("Window size = 340,640");

        return ChromeOptions;
    }

    private boolean isPlatform(String my_platform) {

        String platform = this.getPlatformVar();
        return my_platform.equals(platform);

    }

    public String getPlatformVar() {


        return System.getenv("PLATFORM");
    }

}
