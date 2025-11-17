package edu.icet.controller.popUpMessages;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.stage.Stage;

public class CustomerUpdateAllPopupController {
    Stage stage = new Stage();

    @FXML
    void btnCloseOnAction(ActionEvent event) {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }

}
