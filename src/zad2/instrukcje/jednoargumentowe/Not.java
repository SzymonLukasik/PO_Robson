package zad2.instrukcje.jednoargumentowe;

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
}
