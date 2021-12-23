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

        Movie m1 = new Movie("Pushpa: The Rise - Part 01", "https://pbs.twimg.com/media/EVDTqTPU4AA_NaT.jpg", "Action/Thriler", "Based on the smuggling of red sander trees in Seshachalam forest, Andhra Pradesh, Pushpa tells the story of a lorry driver who is part of the illegal business.", 84.0, "2h 59m","Telugu, Malayalam, Tamil, Kannada, Hindi");

        Movie m2 = new Movie("Spider-Man: No Way Home","https://terrigen-cdn-dev.marvel.com/content/prod/1x/snh_online_6072x9000_posed_01.jpg","Action/Adventure/SciFi","For the first time in the cinematic history of Spider-Man, our friendly neighborhood hero is unmasked and no longer able to separate his normal life from the high-stakes of being a Super Hero.",93.0,"2h 28m","English, Hindi, Telugu, Kannada, Tamil");

        Movie m3 = new Movie("The Matrix Resurrections","https://i2.wp.com/bloody-disgusting.com/wp-content/uploads/2021/11/matrix-resurrections-poster.png?ssl=1","Action/Adventure/SciFi","From visionary filmmaker Lana Wachowski comes \"The Matrix Resurrections,\" the long-awaited fourth film in the groundbreaking franchise that redefined a genre. The new film reunites original stars Keanu Reeves and Carrie-Anne Moss in the iconic roles they made famous, Neo and Trinity.",66.2,"2h 28m","English, Hindi, Tamil, Telgu");

        Movie m4 = new Movie("83","https://m.media-amazon.com/images/M/MV5BNTMyZTYyODYtMjUwNS00NmU1LWEzY2MtNjgxMjc3MjFiNWE0XkEyXkFqcGdeQXVyNjY1MTg4Mzc@._V1_.jpg","Drama/Sports","1983 Cricket World Cup taught India to win. 14 men fought against all odds. This is their Story!",90.2,"2h 43m","Hindi, Malayalam, Kannada, Telgu, Tamil");


        Theatre th1 = new Theatre("INOX Kalyan","2nd Floor, Metro Junction Mall, Netivali Village, Kalyan Shilphata Road, Kalyan, Maharashtra 421306, India","https://lh5.googleusercontent.com/p/AF1QipOgaEjM7PR0ItGtQZ3M8y3u8qC1feOCb57hU02E=w1080-k-no",8.5);
        th1.addFacility("F&B");
        th1.addFacility("MTicket");
        th1.addFacility("Gaming Zone");
        th1.addFacility("Parking Facility");

        th1.addMovie(m1);
        th1.addMovie(m2);
        th1.addMovie(m4);

        Theatre th2 = new Theatre("SM5 Multiplex","Sarvoday Mall, Opposite Phool Market, Kalyan (W), Kalyan, Maharashtra 421301, India","https://lh5.googleusercontent.com/p/AF1QipOWMsX-2eXNGaPhYtVTfY2QpOPBMF2hvS7ErFTC=w1080-k-no",6.2);
        th2.addFacility("F&B");
        th2.addFacility("MTicket");
        th2.addFacility("Parking Facility");
        th2.addFacility("Food Court");

        th2.addMovie(m1);
        th2.addMovie(m2);
        th2.addMovie(m3);


        Theatre th3 = new Theatre("PVR: Lodha Xperia, Palava","3rd Floor, Xperia Mall, Kalyan-Shilphata Road, Opposit Lodha World School, Dombivali (E), Mumbai, Maharashtra 421204, India","https://lh3.googleusercontent.com/proxy/-G6rJvhDNEfL_3nTEXybg08uvRK6DdH8l8Nk2bW4808_qWTHx4naNYDbmJ8yG93LIC-ekrAt7RL-30pYUdLq1yz6UK6Cz-1Rjs_yT7MDyn8vbDdMesdFKpYbFgM",9.2);
        th3.addFacility("Ticket Cancellation");
        th3.addFacility("F&B");
        th3.addFacility("MTicket");
        th3.addFacility("Wheel Chair Facility");

        th3.addMovie(m1);
        th3.addMovie(m2);
        th3.addMovie(m3);
        th3.addMovie(m4);

        m1.addTheatre(th1);
        m1.addTheatre(th2);
        m1.addTheatre(th3);

        m2.addTheatre(th1);
        m2.addTheatre(th2);
        m2.addTheatre(th3);

        m3.addTheatre(th2);
        m3.addTheatre(th3);

        m4.addTheatre(th1);
        m4.addTheatre(th3);

        //m1 shows

        Show m1th1a = new Show(m1,th1,"9:00 AM",50,150,20,200,"sh1");
        Show m1th1b = new Show(m1,th1,"12:00 PM",50,150,20,200,"sh1");
        Show m1th1c = new Show(m1,th1,"6:00 PM",50,150,20,200,"sh1");

        Show m1th2a = new Show(m1,th2,"9:00 AM",50,150,20,200,"sh1");
        Show m1th2b = new Show(m1,th2,"12:00 PM",50,150,20,200,"sh1");
        Show m1th2c = new Show(m1,th2,"6:00 PM",50,150,20,200,"sh1");

        Show m1th3a = new Show(m1,th3,"9:00 AM",50,150,20,200,"sh1");
        Show m1th3b = new Show(m1,th3,"12:00 PM",50,150,20,200,"sh1");
        Show m1th3c = new Show(m1,th3,"6:00 PM",50,150,20,200,"sh1");

        //m2 shows

        Show m2th1a = new Show(m2,th1,"9:00 AM",50,150,20,200,"sh1");
        Show m2th1b = new Show(m2,th1,"12:00 PM",50,150,20,200,"sh1");
        Show m2th1c = new Show(m2,th1,"6:00 PM",50,150,20,200,"sh1");

        Show m2th2a = new Show(m2,th2,"9:00 AM",50,150,20,200,"sh1");
        Show m2th2b = new Show(m2,th2,"12:00 PM",50,150,20,200,"sh1");
        Show m2th2c = new Show(m2,th2,"6:00 PM",50,150,20,200,"sh1");

        Show m2th3a = new Show(m2,th3,"9:00 AM",50,150,20,200,"sh1");
        Show m2th3b = new Show(m2,th3,"12:00 PM",50,150,20,200,"sh1");
        Show m2th3c = new Show(m2,th3,"6:00 PM",50,150,20,200,"sh1");


        //m3 shows
        Show m3th2a = new Show(m3,th2,"9:00 AM",50,150,20,200,"sh1");
        Show m3th2b = new Show(m3,th2,"12:00 PM",50,150,20,200,"sh1");
        Show m3th2c = new Show(m3,th2,"6:00 PM",50,150,20,200,"sh1");

        Show m3th3a = new Show(m3,th3,"9:00 AM",50,150,20,200,"sh1");
        Show m3th3b = new Show(m3,th3,"12:00 PM",50,150,20,200,"sh1");
        Show m3th3c = new Show(m3,th3,"6:00 PM",50,150,20,200,"sh1");


        //m4 shows
        Show m4th1a = new Show(m4,th1,"9:00 AM",50,150,20,200,"sh1");
        Show m4th1b = new Show(m4,th1,"12:00 PM",50,150,20,200,"sh1");
        Show m4th1c = new Show(m4,th1,"6:00 PM",50,150,20,200,"sh1");

        Show m4th3a = new Show(m4,th3,"9:00 AM",50,150,20,200,"sh1");
        Show m4th3b = new Show(m4,th3,"12:00 PM",50,150,20,200,"sh1");
        Show m4th3c = new Show(m4,th3,"6:00 PM",50,150,20,200,"sh1");

        th1.addShow(m1th1a);
        th1.addShow(m1th1b);
        th1.addShow(m1th1c);
        th1.addShow(m2th1a);
        th1.addShow(m2th1b);
        th1.addShow(m2th1c);
        th1.addShow(m4th1a);
        th1.addShow(m4th1b);
        th1.addShow(m4th1c);

        th2.addShow(m1th2a);
        th2.addShow(m1th2b);
        th2.addShow(m1th2c);
        th2.addShow(m2th2a);
        th2.addShow(m2th2b);
        th2.addShow(m2th2c);
        th2.addShow(m3th2a);
        th2.addShow(m3th2b);
        th2.addShow(m3th2c);

        th3.addShow(m1th3a);
        th3.addShow(m1th3b);
        th3.addShow(m1th3c);
        th3.addShow(m2th3a);
        th3.addShow(m2th3b);
        th3.addShow(m2th3c);
        th3.addShow(m3th3a);
        th3.addShow(m3th3b);
        th3.addShow(m3th3c);
        th3.addShow(m4th3a);
        th3.addShow(m4th3b);
        th3.addShow(m4th3c);


        DB.addMovie(m1);
        DB.addMovie(m2);
        DB.addMovie(m3);
        DB.addMovie(m4);

        DB.addTheatre(th1);
        DB.addTheatre(th2);
        DB.addTheatre(th3);

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
            primaryStage.setTitle("BookMyMovie");
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