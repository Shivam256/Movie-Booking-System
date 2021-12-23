package com.example.moviebooking;

import com.example.moviebooking.datamodels.Movie;
import com.example.moviebooking.datamodels.Theatre;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
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

public class MoviePageController {
    @FXML
    private HBox movieInfo;

    @FXML
    private VBox theatresSection;

    public void initialize(){
        Movie movie = DB.getCurrentMovie();

        Image img = new Image(movie.getImageUrl());
        ImageView imgView = new ImageView(img);
        imgView.setFitHeight(400);
        imgView.setFitWidth(300);
        imgView.setStyle("-fx-border-radius:10px");

        VBox vb = new VBox();
        vb.setSpacing(20);

        Label lb1 = new Label(movie.getName());
        lb1.setTextFill(Color.WHITE);
        lb1.setFont(new Font("Arial", 45));
        lb1.setStyle("-fx-font-weight:800");

        Label lb2 = new Label(movie.getPlot());
        lb2.setTextFill(Color.WHITE);
        lb2.setFont(new Font("Arial", 25));
        lb2.setStyle("-fx-fontWeight:600");

        Label lb3 = new Label(movie.getDuration());
        lb3.setTextFill(Color.GRAY);
        lb3.setFont(new Font("Arial", 20));
        lb3.setStyle("-fx-fontWeight:600");

        Label lb4 = new Label(movie.getDescription());
        lb4.setTextFill(Color.WHITE);
        lb4.setFont(new Font("Arial", 25));
        lb4.setStyle("-fx-fontWeight:600");
        lb4.setWrapText(true);

        Label lb6 = new Label(movie.getLanguages());
        lb6.setTextFill(Color.GRAY);
        lb6.setFont(new Font("Arial", 20));
        lb6.setStyle("-fx-fontWeight:600");

        Label lb5 = new Label( Double.toString(movie.getRatingsCount()) + "%");
        lb5.setTextFill(Color.rgb(255,215,0));
        lb5.setFont(new Font("Arial", 50));
        lb5.setStyle("-fx-fontWeight:600");


        vb.getChildren().add(lb1);
        vb.getChildren().add(lb2);
        vb.getChildren().add(lb3);
        vb.getChildren().add(lb4);
        vb.getChildren().add(lb6);
        vb.getChildren().add(lb5);

        movieInfo.getChildren().add(imgView);
        movieInfo.getChildren().add(vb);

        for(Theatre theatre:movie.getTheatres()){
            HBox theatreOverview = new HBox();

            theatreOverview.setPrefHeight(43);
//            theatreOverview.setPrefWidth(750);
            theatreOverview.setSpacing(50);
            theatreOverview.setPadding(new Insets(5,10,5,10));
            theatreOverview.setStyle("-fx-background-color:#212121");
            Label lb7 = new Label(theatre.getName());
            lb7.setTextFill(Color.WHITE);
            lb7.setFont(new Font("Arial", 25));
            lb7.setStyle("-fx-font-weight:600");

            Button btn = new Button();
            btn.setText("VIEW");
            btn.setPrefWidth(180);
            btn.setPrefHeight(30);
            btn.setStyle("-fx-background-color:#F72585;-fx-font-weight:800;-fx-text-fill:white");

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



            theatreOverview.getChildren().add(lb7);
            theatreOverview.getChildren().add(btn);
            theatresSection.getChildren().add(theatreOverview);
        }
    }

    public void goBack() throws IOException {
        DB.setCurrentMovie(null);
        SceneController.launchScene("mainScreen.fxml");
    }
}
