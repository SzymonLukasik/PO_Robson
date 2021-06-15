package zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.arytmetyczne;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.DwuargumentowaDouble;

public abstract class InstrukcjaArytmetyczna extends DwuargumentowaDouble {

    public InstrukcjaArytmetyczna(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String toString() {
        return "( " + argument1.wartoscLiczbowaToString() +
                " " + znakOperacji() + " " +
                argument2.wartoscLiczbowaToString() + " )";
    }
}
