package com.project.thrillio.datastore;

import com.project.thrillio.contants.KidFriendlyStatus;
import com.project.thrillio.contants.UserType;
import com.project.thrillio.controllers.BookmarkController;
import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.User;
import com.project.thrillio.partner.Shareable;

public class View {

    public static void browse(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is browsing items ...");
        int bookmarkCount = 0;

        for (Bookmark[] bookmarksList : bookmarks) {
            for (Bookmark bookmark : bookmarksList) {
            	// Bookmarking!!
                if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT && getBookmarkDecision(bookmark)) {
                    bookmarkCount++;

                    BookmarkController.getInstance().saveUserBookmark(user, bookmark);

                    System.out.println("New Item Bookmarked -- " + bookmark);
                }

                if(UserType.EDITOR.equals(user.getUserType()) || UserType.CHIEF_EDITOR.equals(user.getUserType())) {
                    // Mark as kid-friendly
                    if (bookmark.isKidFriendlyEligible() && KidFriendlyStatus.UNKNOWN.equals(bookmark.getKidFriendStatus())) {
                        String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
                        if(!KidFriendlyStatus.UNKNOWN.equals(kidFriendlyStatus)){
                            BookmarkController.getInstance().setKidFriendStatus(user, kidFriendlyStatus, bookmark);
                        }
                    }

                    // Sharing
                    if (KidFriendlyStatus.APPROVED.equals(bookmark.getKidFriendStatus()) && bookmark instanceof Shareable) {
                    	boolean isShared = getShareDecision();
                    	if(isShared) {
                    		BookmarkController.getInstance().share(user, bookmark);
                    	}
                    }

                }
            }
        }
    }

    private static boolean getShareDecision() {
        return Math.random() < 0.5;
    }

    private static String getKidFriendlyStatusDecision(Bookmark bookmark) {
    	
    	double randomVal = Math.random();
    	
        if (randomVal < 0.4) {
            return KidFriendlyStatus.APPROVED;
        }
        
        if (randomVal >= 0.4 && randomVal < 0.8) {
            return KidFriendlyStatus.REJECTED;
        }

        return KidFriendlyStatus.UNKNOWN;
    }

    private static boolean getBookmarkDecision(Bookmark bookmark) {
        return Math.random() < 0.5;
    }

    public static void bookmark(User user, Bookmark[][] bookmarks) {
        System.out.println("\n" + user.getEmail() + " is bookmarking");
        for (int i = 0; i < DataStore.USER_BOOKMARK_LIMIT; i++){
            int typeOffset = (int) (Math.random() * DataStore.BOOKMARK_TYPES_COUNT);
            int bookmarkOffset = (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);

            Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];

            BookmarkController.getInstance().saveUserBookmark(user, bookmark);

            System.out.println(bookmark);
        }
    }
}
