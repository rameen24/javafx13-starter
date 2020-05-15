package com.sample.controllers.Controller_Bruker;

import com.sample.Filhåndtering.FileSaverCsv;
import com.sample.ProduktData.Produkter;
import com.sample.Validering.KonverterInterger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.net.URL;
import java.util.ResourceBundle;

import static javax.swing.JOptionPane.showInputDialog;


public class FullførKjøp implements Initializable {

    private ObservableList<Produkter> etProdukt = FXCollections.observableArrayList();

    private Alert feil = new Alert(Alert.AlertType.ERROR);

    public void error(String title, String header) {
        feil.setTitle(title);
        feil.setHeaderText(header);
        feil.showAndWait();
    }

    private FileSaverCsv saverCsv;

    @FXML
    private TableView<Produkter> tableview;

    @FXML
    private TableColumn<Produkter, String> komponenetcol;

    @FXML
    private TableColumn<Produkter, String> typecol;

    @FXML
    private TableColumn<Produkter, String> merkecol;

    @FXML
    private TableColumn<Produkter, Integer> priscol;

    @FXML
    private Button fullførkjøpbtn;

    @FXML
    private Label prisfelt;

    @FXML
    private Button slettbtn;

    @FXML
    void fullførkjøpaction(ActionEvent event) {

    }

    @FXML
    void gåtilbakeaction(ActionEvent event) {

    }



    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        merkecol.setCellFactory(TextFieldTableCell.forTableColumn());
        priscol.setCellFactory(TextFieldTableCell.forTableColumn(new KonverterInterger()));
        typecol.setCellFactory(TextFieldTableCell.forTableColumn());
        komponenetcol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tableview.setItems(etProdukt);


    }
}
