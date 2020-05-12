package com.sample.controllers.Controller_Admin;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class MenyAdmin {

    @FXML
    private Button Harddisk_admin,Skjermkort_admin, minne_admin, pros_admin, skjerm_admin;

    @FXML
    void action (ActionEvent event) throws IOException{
        if (event.getSource() == Harddisk_admin){
            App.changeView("Harddisk_Admin.fxml");
        }
        if(event.getSource() == Skjermkort_admin){
            App.changeView("Skjermkort_admin.fxml");

        }
        if (event.getSource() == skjerm_admin){
            App.changeView("Skjerm_admin.fxml");
        }
        if(event.getSource() == minne_admin){
            App.changeView("Minne_admin.fxml");
        }
        if(event.getSource() == pros_admin){
            App.changeView("Prosessor_admin.fxml");
        }

    }
}

