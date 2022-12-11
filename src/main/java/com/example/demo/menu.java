package com.example.demo;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//import javafx.util.Optional;

import java.io.IOException;
import java.util.Optional;

public class menu {
    private static menu singleInstance = null;
    private menu(){

    }
    public static menu getInstance(){
        if(singleInstance == null)
            singleInstance= new menu();
        return singleInstance;
    }

    public void menuScene(Scene menuScene, Group root, Stage primaryStage,long score) throws IOException {
        Parent menuRoot = FXMLLoader.load(getClass().getResource("mainMenu.fxml"));

        Scene scene = new Scene(menuRoot);

        primaryStage.setScene(scene);

        Text text = new Text("Welcome to 2048!");
        text.relocate(250,250);
        text.setFont(Font.font(80));
        root.getChildren().add(text);


        Text scoreText = new Text(score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(250,600);
        scoreText.setFont(Font.font(80));
        root.getChildren().add(scoreText);

        Button quitButton = new Button("QUIT");
        quitButton.setPrefSize(100,30);
        quitButton.setTextFill(Color.PINK);
        root.getChildren().add(quitButton);
        quitButton.relocate(100,800);
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
                }
            }
        });



    }
}