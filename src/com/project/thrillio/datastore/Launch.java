package com.project.thrillio.datastore;

import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.User;
import com.project.thrillio.manage.BookmarkManager;
import com.project.thrillio.manage.UserManager;

public class Launch {
    private static User[] users;
    private static Bookmark[][] bookmarks;

    private static void loadData() {
        System.out.println("1. Loading data ...");
        DataStore.loadData();

        users = UserManager.getInstance().getUsers();
        bookmarks = BookmarkManager.getInstance().getBookmarks();

        System.out.println("Printing data ...");
        printUserData();
        printBookmarkData();
    }

    private static void printUserData() {
        System.out.println("\n1. User data ...");
        for (User user : users) {
            System.out.println(user);
        }
    }

    private static void printBookmarkData() {
        for (Bookmark[] bookmarksList : bookmarks) {
            for (Bookmark bookmark : bookmarksList) {
                System.out.println(bookmark);
            }
        }
    }

    private static void startBookmarking() {
        System.out.println("\n2. Bookmarking ...");
        for (User user : users) {
            View.bookmark(user, bookmarks);
        }

    }

    public static void main(String[] args) {
        loadData();
        startBookmarking();
    }

}
