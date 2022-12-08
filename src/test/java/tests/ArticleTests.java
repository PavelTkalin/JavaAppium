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


@Epic("Tests for Articles")
public class ArticleTests extends CoreTestCase {


    @Test
    @Features(value = {@Feature(value = "Article"), @Feature(value = "Article")})
    @DisplayName("Compare article title with expected one")
    @Description("We compare titles of article to expected one")
    @Step("Starting test testCompareArticleTitle")
    @Severity(value = SeverityLevel.BLOCKER)

    public void testCompareArticleTitle() {



        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        //     ArticlePageObject.takeScreenshot("article_page");

        Assert.assertEquals("We see unexpected title", "Java (programming language)", article_title);

    }


    @Test
    @Features(value = {@Feature(value = "Article"), @Feature(value = "Article")})
    @DisplayName("Test assert element has text")
    @Description("We verify whether element has text")
    @Step("Starting test testAssertElementHasText")
    @Severity(value = SeverityLevel.MINOR)
    public void testAssertElementHasText() {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }


    @Test
    @Features(value = {@Feature(value = "Article"), @Feature(value = "Article")})
    @DisplayName("Test assert element is present")
    @Description("We verify whether element is present")
    @Step("Starting test testAssertElementPresent")
    @Severity(value = SeverityLevel.CRITICAL)

    public void testAssertElementPresent()
    {

        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }

}
