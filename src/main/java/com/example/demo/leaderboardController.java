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
 *
 * </p>
 * */

public class leaderboardController implements Initializable {

    @FXML
    private TableView<Account> leaderboard;

    @FXML
    private TableColumn<Account, String> usernameColumn;

    @FXML
    private TableColumn<Account, Long> scoreColumn;

    ObservableList<Account> list = FXCollections.observableArrayList(Account.accounts);
    public leaderboardController() throws IOException {
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("hello");
        for(Account acc : Account.accounts){
            System.out.println(acc.getUserName()+"<<"+acc.getScore());
        }
        usernameColumn.setCellValueFactory(new PropertyValueFactory<Account, String>("userName"));
        scoreColumn.setCellValueFactory(new PropertyValueFactory<Account, Long>("score"));
//        usernameColumn.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUserName()));
//        scoreColumn.setCellValueFactory(cellData -> new SimpleLongProperty(cellData.getValue().getScore()).asObject());
        leaderboard.setItems(list);

    }
}
