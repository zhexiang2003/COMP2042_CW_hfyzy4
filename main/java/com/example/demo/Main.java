package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * This is the main class for the game 2048.
 *
 * <p>This class extends the Application class and this is the main entry for the game. The game needed to be started
 * through this main class.
 * </p>
 *
 * @author Yap Zhe Xiang
 */

public class Main extends Application {
    static final int WIDTH = 1000;
    static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);

    /**
     * Start the game
     * @param primaryStage Starts the primary stage. */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Account.readFile();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("fxml/mainMenu.fxml"));
        Parent root = loader.load();
        Scene startUpScene = new Scene(root);
        primaryStage.setTitle("2048");
        primaryStage.setScene(startUpScene);

        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);

    }
}
