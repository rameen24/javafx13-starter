package com.sample.controllers.Controller_Bruker;

import com.sample.Filhåndtering.ThreadHåndtering;
import com.sample.ProduktData.Produkter;
import com.sample.ProduktData.ProdukterCollection;
import com.sample.Validering.KonverterInterger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Minner_Bruker implements Initializable {
    private ProdukterCollection collection = new ProdukterCollection();
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
        BufferedReader bufferedReader;
        String Delimiter = ";";

        try {
            ThreadHåndtering thread = new ThreadHåndtering("src/main/resources/Test/minne.jobj") ;
            bufferedReader = new BufferedReader(thread.call());

            String linje;
            while ((linje = bufferedReader.readLine()) != null) {
                String[] produkt = linje.split(Delimiter, -1);
                Produkter produkter = new Produkter(produkt[0], produkt[1],Integer.parseInt(produkt[3]),produkt[2]);
                collection.enMaskin.add(produkter);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    void leggtilhandlekurvaction(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        merkecol.setCellFactory(TextFieldTableCell.forTableColumn());
        priscol.setCellFactory(TextFieldTableCell.forTableColumn(new KonverterInterger()));
        typecol.setCellFactory(TextFieldTableCell.forTableColumn());
        komponenetcol.setCellFactory(TextFieldTableCell.forTableColumn());


        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }
}
