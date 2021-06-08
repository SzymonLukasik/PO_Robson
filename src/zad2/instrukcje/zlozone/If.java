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

        s.append("( " + warunek.wartoscToString() + " )")
         .append("? " + blok_prawda.toString() + "\n")
         .append(": " + blok_falsz.toString() + "\n");

        return s.toString();
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        warunek.zadeklarujJakoFunkcje();
        warunek.deklarujPodrzedneWyrazeniaJakoFunkcje();

        blok_prawda.zadeklarujJakoFunkcje();
        blok_prawda.deklarujPodrzedneWyrazeniaJakoFunkcje();

        blok_falsz.zadeklarujJakoFunkcje();
        blok_falsz.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    @Override
    public double wykonaj() throws BladWykonania {
        if(warunek.wartoscLogiczna())
            return blok_prawda.wykonaj();
        else
            return blok_falsz.wykonaj();
    }

    @Override
    public String deklaracjaFunkcji() {
        StringBuilder s = new StringBuilder();

        s.append(this.nazwaFunkcji() + " {\n")
                .append("\n return" + this + "\n");

        return s.toString();
    }
}
