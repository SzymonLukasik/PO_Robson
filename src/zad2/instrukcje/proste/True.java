package zad2.instrukcje.proste;

import zad2.instrukcje.bledy.BladWykonania;

public class True extends InstrukcjaProsta {

    @Override
    public double wykonaj() throws BladWykonania {
        return 1;
    }

    @Override
    public String toString() {
        return "true";
    }
}
