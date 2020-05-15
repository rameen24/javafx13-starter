package com.sample.Filhåndtering;

import com.sample.Exception.InvalidProduktException;
import com.sample.ProduktData.Produkter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public interface FileSaver {
     void save(ArrayList<Produkter> produkter, File filePath) throws IOException;
}
