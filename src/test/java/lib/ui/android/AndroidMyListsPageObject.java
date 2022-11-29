package lib.ui.android;

import io.appium.java_client.AppiumDriver;
import lib.ui.MyListsPageObject;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text ='{FOLDERNAME}']";
        ARTICLE_BY_TITLE = "xpath://*[@text ='{TITLE}')]";
        LIST_OF_ARTICLES = "id:org.wikipedia:id/item_title";

    }

    public AndroidMyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
}
