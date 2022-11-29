package lib.ui.ios;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class IOSMyListsPageObject extends MyListsPageObject {

    static {

        LIST_OF_ARTICLES = "id:org.wikipedia:id/item_title";

    }

    public IOSMyListsPageObject (AppiumDriver driver) {
        super(driver);
    }
}
