package com.example.demo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * This is the leaderboard class for the game 2048.
 *
 * <p>
 *     This class is responsible for displaying the leaderboard of the game. The leaderboard is created using JavaFX
 *     TableView.
 * </p>
 * */

/** The leaderboardController class allows initialization when the leaderboard function is called. */
public class leaderboardController implements Initializable {

    /** Leaderboard has three variables which are leaderboard, usernameColumn and scoreColumn. */
    @FXML
    private TableView<Account> leaderboard;

    @FXML
    private TableColumn<Account, String> usernameColumn;

    @FXML
    private TableColumn<Account, Long> scoreColumn;

    /** This ObservableList contains the list of account in the static Account class. */
    ObservableList<Account> list = FXCollections.observableArrayList(Account.accounts);

    public leaderboardController() throws IOException {
    }

    /** This method is called when the leaderboard is loaded. */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("userName"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<Account, Long>("score"));
        leaderboard.setItems(list);

    }
}
