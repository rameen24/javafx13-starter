package com.sample.controllers;

import com.sample.Data.Datamaskin;
import com.sample.Data.DatamaskinCollection;
import com.sample.Data.Produkter;
import com.sample.Validering.KonverterInterger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.FileWriter;
import java.io.IOException;

public class Admin {
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert warning = new Alert(Alert.AlertType.WARNING);
    private Datamaskin datamaskin = new Datamaskin();
    private DatamaskinCollection collection = new DatamaskinCollection();
    @FXML
    private TextField typetxt, merketxt, pristxt;

    @FXML
    private ChoiceBox<String> komponenterliste;

    @FXML
    private Button Registrerbfn;

    @FXML
    private TableView<Datamaskin> tableview;

    @FXML
    private TableColumn<Datamaskin, String> komponentercol, typecol, merkecol;

    @FXML
    private TableColumn<Datamaskin, Integer> priscol;

    @FXML
    void actionregistrerbtn(ActionEvent event) throws IOException {
        FileWriter fileWriter = new FileWriter("src/main/resources/Test/Datamaskin.csv", true);
        //fileWriter.write((tableview));
        fileWriter.close();

    }



    @FXML
    private void merkeEdited(TableColumn.CellEditEvent <Produkter,String> cellEditEvent) {
        try {
            cellEditEvent.getRowValue().setMerke(cellEditEvent.getNewValue());
        } catch (IllegalArgumentException e) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig merke: må skrive merket med stor forbokstav");
            warning.showAndWait();
        }

        tableview.refresh();
    }

    @FXML
    private void prisEdited(TableColumn.CellEditEvent<Produkter,Integer> cellEditEvent) {
        if(KonverterInterger.Konverter.conversionSuccessful) {
            try {
                cellEditEvent.getRowValue().setPris(cellEditEvent.getNewValue());
            } catch (IllegalArgumentException e) {
                warning.setTitle("Warning");
                warning.setHeaderText("Ugyldig pris: må skrive inn positivt tall");
                warning.showAndWait();
            }
        }
        tableview.refresh();
    }

    @FXML
    private void typeEdited(TableColumn.CellEditEvent<Produkter,String> cellEditEvent) {
        try {
            cellEditEvent.getRowValue().setType(cellEditEvent.getNewValue());
        } catch (IllegalArgumentException e) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig type");
            warning.showAndWait();
        }

        tableview.refresh();
    }

    @FXML
    private void komponentEdited(TableColumn.CellEditEvent<Produkter,String> cellEditEvent) {
        try {
            cellEditEvent.getRowValue().setKomponenet(cellEditEvent.getNewValue());
        } catch (IllegalArgumentException e) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig komponent: må skrive inn med stor forbokstav");
            warning.showAndWait();
        }

        tableview.refresh();
    }
    @FXML
    public void initialize() {
        collection.attachTableView(tableview);
        komponentercol.setCellFactory(TextFieldTableCell.forTableColumn());
        typecol.setCellFactory(TextFieldTableCell.forTableColumn());
        merkecol.setCellFactory(TextFieldTableCell.forTableColumn());
        priscol.setCellFactory(TextFieldTableCell.forTableColumn(new KonverterInterger.Konverter()));
        tableview.setEditable(true);
        collection.attachTableView(tableview);

    }



}

