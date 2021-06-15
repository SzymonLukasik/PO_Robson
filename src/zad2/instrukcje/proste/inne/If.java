package zad2.instrukcje.proste.inne;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;

public class If extends InstrukcjaProsta {

    private Instrukcja warunek;
    private Instrukcja blok_prawda;
    private Instrukcja blok_falsz;

    public If(Instrukcja warunek, Instrukcja blok_prawda, Instrukcja blok_falsz) {
        super();
        this.warunek = warunek;
        this.blok_prawda = blok_prawda;
        this.blok_falsz = blok_falsz;
    }

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        warunek.przydzielProgram(program);
        blok_prawda.przydzielProgram(program);
        blok_falsz.przydzielProgram(program);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("( " + warunek.wartoscLogicznaToString())
         .append(" ? " + blok_prawda.wartoscLiczbowaToString())
         .append(" : " + blok_falsz.wartoscLiczbowaToString() + " )");

        return s.toString();
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        warunek.deklarujJakoFunkcje();
        warunek.deklarujPodrzedneWyrazeniaJakoFunkcje();

        blok_prawda.deklarujJakoFunkcje();
        blok_prawda.deklarujPodrzedneWyrazeniaJakoFunkcje();

        blok_falsz.deklarujJakoFunkcje();
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
    public String wartoscLiczbowaToString() {
        return toString();
    }

    @Override
    public String wartoscLogicznaToString() {
        return stringLiczbaNaLogiczna();
    }

    @Override
    public String voidToString() {
        StringBuilder s = new StringBuilder();

        s.append("if ( " + warunek.wartoscLogicznaToString() + " ) {\n")
                .append(blok_prawda.voidToString() + "\n} else {\n")
                .append(blok_falsz.voidToString() + "\n}");

        return s.toString();
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new If(Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
