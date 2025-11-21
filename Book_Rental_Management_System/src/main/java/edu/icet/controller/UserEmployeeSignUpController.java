package edu.icet.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.Employee;
import edu.icet.service.EmployeeSignUpSerivice;
import edu.icet.service.impl.EmployeeSignUpServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.net.URL;
import java.sql.JDBCType;
import java.util.ResourceBundle;

public class UserEmployeeSignUpController implements Initializable {

    Stage stage = new Stage();
    EmployeeSignUpSerivice employeeSignUpSerivice = new EmployeeSignUpServiceImpl();

    @FXML
    private ComboBox<String> comboEmployeeRole;
    @FXML
    private JFXTextField txtEmployeEmail;
    @FXML
    private JFXPasswordField txtEmployeeConfirmPassword;
    @FXML
    private JFXTextField txtEmployeeId;
    @FXML
    private JFXTextField txtEmployeeName;
    @FXML
    private JFXPasswordField txtEmployeePassword;
    @FXML
    private Label lblErrorPasswordConfirm;
    @FXML
    private Label lblAddedSuccess;



    @FXML
    void btnGoBackSignOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UserLogIn.fxml"))));
            stage.resizableProperty();
            stage.show();

            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnGoToAdminSignUpOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UserSignUpAdmin.fxml"))));
            stage.resizableProperty();
            stage.show();

            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSignUpEmployeeOnAction(ActionEvent event) {
        String employeePassword = txtEmployeePassword.getText();
        String encryptedPassword = BCrypt.hashpw(employeePassword, BCrypt.gensalt());

        if(txtEmployeeId.getText().isEmpty()       || txtEmployeeName.getText().isEmpty() ||
           comboEmployeeRole.getValue() == null    || txtEmployeEmail.getText().isEmpty() ||
           txtEmployeePassword.getText().isEmpty() || txtEmployeeConfirmPassword.getText().isEmpty()) {
            lblAddedSuccess.setText("Please fill all the fields");

        }else if(!txtEmployeePassword.getText().equals(txtEmployeeConfirmPassword.getText())) {
            lblErrorPasswordConfirm.setText("Passwords do not match");

        }else {
            employeeSignUpSerivice.addEmployeeSignUp(new Employee(
                    Integer.parseInt(txtEmployeeId.getText()),
                    txtEmployeeName.getText(),
                    comboEmployeeRole.getValue(),
                    txtEmployeEmail.getText(),
                    encryptedPassword


            ));
            lblErrorPasswordConfirm.setText("Passwords Correct");
            lblAddedSuccess.setText("Added Successfully");
        }


    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboEmployeeRole.getItems().addAll("Librarian","Assistant Librarian","Clerk");

        int nextId = employeeSignUpSerivice.getNextEmployeeId();
        txtEmployeeId.setText(String.valueOf(nextId));
        txtEmployeeId.setEditable(false);

    }


}
