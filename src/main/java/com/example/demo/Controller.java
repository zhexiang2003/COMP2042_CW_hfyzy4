package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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

}
