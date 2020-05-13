package com.sample.Filhåndtering;

import com.sample.Exception.InvalidProduktException;
import com.sample.ProduktData.ProduktParse;
import com.sample.ProduktData.Produkter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileOpnerCsv implements FileOpner{
    @Override
    public ArrayList<Produkter> open(ArrayList<Produkter> produkter, Path filePath) throws IOException, InvalidProduktException {
        File file = new File (String.valueOf(filePath));
        BufferedReader br = null;

        int teller = 0;
        if(file.exists()){
            String linjeTabell;
            br = Files.newBufferedReader(Paths.get(String.valueOf(filePath)));

            while ((linjeTabell = br.readLine()) != null){
                teller++;
                if(teller == 1){
                    continue;
                }
                produkter.add(ProduktParse.parsePerson(linjeTabell));
            }
        }
        br.close();
        return produkter;
    }

}

