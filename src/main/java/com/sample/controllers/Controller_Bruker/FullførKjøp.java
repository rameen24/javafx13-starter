package com.sample.controllers.Controller_Bruker;

import com.sample.Data.Datamaskin;
import com.sample.Filhåndtering.FileOpnerCsv;
import com.sample.Filhåndtering.FileSaverCsv;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.FileWriter;

import static javax.swing.JOptionPane.showInputDialog;


public class FullførKjøp {
    private Alert feil = new Alert(Alert.AlertType.ERROR);
    public void error (String title,String header){
        feil.setTitle(title);
        feil.setHeaderText(header);
        feil.showAndWait();
    }
    private FileSaverCsv saverCsv;
    @FXML
    private TableView<Datamaskin> tableview;

    @FXML
    private TableColumn<Datamaskin, String> komponenetcol;

    @FXML
    private TableColumn<Datamaskin, String> typecol;

    @FXML
    private TableColumn<Datamaskin, String> merkecol;

    @FXML
    private TableColumn<Datamaskin, Integer> priscol;

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
    void slettaction(ActionEvent event) {

    }
}
