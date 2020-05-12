package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;
import com.sample.ProduktData.Produkter;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileSaverJobj implements FileSaver {

    @Override
    public void save(ArrayList<Produkter> produkter, File filePath) throws IOException {
        try{
            FileOutputStream fos = new FileOutputStream(filePath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Produkter etprodukt: produkter){
                oos.writeObject(etprodukt);
            }
            oos.close();
        }catch (Exception e){
            throw new IOException("Kan ikke finne filen");
        }

    }
}

