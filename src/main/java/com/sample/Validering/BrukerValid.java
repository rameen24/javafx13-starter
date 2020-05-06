package com.sample.Validering;

import com.sample.Exception.InvalidMerkeException;


import java.util.regex.Pattern;

public class BrukerValid {
    public static void navnValidering(String navn)  throws InvalidMerkeException {
        if(!Pattern.matches("^[a-zA-ZæøåÆØÅ. \\-]{2,20}$",navn)){
            throw new InvalidMerkeException("Du må skrive inn gyldig navn");
        }

    }



}

