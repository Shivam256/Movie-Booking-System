package com.example.moviebooking.datamodels;

import com.example.moviebooking.Main;

public class Booking {
    private User user;
    private Show show;
    private String bookingId;

    public Booking(User user, Show show) {
        this.user = user;
        this.show = show;
        bookingId = "kth" + Double.toString(Math.random()*100)+"mov";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
