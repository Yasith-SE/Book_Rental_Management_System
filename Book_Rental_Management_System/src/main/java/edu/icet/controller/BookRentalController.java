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
    void btmBuyRentalBookOnAction(ActionEvent event) {
        if(txtBookId.getText().isEmpty() || txtBookTitle.getText().isEmpty()  || txtBookRentalId.getText().isEmpty()  ||txtNic.getText().isEmpty() ||
                txtCustomerName.getText().isEmpty()  || issueDatepicker.getValue() == null || dueDatePicker.getValue() == null ||
                txtBookQuantity.getText().isEmpty()  || txtBookRentalCost.getText().isEmpty()){

            lblValidationMessage.setText("Fill all the fields");

        } else{
            LocalDate issueDate = issueDatepicker.getValue();
            LocalDate dueDate = dueDatePicker.getValue();

            if(issueDate == null || dueDate == null){
                lblIssueDate.setText("Select Issue Date");
                return;

            }if(dueDate.isBefore(issueDate)){
                lblDueDate.setText("Due Date Cannot before IssueDate");
                return;

            }

            bookRental = new BookRental(
                    txtBookRentalId.getText(),
                    txtNic.getText(),
                    txtCustomerName.getText(),
                    issueDate,
                    dueDate
            );
            for(BookRentalItem bookRentalItem : bookBucket){
                rentalItemService.saveRentalItem(
                        txtBookRentalId.getText(),
                        bookRentalItem.getBookId(),
                        bookRentalItem.getQuantity(),
                        bookRentalItem.getRentalCost()
                );

                bookStoreService.reduceBookQty(
                        bookRentalItem.getBookId(),
                        bookRentalItem.getQuantity()
                );

            }

            lblValidationMessage.setText("Book Rented Succuessfully");
            bookBucket.clear();
        }
    }

    @FXML
    void btnAddToBookBucketOnAction(ActionEvent event) {
        BookRentalItem bookRentalItem = new BookRentalItem(
                txtBookId.getText(),
                txtBookTitle.getText(),
                Integer.parseInt(txtBookQuantity.getText()),
                Double.parseDouble(txtBookRentalCost.getText())
        );
        bookBucket.add(bookRentalItem);
    }



    @FXML
    void btnBuyRentalBookOnAction(KeyEvent event) {
        btmBuyRentalBookOnAction(null);


    }

    @FXML
    void btnCancelBookOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelBookOrderOnActionn(KeyEvent event) {

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
