package com.sample.controllers.Controller_Bruker;

import com.sample.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class Meny_Bruker {
    @FXML
    private Button prosessorbtn, haddisk, minnebtn, skjermbtn, skjermkortbtn, divesebtn;

    @FXML
    void action(ActionEvent event) throws IOException {
        if (event.getSource() == haddisk){
            App.changeView("Harddsik_Bruker.fxml");
        }
        if(event.getSource() == skjermkortbtn){
            App.changeView("Skjermkort_Bruker.fxml");

        }
        if (event.getSource() == skjermbtn){
            App.changeView("Skjerm_Bruker.fxml");
        }
        if(event.getSource() == minnebtn){
            App.changeView("Minne_Bruker.fxml");
        }
        if(event.getSource() == prosessorbtn){
            App.changeView("Prosessor_Bruker.fxml");
        }
        if(event.getSource() == divesebtn){
            App.changeView("velgkomponenter.fxml");
        }


    }

}
