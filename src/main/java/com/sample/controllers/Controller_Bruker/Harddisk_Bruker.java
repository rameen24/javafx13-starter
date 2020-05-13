package com.sample.controllers.Controller_Bruker;

import com.sample.ProduktData.Produkter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class Harddisk_Bruker {
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
    private Button leggtilhandlekurv, visprodukter;



    @FXML
    void visprodukteraction(ActionEvent event) {

    }

    @FXML
    void leggtilhandlekurvaction(ActionEvent event) {

    }

}
