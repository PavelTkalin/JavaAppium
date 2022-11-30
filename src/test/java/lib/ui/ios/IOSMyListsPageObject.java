package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {

        LIST_OF_ARTICLES = "id:org.wikipedia:id/item_title";

    }

    public IOSMyListsPageObject (RemoteWebDriver driver) {
        super(driver);
    }
}
