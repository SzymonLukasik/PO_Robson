package zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.logiczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;

public class Or extends InstrukcjaLogiczna {

    public Or(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    protected String znakOperacji() {
        return "||";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return (argument1.wartoscLogiczna() || argument2.wartoscLogiczna()) ? 1 : 0;
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Or(Instrukcja.dajLosowa(glebokosc - 1), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
