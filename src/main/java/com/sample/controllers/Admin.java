package com.sample.controllers;

import com.sample.Data.Datamaskin;
import com.sample.Data.Produkter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Admin {
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert warning = new Alert(Alert.AlertType.WARNING);
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
    void actionregistrerbtn(ActionEvent event) {

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
        try {
            cellEditEvent.getRowValue().setPris(cellEditEvent.getNewValue());
        } catch (IllegalArgumentException e) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig pris: må skrive inn positivt tall");
            warning.showAndWait();
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

    }

}

