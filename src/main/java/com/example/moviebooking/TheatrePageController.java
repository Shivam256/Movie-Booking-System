package com.example.moviebooking;

import com.example.moviebooking.datamodels.Movie;
import com.example.moviebooking.datamodels.Theatre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.io.IOException;

public class TheatrePageController {
    @FXML
    private HBox theatreInfo;

    @FXML
    private HBox availableMovies;

    public void initialize(){
        Theatre theatre = DB.getCurrentTheatre();

        Image img = new Image(theatre.getImageUrl());
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(320);
        imgView.setFitWidth(250);
        imgView.setStyle("-fx-border-radius:10px");

        VBox vb = new VBox();
        vb.setSpacing(20);

        Label lb1 = new Label(theatre.getName());
        lb1.setTextFill(Color.WHITE);
        lb1.setFont(new Font("Arial", 45));
        lb1.setStyle("-fx-font-weight:800");

        Label lb2 = new Label(theatre.getLocation());
        lb2.setTextFill(Color.WHITE);
        lb2.setFont(new Font("Arial", 25));
        lb2.setStyle("-fx-fontWeight:600");
        lb2.setWrapText(true);

        Label lb3 = new Label( Double.toString(theatre.getRatings()));
        lb3.setTextFill(Color.rgb(255,215,0));
        lb3.setFont(new Font("Arial", 50));
        lb3.setStyle("-fx-fontWeight:600");

        StringBuilder fac = new StringBuilder("Facilities: \n");

        for(String facility: theatre.getFacilities()){
            fac.append(facility);
            fac.append(", ");
        }

        Label lb4 = new Label(fac.toString());
        lb4.setTextFill(Color.GRAY);
        lb4.setFont(new Font("Arial", 25));
        lb4.setStyle("-fx-fontWeight:600");
        lb4.setWrapText(true);

        vb.getChildren().add(lb1);
        vb.getChildren().add(lb2);
        vb.getChildren().add(lb3);
        vb.getChildren().add(lb4);
        theatreInfo.getChildren().add(imgView);
        theatreInfo.getChildren().add(vb);

        for (Movie movie : theatre.getMovies()) {
            VBox vb2 = new VBox();
            Image img2 = new Image(movie.getImageUrl());
            ImageView imgView2 = new ImageView(img2);
            imgView2.setFitHeight(300);
            imgView2.setFitWidth(250);
            imgView2.setStyle("-fx-border-radius:10px");

            Label lb12 = new Label(movie.getName());
            lb12.setTextFill(Color.WHITE);
            lb12.setFont(new Font("Arial", 20));
            lb12.setStyle("-fx-font-weight:800");

            Button btn = new Button();
            btn.setText("BOOK");
            btn.setPrefWidth(220);
            btn.setPrefHeight(30);
            btn.setStyle("-fx-background-color:#F72585;-fx-font-weight:800;-fx-text-fill:white");

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    DB.setCurrentMovie(movie);
                    try {
                        SceneController.launchScene("bookingPage.fxml");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            });

            vb2.setPrefHeight(480);
            vb2.setPrefWidth(250);
            vb2.getChildren().add(imgView2);
            vb2.getChildren().add(lb12);
            vb2.getChildren().add(btn);
            vb2.setStyle("fx-overflow:hidden;-fx-background-color:#212121");
            vb2.setAlignment(Pos.TOP_CENTER);
            vb2.setSpacing(5);
            availableMovies.getChildren().add(vb2);
        }

    }

    @FXML
    public void goBack() throws IOException {
        DB.setCurrentTheatre(null);
        SceneController.launchScene("mainScreen.fxml");
    }
}
