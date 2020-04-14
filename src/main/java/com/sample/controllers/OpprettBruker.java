package com.sample.controllers;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import com.sample.Data.Bruker;

import java.io.IOException;

public class OpprettBruker {
    @FXML
    private TextField fornavn;

    @FXML
    private TextField brukernavn;

    @FXML
    private TextField epost;

    @FXML
    private TextField etternavn;

    @FXML
    private PasswordField passord;

    @FXML
    private ImageView imageView;

    @FXML
    private Button registerer;

    //Hvis man allerede har bruker
    @FXML
    void SwitchToLogginn(ActionEvent event) throws IOException {
        App.changeView("login");
    }

    //Registrer knappen
    @FXML
    private void switchToHandleKurv() throws IOException {
        Bruker enbruker = new Bruker();

        App.changeView("handlekurv");
    }

}
