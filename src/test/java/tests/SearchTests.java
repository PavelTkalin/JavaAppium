package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

@Epic("Search tests")
public class SearchTests extends CoreTestCase {


    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test cancelling search by pressing cancel button")
    @Description("We verify whether it is possible to cancel test")
    @Step("Starting test testCancelTestSearch")
    @Severity(value = SeverityLevel.MINOR)


    public void testCancelTestSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.waitForCancelButtonToAppear();
        SearchPageObject.clickCancelSearch();
    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test searching the article and pressing the button")
    @Description("We verify whether it is possible to search the article and pressing the button")
    @Step("Starting test testSearch")
    @Severity(value = SeverityLevel.CRITICAL)

    public void testSearch() {


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }


    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test swiping the article down to the footer")
    @Description("We verify whether it is possible to swipe the article down to the footer")
    @Step("Starting test testTestSwipeArticle")
    @Severity(value = SeverityLevel.MINOR)
    public void testTestSwipeArticle() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        ArticlePageObject.swipeToFooter();


    }

    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test that amount of searched articles is not empty")
    @Description("We verify whether if amount of searched articles is not empty")
    @Step("Starting test testAmountOfNotEmptySearch")
    @Severity(value = SeverityLevel.MINOR)

    public void testAmountOfNotEmptySearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Linkin park discography");
        SearchPageObject.clickByArticle();
        int amount_of_search_results = SearchPageObject.getAmountOfFoundArticles();


        Assert.assertTrue(
                "We found too few results",
                amount_of_search_results > 0);
    }


    @Test
    @Features(value = {@Feature(value = "Search"), @Feature(value = "Operations with articles")})
    @DisplayName("Test that amount of searched articles is empty")
    @Description("We verify whether if amount of searched articles not empty")
    @Step("Starting test testAmountOfEmptySearch")
    @Severity(value = SeverityLevel.MINOR)

    public void testOfEmptyAmountSearch() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

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
