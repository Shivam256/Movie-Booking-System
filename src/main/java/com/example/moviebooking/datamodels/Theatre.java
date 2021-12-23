package com.example.moviebooking.datamodels;

import java.util.ArrayList;

public class Theatre {
    private String name;
    private String location;
    private String imageUrl;
    private double ratings;
    private ArrayList<String> facilities = new ArrayList<String>();
    private ArrayList<Movie> movies = new ArrayList<Movie>();
    private ArrayList<Show> shows = new ArrayList<Show>();
//    private ArrayList<Show> shows;

    public Theatre(String name, String location, String imageUrl,double ratings) {
        this.name = name;
        this.location = location;
        this.imageUrl = imageUrl;
        this.ratings = ratings;
//        this.shows = shows;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getRatings() {
        return ratings;
    }

    public void setRatings(double ratings) {
        this.ratings = ratings;
    }

    public void addFacility(String facility){
        facilities.add(facility);
    }

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    public void addShow(Show show){
        shows.add(show);
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public ArrayList<String> getFacilities() {
        return facilities;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }
}
