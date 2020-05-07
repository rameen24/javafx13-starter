package com.sample.Filhåndtering;

import com.sample.Data.Datamaskin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class FileSaverCsv implements FileSaver{
    @Override
    public void save(Datamaskin registry, String filePath) throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("FileWriter");
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter
                ("Komma separerte verdier", "*.csv"));

        Stage stage = new Stage();
        stage.setX(250);
        stage.setY(200);

        File file = fc.showSaveDialog(stage);
        File enfile = new File(file.getAbsolutePath());

        FileWriter fileWriter = new FileWriter(enfile);
        fileWriter.write(registry.toString());
        fileWriter.close();

    }
}
