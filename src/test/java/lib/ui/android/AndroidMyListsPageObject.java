package lib.ui.android;

import lib.ui.MyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidMyListsPageObject extends MyListsPageObject {

    static {
        FOLDER_BY_NAME_TPL = "xpath://*[@text ='{FOLDERNAME}']";
        ARTICLE_BY_TITLE = "xpath://*[@text ='{TITLE}')]";
        LIST_OF_ARTICLES = "id:org.wikipedia:id/item_title";

    }

    public AndroidMyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }


}
