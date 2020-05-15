package com.sample.Filhåndtering;


import javafx.concurrent.Task;
import javafx.scene.control.Alert;

import java.io.*;

public class ThreadHåndtering extends Task<FileReader> {

    private String path;

    public ThreadHåndtering(String path) {
        this.path = path;
    }

    @Override
        public FileReader call() throws InterruptedException {
            FileReader fileReader = null;
            try {
                fileReader = new FileReader(path);
                Thread.sleep(500);
            }

            catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return fileReader;

        }
    }

