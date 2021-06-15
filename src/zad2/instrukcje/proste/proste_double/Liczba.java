package zad2.instrukcje.proste.proste_double;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;
import java.util.Random;

public class Liczba extends ProstaDouble {

    private int wartosc;

    public Liczba(int wartosc) {
        this.wartosc = wartosc;
    }

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
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

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Liczba(new Random().nextInt());
    };
}
