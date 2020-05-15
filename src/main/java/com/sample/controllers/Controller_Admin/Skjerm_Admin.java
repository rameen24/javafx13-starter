package com.sample.controllers.Controller_Admin;

import com.sample.Avvik.Avvik;
import com.sample.Filhåndtering.ThreadHåndtering;
import com.sample.ProduktData.Produkter;
import com.sample.ProduktData.ProdukterCollection;
import com.sample.Validering.KonverterInterger;
import com.sample.controllers.TableHåndtering;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class Skjerm_Admin
        implements Initializable {
    Alert error = new Alert(Alert.AlertType.ERROR);
    Alert warning = new Alert(Alert.AlertType.WARNING);
    private ProdukterCollection collection = new ProdukterCollection();
    private ObservableList<Produkter> etProdukt = FXCollections.observableArrayList();
    private Produkter produkter;
    @FXML
    private TextField typetxt, merketxt, pristxt, komponenettxt;

    @FXML
    private TableView<Produkter> tableview;

    @FXML
    private TableColumn<Produkter, String> komponentercol, typecol, merkecol;

    @FXML
    private TableColumn<Produkter, Integer> priscol;

    @FXML
    private TextField sokefelt;

    @FXML
    void vistabelaction(ActionEvent event) {
        BufferedReader bufferedReader;
        String Delimiter = ";";

        try {
            ThreadHåndtering thread = new ThreadHåndtering("src/main/resources/Test/skjerm.jobj") ;
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
    void lagretabelaction(ActionEvent event) throws IOException {
        FileWriter fw = new FileWriter("src/main/resources/Test/skjerm.jobj", false);
        fw.write(toString(tableview));
        fw.close();

    }

    private String toString(TableView<Produkter> tableview) throws IOException {
        String write = " ";
        try{

            for(int x = 0; x < collection.enMaskin.size(); x++){
                write +=    collection.enMaskin.get(x).getKomponent()+";"
                        +collection.enMaskin.get(x).getType()+";"
                        +collection.enMaskin.get(x).getMerke()+";"
                        +collection.enMaskin.get(x).getPris()+";"+
                        "\n";
            }
        }catch (Exception e){
            throw new IOException("Noe gikk feil");

        }
        return write;
    }
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        merkecol.setCellFactory(TextFieldTableCell.forTableColumn());
        priscol.setCellFactory(TextFieldTableCell.forTableColumn(new KonverterInterger()));
        typecol.setCellFactory(TextFieldTableCell.forTableColumn());
        komponentercol.setCellFactory(TextFieldTableCell.forTableColumn());
        tableview.setEditable(true);


        tableview.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

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
                } else if (produktobjekt.getKomponent().toLowerCase().contains(lowerCaseF)) {
                    return true;
                } else if (produktobjekt.getKomponent().toLowerCase().contains(lowerCaseF)) {
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

        Produkter produkterTabell = null;
        if (!allowAddObj) {
            error.setTitle("Error: Wrong Input");
            error.setHeaderText(Avvik.melding);
            error.showAndWait();
        } else {
            produkterTabell = new Produkter(type,merke,pris,komponenet);
            etProdukt.add(produkterTabell);
        }
        return produkterTabell;

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
            collection.addElement(produkter);
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
            event.getRowValue().setKomponent(event.getNewValue());
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


