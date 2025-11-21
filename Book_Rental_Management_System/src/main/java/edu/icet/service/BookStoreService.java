package edu.icet.service;

import edu.icet.model.BookStore;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface BookStoreService {

    ObservableList<BookStore> bookStores();
    void addstoreBook(BookStore bookStore);

    boolean exsistByID(String bookId);

    String generateNextBookId() throws SQLException;

    void updateStoreBook(BookStore bookStore);

    boolean deleteStoreBook(String bookId);


}
