package com.sample.ProduktData;

import java.util.List;

public class ProduktFormat {

    public static String DELIMITER =";";

    private static String produktFormat(Produkter etProdukt){

        return etProdukt.getType() + DELIMITER  + etProdukt.getMerke() + DELIMITER
                +etProdukt.getPris() + DELIMITER + etProdukt.getKomponent();
    }

    public static String prodFormat(List<Produkter> produkterList){
        StringBuilder pFormat = new StringBuilder();
        for(Produkter element : produkterList){
            pFormat.append(produktFormat(element));
            pFormat.append("\n");
        }
        return pFormat.toString();
    }

}
