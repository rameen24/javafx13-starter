package com.sample.Validering;

import com.sample.Exception.InvalidKomponentException;
import com.sample.Exception.InvalidMerkeException;
import com.sample.Exception.InvalidPrisException;
import com.sample.Exception.InvalidTypeException;


import java.util.regex.Pattern;

public class Validering {
    public static void typeValidering(String type) throws InvalidTypeException {
        if (!Pattern.matches("[A-ZÅÆØ][a-zåæø]*", type)) {
            throw new InvalidTypeException("Du må skrive type i riktig");
        }
    }

    public static void KomponenentInputValidering(String komponenent) throws InvalidKomponentException {
        if (!Pattern.matches("[A-ZÅÆØ][a-zåæø]*", komponenent)) {
            throw new InvalidKomponentException("Feil format");
        }
    }
    public static void merkeInputValidering(String merke) throws InvalidMerkeException {
        if (!Pattern.matches("[A-ZÅÆØ][a-zåæø]*", merke)) {
            throw new InvalidMerkeException("Feil merke format");
        }
    }
        public static void prisValid (int pris) throws InvalidPrisException{
            if (pris < 0 || pris > 50_000) {
                throw new InvalidPrisException("Ugyldig pris");
            }
        }

    }





