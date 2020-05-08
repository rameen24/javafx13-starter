package com.sample.Data;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.io.Serializable;

public class Produkter implements Serializable {
    private transient SimpleStringProperty komponenet;
    private transient SimpleStringProperty merke;
    private transient SimpleStringProperty type;
    private transient SimpleIntegerProperty pris;

    public Produkter(){
    }


    public Produkter(String type, String merke, int pris, String komponenet) {
        this.komponenet = new SimpleStringProperty(komponenet);
        this.merke = new SimpleStringProperty(merke);
        this.type = new SimpleStringProperty(type);
        this.pris = new SimpleIntegerProperty(pris); }

    public String getKomponenet() {
        return komponenet.get();
    }

    public SimpleStringProperty komponenetProperty() {
        return komponenet;
    }

    public void setKomponenet(String komponenet) {
        this.komponenet.set(komponenet);
    }

    public String getMerke() {
        return merke.get();
    }

    public SimpleStringProperty merkeProperty() {
        return merke;
    }

    public void setMerke(String merke) {
        this.merke.set(merke);
    }

    public String getType() {
        return type.get();
    }

    public SimpleStringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public int getPris() {
        return pris.get();
    }

    public SimpleIntegerProperty prisProperty() {
        return pris;
    }

    public void setPris(int pris) {
        if(pris < 0) {
            throw new IllegalArgumentException("intData cannot be negative");
        }
        this.pris.set(pris);
    }
}
