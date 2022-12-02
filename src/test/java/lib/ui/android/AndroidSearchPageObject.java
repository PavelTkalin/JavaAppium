package lib.ui.android;

import lib.ui.SearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AndroidSearchPageObject extends SearchPageObject {
    static {
        SEARCH_INIT_ELEMENT = "id:org.wikipedia:id/fragment_feed_header";
        SEARCH_INPUT = "id:org.wikipedia:id/search_src_text";
        SEARCH_RESULT_BY_SUBSTRING_TPL = "xpath://*[@resource-id = 'org.wikipedia:id/page_list_item_container']//*[contains(@text ='{SUBSTRING}')]";
        SEARCH_CANCEL_BUTTON = "id:org.wikipedia:id/search_close_btn";
        SEARCH_BUTTON = "id:org.wikipedia:id/search_src_text";
        SEARCH_RESULT_ELEMENT = "xpath://*[@resource-id = 'org.wikipedia:id/search_results_list']//*[@resource-id = 'org.wikipedia:id/page_list_item_container']";
        SEARCH_MAIN_ARTICLE = "xpath://android.widget.FrameLayout[@content-desc='Explore']";
        SEARCH_EMPTY_RESULT_ELEMENT = "xpath://*[contains(@text,'No results found')]";
    }

    public AndroidSearchPageObject(RemoteWebDriver driver) {

        super(driver);
    }
}
