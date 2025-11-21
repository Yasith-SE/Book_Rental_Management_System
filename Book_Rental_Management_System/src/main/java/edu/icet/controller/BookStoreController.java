package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.BookStore;
import edu.icet.service.BookStoreService;
import edu.icet.service.impl.BookStoreServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class BookStoreController implements Initializable {

    BookStore bookStore = new BookStore();
    BookStoreService bookStoreService = new BookStoreServiceImpl();

    @FXML
    private JFXComboBox<String> comboBookCategory;

    @FXML
    private Label lblAuthorError;

    @FXML
    private Label lblBookTitleError;

    @FXML
    private Label lblQuantityPrice;

    @FXML
    private Label lblSelectCategory;

    @FXML
    private Label lblUnitPrice;

    @FXML
    private Label lblValidationMessage;

    @FXML
    private JFXTextField txtBookAuthor;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtBookPrice;

    @FXML
    private JFXTextField txtBookQuantity;

    @FXML
    private JFXTextField txtBookTitle;


    @FXML
    void btnBookDeleteOnAction(ActionEvent event) {



    }

    @FXML
    void btnBookRegisterOnAction(ActionEvent event) {



        if(txtBookId.getText().isEmpty()    || txtBookTitle.getText().isEmpty()    || txtBookAuthor.getText().isEmpty() ||
           txtBookPrice.getText().isEmpty() || txtBookQuantity.getText().isEmpty() || comboBookCategory.getValue() == null){
            lblValidationMessage.setText("Please fill all the fields");


        }else if(bookStoreService.exsistByID(txtBookId.getText())) {
            lblValidationMessage.setText("Book ID already exists");


        }else{

            bookStoreService.addstoreBook(new BookStore(
                    txtBookId.getText(),
                    txtBookTitle.getText(),
                    txtBookAuthor.getText(),
                    comboBookCategory.getValue(),
                    Integer.parseInt(txtBookQuantity.getText()),
                    Double.parseDouble(txtBookPrice.getText())

            ));
            lblValidationMessage.setText("Book Registered Successfully");

        }

    }


    @FXML
    void btnBookUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        comboBookCategory.getItems().addAll("Science Fiction", "Romance", "Mystery", "Fantasy", "Non-Fiction", "Horror", "Biography", "Self-Help");


        loadNextBookId();


    }

    private void loadNextBookId() {
        try {
            String nextId = bookStoreService.generateNextBookId();
            txtBookId.setText(nextId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
