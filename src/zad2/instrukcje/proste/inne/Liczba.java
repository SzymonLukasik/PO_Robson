package zad2.instrukcje.proste.inne;

import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;

public class Liczba extends InstrukcjaProsta {

    private int wartosc;

    public Liczba(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {}

    @Override
    public double wykonaj() throws BladWykonania {
        return wartosc;
    }

    @Override
    public String toString() {
        return "" + wartosc;
    }

    @Override
    public String voidToString() {
        return program.doubleDummyToString() + " = " + this;
    }
}
