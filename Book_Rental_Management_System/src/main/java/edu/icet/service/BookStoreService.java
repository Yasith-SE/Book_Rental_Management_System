package edu.icet.service;

import edu.icet.model.BookStore;
import javafx.collections.ObservableList;

public interface BookStoreService {

    ObservableList<BookStore> bookStores();
    void setstoreBook(BookStore bookStore);


}
