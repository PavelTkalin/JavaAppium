package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.searchPageObjectFactory;
import org.junit.Test;

public class SearchTests extends CoreTestCase {


    @Test


    public void testCancelTestSearch() {

        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
    }

    @Test

    public void testSearch() {


        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }


    @Test
    public void testTestSwipeArticle() {

        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();


    }

    @Test

    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Linkin park discography");
        SearchPageObject.clickByArticle();
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();


        assertTrue(
                "We found too few results",
                amount_of_search_results > 0);
    }


    @Test

    public void testOfEmptyAmountSearch() {

        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("fdfd&454d");
        SearchPageObject.clickByArticle();
        SearchPageObject.waitForEmptyResultsLabel();
        SearchPageObject.assertThereIsNoResultOfSearch();
    }


 /*
    public void testVerifyTestSearch() {
        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        WebElement java = SearchPageObject.waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']//*[@text ='Java']"), "Cannot find object-oriented programming language searching by Java", 15);
        WebElement javaScript = SearchPageObject.waitForElementPresent(By.xpath("//*[@resource-id = 'org.wikipedia:id/page_list_item_title']//*[@text ='JavaScript']"), "Cannot find object-oriented programming language searching by JavaScript", 15);
        String expected_article_text = "Java";
        String actual_article_text_java = java.getText();
        String actual_article_text_javascript = javaScript.getText();
        assertTrue(actual_article_text_java.contains(expected_article_text));
        assertTrue(actual_article_text_javascript.contains(expected_article_text));

    }
*/

}
