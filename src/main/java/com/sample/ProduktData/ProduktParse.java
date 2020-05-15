package com.sample.ProduktData;

import com.sample.Exception.InvalidProduktException;
import com.sample.ProduktData.ProduktFormat;
import com.sample.ProduktData.Produkter;
import javafx.scene.control.TableView;

import java.io.IOException;

public class ProduktParse {

        public static Produkter parsePerson(String str) throws InvalidProduktException {
            //En String array av linje, det indeksene plasseres etter DELIMITER tegnet (;)
            String[] linjeArray = str.split(ProduktFormat.DELIMITER);
            if (linjeArray.length !=3) {
                throw new InvalidProduktException("Filen åpnes ikke: Feil bruk av skiletegn -;-.");
            }

            String type = linjeArray[0];

            int pris;
            try {
                pris = Integer.parseInt(linjeArray[1]);
            } catch (NumberFormatException e) {
                throw new InvalidProduktException("Ugyldig pris");
            }
            String merke = linjeArray[2];
            String komponenet = linjeArray[3];

            return new Produkter(type, merke, pris, komponenet);
        }

    }


