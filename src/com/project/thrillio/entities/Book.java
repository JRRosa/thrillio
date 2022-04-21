package com.project.thrillio.entities;

public class Book extends Bookmark {

    private int publicationYear;
    private String publisher;
    private String[] authors;
    private String genre;
    private double amazonRating;
    
    public int getPublicationYear() {
        return publicationYear;
    }
    public double getAmazonRating() {
        return amazonRating;
    }
    public void setAmazonRating(double amazonRating) {
        this.amazonRating = amazonRating;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public String[] getAuthors() {
        return authors;
    }
    public void setAuthors(String[] authors) {
        this.authors = authors;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }


}
