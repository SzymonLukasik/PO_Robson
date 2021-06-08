package zad2.instrukcje.proste.dwuargumentowe.logiczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.dwuargumentowe.InstrukcjaDwuargumentowa;

public class Or extends InstrukcjaDwuargumentowa {

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

    @Override
    public String voidToString() {
        return program.boolDummyToString() + " = " + this + ";";
    }
}
