package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {

    @FXML
    private Button blueButton;

    @FXML
    private Button greenButton;

    @FXML
    private AnchorPane menuBackground;

    @FXML
    private Button playButton;

    @FXML
    private TextField playerNameBox;

    @FXML
    private Button redButton;

    Stage stage;
    Scene scene;
    Parent root;

    public void switchToGame (ActionEvent event) {
        stage = (Stage) menuBackground.getScene().getWindow();
        stage.setScene(scene);
        stage.close();
    }

    /*

    @FXML
    public void switchToGame (ActionEvent event) throws IOException {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //playButton.setOnAction(e -> stage.setScene(scene));

        stage = (Stage) menuBackground.getScene().getWindow();
        System.out.println("You successfully joined!");
        stage.close();
    }
    */
    /*

    private boolean defaultMenu = true;

    public void changeBackgroundColour(ActionEvent event) {
        if (defaultMenu) {
            defaultColour();
        } else {
            redColour();
        }
    }

    public void redColour() {
        menuBackground.setStyle("-fx-background-color: #FF0000");
    }

    public void blueColour() {
        menuBackground.setBackground(Background.fill(Color.BLUE));
    }

    public void greenColour() {
        menuBackground.setBackground(Background.fill(Color.GREEN));
    }

    public void defaultColour() {
        menuBackground.setStyle("-fx-background-color: #FFFFFF");
    }
    */
}
