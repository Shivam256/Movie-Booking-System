package com.example.moviebooking;

import com.example.moviebooking.datamodels.User;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.io.IOException;

public class HelloController {


    @FXML
    public void userLoginClicked() throws IOException {
        SceneController.launchScene("userLogin.fxml");
    }

}