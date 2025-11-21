package edu.icet.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.Admin;
import edu.icet.model.Employee;
import edu.icet.service.AdminSignUpService;
import edu.icet.service.impl.AdminSignUpServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserAdminSignUp implements Initializable {

    Stage stage = new Stage();
    AdminSignUpService adminSignUpService = new AdminSignUpServiceImpl();

    @FXML
    private ComboBox<String> comboAdminRole;

    @FXML
    private JFXPasswordField txtAdminConfirmPassword;

    @FXML
    private JFXTextField txtAdminEmail;

    @FXML
    private JFXTextField txtAdminId;

    @FXML
    private JFXTextField txtAdminName;

    @FXML
    private JFXPasswordField txtAdminPassword;

    @FXML
    private Label lblErrorPassword;

    @FXML
    private Label lblAddedSuccess;


    @FXML
    void btnGoBackSignInOnAction(ActionEvent event) {
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
    void btnGoToEmployeeSignUpOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/UserSignUpEmployeeView.fxml"))));
            stage.resizableProperty();
            stage.show();
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSignUpAdminOnAction(ActionEvent event) {
        String adminPassword = txtAdminPassword.getText();
        String encryptedPassword = BCrypt.hashpw(adminPassword, BCrypt.gensalt());

        if(txtAdminId.getText().isEmpty()       || txtAdminName.getText().isEmpty() ||
                comboAdminRole.getValue() == null    || txtAdminEmail.getText().isEmpty() ||
                txtAdminPassword.getText().isEmpty() || txtAdminConfirmPassword.getText().isEmpty()) {
            lblAddedSuccess.setText("Please fill all the fields");

        }else if(!txtAdminPassword.getText().equals(txtAdminConfirmPassword.getText())) {
            lblErrorPassword.setText("Passwords do not match");

        }else {
            adminSignUpService.addAdminSignUp(new Admin(
                    //Integer.parseInt(txtEmployeeId.getText()),
                    Integer.parseInt(txtAdminId.getText()),
                    txtAdminName.getText(),
                    comboAdminRole.getValue(),
                    txtAdminEmail.getText(),
                    encryptedPassword


            ));
            lblErrorPassword.setText("Passwords Correct");
            lblAddedSuccess.setText("Added Successfully");
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboAdminRole.getItems().addAll("Admin","Manager","sss");

        int nextAdminId = adminSignUpService.getNextAdminId();
        txtAdminId.setText(String.valueOf(nextAdminId));
        txtAdminId.setEditable(false);

    }
}
