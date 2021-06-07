package zad2.instrukcje.proste;

import zad2.instrukcje.bledy.BladWykonania;

public class False extends InstrukcjaProsta{
    @Override
    public double wykonaj() throws BladWykonania {
        return 0;
    }

    @Override
    public String toString() {
        return "false";
    }
}
