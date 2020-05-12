package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;
import com.sample.ProduktData.Produkter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileOpner {
    ArrayList<Produkter> open(Path filePath) throws IOException ;
}
