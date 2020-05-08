package com.sample.Validering;

import com.sample.Exception.InvalidKomponentException;
import com.sample.Exception.InvalidMerkeException;
import com.sample.Exception.InvalidPrisException;
import com.sample.Exception.InvalidTypeException;


import java.util.regex.Pattern;

public class Validering {
    public static void typeValidering(String type) throws InvalidTypeException {
        if (!Pattern.matches("^[a-zA-ZæøåÆØÅ. \\-]{2,20}$", type)) {
            throw new InvalidTypeException("Du må skrive inn gyldig navn");
        }
    }

    public static void KomponenentInputValidering(String komponenent) throws InvalidKomponentException {
        if (!Pattern.matches("[A-ZÅÆØ][a-zåæø]*", komponenent)) {
            throw new InvalidKomponentException("Feil navn format");
        }
    }
    public static void merkeInputValidering(String merke) throws InvalidMerkeException {
        if (!Pattern.matches("[A-ZÅÆØ][a-zåæø]* [A-ZÅÆØ][a-zåæø]*", merke)) {
            throw new InvalidMerkeException("Feil navn format");
        }
    }
        public static void prisValid (int pris) throws InvalidPrisException{
            if (pris < 0 || pris > 10000) {
                throw new InvalidPrisException("Ugyldig pris");
            }
        }

    }





