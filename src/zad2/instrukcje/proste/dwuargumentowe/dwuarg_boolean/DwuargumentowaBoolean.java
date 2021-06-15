package zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.dwuargumentowe.Dwuargumentowa;

public abstract class DwuargumentowaBoolean extends Dwuargumentowa {
    public DwuargumentowaBoolean(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String wartoscLiczbowaToString() {
        return stringLogicznaNaLiczbe();
    }

    @Override
    public String wartoscLogicznaToString() {
        return toString();
    }

    @Override
    public String voidToString() {
        return dummyLogicznaToString();
    }
}
