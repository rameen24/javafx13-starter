package com.sample.Validering;

import com.sample.Exception.InvalidBrukerException;
import com.sample.Exception.InvalidPasswordException;
import com.sample.Exception.InvalidBrukernavnException;
import com.sample.Exception.InvalidEpostException;


import java.util.regex.Pattern;

public class BrukerValid {
    public static void navnValidering(String navn)  throws InvalidBrukerException {
        if(!Pattern.matches("^[a-zA-ZæøåÆØÅ. \\-]{2,20}$",navn)){
            throw new InvalidBrukerException("Du må skrive inn gyldig navn");
        }

    }



}

