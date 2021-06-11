package zad2.instrukcje.proste.dwuargumentowe;

import zad2.instrukcje.Instrukcja;

public abstract class DwuargumentowaDouble extends Dwuargumentowa {

    public DwuargumentowaDouble(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String toString() {
        return "( " + argument1.wartoscToString() +
                " " + znakOperacji() + " " +
                argument2.wartoscToString() + " )";
    }
}
