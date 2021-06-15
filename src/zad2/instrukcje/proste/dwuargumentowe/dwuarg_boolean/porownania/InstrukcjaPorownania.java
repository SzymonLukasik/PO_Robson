package zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.porownania;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.DwuargumentowaBoolean;

public abstract class InstrukcjaPorownania extends DwuargumentowaBoolean {

    public InstrukcjaPorownania(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String toString() {
        return "( " + argument1.wartoscLiczbowaToString() +
                " " + znakOperacji() + " " +
                argument2.wartoscLiczbowaToString() + " )";
    }
}
