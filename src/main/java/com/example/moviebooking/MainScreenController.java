package com.example.moviebooking;

import com.example.moviebooking.datamodels.Booking;
import com.example.moviebooking.datamodels.Movie;
import com.example.moviebooking.datamodels.Theatre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainScreenController {
    private List<Movie> movies;
    private List<Theatre> theatres;

    @FXML
    private HBox itemsContainer;

    @FXML
    private Label bookingInfoLabel;


    public void setMoviesInScreen() {
        itemsContainer.getChildren().clear();
//        Movie m1 = new Movie("Pushpa", "https://pbs.twimg.com/media/EVDTqTPU4AA_NaT.jpg", "Action/Thriler", "Based on the smuggling of red sander trees in Seshachalam forest, Andhra Pradesh, Pushpa tells the story of a lorry driver who is part of the illegal business.", 84.0, "2h 59m","Telugu, Malayalam, Tamil, Kannada, Hindi");
        movies = new ArrayList<Movie>();
//        movies.add(m1);
//        movies.add(m1);
//        movies.add(m1);
//        movies.add(m1);
        movies = DB.getMovies();

        for (Movie movie : movies) {
            VBox vb = new VBox();
            Image img = new Image(movie.getImageUrl());
            ImageView imgView = new ImageView(img);
            imgView.setFitHeight(400);
            imgView.setFitWidth(300);
            imgView.setStyle("-fx-border-radius:10px");

            Label lb1 = new Label(movie.getName());
            lb1.setTextFill(Color.WHITE);
            lb1.setFont(new Font("Arial", 20));
            lb1.setStyle("-fx-font-weight:800");

            Label lb2 = new Label(movie.getPlot());
            lb2.setTextFill(Color.WHITE);
            lb2.setFont(new Font("Arial", 15));
            lb2.setStyle("-fx-fontWeight:600");

            Button btn = new Button();
            btn.setText("VIEW");
            btn.setPrefWidth(270);
            btn.setPrefHeight(40);
            btn.setStyle("-fx-background-color:#F72585;-fx-font-weight:800;-fx-text-fill:white");

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    DB.setCurrentMovie(movie);
                    try {
                        SceneController.launchScene("moviePage.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            vb.setPrefHeight(535);
            vb.setPrefWidth(300);
            vb.getChildren().add(imgView);
            vb.getChildren().add(lb1);
            vb.getChildren().add(lb2);
            vb.getChildren().add(btn);
            vb.setStyle("fx-overflow:hidden;-fx-background-color:#212121");
            vb.setAlignment(Pos.TOP_CENTER);
            vb.setSpacing(10);
            itemsContainer.getChildren().add(vb);
        }
    }

    public void setTheatresInScreen(){
        itemsContainer.getChildren().clear();
//        Theatre th1 = new Theatre("INOX Kalyan","2nd Floor, Metro Junction Mall, Netivali Village, Kalyan Shilphata Road, Kalyan, Maharashtra 421306, India","https://lh5.googleusercontent.com/p/AF1QipOgaEjM7PR0ItGtQZ3M8y3u8qC1feOCb57hU02E=w1080-k-no",8.5);
        theatres = new ArrayList<Theatre>();
//        theatres.add(th1);
//        theatres.add(th1);

        theatres = DB.getTheatres();

        for(Theatre theatre:theatres){
            VBox vb = new VBox();
            Image img = new Image(theatre.getImageUrl());
            ImageView imgView = new ImageView(img);
            imgView.setFitHeight(400);
            imgView.setFitWidth(300);
            imgView.setStyle("-fx-border-radius:10px");

            Label lb1 = new Label(theatre.getName());
            lb1.setTextFill(Color.WHITE);
            lb1.setFont(new Font("Arial", 20));
            lb1.setStyle("-fx-font-weight:800");

            Label lb2 = new Label(theatre.getLocation());
            lb2.setTextFill(Color.WHITE);
            lb2.setFont(new Font("Arial", 15));
            lb2.setStyle("-fx-fontWeight:600");
            lb2.maxWidth(250);
            lb2.prefWidth(270);

            Button btn = new Button();
            btn.setText("VIEW");
            btn.setPrefWidth(270);
            btn.setPrefHeight(40);
            btn.setStyle("-fx-background-color:#4CC9F0;-fx-font-weight:800;-fx-text-fill:white");

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    DB.setCurrentTheatre(theatre);
                    try {
                        SceneController.launchScene("theatrePage.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            vb.setPrefHeight(535);
            vb.setPrefWidth(300);
            vb.getChildren().add(imgView);
            vb.getChildren().add(lb1);
            vb.getChildren().add(lb2);
            vb.getChildren().add(btn);
            vb.setStyle("fx-overflow:hidden;-fx-background-color:#212121");
            vb.setAlignment(Pos.TOP_CENTER);
            vb.setSpacing(10);
            itemsContainer.getChildren().add(vb);
        }
    }

    public void initialize() {
        setMoviesInScreen();
        if(DB.getCurrentUser().getBookings().size() >0){
            Booking bk = DB.getCurrentUser().getBookings().get(0);
            bookingInfoLabel.setText("Booking Id: " + bk.getBookingId() + "  Venue: " + bk.getShow().getTheatre().getName() + "  Movie: " + bk.getShow().getMovie().getName());
        }
    }

    public void handleMoviesClick() {
        setMoviesInScreen();
    }

    public void handleTheatresClick() {
        setTheatresInScreen();
    }
}
