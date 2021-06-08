package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

public class While extends InstrukcjaZlozona{

    private Instrukcja warunek;
    private Instrukcja blok;

    public While(Instrukcja warunek, Instrukcja blok) {
        this.warunek = warunek;
        this.blok = blok;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("while ( " + warunek.wartoscToString() + ") {\n")
         .append(blok.toString() + "\n}\n");

        return s.toString();
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        warunek.zadeklarujJakoFunkcje();
        warunek.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    @Override
    public double wykonaj() throws BladWykonania {
        while(warunek.wartoscLogiczna()) {
            blok.wykonaj();
        }
        return 0;
    }

    @Override
    public String deklaracjaFunkcji() {
        StringBuilder s = new StringBuilder();

        s.append(this.nazwaFunkcji() + " {\n")
         .append(this.toString())
         .append("\n return 0 \n}\n");

        return s.toString();
    }
}
