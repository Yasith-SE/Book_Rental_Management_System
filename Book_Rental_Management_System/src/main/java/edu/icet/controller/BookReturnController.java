package edu.icet.controller;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.BookReturn;
import edu.icet.service.BookReturnService;
import edu.icet.service.impl.BookReturnServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BookReturnController {

    Stage stage = new Stage();


    private final BookReturnService bookReturnService = new BookReturnServiceImpl();

    @FXML private DatePicker IssueDatePicker;

    @FXML private DatePicker dueDatePicker;

    @FXML private DatePicker returnDatePicker;

    @FXML private JFXTextField txtBookId;

    @FXML private JFXTextField txtBookTitle;

    @FXML private JFXTextField txtCustomerName;

    @FXML private JFXTextField txtFinePerDay;

    @FXML private JFXTextField txtNIC;

    @FXML private JFXTextField txtRentalId;

    @FXML private JFXTextField txtRentalSearch;

    @FXML private JFXTextField txtTotalFine;

    @FXML
    void txtRentalSearchOnAction(ActionEvent event) {
        String searchId = txtRentalSearch.getText();
        if (searchId.isEmpty()) {
            showAlert(Alert.AlertType.WARNING, "Input Error", "Please enter a Rental ID.");
            return;
        }

        BookReturn rentalData = bookReturnService.getRentalDetails(searchId);

        if (rentalData != null) {

            txtRentalId.setText(rentalData.getRentalId());
            txtBookId.setText(rentalData.getBookId());
            txtBookTitle.setText(rentalData.getBookTitle());
            txtNIC.setText(rentalData.getCustomerId());
            txtCustomerName.setText(rentalData.getCustomerName());

            IssueDatePicker.setValue(rentalData.getIssueDate());
            dueDatePicker.setValue(rentalData.getDueDate());

            returnDatePicker.setValue(LocalDate.now());

            calculateFineProcess(null);

        } else {
            showAlert(Alert.AlertType.ERROR, "Not Found", "Rental ID not found or invalid.");
        }
    }

    @FXML
    void calculateFineProcess(ActionEvent event) {
        if (dueDatePicker.getValue() == null || returnDatePicker.getValue() == null) {
            return;
        }

        LocalDate dueDate = dueDatePicker.getValue();
        LocalDate returnDate = returnDatePicker.getValue();

        long overdueDays = 0;

        if (returnDate.isAfter(dueDate)) {
            overdueDays = ChronoUnit.DAYS.between(dueDate, returnDate);
        }

        double fineRate = 50.0;
        try {
            if (!txtFinePerDay.getText().isEmpty()) {
                fineRate = Double.parseDouble(txtFinePerDay.getText());
            } else {
                txtFinePerDay.setText(String.valueOf(fineRate));
            }
        } catch (NumberFormatException e) {
            txtFinePerDay.setText("50.0");
        }

        double totalFine = overdueDays * fineRate;
        txtTotalFine.setText(String.valueOf(totalFine));
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) {
        if (txtRentalId.getText().isEmpty() || txtBookId.getText().isEmpty()) {

            showAlert(Alert.AlertType.ERROR, "Error", "Please Search for a Rental first.");
            return;
        }

        try {
            BookReturn bookReturn = new BookReturn();
            bookReturn.setRentalId(txtRentalId.getText());
            bookReturn.setBookId(txtBookId.getText());
            bookReturn.setCustomerId(txtNIC.getText());
            bookReturn.setReturnDate(returnDatePicker.getValue());
            bookReturn.setOverDueDays((int) ChronoUnit.DAYS.between(dueDatePicker.getValue(), returnDatePicker.getValue()));

            double fine = txtTotalFine.getText().isEmpty() ? 0.0 : Double.parseDouble(txtTotalFine.getText());
            bookReturn.setTotalFine(fine);

            boolean isReturned = bookReturnService.returnBook(bookReturn);

            if (isReturned) {
                showAlert(Alert.AlertType.INFORMATION, "Success", "Book Returned Successfully!");
                clearFields();
            } else {
                showAlert(Alert.AlertType.ERROR, "Failed", "Could not process return.");
            }

        } catch (Exception e) {
            e.printStackTrace();
            showAlert(Alert.AlertType.ERROR, "Error", "An error occurred: " + e.getMessage());
        }
    }

    private void clearFields() {
        txtRentalSearch.clear();
        txtRentalId.clear();
        txtBookId.clear();
        txtBookTitle.clear();
        txtNIC.clear();
        txtCustomerName.clear();
        txtTotalFine.clear();
        IssueDatePicker.setValue(null);
        dueDatePicker.setValue(null);
        returnDatePicker.setValue(null);
    }

    private void showAlert(Alert.AlertType type, String title, String msg) {
        Alert alert = new Alert(type);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    @FXML void btnCancelReturnBookOnAction(ActionEvent event) {
        clearFields();
    }
    @FXML void btnCloseOnAction(ActionEvent event) {
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}