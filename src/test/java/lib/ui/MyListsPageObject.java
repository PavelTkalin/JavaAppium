package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;

abstract public class MyListsPageObject extends MainPageObject {

   protected static String

            FOLDER_BY_NAME_TPL,
            ARTICLE_BY_TITLE,
    LIST_OF_ARTICLES;

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);

    }

    public static String getSavedArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE.replace("{FOLDERNAME}", article_title);

    }


    public static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BY_NAME_TPL.replace("{FOLDERNAME}", name_of_folder);

    }

    public void openFolderByName(String name_of_folder) {

        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(FOLDER_BY_NAME_TPL, "cannot find folder by name" + name_of_folder, 5);

    }


    public void openFolder() {


        this.waitForElementAndClick(LIST_OF_ARTICLES, "cannot click the list of articles", 15);

    }


    public void waitForArticleTitleToAppearByTitle(String article_title) {

        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(article_xpath, "Cannot find saved article" + article_title, 15);

    }

    public void waitForArticleTitleToDissappearByTitle(String article_title) {

        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title" + article_title, 15);

    }


    public void waitForArticleTitleToDissappear() {


        this.waitForElementAndClick(ARTICLE_BY_TITLE, "Saved article still present with title", 15);

    }


    public void swipeByArticleToDelete(String article_title) {

        this.waitForArticleTitleToAppearByTitle(article_title);

        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(article_xpath, "Cannot swipe");

        if(Platform.getInstance().isiOS()) {

this.clickElementToTheRightUpCorner(article_xpath, "Cannot find saved article");
        }

        this.waitForArticleTitleToDissappearByTitle(article_title);

    }


    public void swipeByArticleToDeleteWithoutTitle(String article_title) {

        this.waitForArticleTitleToAppearByTitle(article_title);

        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(article_xpath, "Cannot swipe");
        this.waitForArticleTitleToDissappear();

    }


}
