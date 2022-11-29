package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.searchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
/*
    @Test

    public void testSaveFirstArticleToMyList() {


        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {

            ArticlePageObject.addArticleTitleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();

        }

        ArticlePageObject.addArticleTitleToMyList("Learning programming");
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openFolder();

        MyListsPageObject.swipeByArticleToDelete(article_title);

    }

*/
    @Test

    public void testSaveTwoArticlesToMyList() {


        SearchPageObject SearchPageObject = searchPageObjectFactory.get(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticle();
        ArticlePageObject ArticlePageObject = ArticlePageObjectFactory.get(driver);
        ArticlePageObject.waitForTitleElement();
        String article_title = ArticlePageObject.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {

            ArticlePageObject.addArticleTitleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();

        }
        ArticlePageObject.addArticleTitleToMyList("Learning programming");
        ArticlePageObject.closeArticle();

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticle();
        ArticlePageObject ArticlePageObject2 = ArticlePageObjectFactory.get(driver);
        ArticlePageObject2.waitForTitleElement();
        String article_title2 = ArticlePageObject2.getArticleTitle();

        if (Platform.getInstance().isAndroid()) {

            ArticlePageObject.addArticleTitleToMyList(name_of_folder);
        } else {
            ArticlePageObject.addArticlesToMySaved();

        }

        ArticlePageObject2.addArticleTitleToMyExistingList();
        ArticlePageObject2.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        ;
        NavigationUI.clickMyLists();
        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
        MyListsPageObject.openFolderByName("Learning programming");
        MyListsPageObject.swipeByArticleToDelete(article_title);


        NavigationUI.clickMyLists();
        String expected_article_title = "JavaScript engine";
        String actual_article_title_javascript = article_title2;
        Assert.assertEquals(actual_article_title_javascript.contains(expected_article_title), true);

    }


}
