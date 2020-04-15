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
        String brukernavnBruker = "Bruker123";
        String passordBruker = "Bruker123";

        String logginnNavn = brukernavn.getText();
        String logginnPassord = passord.getText();
        if(logginnNavn.equals(brukernavnAdmin) && logginnPassord.equals(passordAdmin)){
            App.changeView("admin.fxml");
        }
        else if(logginnNavn.equals(brukernavnBruker) && logginnPassord.equals(passordBruker)){
            App.changeView("handlekurv.fxml");
        }
//logger man inn som bruker havner man i handlekurven!
 //Logger man inn som admin havner man i adminsiden!
    }

}
