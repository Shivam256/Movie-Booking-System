package com.example.moviebooking.datamodels;

public class Show {
    private String id;
    private Movie movie;
    private Theatre theatre;
    private String time;
    private int normalSeats;
    private double normalSeatsPrice;
    private int premiumSeats;
    private double premiumSeatsPrice;
    private int availableNormalSeats;
    private int availablePremiumSeats;

    public Show(Movie movie, Theatre theatre, String time, int normalSeats, double normalSeatsPrice, int premiumSeats, double premiumSeatsPrice, String id) {
        this.movie = movie;
        this.theatre = theatre;
        this.time = time;
        this.normalSeats = normalSeats;
        this.normalSeatsPrice = normalSeatsPrice;
        this.premiumSeats = premiumSeats;
        this.premiumSeatsPrice = premiumSeatsPrice;
        this.availableNormalSeats = 0;
        this.availablePremiumSeats = 0;
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getNormalSeats() {
        return normalSeats;
    }

    public void setNormalSeats(int normalSeats) {
        this.normalSeats = normalSeats;
    }

    public double getNormalSeatsPrice() {
        return normalSeatsPrice;
    }

    public void setNormalSeatsPrice(double normalSeatsPrice) {
        this.normalSeatsPrice = normalSeatsPrice;
    }

    public int getPremiumSeats() {
        return premiumSeats;
    }

    public void setPremiumSeats(int premiumSeats) {
        this.premiumSeats = premiumSeats;
    }

    public double getPremiumSeatsPrice() {
        return premiumSeatsPrice;
    }

    public void setPremiumSeatsPrice(double premiumSeatsPrice) {
        this.premiumSeatsPrice = premiumSeatsPrice;
    }

    public int getAvailableNormalSeats() {
        return availableNormalSeats;
    }

    public void setAvailableNormalSeats(int availableNormalSeats) {
        this.availableNormalSeats = availableNormalSeats;
    }

    public int getAvailablePremiumSeats() {
        return availablePremiumSeats;
    }

    public void setAvailablePremiumSeats(int availablePremiumSeats) {
        this.availablePremiumSeats = availablePremiumSeats;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.time;
    }
}

