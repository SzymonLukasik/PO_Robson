package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

public class If extends InstrukcjaZlozona {

    private Instrukcja warunek;
    private Instrukcja blok_prawda;
    private Instrukcja blok_falsz;

    public If(Instrukcja warunek, Instrukcja blok_prawda, Instrukcja blok_falsz) {
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("if ( " + )
    }

    @Override
    public void eksportujDoFunkcjiGdyKonieczne() {
        this.zadeklarujJakoFunkcje();
        war
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return 0;
    }

    @Override
    public String wartoscToString() {
        return null;
    }

    @Override
    public void zadeklarujJakoFunkcje() {

    }

    @Override
    public String nazwaFunkcji() {
        return null;
    }
}
