package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.searchPageObjectFactory;
import org.junit.Test;

public class ArticleTests extends CoreTestCase {


    @Test

    public void testCompareArticleTitle() {


        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        String article_title = ArticlePageObject.getArticleTitle();

        assertEquals("We see unexpected title", "Java (programming language)", article_title);

    }


    @Test
    public void testAssertElementHasText() {

        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }


    @Test

    public void testAssertElementPresent() {

        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);


        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();

    }

}
