package com.project.thrillio.entities;

public class Bookmark {
    private long id;
    private String title;
    private String profileUrl;
    
    public long getId() {
        return id;
    }
    public String getProfileUrl() {
        return profileUrl;
    }
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setId(long id) {
        this.id = id;
    }
}