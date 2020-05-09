package com.sample.controllers;

import com.sample.Avvik.Avvik;
import com.sample.ProduktData.Produkter;
import com.sample.ProduktData.ProdukterCollection;
import com.sample.Validering.KonverterInterger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;



import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Admin implements Initializable {
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert warning = new Alert(Alert.AlertType.WARNING);
    private ProdukterCollection collection = new ProdukterCollection();
    private ObservableList<Produkter> etProdukt = FXCollections.observableArrayList();
    private Produkter produkter;
    @FXML
    private TextField typetxt, merketxt, pristxt, komponenettxt;

    @FXML
    private Button Registrerbfn;

    @FXML
    private TableView<Produkter> tableview;

    @FXML
    private TableColumn<Produkter, String> komponentercol, typecol, merkecol;

    @FXML
    private TableColumn<Produkter, Integer> priscol;

    @FXML
    private TextField sokefelt;

    @FXML
    void sokbtn(ActionEvent event) {
    }


    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        merkecol.setCellFactory(TextFieldTableCell.forTableColumn());
        priscol.setCellFactory(TextFieldTableCell.forTableColumn(new KonverterInterger()));
        typecol.setCellFactory(TextFieldTableCell.forTableColumn());
        komponentercol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableview.setEditable(true);


        FilteredList<Produkter> filteredList = new FilteredList<>(collection.enMaskin, b -> true);
        sokefelt.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredList.setPredicate(produktobjekt -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String soktxt = newValue;
                int pris = 0;
                if (Pattern.matches("[0-9]*", soktxt)) {

                    try {
                        pris = Integer.parseInt(soktxt);
                    } catch (NumberFormatException e) {
                        System.err.println(e.getMessage());
                    }
                }
                String lowerCaseF = newValue.toLowerCase();
                if (produktobjekt.getMerke().toLowerCase().contains(lowerCaseF)) {
                    return true;
                } else if (produktobjekt.getType().toLowerCase().contains(lowerCaseF)) {
                    return true;
                } else if (produktobjekt.getKomponenet().toLowerCase().contains(lowerCaseF)) {
                    return true;
                } else if (produktobjekt.getKomponenet().toLowerCase().contains(lowerCaseF)) {
                    return true;
                } else if (produktobjekt.getPris() == pris) {
                    return true;
                } else return false;
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

        boolean allowAddObj = merkeValid && prisValid && typeValid && komponentValid;
        if (!(merke.isEmpty() || type.isEmpty() || merke.isEmpty())) {
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
        } else {
            error.setTitle("Error");
            error.setHeaderText("Du har ikke fylt ut alle text feltene");
            error.showAndWait();
        }
        return null;
    }
    private void resetTxtFields() {
        merketxt.setText("");
        pristxt.setText("");
        typetxt.setText("");
        komponenettxt.setText("");
    }


    @FXML
    void actionregistrerbtn(ActionEvent event)  {
        produkter = createProduktObjekt();
        if (produkter != null) {
            collection.attachTableView(tableview);
            System.out.println(produkter.toString());
            resetTxtFields();
        }
    }
    private TableHåndtering entable = new TableHåndtering();

    @FXML
    void komponentEdited(TableColumn.CellEditEvent<Produkter, String> event) {
        if (!entable.komponentCell(event.getNewValue())) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig format");
            warning.showAndWait();
            tableview.refresh();
        } else {
            event.getRowValue().setKomponenet(event.getNewValue());
        }
    }


    @FXML
    void merkeEdited(TableColumn.CellEditEvent<Produkter, String> event) {
        if (!entable.merkCell(event.getNewValue())) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig format");
            warning.showAndWait();
            tableview.refresh();
        } else {
            event.getRowValue().setMerke(event.getNewValue());
        }
    }
    @FXML
    void typeEdited(TableColumn.CellEditEvent<Produkter, String> event) {
        if (!entable.typeCell(event.getNewValue())) {
            warning.setTitle("Warning");
            warning.setHeaderText("Ugyldig format");
            warning.showAndWait();
            tableview.refresh();
        } else {
            event.getRowValue().setType(event.getNewValue());
        }
    }

    @FXML
    void prisEdited(TableColumn.CellEditEvent<Produkter, Integer> event) {
        if (KonverterInterger.conversionSuccessful) {
            try {
                event.getRowValue().setPris(event.getNewValue());
            } catch (IllegalArgumentException e) {
                Avvik.showErrorDialog("Du kan ikke taste inn et negativt tall!");
            }
        }
        tableview.refresh();
    }

}

