package edu.icet.controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import edu.icet.model.BookStore;
import edu.icet.service.BookStoreService;
import edu.icet.service.impl.BookStoreServiceImpl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BookStoreController {

    BookStore bookStore = new BookStore();
    BookStoreService bookStoreService = new BookStoreServiceImpl();

    @FXML
    private JFXComboBox<?> comboBookCategory;

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
            System.out.println("Please fill all the fields");


        }else{


            bookStoreService.addstoreBook(new BookStore(
                    txtBookId.getText(),
                    txtBookTitle.getText(),
                    txtBookAuthor.getText(),
                    String.valueOf(comboBookCategory.getValue()),
                    Integer.parseInt(txtBookQuantity.getText()),
                    Double.parseDouble(txtBookPrice.getText())

            ));

        }

    }

    @FXML
    void btnBookUpdateOnAction(ActionEvent event) {

    }

    @FXML
    void btnCloseOnAction(ActionEvent event) {

    }

}
