package zad2.instrukcje.proste.dwuargumentowe;

import zad2.instrukcje.Instrukcja;

public abstract class DwuargumentowaBoolean extends Dwuargumentowa{
    public DwuargumentowaBoolean(Instrukcja argument1, Instrukcja argument2) {
        super(argument1, argument2);
    }

    @Override
    public String toString() {
        return "( " + argument1.wartoscLogicznaToString() +
                " " + znakOperacji() + " " +
                argument2.wartoscLogicznaToString() + " )";
    }
}
