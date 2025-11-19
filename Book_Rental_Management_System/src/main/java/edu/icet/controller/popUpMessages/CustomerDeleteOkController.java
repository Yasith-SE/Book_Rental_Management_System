package edu.icet.controller.popUpMessages;

import edu.icet.controller.CustomerRegistrationFormController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CustomerDeleteOkController {

    Stage stage = new Stage();

    @FXML
    void closeBtnOnAction(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }



}
