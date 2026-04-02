package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LibraryDashboardController {
    Stage stage = new Stage();


    @FXML
    void btnBookRegOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/BookStore.fxml"))));
            stage.resizableProperty();
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    void btnLoginButtonOnAction(ActionEvent event) {
        try {

            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UserLogin.fxml"))));
            stage.resizableProperty();
            stage.close();
            stage.show();

            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnRentalBooksOnAction(ActionEvent event) {
        try {
            stage.setScene((new Scene(FXMLLoader.load(getClass().getResource("/view/BookRentalView.fxml")))));
            stage.resizableProperty();
            stage.close();
            stage.show();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnReturnBooksOnAction(ActionEvent event) {
        try {
            stage.setScene((new Scene(FXMLLoader.load(getClass().getResource("/view/BookReturnView.fxml")))));
            stage.resizableProperty();
            stage.close();
            stage.show();



        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();

    }

}
