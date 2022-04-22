package com.project.thrillio.dao;

import com.project.thrillio.datastore.DataStore;
import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.UserBookmark;

public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }

    public void saveUserBookmark(UserBookmark userBookmark) {
        DataStore.add(userBookmark);
    }
    
}
