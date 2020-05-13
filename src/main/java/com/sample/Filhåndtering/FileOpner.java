package com.sample.Filhåndtering;

import com.sample.Exception.InvalidProduktException;
import com.sample.ProduktData.Produkter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileOpner {
    ArrayList<Produkter> open (ArrayList <Produkter> produkter, Path filePath) throws IOException, InvalidProduktException;
}
