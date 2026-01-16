package edu.icet.controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.Admin;
import edu.icet.model.Users;
import edu.icet.service.UserLoginService;
import edu.icet.service.impl.UserLoginServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSignInController implements Initializable {
    Stage stage = new Stage();
    UserLoginService userLoginService = new UserLoginServiceImpl();


    @FXML
    private ComboBox<String> comboRole;

    @FXML
    private Label lblRoleName;
    @FXML
    private Label lblAddedSuccess;

    @FXML
    private JFXPasswordField txtLoginPassword;

    @FXML
    private JFXTextField txtLoginUsername;

    @FXML
    void btnDashboardOnAction(ActionEvent event) {
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardView.fxml"))));
            stage.resizableProperty();
            stage.show();

            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnSignInOnAction(ActionEvent event) {

        // 1. Get Data (Trim the username!)
        String username = txtLoginUsername.getText().trim();
        String password = txtLoginPassword.getText();
        String role = comboRole.getValue();

        // 2. Check for empty fields
        if (username.isEmpty() || password.isEmpty() || role == null) {
            lblAddedSuccess.setText("Please fill all fields");
            return;
        }

        // 3. Call the Service ONCE
        boolean isLoginSuccess = userLoginService.loginUser(username, password, role);

        if (isLoginSuccess) {
            lblAddedSuccess.setText("Login Successful");
            try {
                stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/DashboardView.fxml"))));
                stage.show();

                // Close Login Window
                Stage currentStage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
                currentStage.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            lblAddedSuccess.setText("Invalid Username or Password");
        }
    }

    @FXML
    void btnSignUpOnAction(ActionEvent event) {
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        boolean b = comboRole.getItems().addAll("Librarian", "Assistant Librarian", "Clerk","Admin","Manager");
       

    }
}
