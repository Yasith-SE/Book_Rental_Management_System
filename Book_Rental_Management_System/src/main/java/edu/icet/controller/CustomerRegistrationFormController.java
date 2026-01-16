package edu.icet.controller;

import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.CustomerRegistration;
import edu.icet.service.CustomerRegistrationService;
import edu.icet.service.impl.CustomerRegistrationServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.ResourceBundle;


public class CustomerRegistrationFormController implements Initializable {
    Stage stage = new Stage();
    CustomerRegistration customerRegistration = new CustomerRegistration();
    CustomerRegistrationService customerRegistrationService = new CustomerRegistrationServiceImpl();

    ViewCustomerTable viewCustomerTable = new ViewCustomerTable();
    ObservableList<CustomerRegistration>customerRegistrationObservableList = FXCollections.observableArrayList();


    @FXML
    private JFXCheckBox checkIFstudent;

    @FXML
    private DatePicker dateChooserTxt;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private Label lblAge;

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
    private Label lblSelectAdultStudent;

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnRegisterOnAction(ActionEvent event) {

        String checkIfStudent = checkIFstudent.isSelected() ? "Student":"Adult";//get student or adult
        //check all fields are filled
        if(txtNIC.getText().isEmpty() || txtName.getText().isEmpty()        || dateChooserTxt.getValue() == null    ||
           txtAge.getText().isEmpty() || txtPhoneNumber.getText().isEmpty() || txtEmailAddress.getText().isEmpty()  || txtHomeAddress.getText().isEmpty()) {
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/popUpMessages/CustomerRegistrationAllFillPopUp.fxml"))));
                stage.resizableProperty();
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else if(customerRegistrationService.existByNIC(txtNIC.getText())){
                try {
                    stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/popUpMessages/CustomerIDDublicateView.fxml"))));
                    stage.resizableProperty();
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

        }else {

            customerRegistrationService.addCustomerReg(new CustomerRegistration(
                    txtNIC.getText(),
                    txtName.getText(),
                    dateChooserTxt.getValue(),
                    Integer.parseInt(txtAge.getText()),
                    txtPhoneNumber.getText(),
                    txtEmailAddress.getText(),
                    txtHomeAddress.getText(),
                    checkIfStudent
            ));



        }

    }

    @FXML
    void btnViewTableOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/ViewTable.fxml"))));
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        boolean result = customerRegistrationService.deleteCustomer(txtNIC.getText());
        if(result) {
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/popUpMessages/CustomerDeletePopup.fxml"))));
                stage.show();
                stage.resizableProperty();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/popUpMessages/NICNotFoundPopupView.fxml"))));
                stage.show();
                stage.resizableProperty();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {

        String checkStudent = checkIFstudent.isSelected()?"Student":"Adult";
        if(txtNIC.getText().isEmpty() || txtName.getText().isEmpty() || dateChooserTxt.getValue() == null ||
           txtAge.getText().isEmpty() || txtPhoneNumber.getText().isEmpty() || txtEmailAddress.getText().isEmpty() ||
        txtHomeAddress.getText().isEmpty()){
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/popUpMessages/CustomerUpdatePopup.fxml"))));
                stage.show();
                stage.resizableProperty();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }else {
            customerRegistrationService.updateCustomer(new CustomerRegistration(
                    txtNIC.getText(),
                    txtName.getText(),
                    dateChooserTxt.getValue(),
                    Integer.parseInt(txtAge.getText()),
                    txtPhoneNumber.getText(),
                    txtEmailAddress.getText(),
                    txtHomeAddress.getText(),
                    checkStudent
            ));

        }
    }

    private void setdobAge(){
        LocalDate dob = dateChooserTxt.getValue();

        if(dob != null) {
            LocalDate nowDate = LocalDate.now();
            int age = Period.between(dob, nowDate).getYears();
            txtAge.setText(String.valueOf(age));

            if (age >= 10 && age <= 25) {
                checkIFstudent.setSelected(true);
                lblSelectAdultStudent.setText(String.valueOf(age));

            }else{
                checkIFstudent.setSelected(false);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dateChooserTxt.setDayCellFactory(picker -> new DateCell(){

            @Override
            public void updateItem(LocalDate date, boolean empty){
                super.updateItem(date,empty);
                setDisable(empty || date.isAfter(LocalDate.now()));
            }
        });

        dateChooserTxt.setOnAction(event -> setdobAge());

    }


}
