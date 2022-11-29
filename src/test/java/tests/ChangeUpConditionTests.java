package tests;

import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.searchPageObjectFactory;
import org.junit.Test;

public class ChangeUpConditionTests extends CoreTestCase {

    @Test

    public void testChangeScreenOrientationOnSearchResults() {


        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();


        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle();

        this.rotateScreenLandscape();

        String title_after_rotation = ArticlePageObject.getArticleTitle();


        assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_rotation);

        this.rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle();


        assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_second_rotation);
    }


    @Test

    public void testSearchArticleBackground() {


        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();

        this.backgroundApp(2);
    }

}
