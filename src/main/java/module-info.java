module com.example.moviebooking {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.moviebooking to javafx.fxml;
    exports com.example.moviebooking;
}