package edu.icet.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class LoginFormController {


    @FXML
    private BorderPane borderPane;

    @FXML
    void adminButtonOnAction(ActionEvent event) {
        setContent("/view/UserAdminView.fxml");
    }

    @FXML
    void employeeButtonOnAction(ActionEvent event) {
        setContent("/view/UserEmployeeView.fxml");
    }

    private void setContent(String path) {
        try {
            borderPane.setCenter(FXMLLoader.load(getClass().getResource(path)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
