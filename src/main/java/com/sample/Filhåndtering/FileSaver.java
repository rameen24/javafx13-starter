package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;

import java.io.IOException;
import java.nio.file.Path;

public interface FileSaver {
    void save(Datamaskin registry, Path filePath) throws IOException;
}
