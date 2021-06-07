package zad2.instrukcje.proste;

import zad2.instrukcje.bledy.BladWykonania;

public class Liczba extends InstrukcjaProsta {

    private int wartosc;

    public Liczba(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return wartosc;
    }

    @Override
    public String toString() {
        return "" + wartosc;
    }
}
