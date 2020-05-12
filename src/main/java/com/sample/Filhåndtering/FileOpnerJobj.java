package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;
import com.sample.ProduktData.Produkter;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpnerJobj implements FileOpner {



    @Override
    public ArrayList<Produkter> open(Path filePath) throws IOException {
        ArrayList<Produkter> produkter = new ArrayList<>();
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



