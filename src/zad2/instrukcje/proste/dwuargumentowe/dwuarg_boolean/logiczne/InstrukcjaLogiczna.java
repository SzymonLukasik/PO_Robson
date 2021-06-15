package zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.logiczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.DwuargumentowaBoolean;

public abstract class InstrukcjaLogiczna extends DwuargumentowaBoolean {

    public InstrukcjaLogiczna(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String toString() {
        return "( " + argument1.wartoscLogicznaToString() +
                " " + znakOperacji() + " " +
                argument2.wartoscLogicznaToString() + " )";
    }
}
