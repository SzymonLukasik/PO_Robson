package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

import java.util.ArrayList;

public class Blok extends InstrukcjaZlozona {

    private ArrayList<Instrukcja> instrukcje;

    public Blok(ArrayList<Instrukcja> instrukcje) {
        this.instrukcje = instrukcje;
    }

    @Override
    public void eksportujDoFunkcjiGdyKonieczne() {
        for(Instrukcja i : instrukcje) {
            i.eksportujDoFunkcjiGdyKonieczne();
        }
    }

    @Override
    public void eksportujJakoFunkcje() {

    }

    @Override
    public double wykonaj() throws BladWykonania {
        double wynik = 0;

        for(Instrukcja i : instrukcje)
            wynik = i.wykonaj();

        return wynik;
    }

    @Override
    public String wartoscToString() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(Instrukcja i : instrukcje)
            s.append(i);

        return s.toString();
    }

    @Override
    public void zadeklarujJakoFunkcje() {

    }

    @Override
    public String nazwaFunkcji() {
        return null;
    }
}
