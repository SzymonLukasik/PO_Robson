package zad2.instrukcje.proste.dwuargumentowe.dwuarg_double;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.dwuargumentowe.Dwuargumentowa;

public abstract class DwuargumentowaDouble extends Dwuargumentowa {

    public DwuargumentowaDouble(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String wartoscLiczbowaToString() {
        return toString();
    }

    @Override
    public String wartoscLogicznaToString() {
        return stringLiczbaNaLogiczna();
    }

    @Override
    public String voidToString() {
        return dummyLiczbaToString();
    }

}
