package com.project.thrillio.datastore;

import com.project.thrillio.contants.Gender;
import com.project.thrillio.entities.Bookmark;
import com.project.thrillio.entities.User;
import com.project.thrillio.entities.UserBookmark;
import com.project.thrillio.manage.BookmarkManager;
import com.project.thrillio.manage.UserManager;
import com.project.thrillio.util.IOUtil;

public class DataStore {
    
    public static final int USER_BOOKMARK_LIMIT = 5;
    public static final int BOOKMARK_COUNT_PER_TYPE = 5;
    public static final int BOOKMARK_TYPES_COUNT = 3;
    public static final int TOTAL_USER_COUNT = 5;

    private static User[] users = new User[TOTAL_USER_COUNT];
    private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
    private static UserBookmark[] userBookmarks = new UserBookmark[TOTAL_USER_COUNT * USER_BOOKMARK_LIMIT];
    private static int bookmarkIndex; 

    public static User[] getUsers(){
        return users;
    }

    public static Bookmark[][] getBookmarks(){
        return bookmarks;
    }

    public static void loadData(){
        loadUsers();
        loadWebLinks();
        loadMovies();
        loadBooks();
        
    }

    private static void loadUsers() {
        /*
        users[0] = UserManager.getInstance().createUser(1000, "user0@project.com", "test", "John", "J", Gender.MALE, UserType.USER);
        users[1] = UserManager.getInstance().createUser(1001, "user1@project.com", "test", "Pedro", "P", Gender.MALE, UserType.EDITOR);
        users[2] = UserManager.getInstance().createUser(1002, "user2@project.com", "test", "Maria", "M", Gender.FEMALE, UserType.CHIEF_EDITOR);
        users[3] = UserManager.getInstance().createUser(1003, "user3@project.com", "test", "Tifany", "T", Gender.FEMALE, UserType.USER);
        users[4] = UserManager.getInstance().createUser(1004, "user4@project.com", "test", "Frank", "F", Gender.MALE, UserType.EDITOR);
        */
    	
        String[] data = new String[TOTAL_USER_COUNT];
        IOUtil.read(data, "User");
        int rowNum = 0;
        for(String row : data) {
        	String[] values = row.split("\t");
        	
        	int gender = Gender.MALE;
        	if ("f".equals(values[5])) {
        		gender = Gender.FEMALE;
			}
        	
        	users[rowNum++] = UserManager.getInstance().createUser(Long.parseLong(values[0]), values[1], values[2], values[3], values[4], gender, values[6]);
        }
    }

    private static void loadWebLinks() {
    	/*
        bookmarks[0][0] = BookmarkManager.getInstance().createWebLink(2000, "Udemy - Java", "https://www.udemy.com/curso/java", "https://www.udemy.com/");
        bookmarks[0][1] = BookmarkManager.getInstance().createWebLink(2001, "Udemy - CShard", "https://www.udemy.com/curso/cshard", "https://www.udemy.com/");
        bookmarks[0][2] = BookmarkManager.getInstance().createWebLink(2002, "Udemy - VBNet", "https://www.udemy.com/curso/vbnet", "https://www.udemy.com/");
        bookmarks[0][3] = BookmarkManager.getInstance().createWebLink(2003, "Udemy - JavaScript", "https://www.udemy.com/curso/javascript", "https://www.udemy.com/");
        bookmarks[0][4] = BookmarkManager.getInstance().createWebLink(2004, "Udemy - React", "https://www.udemy.com/curso/react", "https://www.udemy.com/");
        */
    	
    	String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "WebLink");
    	int colNum = 0;
    	for (String row : data) {
			String[] values = row.split("\t");
			bookmarks[0][colNum++] = BookmarkManager.getInstance().createWebLink(Long.parseLong(values[0]), values[1], values[2], values[3]);
		}
    	
    }

    private static void loadMovies() {
    	/*
        bookmarks[1][0] = BookmarkManager.getInstance().createMovie(3000, "John Wick","https://www.imdb.com/title/tt2911666/", 2014, new String[]{"Keanu Reeves"}, new String[]{"Chad Stahelski", "David Leitch"}, MovieGenre.CLASSICS, 7.4);
        bookmarks[1][1] = BookmarkManager.getInstance().createMovie(3001, "The Rock","https://www.imdb.com/title/tt2911667/", 2015, new String[]{"The Rock"}, new String[]{"David Leitch"}, MovieGenre.DOCUMENTARIES, 8.1);
        bookmarks[1][2] = BookmarkManager.getInstance().createMovie(3002, "Potter","https://www.imdb.com/title/tt2911668/", 2016, new String[]{"Potter"}, new String[]{"Leitch"}, MovieGenre.ACTION_AND_AVENTURE, 9.3);
        bookmarks[1][3] = BookmarkManager.getInstance().createMovie(3003, "Dell","https://www.imdb.com/title/tt2911669/", 2017, new String[]{"Dell", "Potter"}, new String[]{"Stahelski"}, MovieGenre.DRAMAS, 6.6);
        bookmarks[1][4] = BookmarkManager.getInstance().createMovie(3004, "Cisco","https://www.imdb.com/title/tt2911670/", 2018, new String[]{"Cisco", "Reeves"}, new String[]{"Stahelski", "Leitch"}, MovieGenre.FOREIGN_THRILLERS, 5.8);
    	*/
    	
    	String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Movie");
    	int colNum = 0;
    	for (String row : data) {
			String[] values = row.split("/t");
			String[] cast = values[3].split(",");
			String[] directors = values[4].split(",");
			bookmarks[1][colNum++] = BookmarkManager.getInstance().createMovie(Long.parseLong(values[0]), values[1], "", Integer.parseInt(values[2]), cast, directors, values[5], Double.parseDouble(values[6])/*, values[7]*/);
		}
    }

    private static void loadBooks() {
    	/*
        bookmarks[2][0] = BookmarkManager.getInstance().createBook(4000, "Munchkin vol. 1", 2016, "Keanu", new String[]{"Potter"}, BookGenre.ART, 9.8);
        bookmarks[2][1] = BookmarkManager.getInstance().createBook(4001, "React", 2017, "Reeves", new String[]{"Potter"}, BookGenre.ART, 4.7);
        bookmarks[2][2] = BookmarkManager.getInstance().createBook(4002, "JavaScript", 2018, "Potter", new String[]{"Potter"}, BookGenre.ART, 2.5);
        bookmarks[2][3] = BookmarkManager.getInstance().createBook(4003, "Java", 2019, "React", new String[]{"Potter"}, BookGenre.ART, 3.4);
        bookmarks[2][4] = BookmarkManager.getInstance().createBook(4004, "Project", 2020, "Udemy", new String[]{"Potter"}, BookGenre.ART, 8.1);
        */
    	
    	String[] data = new String[BOOKMARK_COUNT_PER_TYPE];
    	IOUtil.read(data, "Book");
    	int colNum = 0;
    	for (String row : data) {
			String[] values = row.split("\t");
			String[] authors = values[4].split(",");
			bookmarks[2][colNum++] = BookmarkManager.getInstance().createBook(Long.parseLong(values[0]), values[1], Integer.parseInt(values[2]), values[3], authors, values[5], Double.parseDouble(values[6]));
		}
    	
    }

    public static void add(UserBookmark userBookmark) {
        userBookmarks[bookmarkIndex] = userBookmark;
        bookmarkIndex++;
    }

}
