package com.example.moviebooking;

import com.example.moviebooking.datamodels.Movie;
import com.example.moviebooking.datamodels.Show;
import com.example.moviebooking.datamodels.Theatre;
import com.example.moviebooking.datamodels.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    static Parent root;
    static Stage primaryStage;
    static Main m = null;

    static Main getMainApplication() {
        return m;
    }

    static Parent getRoot() {

        return root;
    }

    static void setRoot(Parent root) {

        Main.root = root;
    }

    static Stage getStage() {

        return primaryStage;
    }

    static void setStage(Stage stage) {

        Main.primaryStage = stage;
    }

    static void seedDB(){
        DB.addUser(new User("shivam256","hello123","shivamgavandi256@gmail.com"));

        Movie m1 = new Movie("Pushpa", "https://pbs.twimg.com/media/EVDTqTPU4AA_NaT.jpg", "Action/Thriler", "Based on the smuggling of red sander trees in Seshachalam forest, Andhra Pradesh, Pushpa tells the story of a lorry driver who is part of the illegal business.", 84.0, "2h 59m","Telugu, Malayalam, Tamil, Kannada, Hindi");
        Theatre th1 = new Theatre("INOX Kalyan","2nd Floor, Metro Junction Mall, Netivali Village, Kalyan Shilphata Road, Kalyan, Maharashtra 421306, India","https://lh5.googleusercontent.com/p/AF1QipOgaEjM7PR0ItGtQZ3M8y3u8qC1feOCb57hU02E=w1080-k-no",8.5);
        th1.addFacility("F&B");
        th1.addFacility("MTicket");
        th1.addFacility("Gaming Zone");
        th1.addFacility("Parking Facility");
        th1.addMovie(m1);
        th1.addMovie(m1);

        m1.addTheatre(th1);
        m1.addTheatre(th1);

        Show m1th1 = new Show(m1,th1,"9:00 AM",50,150,20,200,"sh1");

        th1.addShow(m1th1);
        th1.addShow(m1th1);


        DB.addMovie(m1);
        DB.addMovie(m1);
        DB.addMovie(m1);

        DB.addTheatre(th1);
        DB.addTheatre(th1);
        DB.addTheatre(th1);

//        DB.setCurrentMovie(m1);
//        DB.setCurrentTheatre(th1);
    }


    //    @Override
//    public void start(Stage stage) throws IOException {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("userLogin.fxml"));
//        Scene scene = new Scene(fxmlLoader.load(), 1500, 800);
//        stage.setTitle("Book My Movie");
//
//        stage.setScene(scene);
//        stage.show();
//    }
    @Override
    public void start(Stage primaryStage) {
        try {
            // setting up the login scene
            seedDB();
//            DB.setCurrentMovie(new Movie("Pushpa", "https://pbs.twimg.com/media/EVDTqTPU4AA_NaT.jpg", "Action/Thriler", "Based on the smuggling of red sander trees in Seshachalam forest, Andhra Pradesh, Pushpa tells the story of a lorry driver who is part of the illegal business.", 84.0, "2h 59m","Telugu, Malayalam, Tamil, Kannada, Hindi"));
            root = FXMLLoader.load(getClass().getResource("homepage.fxml"));
            Main.primaryStage = primaryStage;
            primaryStage.setTitle("Cinema Booking Management System");
//            primaryStage.initStyle(StageStyle.UNDECORATED);
            Scene scene = new Scene(root, 1500, 850);
//            scene.getStylesheets().add(getClass().getResource("/scenes/application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}