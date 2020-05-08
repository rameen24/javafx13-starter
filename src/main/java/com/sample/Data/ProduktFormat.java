package com.sample.Data;

import java.util.List;

public class ProduktFormat { public static String DELIMITER =";";

    private static String personFormat(Produkter etProdukt){

        return etProdukt.getType() + DELIMITER  + etProdukt.getMerke() + DELIMITER
                +etProdukt.getPris() + DELIMITER + etProdukt.getKomponenet();
    }

    public static String prodFormat(List<Produkter> produkterList){
        StringBuilder pFormat = new StringBuilder();
        for(Produkter element : produkterList){
            pFormat.append(personFormat(element));
            pFormat.append("\n");
        }
        return pFormat.toString();
    }
}
