package edu.icet.service.impl;

import edu.icet.model.BookStore;
import edu.icet.repository.BookStoreRepository;
import edu.icet.repository.impl.BookStoreRepositoryImpl;
import edu.icet.service.BookStoreService;
import edu.icet.service.CustomerRegistrationService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookStoreServiceImpl implements BookStoreService {

    BookStoreRepository bookStoreRepository = new BookStoreRepositoryImpl();

    BookStore bookStore = new BookStore();

    @Override
    public ObservableList<BookStore>bookStores(){
        ObservableList<BookStore>bookStoreObservableList = FXCollections.observableArrayList();
        try {
            ResultSet resultSet = bookStoreRepository.allBookDetails();
            while(resultSet.next()){
                bookStoreObservableList.add(new BookStore(
                        bookStore.getBookId(),
                        bookStore.getBookTitle(),
                        bookStore.getAuthor(),
                        bookStore.getCategory(),
                        bookStore.getQuantity(),
                        bookStore.getPrice()
                ));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } {


        }
        return bookStoreObservableList;

    }
    @Override
    public void setstoreBook(BookStore bookStore){
        try {
            bookStoreRepository.addBooksDetails(bookStore);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
