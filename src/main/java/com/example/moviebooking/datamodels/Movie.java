package com.example.moviebooking.datamodels;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String imageUrl;
    private String plot;
    private String description;
    private double ratingsCount;
    private String duration;
    private String languages;
    private ArrayList<Theatre> theatres = new ArrayList<Theatre>();

    public Movie(String name, String imageUrl, String plot, String description, double ratingsCount, String duration,String languages) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.plot = plot;
        this.description = description;
        this.ratingsCount = ratingsCount;
        this.duration = duration;
        this.languages = languages;
//        this.theatres = theatres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPlot() {
        return plot;
    }

    public void setPlot(String plot) {
        this.plot = plot;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRatingsCount() {
        return ratingsCount;
    }

    public void setRatingsCount(double ratingsCount) {
        this.ratingsCount = ratingsCount;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public ArrayList<Theatre> getTheatres() {
        return theatres;
    }

    public void setTheatres(ArrayList<Theatre> theatres) {
        this.theatres = theatres;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public void addTheatre(Theatre theatre){
        theatres.add(theatre);
    }




}
