package tests;

import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;


@Epic("Tests for mobile device conditions")
public class ChangeUpConditionTests extends CoreTestCase {

    @Test
    @Features(value = {@Feature(value = "Mobile device parametres"), @Feature(value = "Screen")})
    @DisplayName("Test change screen orientation on search results")
    @Description("We verify whether article is searchable after screen rotation")
    @Step("Starting test testChangeScreenOrientationOnSearchResults")
    @Severity(value = SeverityLevel.NORMAL)

    public void testChangeScreenOrientationOnSearchResults() {


        if (Platform.getInstance().isMw()) {

            return;
        }


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();


        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);

        String title_before_rotation = ArticlePageObject.getArticleTitle();

        this.rotateScreenLandscape();

        String title_after_rotation = ArticlePageObject.getArticleTitle();


        Assert.assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_rotation);

        this.rotateScreenPortrait();

        String title_after_second_rotation = ArticlePageObject.getArticleTitle();


        Assert.assertEquals("Article title have been changed after screen rotation", title_before_rotation, title_after_second_rotation);
    }


    @Test
    @Features(value = {@Feature(value = "Article"), @Feature(value = "Search")})
    @DisplayName("Test change screen orientation on search results")
    @Description("We verify whether article is searchable")
    @Step("Starting test testSearchArticleBackground")
    @Severity(value = SeverityLevel.MINOR)

    public void testSearchArticleBackground() {

        if (Platform.getInstance().isMw()) {

            return;
        }


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();

    }

}
