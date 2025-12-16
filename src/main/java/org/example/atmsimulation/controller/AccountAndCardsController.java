package org.example.atmsimulation.controller;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import org.example.atmsimulation.Launcher;
import org.example.atmsimulation.model.Account;
import org.example.atmsimulation.model.Card;
import org.example.atmsimulation.utilities.FXMLUtil;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class AccountAndCardsController implements Initializable {
    @FXML
    private TableView<Account> tableAccount;
    @FXML
    private TableColumn<Account, String> columnAccountId;
    @FXML
    private TableColumn<Account, String> columnName;
    @FXML
    private TableColumn<Account, String> columnSurname;
    @FXML
    private TableColumn<Account, Double> columnBalance;
    @FXML
    private FlowPane paneCards;
    @FXML
    private Button btnBack;
    FXMLUtil fxmlUtil = new FXMLUtil();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        columnAccountId.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getAccountId()));
        columnName.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getName()));
        columnSurname.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getSurname()));
        columnBalance.setCellValueFactory(cellData ->
                new SimpleDoubleProperty(cellData.getValue().getBalance()).asObject());
        List<Account> filtered = Launcher.accounts.stream()
                .filter(acc -> acc.getName().equals(LoginController.tempAcc.getName()) && acc.getSurname().equals(LoginController.tempAcc.getSurname()))
                .collect(Collectors.toList());
        tableAccount.setItems(FXCollections.observableArrayList(filtered));


        tableAccount.setOnMouseClicked(event -> {
            Account selectedAcc = tableAccount.getSelectionModel().getSelectedItem();
            if (selectedAcc != null) {
                showCards(selectedAcc);
            }
        });
    }

    private void showCards(Account acc) {
        paneCards.getChildren().clear();

        for (Card card : acc.getCard()) {
            Label bankName = new Label("ÖRNEK BANK");
            bankName.setFont(Font.font("Segoe UI", FontWeight.BOLD, 41));
            bankName.setTextFill(Color.WHITE);


            String lastFour = LoginController.cardId.substring(card.getCardId().length() - 4);
            Label cardNo = new Label("**** **** **** " + lastFour);
            cardNo.setFont(Font.font("Segoe UI", FontWeight.BOLD, 31));
            cardNo.setTextFill(Color.WHITE);

            Label owner = new Label(LoginController.tempAcc.getName() + " " + LoginController.tempAcc.getSurname());
            owner.setFont(Font.font("Segoe UI", 14));
            owner.setTextFill(Color.WHITE);
            String mounth = card.getExpiryDate().toString().substring(card.getExpiryDate().toString().length() - 2);
            String year = card.getExpiryDate().toString().substring(2, 4);
            Label expiry = new Label(mounth + "-" + year);
            expiry.setFont(Font.font("Segoe UI", 12));
            expiry.setTextFill(Color.WHITE);

            HBox bottomRow = new HBox(owner, new Region(), expiry);
            HBox.setHgrow(bottomRow.getChildren().get(1), Priority.ALWAYS); // boşluk doldurur
            bottomRow.setAlignment(Pos.BOTTOM_CENTER);
            Region spacer = new Region();
            VBox vbox = new VBox(bankName, spacer, cardNo, bottomRow);
            VBox.setVgrow(spacer, Priority.ALWAYS); // ortadaki Region boşluğu doldurur
            vbox.setPadding(new Insets(15));
            vbox.setPrefSize(317, 200);
            Button cardButton = new Button();
            cardButton.setPrefSize(317, 200);
            cardButton.setStyle("-fx-background-color: #d02929;\n" +
                    "    -fx-border-color: rgba(255,255,255,0.8);\n" +
                    "    -fx-text-fill: rgba(255,255,255,0.8);\n" +
                    "    -fx-border-radius: 20;\n" +
                    "    -fx-background-radius: 20;");
            cardButton.setGraphic(vbox);
            paneCards.getChildren().add(cardButton);
        }
    }

    @FXML
    private void handleBack() {
        fxmlUtil.loadScreen(btnBack, "MainScreen");
    }
}
