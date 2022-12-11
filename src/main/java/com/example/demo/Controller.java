package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;


public class Controller {

    @FXML
    private GridPane girdmenu;

    @FXML
    private Button blueButton;

    @FXML
    private Button dewberryButton;

    @FXML
    private AnchorPane menuBackground;

    @FXML
    private Button playButton;

    @FXML
    private TextField playerNameBox;

    @FXML
    private Button redButton;

    static final int WIDTH = 1000;
    static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);
    private Color colorString;

    //Stage primaryStage;
    Parent root;

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    @FXML
    void switchToGame(ActionEvent event) {
        Group menuRoot = new Group();
        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
        Group accountRoot = new Group();
        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
        Group getAccountRoot = new Group();
        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
        Group endgameRoot = new Group();
        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));

        Group rankRoot = new Group();
        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);

        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
        backgroundOfMenu.setX(WIDTH / 2 - 120);
        backgroundOfMenu.setY(180);
        menuRoot.getChildren().add(backgroundOfMenu);

        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
        backgroundOfMenuForPlay.setY(180);
        accountRoot.getChildren().add(backgroundOfMenuForPlay);

        Stage primaryStage = new Stage();
        Group gameRoot = new Group();
        setGameRoot(gameRoot);

        if (playButton.isPressed()) {
            colorString = Color.rgb(0,0,0);
        }

        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, colorString);
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);
        GameScene game = new GameScene();
        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
        primaryStage.setTitle("2048");

        primaryStage.show();

    }

    @FXML
    public void blueColour(ActionEvent event) {
        // the variable that carries the string color will be changed
        colorString = Color.rgb(0,0,255);
    }

    @FXML
    public void dewberryColour(ActionEvent event) {
        colorString = Color.rgb(139,85,155);
    }

    @FXML
    public void redColour(ActionEvent event) {
        colorString = Color.rgb(255,0,0);
    }

//    public void switchToGame (Stage primaryStage) throws IOException {
//
//        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//        Stage stage = (Stage) playButton.getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//
//
////        Group menuRoot = new Group();
////        Scene menuScene = new Scene(menuRoot, WIDTH, HEIGHT);
////        Group accountRoot = new Group();
////        Scene accountScene = new Scene(accountRoot, WIDTH, HEIGHT, Color.rgb(150, 20, 100, 0.2));
////        Group getAccountRoot = new Group();
////        Scene getAccountScene = new Scene(getAccountRoot, WIDTH, HEIGHT, Color.rgb(200, 20, 100, 0.2));
////        Group endgameRoot = new Group();
////        Scene endGameScene = new Scene(endgameRoot, WIDTH, HEIGHT, Color.rgb(250, 20, 100, 0.2));
////
////        Group rankRoot = new Group();
////        Scene rankScene = new Scene(rankRoot, WIDTH, HEIGHT, Color.rgb(250, 50, 120, 0.3));
////        BackgroundFill background_fill = new BackgroundFill(Color.rgb(120, 100, 100), CornerRadii.EMPTY, Insets.EMPTY);
////        Background background = new Background(background_fill);
////
////        Rectangle backgroundOfMenu = new Rectangle(240, 120, Color.rgb(120, 120, 120, 0.2));
////        backgroundOfMenu.setX(WIDTH / 2 - 120);
////        backgroundOfMenu.setY(180);
////        menuRoot.getChildren().add(backgroundOfMenu);
////
////        Rectangle backgroundOfMenuForPlay = new Rectangle(240, 140, Color.rgb(120, 20, 100, 0.2));
////        backgroundOfMenuForPlay.setX(WIDTH / 2 - 120);
////        backgroundOfMenuForPlay.setY(180);
////        accountRoot.getChildren().add(backgroundOfMenuForPlay);
////
////        Stage primarystage = new Stage();
////        Group gameRoot = new Group();
////        setGameRoot(gameRoot);
////        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
////        setGameScene(gameScene);
////        primaryStage.setScene(gameScene);
////        GameScene game = new GameScene();
////        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot);
////
//////        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
//////        Scene startUpScene = new Scene(root);
//////        primaryStage.setTitle("2048");
//////        primaryStage.setScene(startUpScene);
//////
////        primaryStage.show();
//////
//////        primaryStage = (Stage) playButton.getScene().getWindow();
//////        Scene scene = new Scene(root);
//////        primaryStage.setScene(gameScene);
//  }


    /*
    @FXML
    public void switchToGame (Stage primaryStage) throws IOException {
        primaryStage = (Stage) menuBackground.getScene().getWindow();
        System.out.println("You successfully joined!");
        primaryStage.setScene(gameScene);
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
