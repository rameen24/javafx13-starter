package com.sample.controllers;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class Logginn {
    @FXML
    private PasswordField passord;

    @FXML
    private TextField brukernavn;


    @FXML
    void logginn(ActionEvent event) throws IOException {
        String brukernavnAdmin = "Admin123";
        String passordAdmin = "Admin123";


        String logginnNavn = brukernavn.getText();
        String logginnPassord = passord.getText();
        if(logginnNavn.equals(brukernavnAdmin) && logginnPassord.equals(passordAdmin)){
            App.changeView("Prosessor_admin.fxml");
        }

        }

 //Logger man inn som admin havner man i adminsiden!
    }


