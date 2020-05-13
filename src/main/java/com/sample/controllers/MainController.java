package com.sample.controllers;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import com.sample.App;
import javafx.fxml.FXML;



//Lagde Main siden
public class MainController {
    @FXML
    private ImageView imageView;
    @FXML
    private Button brukerbtn;

    @FXML
    void switchAdmin(ActionEvent event) throws IOException {
        App.changeView("logginn.fxml");

    }
    @FXML
    void switchOpprettBruker(ActionEvent event) throws IOException{
        App.changeView("Prosessor_Bruker.fxml");

    }

}