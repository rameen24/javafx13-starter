package com.sample.Validering;
import com.sample.Avvik.Avvik;

public class KonverterInterger {
    public static class Konverter extends javafx.util.converter.IntegerStringConverter {

        public static boolean conversionSuccessful = true;

        @Override
        public Integer fromString(String s) {
            try {
                Integer result = super.fromString(s);
                conversionSuccessful = true;
                return result;
            } catch (NumberFormatException e) {
                Avvik.showErrorDialog("Du må taste inn et gyldig tall!");

                conversionSuccessful = false;
                return 0;
            }
        }
    }

}