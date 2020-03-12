package cl.desafiolatam.passstrength.model;

import android.util.Log;

import androidx.annotation.VisibleForTesting;

public class Verifier {

    public static final int MIN_LENGTH = 5;

    public static final int WEAK = -1;
    public static final int MEDIUM = -2;
    public static final int STRONG = -3;
    public static final int VERY_STRONG = -4;


    public int evaluatePass(final String password) {
        if(!evaluateLength(password)) return WEAK;
        if(!evaluateUpper(password)) return MEDIUM;
        if(evaluateNumber(password) || !evaluateUpper(password) || !evaluateLength(password)) return VERY_STRONG;
        return STRONG;
    }

    @VisibleForTesting
    protected boolean evaluateLength(String password) {
        return password.length() > MIN_LENGTH;
    }

    @VisibleForTesting
    protected boolean evaluateUpper(final String password) {
        return !password.toLowerCase().equals(password);
    }

    protected boolean evaluateNumber(String password){

        for (int i = 0; i < password.length(); i++){
            char a = password.charAt(i);
            Log.i("letra", ""+ a);

            if (Character.isDigit(a)){
                Log.i("letra", "Verdadero");
                return true;
            }
        }
        return false;
    }
}
