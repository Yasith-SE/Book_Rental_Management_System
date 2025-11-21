package edu.icet.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class BookReturnController {

    @FXML
    private DatePicker IssueDatePicker;

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private DatePicker finePerDatePicker;

    @FXML
    private DatePicker overDueDatePicker;

    @FXML
    private JFXRadioButton rdbNotReturnBook;

    @FXML
    private JFXRadioButton rdbReturnBook;

    @FXML
    private DatePicker returnDatePicker;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtBookTitle;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtRentalId;

    @FXML
    private JFXTextField txtRentalSearch;

    @FXML
    void btnCancelReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {

    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {

    }

    @FXML
    void txtRentalSearchOnAction(ActionEvent event) {

    }

}
