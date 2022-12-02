package tests;

import lib.CoreTestCase;
import lib.Platform;
import lib.ui.*;
import lib.ui.factories.ArticlePageObjectFactory;
import lib.ui.factories.MyListsPageObjectFactory;
import lib.ui.factories.NavigationUIFactory;
import lib.ui.factories.SearchPageObjectFactory;
import org.junit.Assert;
import org.junit.Test;

public class MyListsTests extends CoreTestCase {

    private static final String name_of_folder = "Learning programming";
    private static final String
            login = "",
            password = "";

    /*
        @Test

        public void testSaveFirstArticleToMyList() {


            SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

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

            if (Platform.getInstance().isMw()) {

                AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
                Auth.clickAuthButton();
                Auth.enterLoginData(login, password);
                Auth.submitForm();

                ArticlePageObject.waitForTitleElement();
                assertEquals("we are not on the same page after login",
                        article_title, ArticlePageObject.getArticleTitle());

                ArticlePageObject.addArticlesToMySaved();
            }


            ArticlePageObject.closeArticle();

            NavigationUI NavigationUI = NavigationUIFactory.get(driver);
            NavigationUI.clickMyLists();

            MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);
            if (Platform.getInstance().isAndroid()) {
                MyListsPageObject.openFolderByName(name_of_folder);

            }

            MyListsPageObject.swipeByArticleToDelete(article_title);

        }

    */
    @Test

    public void testSaveTwoArticlesToMyList() {


        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);

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

        if (Platform.getInstance().isMw()) {

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            assertEquals("we are not on the same page after login",
                    article_title, ArticlePageObject.getArticleTitle());

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

        if (Platform.getInstance().isMw()) {

            AuthorizationPageObject Auth = new AuthorizationPageObject(driver);
            Auth.clickAuthButton();
            Auth.enterLoginData(login, password);
            Auth.submitForm();

            ArticlePageObject.waitForTitleElement();
            assertEquals("we are not on the same page after login",
                    article_title, ArticlePageObject.getArticleTitle());

            ArticlePageObject.addArticlesToMySaved();
        }

        ArticlePageObject2.addArticleTitleToMyExistingList();
        ArticlePageObject2.closeArticle();

        NavigationUI NavigationUI = NavigationUIFactory.get(driver);
        NavigationUI.openNavigation();
        NavigationUI.clickMyLists();


        MyListsPageObject MyListsPageObject = MyListsPageObjectFactory.get(driver);


        if (Platform.getInstance().isAndroid()) {
            MyListsPageObject.openFolderByName(name_of_folder);

        }

        MyListsPageObject.swipeByArticleToDelete(article_title);


        NavigationUI.clickMyLists();


        String expected_article_title = "JavaScript engine";
        String actual_article_title_javascript = article_title2;
        Assert.assertEquals(actual_article_title_javascript.contains(expected_article_title), true);

    }


}
