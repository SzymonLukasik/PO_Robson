package zad2.instrukcje.proste.jednoargumentowe;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

public class Not extends InstrukcjaJednoargumentowa {

    public Not(Instrukcja argument) {
        super(argument);
        this.znakOperacji = "!";
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return (! argument.wartoscLogiczna()) ? 1 : 0;
    }

    @Override
    public String voidToString() {
        return program.boolDummyToString() + " = " + this + ";";
    }
}
