package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
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

/**
 * This is the Controller class for the main menu of the game 2048.
 *
 * <p>
 *     This class is responsible for user input and buttons handling. The game state will be updated if any buttons are
 *     pressed or clicked.
 * </p>
 * */
public class Controller {

    /** Gridpane of the mainMenu.fxml*/
    @FXML
    private GridPane girdmenu;

    /** Change to ultimate gray colour in game.*/
    @FXML
    private Button ultimateGrayButton;

    /**  Change to dewberry colour in game.*/
    @FXML
    private Button dewberryButton;

    /** Anchor Pane of the mainMenu.fxml*/
    @FXML
    private AnchorPane menuBackground;

    /** Play the game when the button is pressed. */
    @FXML
    private Button playButton;

    /** Change to Veri Pery colour*/
    @FXML
    private Button veriPeryButton;

    /** Insert username in the textfield*/
    @FXML
    private TextField username;

    /** Click to view the leaderboard of the game*/
    @FXML
    private Button leaderboardButton;

    /** The basic information of the game, including the game dimension, root, scene and colour scheme. */
    static final int WIDTH = 1000;
    static final int HEIGHT = 700;
    private Group gameRoot = new Group();
    private Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(189, 177, 92));
    private static Scanner input= new Scanner(System.in);
    private Color colorString = Color.rgb(189, 177, 92);

    public void setGameScene(Scene gameScene) {
        this.gameScene = gameScene;
    }

    public void setGameRoot(Group gameRoot) {
        this.gameRoot = gameRoot;
    }

    /** The gme is started when the play button is clicked. This function will create the 2048 game scene based on the
     * information.
     * @param event event*/

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
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, colorString);
        setGameScene(gameScene);
        primaryStage.setScene(gameScene);
        GameScene game = new GameScene();

        String name = username.getText();
        Account user = new Account();

        game.game(gameScene, gameRoot, primaryStage, endGameScene, endgameRoot,user);
        primaryStage.setTitle("2048");

        primaryStage.show();

    }

    /** The background will be changed to Ultimate Gray colour when its button is pressed.
     * @param event event*/
    @FXML
    public void ultimateGrayColour(ActionEvent event) {
        // the variable that carries the string color will be changed
        colorString = Color.rgb(147,149,151);
    }

    /** The background will be changed to Dewberry colour when its button is pressed.
     * @param event event*/
    @FXML
    public void dewberryColour(ActionEvent event) {
        colorString = Color.rgb(139,85,155);
    }

    /** The background will be changed to Veri Pery colour when its button is pressed.
     * @param event event*/
    @FXML
    public void veriPeryColour(ActionEvent event) {
        colorString = Color.rgb(102,103,171);
    }

    @FXML
    public void playerName (ActionEvent event) {

    }

    /** The leaderboard will appear in new window when its button is pressed.
     * @param event event*/
    @FXML
    public void viewLeaderboard(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/leaderboard.fxml"));
        Parent leaderBoardRoot = loader.load();
        Scene leaderboard = new Scene(leaderBoardRoot);
        Stage secondaryStage = new Stage();
        secondaryStage.setTitle("2048 Leaderboard");
        secondaryStage.setScene(leaderboard);
        secondaryStage.show();

    }

}
