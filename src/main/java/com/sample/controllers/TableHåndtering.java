package com.sample.controllers;

import com.sample.Avvik.Avvik;

public class TableHåndtering {
    public boolean typeCell(String newValue){
        if(newValue.isEmpty()){ return false; }
        return Avvik.typeValid(newValue);
    }
    public boolean komponentCell(String newValue){
        if(newValue.isEmpty()){ return false; }
        return Avvik.komponentValid(newValue);
    }
    public boolean merkCell(String newValue){
        if(newValue.isEmpty()){ return false; }
        return Avvik.merkeValid(newValue);
    }
}
