package com.example.demo;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.Parent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.application.Platform;

import java.io.IOException;
import java.util.Optional;

public class EndGame {
    public Popup messagePopUp = new Popup();
    public Label labelMessage = new Label("This is a popup!");

    private static EndGame singleInstance = null;
    private EndGame(){

    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score) {
        Text text = new Text("GAME OVER");
        text.relocate(300,150);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        Text scoreText = new Text("Score: "+score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(410,300);
        scoreText.setFont(Font.font(60));
        root.getChildren().add(scoreText);
        /*
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scorePopup.fxml"));
        Parent parent = null;
        try {
            parent = FXMLLoader.load(getClass().getResource("scorePopup.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        messagePopUp.getContent().add(parent);
        messagePopUp.setAutoFix(true);
        messagePopUp.setAutoHide(true);
        messagePopUp.show(primaryStage);
        */

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.BLACK);
        root.getChildren().add(quitButton);
        quitButton.relocate(300,500);
        quitButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Quit Dialog");
                alert.setHeaderText("Quit from this page");
                alert.setContentText("Are you sure?");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                    root.getChildren().clear();
                    Platform.exit();
                    System.exit(0);
                }
            }
        });

        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setPrefSize(150,30);
        mainMenuButton.setTextFill(Color.BLACK);
        root.getChildren().add(mainMenuButton);
        mainMenuButton.relocate(500,500);

        mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.close();
            }
        });
    }
}
