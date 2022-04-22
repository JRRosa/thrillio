package com.project.thrillio.dao;

import com.project.thrillio.datastore.DataStore;
import com.project.thrillio.entities.Bookmark;

public class BookmarkDao {

    public Bookmark[][] getBookmarks(){
        return DataStore.getBookmarks();
    }
    
}
