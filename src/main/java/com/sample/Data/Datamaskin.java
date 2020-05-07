package com.sample.Data;

import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Datamaskin implements Serializable {
    private SimpleStringProperty prosessor;
    private SimpleStringProperty skjermkort;
    private SimpleStringProperty minne;
    private SimpleStringProperty harddisk;
    private SimpleStringProperty tastatur;
    private SimpleStringProperty mus;
    private SimpleStringProperty skjerm;

    public  Datamaskin(){

    }

    public Datamaskin(SimpleStringProperty prosessor, SimpleStringProperty skjermkort, SimpleStringProperty minne,
                      SimpleStringProperty harddisk, SimpleStringProperty tastatur, SimpleStringProperty mus,
                      SimpleStringProperty skjerm) {
        this.prosessor = prosessor;
        this.skjermkort = skjermkort;
        this.minne = minne;
        this.harddisk = harddisk;
        this.tastatur = tastatur;
        this.mus = mus;
        this.skjerm = skjerm;
    }

    public String getProsessor() {
        return prosessor.get();
    }

    public SimpleStringProperty prosessorProperty() {
        return prosessor;
    }

    public void setProsessor(String prosessor) {
        this.prosessor.set(prosessor);
    }

    public String getSkjermkort() {
        return skjermkort.get();
    }

    public SimpleStringProperty skjermkortProperty() {
        return skjermkort;
    }

    public void setSkjermkort(String skjermkort) {
        this.skjermkort.set(skjermkort);
    }

    public String getMinne() {
        return minne.get();
    }

    public SimpleStringProperty minneProperty() {
        return minne;
    }

    public void setMinne(String minne) {
        this.minne.set(minne);
    }

    public String getHarddisk() {
        return harddisk.get();
    }

    public SimpleStringProperty harddiskProperty() {
        return harddisk;
    }

    public void setHarddisk(String harddisk) {
        this.harddisk.set(harddisk);
    }

    public String getTastatur() {
        return tastatur.get();
    }

    public SimpleStringProperty tastaturProperty() {
        return tastatur;
    }

    public void setTastatur(String tastatur) {
        this.tastatur.set(tastatur);
    }

    public String getMus() {
        return mus.get();
    }

    public SimpleStringProperty musProperty() {
        return mus;
    }

    public void setMus(String mus) {
        this.mus.set(mus);
    }

    public String getSkjerm() {
        return skjerm.get();
    }

    public SimpleStringProperty skjermProperty() {
        return skjerm;
    }

    public void setSkjerm(String skjerm) {
        this.skjerm.set(skjerm);
    }


}
