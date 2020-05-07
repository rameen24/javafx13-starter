package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileSaverJobj implements FileSaver {
    @Override
    public void save(Datamaskin registry, String filePath) throws IOException {

        File file = new File(filePath);

        FileOutputStream fos = new FileOutputStream(filePath);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        if (file != null) {
            oos.writeObject(registry);
            oos.flush();
            oos.close();
            fos.flush();
            fos.close();

        } else {
            throw new IOException("Ugyldig fil");
        }
    }
}
