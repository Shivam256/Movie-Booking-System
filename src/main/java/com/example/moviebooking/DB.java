package com.example.moviebooking;

import com.example.moviebooking.datamodels.Movie;
import com.example.moviebooking.datamodels.Theatre;
import com.example.moviebooking.datamodels.User;

import java.util.ArrayList;

public class DB {
    static ArrayList<User> users = new ArrayList<User>();
    static User currentUser;
    static Movie currentMovie;
    static Theatre currentTheatre;
    static ArrayList<Movie> movies = new ArrayList<Movie>();
    static ArrayList<Theatre> theatres = new ArrayList<Theatre>();


    public static Movie getCurrentMovie() {
        return currentMovie;
    }

    public static void setCurrentMovie(Movie currentMovie) {
        DB.currentMovie = currentMovie;
    }

    public static Theatre getCurrentTheatre() {
        return currentTheatre;
    }

    public static void setCurrentTheatre(Theatre currentTheatre) {
        DB.currentTheatre = currentTheatre;
    }

    static void addUser(User user) {
        users.add(user);
    }

    public static ArrayList<User> getUsers() {
        return users;
    }


    public static User getCurrentUser() {
        return currentUser;
    }

    static void setCurrentUser(User user) {
        currentUser = user;
    }

    static void addMovie(Movie movie){
        movies.add(movie);
    }

    static void addTheatre(Theatre theatre){
        theatres.add(theatre);
    }

    public static ArrayList<Movie> getMovies() {
        return movies;
    }

    public static ArrayList<Theatre> getTheatres() {
        return theatres;
    }
}
