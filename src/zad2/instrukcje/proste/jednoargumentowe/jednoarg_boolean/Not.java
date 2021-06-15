package zad2.instrukcje.proste.jednoargumentowe.jednoarg_boolean;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;

public class Not extends JednoargumentowaBoolean {

    public Not(Instrukcja argument) {
        super(argument);
    }

    @Override
    protected String znakOperacji() {
        return "!";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return (! argument.wartoscLogiczna()) ? 1 : 0;
    }

    @Override
    public String toString() {
        return znakOperacji() + " " + argument.wartoscLogicznaToString();
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Not(Instrukcja.dajLosowa(glebokosc - 1));
    };


}
