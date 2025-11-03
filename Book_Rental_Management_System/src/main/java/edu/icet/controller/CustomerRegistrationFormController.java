package edu.icet.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.CustomerRegistration;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class CustomerRegistrationFormController implements Initializable {
    Stage stage = new Stage();
    CustomerRegistration customerRegistration = new CustomerRegistration();



    @FXML
    private JFXCheckBox checkIFstudent;

    @FXML
    private DatePicker dateChooserTxt;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtEmailAddress;

    @FXML
    private JFXTextField txtHomeAddress;

    @FXML
    private JFXTextField txtNIC;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtPhoneNumber;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {


    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


}
