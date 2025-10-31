package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryDashboardController {
    Stage stage = new Stage();


    @FXML
    void btnBookRegOnAction(ActionEvent event) {

    }

    @FXML
    void btnCustomerOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerRegistrationView.fxml"))));
            stage.resizableProperty();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnRentalBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnBooksOnAction(ActionEvent event) {

    }

}
