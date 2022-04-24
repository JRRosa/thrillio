package com.project.thrillio.entities;

import com.project.thrillio.contants.KidFriendlyStatus;

public abstract class Bookmark {
    private long id;
    private String title;
    private String profileUrl;
    private String kidFriendStatus = KidFriendlyStatus.UNKNOWN;
    private User kidFriendlyMarkedBy;
    private User sharedBy;
    
    public long getId() {
        return id;
    }

    public User getSharedBy() {
        return sharedBy;
    }

    public void setSharedBy(User sharedBy) {
        this.sharedBy = sharedBy;
    }

    public User getKidFriendlyMarkedBy() {
        return kidFriendlyMarkedBy;
    }

    public void setKidFriendlyMarkedBy(User kidFriendlyMarkedBy) {
        this.kidFriendlyMarkedBy = kidFriendlyMarkedBy;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getKidFriendStatus() {
        return kidFriendStatus;
    }
    public void setKidFriendStatus(String kidFriendStatus) {
        this.kidFriendStatus = kidFriendStatus;
    }

    public abstract boolean isKidFriendlyEligible();
    
	@Override
	public String toString() {
		return "Bookmark [id=" + id + ", title=" + title + ", profileUrl=" + profileUrl + "]";
	}   
}