package com.sample.Avvik;

import com.sample.Exception.InvalidKomponentException;
import com.sample.Exception.InvalidMerkeException;
import com.sample.Exception.InvalidPrisException;
import com.sample.Exception.InvalidTypeException;
import com.sample.Validering.Validering;
import javafx.scene.control.Alert;

public class Avvik {
    public static void showErrorDialog(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Feil!");
        alert.setHeaderText("Ugyldig data!");
        alert.setContentText(msg);

        alert.showAndWait();
    }
    public static String melding;
    public static boolean komponentValid(String komponent){
        boolean sjekk = true;
        try{
            Validering.KomponenentInputValidering(komponent);
        } catch (InvalidKomponentException e){
            melding = e.getMessage();
            sjekk = false;
        }
        return sjekk;
    }
    public static boolean typeValid(String type){
        boolean sjekk = true;
        try{
            Validering.typeValidering(type);
        } catch (InvalidTypeException e){
            melding = e.getMessage();
            sjekk = false;
        }
        return sjekk;
    }
    public static boolean merkeValid(String merke) {
        boolean sjekk = true;
        try {
            Validering.merkeInputValidering(merke);
        } catch (InvalidMerkeException e) {
            melding = e.getMessage();
            sjekk = false;
        }
        return sjekk;
    }
    public static boolean prisValid(int pris){
        boolean sjekk = true;
        try{
            Validering.prisValid(pris);

        } catch (InvalidPrisException e){
            melding=e.getMessage();
            sjekk = false;
        }
        return sjekk;
    }

}
