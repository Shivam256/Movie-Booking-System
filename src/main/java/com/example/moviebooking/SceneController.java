package com.example.moviebooking;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class SceneController {
    public static void launchScene (String sceneName) throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(sceneName));
        Main.setRoot(loader.load());
        Scene scene = new Scene(Main.getRoot(),1500, 850);
        Main.getStage().setScene(scene);
        Main.getStage().show();
    }
}
