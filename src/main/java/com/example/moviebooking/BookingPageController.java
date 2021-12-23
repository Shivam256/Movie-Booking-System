package com.example.moviebooking;

import com.example.moviebooking.datamodels.Show;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private HBox premiumSeatsSection;

    @FXML
    private Label totalCostLabel;

    @FXML
    private ImageView moviePoster;

    private Alert alert = new Alert(Alert.AlertType.NONE);

    private int normalSeats = 0;
    private int premiusSeats = 0;
    public double totalCost = 0;
    private Show selectedShow;


    public ArrayList<Show> getCurrentShows() {
        ArrayList<Show> cShows = new ArrayList<Show>();

        for (Show show : DB.getCurrentTheatre().getShows()) {
            if (show.getMovie().getName().equals(DB.currentMovie.getName())) {
                cShows.add(show);
            }
        }
        return cShows;
    }

    public void selectNormalSeats(int normalSeats) {
        this.totalCost -= this.normalSeats * selectedShow.getNormalSeatsPrice();
        this.normalSeats = normalSeats;
        this.totalCost += normalSeats * selectedShow.getNormalSeatsPrice();
        totalCostLabel.setText("Rs. " + Double.toString(this.totalCost));
//        System.out.println(totalCost);
    }

    public void selectPremiumSeats(int premiumSeats) {
        this.totalCost -= this.premiusSeats * selectedShow.getPremiumSeatsPrice();
        this.premiusSeats = premiumSeats;
        this.totalCost += premiumSeats * selectedShow.getPremiumSeatsPrice();
        totalCostLabel.setText("Rs. " + Double.toString(this.totalCost));
//
//        System.out.println(totalCost);
    }

    public Show getShowFromTime(String time) {
        ArrayList<Show> shows = getCurrentShows();
        for (Show show : shows) {
            if (show.getTime().equals(time)) {
                return show;
            }
        }

        return null;
    }

    public void setSelectedShow(Show show) {
        this.selectedShow = show;
    }

    public void initialize() {
//        Label lb1 = new Label();
        bookingHeaderLabel.setText("Book tickets for " + DB.getCurrentMovie().getName() + " at " + DB.getCurrentTheatre().getName());
        bookingHeaderLabel.setTextFill(Color.WHITE);
        bookingHeaderLabel.setFont(new Font("Arial", 40));
        bookingHeaderLabel.setStyle("-fx-font-weight:700");

        Image img = new Image(DB.getCurrentMovie().getImageUrl());
        moviePoster.setImage(img);

        ArrayList<Show> shows = getCurrentShows();

        ComboBox comboBox = new ComboBox(FXCollections.observableArrayList(shows));
        comboBox.setStyle("-fx-background-color:#4CC9F0;-fx-text-fill:white");

        selectShowSection.getChildren().add(comboBox);
        comboBox.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(comboBox.getValue());
                Show selectedShow = getShowFromTime(comboBox.getValue().toString());
                System.out.println(selectedShow.getId());

                setSelectedShow(selectedShow);
                availableNormalSeats.setText("Available normal seats (Rs. " + selectedShow.getNormalSeatsPrice() + "): " + selectedShow.getAvailableNormalSeats() + "/" + selectedShow.getNormalSeats());
                availablePremiumSeats.setText("Available premium seats(Rs. " + selectedShow.getPremiumSeatsPrice() + "): " + selectedShow.getAvailablePremiumSeats() + "/" + selectedShow.getPremiumSeats());
            }
        });
        ArrayList<Integer> seats = new ArrayList<Integer>();
        for (int i = 0; i <= 10; i++) {
            seats.add(i);
        }

        ComboBox comboBox1 = new ComboBox(FXCollections.observableArrayList(seats));
        comboBox1.setStyle("-fx-background-color:#4CC9F0;-fx-text-fill:white");
        normalSeatsSection.getChildren().add(comboBox1);

        ComboBox comboBox2 = new ComboBox(FXCollections.observableArrayList(seats));
        comboBox2.setStyle("-fx-background-color:#4CC9F0;-fx-text-fill:white");
        premiumSeatsSection.getChildren().add(comboBox2);

        comboBox1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println(Integer.parseInt(comboBox1.getValue().toString()));
                selectNormalSeats(Integer.parseInt(comboBox1.getValue().toString()));
            }
        });

        comboBox2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                selectPremiumSeats(Integer.parseInt(comboBox2.getValue().toString()));
            }
        });


    }

    @FXML
    public void bookShow() {
        if (this.normalSeats == 0 && this.premiusSeats == 0) {
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("SELECT SEATS TO BOOK!");
            alert.show();
            return;
        }
        if (this.normalSeats > selectedShow.getAvailableNormalSeats() || this.premiusSeats > selectedShow.getAvailablePremiumSeats()) {
            System.out.println(this.normalSeats);
            System.out.println(this.premiusSeats);
            System.out.println(selectedShow.getAvailableNormalSeats());
            System.out.println(selectedShow.getAvailablePremiumSeats());
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("THE NO OF SEATS YOU CHOSE ARE NOT AVAILABLE! PLEASE CHECK THE AVAILABLE SEATS.");
            alert.show();
            return;
        }
        for (Show show : DB.getCurrentTheatre().getShows()) {
            if (show.getMovie().getName().equals(selectedShow.getMovie().getName()) && show.getTime().equals(selectedShow.getTime())) {
                show.setAvailableNormalSeats(show.getAvailableNormalSeats() - normalSeats);
                show.setAvailablePremiumSeats(show.getAvailablePremiumSeats() - premiusSeats);
                alert.setAlertType(Alert.AlertType.INFORMATION);
                alert.setHeaderText("YOUR TICKETS HAVE BEEN BOOKED!");
                alert.show();
                availableNormalSeats.setText("Available normal seats (Rs. " + selectedShow.getNormalSeatsPrice() + "): " + selectedShow.getAvailableNormalSeats() + "/" + selectedShow.getNormalSeats());
                availablePremiumSeats.setText("Available premium seats(Rs. " + selectedShow.getPremiumSeatsPrice() + "): " + selectedShow.getAvailablePremiumSeats() + "/" + selectedShow.getPremiumSeats());

                return;
            }
        }


    }
}
