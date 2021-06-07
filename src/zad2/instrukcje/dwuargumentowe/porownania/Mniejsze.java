package zad2.instrukcje.dwuargumentowe.porownania;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.dwuargumentowe.InstrukcjaDwuargumentowa;

public class Mniejsze extends InstrukcjaDwuargumentowa {

    public Mniejsze(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
        this.znakOperacji = "<";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return (argument1.wykonaj() < argument2.wykonaj()) ? 1 : 0;
    }
}
