package com.sample.controllers;

import com.sample.Avvik.Avvik;
import com.sample.Data.Datamaskin;
import com.sample.Data.ProdukterCollection;
import com.sample.Data.Produkter;
import com.sample.Validering.KonverterInterger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Admin {
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert warning = new Alert(Alert.AlertType.WARNING);
    private  ObservableList<Datamaskin> datamaskin = FXCollections.observableArrayList();
    private ProdukterCollection collection = new ProdukterCollection();
    private ObservableList<Produkter> etProdukt = FXCollections.observableArrayList();
    @FXML
    private TextField typetxt, merketxt, pristxt, komponenettxt;

    @FXML
    private Button Registrerbfn;

    @FXML
    private TableView<Produkter> tableview;

    @FXML
    private TableColumn<Datamaskin, String> komponentercol, typecol, merkecol;

    @FXML
    private TableColumn<Datamaskin, Integer> priscol;

    @FXML
    private TextField sokefelt;

    @FXML
    void sokbtn(ActionEvent event) {}


    @FXML
    void actionregistrerbtn(ActionEvent event) throws IOException {
        registerPerson();
        updatePersonList();

        }


    private void updatePersonList() {
        collection.attachTableView(tableview);}

    private void registerPerson() {
        Produkter objekt = createProduktObjekt();
        if (objekt != null) {
            resetTxtFields();
            System.out.println(objekt.toString());
            collection.addElement(objekt);}
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
    public void initialize(URL url, ResourceBundle resourceBundle){
        collection.attachTableView(tableview);
        komponentercol.setCellFactory(TextFieldTableCell.forTableColumn());
        typecol.setCellFactory(TextFieldTableCell.forTableColumn());
        merkecol.setCellFactory(TextFieldTableCell.forTableColumn());
        priscol.setCellFactory(TextFieldTableCell.forTableColumn(new KonverterInterger.Konverter()));
        tableview.setEditable(true);



        FilteredList<Produkter> filteredList = new FilteredList<>(collection.enMaskin, b -> true);
        sokefelt.textProperty().addListener((observable,oldValue,newValue)->{
            filteredList.setPredicate(produktobjekt->{
                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                String soktxt = newValue;
                int pris = 0;
                if(Pattern.matches("[0-9]*",soktxt)) {

                    try {
                        pris = Integer.parseInt(soktxt);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());
                    }
                }
                String lowerCaseF = newValue.toLowerCase();
                if(produktobjekt.getMerke().toLowerCase().contains(lowerCaseF)){
                    return true;
                }else if(produktobjekt.getType().toLowerCase().contains(lowerCaseF)){
                    return true;
                }else if(produktobjekt.getKomponenet().toLowerCase().contains(lowerCaseF)){
                    return true;
                }else if(produktobjekt.getKomponenet().toLowerCase().contains(lowerCaseF)){
                    return true;
                }else if(produktobjekt.getPris()== pris){
                    return true;
                }
                else return false;
            });
        });
        SortedList<Produkter> sortertData = new SortedList<>(filteredList);
        sortertData.comparatorProperty().bind(tableview.comparatorProperty());
        tableview.setItems(sortertData);
    }


    private Produkter createProduktObjekt() {
        String komponenet = komponenettxt.getText();
        boolean komponentValid = Avvik.komponentValid(komponenet);

        String type = typetxt.getText();
        boolean typeValid = Avvik.typeValid(type);

        int pris = Integer.parseInt(pristxt.getText());
        boolean prisValid = Avvik.prisValid(pris);

        String merke = merketxt.getText();
        boolean merkeValid = Avvik.merkeValid(merke);

        boolean allowAddObj = merkeValid && prisValid && typeValid;

        Produkter produktTable = null;
        if (!allowAddObj) {
            error.setTitle("Error: Wrong Input");
            error.setHeaderText(Avvik.melding);
            error.showAndWait();
        } else {
            produktTable = new Produkter(type, merke, pris, komponenet);
            etProdukt.add(produktTable);
        }
        return produktTable;
    }

    private void resetTxtFields() {
        merketxt.setText("");
        pristxt.setText("");
        typetxt.setText("");
        komponenettxt.setText("");
    }

}



