package zad2.instrukcje.proste.inne;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;
import zad2.instrukcje.proste.jednoargumentowe.Not;
import zad2.instrukcje.zlozone.Blok;
import zad2.instrukcje.zlozone.InstrukcjaZlozona;

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

        s.append("( " + warunek.wartoscToString() + " )")
         .append("? " + blok_prawda.wartoscToString())
         .append(" : " + blok_falsz.wartoscToString());

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
    public String voidToString() {
        return program.doubleDummyToString() + " = " + this + ";";
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new If(Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
