package edu.icet.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.CustomerRegistration;
import edu.icet.service.CustomerRegistrationService;
import edu.icet.service.impl.CustomerRegistrationServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class CustomerRegistrationFormController implements Initializable {
    Stage stage = new Stage();
    CustomerRegistration customerRegistration = new CustomerRegistration();
    CustomerRegistrationService customerRegistrationService = new CustomerRegistrationServiceImpl();


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
    private TableView<CustomerRegistration> customerTblView;

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
    void btnCloseOnAction(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

//        if(getRegister()){
//            try {
//                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/CustomerRegistrationAllFillPopUp.fxml"))));
//                stage.resizableProperty();
//                stage.show();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//
//        }else if(getRegister() == true){}
            customerRegistrationService.addCustomerReg(new CustomerRegistration(
                    txtNIC.getText(),
                    txtName.getText(),
                    dateChooserTxt.getValue(),
                    Integer.parseInt(txtAge.getText()),
                    Integer.parseInt(txtPhoneNumber.getText()),
                    txtEmailAddress.getText(),
                    txtHomeAddress.getText()
            ));
            viewTable();





    }
//    public boolean getRegister(){
//        customerRegistrationService.addCustomerReg(new CustomerRegistration(
//                txtNIC.getText(),
//                txtName.getText(),
//                dateChooserTxt.getValue(),
//                Integer.parseInt(txtAge.getText()),
//                Integer.parseInt(txtPhoneNumber.getText()),
//                txtEmailAddress.getText(),
//                txtHomeAddress.getText()
//        ));
//        return false;
//
//
//    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

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

        viewTable();

    }
    private void viewTable(){
        customerTblView.setItems(customerRegistrationService.allCustomerResultSet());


    }


}
