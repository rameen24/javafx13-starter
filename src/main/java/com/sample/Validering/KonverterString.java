package com.sample.Validering;

import com.sample.Avvik.Avvik;

public class KonverterString extends javafx.util.converter.IntegerStringConverter  {
    private boolean conversionSuccessful;

    @Override
    public Integer fromString(String s) {
        try {
            Integer result = super.fromString(s);
            conversionSuccessful = true;
            return result;
        } catch(NumberFormatException e) {
            Avvik.showErrorDialog("Du må skrive inn et gyldig tall.");
            conversionSuccessful = false;
            return 0;
        }
    }

    public boolean wasSuccessful() {
        return conversionSuccessful;
    }
}
