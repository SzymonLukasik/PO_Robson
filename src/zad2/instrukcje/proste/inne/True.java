package zad2.instrukcje.proste.inne;

import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;

public class True extends InstrukcjaProsta {

    @Override
    public double wykonaj() throws BladWykonania {
        return 1;
    }

    @Override
    public String toString() {
        return "true";
    }

    @Override
    public String voidToString() {
        return program.boolDummyToString() + " = " + this;
    }
}