package zad2.instrukcje.dwuargumentowe.logiczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.dwuargumentowe.InstrukcjaDwuargumentowa;

public class And extends InstrukcjaDwuargumentowa {

    public And(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
        this.znakOperacji = "&&";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return (argument1.wartoscLogiczna() && argument2.wartoscLogiczna()) ? 1 : 0;
    }
}
