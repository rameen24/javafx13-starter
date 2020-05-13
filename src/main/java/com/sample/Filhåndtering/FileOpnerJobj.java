package com.sample.Filhåndtering;

import com.sample.ProduktData.Produkter;
import javafx.collections.ObservableList;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpnerJobj implements FileOpner {
    public FileOpnerJobj(ArrayList<Produkter> produkter, File filePath) throws IOException {
    }

    @Override
    public ArrayList<Produkter> open(ArrayList<Produkter> produkter, Path filePath) throws IOException {
        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin)){

            Produkter etprodukt;
            while ((etprodukt = (Produkter) oin.readObject()) != null){
                produkter.add(etprodukt);
            }
            oin.close();
        }catch(ClassNotFoundException e){
            throw new IOException("Kan ikke finne filen");
        }
        return produkter;
    }
    }




