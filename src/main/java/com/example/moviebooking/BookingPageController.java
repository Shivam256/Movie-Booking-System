package com.example.moviebooking;

import com.example.moviebooking.datamodels.Show;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class BookingPageController {
    @FXML
    private VBox bookingSection;
    
    @FXML
    private Label bookingHeaderLabel;

    @FXML
    private HBox selectShowSection;

    @FXML
    private Label availableNormalSeats;

    @FXML
    private Label availablePremiumSeats;

    @FXML
    private HBox normalSeatsSection;

    @FXML
    private  HBox premiumSeatsSection;

    private int normalSeats = 0;
    private int premiusSeats = 0;

    

    public ArrayList<Show> getCurrentShows(){
        ArrayList<Show> cShows = new ArrayList<Show>();

        for(Show show:DB.getCurrentTheatre().getShows()){
            if(show.getMovie().getName().equals(DB.currentMovie.getName())){
                cShows.add(show);
            }
        }
        return cShows;
    }

    public Show getShowFromTime(String time){
        ArrayList<Show> shows = getCurrentShows();
        for(Show show:shows){
            if(show.getTime().equals(time)){
                return show;
            }
        }

        return null;
    }

    public void initialize(){
//        Label lb1 = new Label();
        bookingHeaderLabel.setText("Book tickets for " + DB.getCurrentMovie().getName() + " at " + DB.getCurrentTheatre().getName());
        bookingHeaderLabel.setTextFill(Color.WHITE);
        bookingHeaderLabel.setFont(new Font("Arial", 30));
        bookingHeaderLabel.setStyle("-fx-font-weight:700");

        ArrayList<Show> shows = getCurrentShows();

        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(shows));
        comboBox.setStyle("-fx-background-color:#212121;-fx-text-fill:white");

        selectShowSection.getChildren().add(comboBox);
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(comboBox.getValue());
                Show selectedShow = getShowFromTime(comboBox.getValue().toString());
                System.out.println(selectedShow.getId());

                availableNormalSeats.setText("Available normal seats: "+ selectedShow.getNormalSeats());
                availablePremiumSeats.setText("Available premium seats: " + selectedShow.getPremiumSeats());
            }
        });
        ArrayList<Integer> seats = new ArrayList<Integer>();
        for(int i=1;i<=10;i++){
            seats.add(i);
        }

        ComboBox comboBox1 = new ComboBox(FXCollections.observableArrayList(seats));
        normalSeatsSection.getChildren().add(comboBox1);

        ComboBox comboBox2 = new ComboBox(FXCollections.observableArrayList(seats));
        premiumSeatsSection.getChildren().add(comboBox2);



    }
}
