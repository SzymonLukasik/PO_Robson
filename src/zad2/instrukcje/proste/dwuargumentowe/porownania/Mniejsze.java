package zad2.instrukcje.proste.dwuargumentowe.porownania;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.dwuargumentowe.Dwuargumentowa;
import zad2.instrukcje.proste.dwuargumentowe.DwuargumentowaDouble;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;

public class Mniejsze extends DwuargumentowaDouble {

    public Mniejsze(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    protected String znakOperacji() {
        return "<";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return (argument1.wykonaj() < argument2.wykonaj()) ? 1 : 0;
    }

    @Override
    public String voidToString() {
        return program.boolDummyToString() + " = " + this + ";";
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Mniejsze(Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
