package edu.icet.controller;

import edu.icet.model.CustomerRegistration;
import edu.icet.service.CustomerRegistrationService;
import edu.icet.service.impl.CustomerRegistrationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewCustomerTable implements Initializable {

    CustomerRegistrationService customerRegistrationService = new CustomerRegistrationServiceImpl();

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colDOB;

    @FXML
    private TableColumn<?, ?> colEmail;

    @FXML
    private TableColumn<?, ?> colHomeAdress;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colNic;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colSelectAdultOrStudent;

    @FXML
    private TableView<CustomerRegistration> customerTblView;

    @FXML
    void closeBtnOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colNic.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colName.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        colDOB.setCellValueFactory(new PropertyValueFactory<>("Dob"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNo"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("emailAddress"));
        colHomeAdress.setCellValueFactory(new PropertyValueFactory<>("homeAddress"));
        colSelectAdultOrStudent.setCellValueFactory(new PropertyValueFactory<>("adultStudent"));

        viewTable();
    }

   private void viewTable(){
        customerTblView.setItems(customerRegistrationService.allCustomerResultSet());

    }


}
