package zad2.instrukcje.proste.jednoargumentowe;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.InstrukcjaProsta;

public abstract class InstrukcjaJednoargumentowa extends InstrukcjaProsta {

    protected transient String znakOperacji;
    protected Instrukcja argument;

    public InstrukcjaJednoargumentowa(Instrukcja argument) {
        this.argument = argument;
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        argument.zadeklarujJakoFunkcje();
        argument.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    @Override
    public String toString() {
        return znakOperacji + " " + argument.wartoscToString();
    }
}
