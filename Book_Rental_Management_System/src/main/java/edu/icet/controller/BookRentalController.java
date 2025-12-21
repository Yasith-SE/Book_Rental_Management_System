package edu.icet.controller;

import com.jfoenix.controls.JFXTextField;
import edu.icet.model.BookRentalItem;
import edu.icet.model.BookStore;
import edu.icet.service.BookStoreService;
import edu.icet.service.impl.BookStoreServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.input.KeyEvent;

public class BookRentalController {

    ObservableList<BookRentalItem> bookBucket = FXCollections.observableArrayList();
    BookStoreService bookStoreService = new BookStoreServiceImpl();
    BookStore bookStore = new BookStore();

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
    private JFXTextField txtRentalBookSearch;

    @FXML
    void btmBuyRentalBookOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddToBookBucketOnAction(ActionEvent event) {

    }

    @FXML
    void btnAddToBookBucketOnActionn(KeyEvent event) {

    }

    @FXML
    void btnBuyRentalBookOnAction(KeyEvent event) {

    }

    @FXML
    void btnCancelBookOrderOnAction(ActionEvent event) {

    }

    @FXML
    void btnCancelBookOrderOnActionn(KeyEvent event) {

    }

    @FXML
    void searchTextFieldOnAction(ActionEvent event) {

    }

    @FXML
    void txtBookTitle(ActionEvent event) {

    }

}
