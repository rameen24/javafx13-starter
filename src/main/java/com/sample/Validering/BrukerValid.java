package com.sample.Validering;

import com.sample.Exception.InvalidBrukerException;
import com.sample.Exception.InvalidPasswordException;
import com.sample.Exception.InvalidBrukernavnException;
import com.sample.Exception.InvalidEpostException;


import java.util.regex.Pattern;

public class BrukerValid {
    public static void navnValidering(String navn)  throws InvalidBrukerException {
        if(!Pattern.matches("[A-ZÅÆØ][a-zåæø]* [A-ZÅÆØ][a-zåæø]*",navn)){
            throw new InvalidBrukerException("Du må skrive inn gyldig navn");
        }

    }
    public static void epostValidering(String epost) throws InvalidEpostException{
        if(!Pattern.matches("^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+" +
                "[a-zA-Z]{2,6}$", epost)){
            throw new InvalidEpostException("Du må skrive inn gydlig epost");
        }
    }
    public static void brukernavnValidering(String brukernavn) throws InvalidBrukernavnException{
        if(!Pattern.matches("^[a-zA-Z0-9](_(?![_.])|\\.(?![_.])|[a-zA-Z0-9]){6,18}[a-zA-Z0-9]$", brukernavn)){
            throw new InvalidBrukernavnException("Du må skrive inn gyldig brukernavn");
        }
    }
    public static void passwordValidering(String password) throws InvalidPasswordException{

    }


}

