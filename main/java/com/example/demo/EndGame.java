package com.example.demo;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URISyntaxException;
import java.util.Optional;

/**
 * This is the EndGame class for the 2048 game.
 *
 * <p>
 *     The Endgame class is responsible for handling the end game scene. It displays the game over scene which contains
 *     the word 'game over' and the score.
 * </p>
 */

public class EndGame {

    /** The mediaPlayer role is to play the music file. */
    public MediaPlayer mediaPlayer;

    private static EndGame singleInstance = null;
    public EndGame(){

    }
    public static EndGame getInstance(){
        if(singleInstance == null)
            singleInstance= new EndGame();
        return singleInstance;
    }

    /** This function is responsible to display the end game scene, including the game over text, score, quit button
     * and main menu button.
     * @param endGameScene end game scene
     * @param root root
     * @param primaryStage primary stage
     * @param score score*/

    public void endGameShow(Scene endGameScene, Group root, Stage primaryStage,long score) throws URISyntaxException {

        /** Display the text. */
        Text text = new Text("GAME OVER");
        text.relocate(300,150);
        text.setFont(Font.font(80));
        root.getChildren().add(text);

        /** Display the score. */
        Text scoreText = new Text("Score: "+score+"");
        scoreText.setFill(Color.BLACK);
        scoreText.relocate(410,300);
        scoreText.setFont(Font.font(60));
        root.getChildren().add(scoreText);

        /** Play the music. */
        Media media = new Media(Main.class.getResource("media/Rick Astley - Never Gonna Give You Up (Official Music Video).mp3").toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        /** Terminate the program when the quit button is pressed. */
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

        /** Return to the main menu when the main menu button is pressed.x */
        Button mainMenuButton = new Button("Main Menu");
        mainMenuButton.setPrefSize(150,30);
        mainMenuButton.setTextFill(Color.BLACK);
        root.getChildren().add(mainMenuButton);
        mainMenuButton.relocate(500,500);

        mainMenuButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mediaPlayer.stop();
                primaryStage.close();
            }
        });
    }

}
