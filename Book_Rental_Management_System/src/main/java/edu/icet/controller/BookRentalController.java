package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.model.BookRental;
import edu.icet.model.BookRentalItem;
import edu.icet.model.BookStore;
import edu.icet.service.BookRentalService;
import edu.icet.service.BookStoreService;
import edu.icet.service.RentalItemService;
import edu.icet.service.impl.BookRentalServiceImpl;
import edu.icet.service.impl.BookStoreServiceImpl;
import edu.icet.service.impl.RentalItemServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.time.LocalDate;
import java.util.Date;

public class BookRentalController {

    ObservableList<BookRentalItem> bookBucket = FXCollections.observableArrayList();
    BookStoreService bookStoreService = new BookStoreServiceImpl();
    BookStore bookStore = new BookStore();
    BookRental bookRental = new BookRental();
    RentalItemService rentalItemService = new RentalItemServiceImpl();

    BookRentalService bookRentalService = new BookRentalServiceImpl();

    @FXML
    private DatePicker dueDatePicker;

    @FXML
    private DatePicker issueDatepicker;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtBookQuantity;

    @FXML
    private JFXTextField txtBookRentalCost;

    @FXML
    private JFXTextField txtBookRentalId;

    @FXML
    private JFXTextField txtCustomerName;

    @FXML
    private JFXTextField txtNic;

    @FXML
    private Label lblDueDate;

    @FXML
    private Label lblIssueDate;


    @FXML
    private Label lblValidationMessage;

    @FXML
    private JFXTextField txtBookTitle;

    @FXML
    private JFXTextField txtRentalBookSearch;


    @FXML
    void btnBuyRentalBookOnAction(ActionEvent event) {


        if (txtBookRentalId.getText().isEmpty() ||
                txtNic.getText().isEmpty() ||
                txtCustomerName.getText().isEmpty() ||
                issueDatepicker.getValue() == null ||
                dueDatePicker.getValue() == null) {

            lblValidationMessage.setText("Please fill all Rental ");
            return;
        }
        if (bookBucket.isEmpty()) {
            lblValidationMessage.setText("Please add at least one book to the bucket.");
            return;
        }

        LocalDate issueDate = issueDatepicker.getValue();
        LocalDate dueDate = dueDatePicker.getValue();

        if (dueDate.isBefore(issueDate)) {
            lblIssueDate.setText("Due Date cannot be before Issue Date.");
            return;
        }


        boolean isPlaced = bookRentalService.placeRental(
                txtBookRentalId.getText(),
                txtNic.getText(),
                txtCustomerName.getText(),
                issueDate,
                dueDate,
                bookBucket
        );

        if (isPlaced) {
            lblValidationMessage.setText("Rental Placed Successfully!");

            bookBucket.clear();
            txtBookRentalId.clear();
            txtNic.clear();
            txtCustomerName.clear();
            issueDatepicker.setValue(null);
            dueDatePicker.setValue(null);
        } else {
            lblValidationMessage.setText("Rental Failed.");
        }
    }

    @FXML
    void btnAddToBookBucketOnAction(ActionEvent event) {
        if(txtBookId.getText().isEmpty() || txtBookQuantity.getText().isEmpty() || txtBookRentalCost.getText().isEmpty()) {
            lblValidationMessage.setText("Please select a book and enter quantity.");
            return;
        }

        try{
            String rentalId = txtBookRentalId.getText();
            String bookId = txtBookId.getText();
            String bookTitle = txtBookTitle.getText();

            int quantityToAdd = Integer.parseInt(txtBookQuantity.getText());


            double unitPrice = Double.parseDouble(txtBookRentalCost.getText());

            double totalLineCost = unitPrice * quantityToAdd;


            boolean isFound = false;
            for (BookRentalItem bookItem : bookBucket){
                if(bookItem.getBookId().equals(bookId)){
                    bookItem.setQuantity(bookItem.getQuantity() + quantityToAdd);
                    bookItem.setRentalCost(bookItem.getRentalCost() + totalLineCost);
                    isFound = true;
                    break;
                }
            }

            if (!isFound){
                BookRentalItem bookRentalItem = new BookRentalItem(
                        rentalId, bookId, bookTitle, quantityToAdd, totalLineCost // Use calculated total cost
                );
                bookBucket.add(bookRentalItem);
            }

            txtBookId.clear();
            txtBookTitle.clear();
            txtBookQuantity.clear();
            txtBookRentalCost.clear();
            txtRentalBookSearch.clear();

            lblValidationMessage.setText("Book added to bucket.");

        } catch (NumberFormatException e){
            lblValidationMessage.setText("Invalid number format in Quantity or Cost.");
        }
    }
    @FXML
    void btnCancelBookOrderOnAction(ActionEvent event) {
        txtBookId.clear();
        txtBookTitle.clear();
        txtBookQuantity.clear();
        txtBookRentalCost.clear();
        txtRentalBookSearch.clear();

        lblValidationMessage.setText("All Cleared");

    }

    @FXML
    void searchTextFieldOnAction(ActionEvent event) {

        String searchValue = txtRentalBookSearch.getText();

        BookStore bookSearch = bookStoreService.searchBook(searchValue);

        if(bookSearch != null){
            txtBookId.setText(bookSearch.getBookId());
            txtBookTitle.setText(bookSearch.getBookTitle());
            txtBookRentalCost.setText(String.valueOf(bookSearch.getPrice()));
            txtBookQuantity.setText("1");
        }

    }
    @FXML
    void searchTextFieldOnKeyRelease(KeyEvent event) {
        searchTextFieldOnAction(null);

    }
    @FXML
    void btnViewTableOnAction(ActionEvent event) {

    }

}
