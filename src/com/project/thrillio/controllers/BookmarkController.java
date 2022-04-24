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

    public void setKidFriendStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        BookmarkManager.getInstance().setKidFriendStatus(user, kidFriendlyStatus, bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        BookmarkManager.getInstance().share(user, bookmark);
    }

    


}
