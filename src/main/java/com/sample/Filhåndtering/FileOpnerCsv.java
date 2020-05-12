package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;
import com.sample.ProduktData.Produkter;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;

public class FileOpnerCsv implements FileOpner{

    @Override
    public ArrayList<Produkter> open(Path filePath) throws IOException {
        return null;
    }
}
