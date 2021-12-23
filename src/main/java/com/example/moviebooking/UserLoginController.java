package com.example.moviebooking;

import com.example.moviebooking.datamodels.User;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class UserLoginController {
    @FXML
    private TextField loginUsername;

    @FXML
    private PasswordField loginPassword;
    @FXML

    private TextField registerUsername;
    @FXML
    private TextField registerEmail;
    @FXML
    private PasswordField registerPassword;
    @FXML
    private PasswordField registerConfirm;

    private Alert alert = new Alert(Alert.AlertType.NONE);

    @FXML
    public void register() throws IOException {

        if(registerUsername.getText().trim().isEmpty() || registerEmail.getText().trim().isEmpty() || registerPassword.getText().trim().isEmpty() || registerConfirm.getText().trim().isEmpty()){
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setHeaderText("INCOMPLETE CREDENTIALS");
            alert.show();
            return;
        }

        if(registerPassword.getText().equals(registerConfirm.getText())){
            User user = new User(registerUsername.getText(),registerPassword.getText(),registerEmail.getText());
            DB.addUser(user);
            DB.setCurrentUser(user);
            SceneController.launchScene("mainScreen.fxml");
        }else{
            alert.setAlertType(Alert.AlertType.ERROR);
            alert.setHeaderText("PASSWORDS DIDN'T MATCH!");
            alert.show();
        }


    }


    @FXML
    public void login() throws IOException {
        if(loginUsername.getText().trim().isEmpty() || loginPassword.getText().trim().isEmpty()){
            System.out.println("empty credentials");
//            Alert alert =  new Alert(Alert.AlertType.NONE);
            alert.setAlertType(Alert.AlertType.WARNING);
            alert.setHeaderText("EMPTY CREDENTIALS!");
            alert.show();
            return;
        }
        for(User user:DB.getUsers()){
           if(user.getUsername().equals(loginUsername.getText()) && user.getPassword().equals(loginPassword.getText())){
               DB.setCurrentUser(user);
               SceneController.launchScene("mainScreen.fxml");
               return;
           }
        }

        alert.setAlertType(Alert.AlertType.ERROR);
        alert.setHeaderText("INCORRECT CREDENTIALS");
        alert.show();

    }
}
