package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class UserController {

    @FXML
    private ComboBox<?> comboUserRole;

    @FXML
    private JFXTextField txtUserNIC;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXTextField txtUserPassword;

    @FXML
    void btnCloseOnAction(ActionEvent event) {

    }

    @FXML
    void btnLoginUserOnAction(ActionEvent event) {

    }

}
