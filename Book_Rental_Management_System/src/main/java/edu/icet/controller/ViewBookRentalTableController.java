package edu.icet.controller;

import edu.icet.model.RentalTableModel;
import edu.icet.service.BookRentalService;
import edu.icet.service.impl.BookRentalServiceImpl;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ViewBookRentalTableController implements Initializable {

    @FXML
    private TableView<RentalTableModel> tblRentalView;

    @FXML
    private TableColumn<RentalTableModel, Double> tblFinalAmount;

    @FXML
    private TableColumn<RentalTableModel, String> tblRentalBookId;

    @FXML
    private TableColumn<RentalTableModel, LocalDate> tblRentalDate;

    @FXML
    private TableColumn<RentalTableModel, String> tblRentalId;

    @FXML
    private TableColumn<RentalTableModel, String> tblRentalNic;

    @FXML
    private TableColumn<RentalTableModel, LocalDate> tblRentalOverduedate;

    private final BookRentalService bookRentalService = new BookRentalServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblRentalId.setCellValueFactory(new PropertyValueFactory<>("rentalId"));
        tblRentalNic.setCellValueFactory(new PropertyValueFactory<>("nic"));
        tblRentalBookId.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        tblRentalDate.setCellValueFactory(new PropertyValueFactory<>("rentalDate"));
        tblRentalOverduedate.setCellValueFactory(new PropertyValueFactory<>("overdueDate"));
        tblFinalAmount.setCellValueFactory(new PropertyValueFactory<>("finalAmount"));

        loadTableData();
    }

    @FXML
    void btnReloadOnAction(ActionEvent event) {
        loadTableData();
    }

    private void loadTableData() {
        ObservableList<RentalTableModel> rentalList = bookRentalService.getAllRentals();
        if (tblRentalView != null) {
            tblRentalView.setItems(rentalList);
        }
    }
}