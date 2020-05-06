package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileOpnerJobj implements FileOpner {
    @Override
    public void open(Datamaskin registry, Path filePath) throws IOException {
        try (InputStream fin = Files.newInputStream(filePath);
             ObjectInputStream oin = new ObjectInputStream(fin))
        {


    }

    }
}
