package zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.arytmetyczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;

public class Plus extends InstrukcjaArytmetyczna {

    public Plus(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    protected String znakOperacji() {
        return "+";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return argument1.wykonaj() + argument2.wykonaj();
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Plus(Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
