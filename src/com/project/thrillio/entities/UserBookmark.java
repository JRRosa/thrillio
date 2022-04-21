package com.project.thrillio.entities;

public class UserBookmark {
    
    private User user;
    private Bookmark bookmark;
    
    public User getUser() {
        return user;
    }
    public Bookmark getBookmark() {
        return bookmark;
    }
    public void setBookmark(Bookmark bookmark) {
        this.bookmark = bookmark;
    }
    public void setUser(User user) {
        this.user = user;
    }
    
}
