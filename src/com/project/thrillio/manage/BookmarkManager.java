package com.project.thrillio.manage;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.charset.MalformedInputException;

import com.project.thrillio.dao.BookmarkDao;
import com.project.thrillio.entities.Book;
import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.Movie;
import com.project.thrillio.entities.User;
import com.project.thrillio.entities.UserBookmark;
import com.project.thrillio.entities.WebLink;
import com.project.thrillio.partner.Shareable;
import com.project.thrillio.util.HttpConnect;
import com.project.thrillio.util.IOUtil;

public class BookmarkManager {
    
    private BookmarkManager(){}

    private static BookmarkManager instance = new BookmarkManager();
    private static BookmarkDao bookmarkDao = new BookmarkDao();

    public static BookmarkManager getInstance() {
        return instance;
    }

    public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast, String[] directors, String genre, double imdbRating){
        
        Movie movie = new Movie();
        
        movie.setId(id);
        movie.setTitle(title);
        movie.setProfileUrl(profileUrl);
        movie.setReleaseYear(releaseYear);
        movie.setCast(cast);
        movie.setDirectors(directors);
        movie.setGenre(genre);
        movie.setImdbRating(imdbRating);
        
        return(movie);
    }

    public Book createBook(long id, String title, int publicationYear, String publisher, String[] authors, String genre, double amazonRating){

        Book book = new Book();

        book.setId(id);
        book.setTitle(title);
        book.setPublicationYear(publicationYear);
        book.setPublisher(publisher);
        book.setAuthors(authors);
        book.setGenre(genre);
        book.setAmazonRating(amazonRating);

        return(book);

    }

    public WebLink createWebLink(long id, String title, String url, String hostl){

        WebLink webLink = new WebLink();

        webLink.setId(id);
        webLink.setTitle(title);
        webLink.setUrl(url);
        webLink.setHost(hostl);

        return(webLink);
    }
    
    public Bookmark[][] getBookmarks(){
        return bookmarkDao.getBookmarks();
    }

    public void saveUserBookmark(User user, Bookmark bookmark) {
        UserBookmark userBookmark = new UserBookmark();
        userBookmark.setUser(user);
        userBookmark.setBookmark(bookmark);

        bookmarkDao.saveUserBookmark(userBookmark);
        
        if (bookmark instanceof WebLink) {
			try {
				String url = ((WebLink) bookmark).getUrl();
				if (!url.endsWith(".pdf")) {
					String webpage = HttpConnect.download(url);
					if (webpage != null) {
						IOUtil.write(webpage, bookmark.getId());
					}
				}
			} catch (MalformedURLException e) {
				// TODO: handle exception
				e.printStackTrace();
			} catch (URISyntaxException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
        

    }

    public void setKidFriendStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
        bookmark.setKidFriendStatus(kidFriendlyStatus);
        bookmark.setKidFriendlyMarkedBy(user);
        System.out.println("Kid-friendly status: " + kidFriendlyStatus + ", Marked by: " + user.getEmail() + ", " + bookmark);
    }

    public void share(User user, Bookmark bookmark) {
        bookmark.setSharedBy(user);
        String itemData = null;
        
        System.out.println("Data to be shared: ");
        if (bookmark instanceof Book) {
        	itemData = ((Book) bookmark).getItemData();
        } else if(bookmark instanceof WebLink) {
        	itemData = ((WebLink) bookmark).getItemData();
        }
        System.out.println(itemData);
    }

}
