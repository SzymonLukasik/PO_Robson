package zad2.instrukcje.proste.inne;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;
import zad2.instrukcje.proste.jednoargumentowe.Not;
import zad2.instrukcje.zlozone.Blok;
import zad2.instrukcje.zlozone.InstrukcjaZlozona;

import java.util.ArrayList;
import java.util.Random;

public class Przypisanie extends InstrukcjaProsta {

    private String nazwa;
    private Instrukcja wartosc;

    public Przypisanie(String nazwa, Instrukcja wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        wartosc.przydzielProgram(program);
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        wartosc.zadeklarujJakoFunkcje();
        wartosc.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return program.przypiszZmiennejWartosc(nazwa, wartosc.wykonaj());
    }

    @Override
    public String toString() {
        return nazwa + " = " + wartosc.wartoscToString();
    }

    @Override
    public String wartoscToString() {
        return "( " + this + " )";
    }

    @Override
    public String voidToString() {
        return this.toString() + ";";
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Przypisanie("zmienna" + new Random().nextInt(), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
