package com.project.thrillio.controllers;

import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.User;
import com.project.thrillio.manage.BookmarkManager;

public class BookmarkController {
    
    private BookmarkController() {}

    private static BookmarkController instance = new BookmarkController();

    public static BookmarkController getInstance() {
        return instance;
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
    }

    


}
