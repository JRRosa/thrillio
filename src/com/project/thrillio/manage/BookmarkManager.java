package com.project.thrillio.manage;

import com.project.thrillio.dao.BookmarkDao;
import com.project.thrillio.entities.Book;
import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.Movie;
import com.project.thrillio.entities.User;
import com.project.thrillio.entities.UserBookmark;
import com.project.thrillio.entities.WebLink;

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
        webLink.setHostl(hostl);

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

    }

}
