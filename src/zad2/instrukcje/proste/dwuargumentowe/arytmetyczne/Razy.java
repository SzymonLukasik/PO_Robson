package zad2.instrukcje.proste.dwuargumentowe.arytmetyczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.dwuargumentowe.InstrukcjaDwuargumentowa;

public class Razy extends InstrukcjaDwuargumentowa {

    public Razy(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
        this.znakOperacji = "*";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return argument1.wykonaj() * argument2.wykonaj();
    }

    @Override
    public String voidToString() {
        return program.doubleDummyToString() + " = " + this;
    }
}
