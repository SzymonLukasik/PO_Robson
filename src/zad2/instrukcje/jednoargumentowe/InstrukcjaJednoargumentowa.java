package zad2.instrukcje.jednoargumentowe;

import zad2.instrukcje.Instrukcja;

public abstract class InstrukcjaJednoargumentowa extends Instrukcja {

    protected String znakOperacji;
    protected Instrukcja argument;

    public InstrukcjaJednoargumentowa(Instrukcja argument) {
        this.argument = argument;
    }

    @Override
    public void eksportujDoFunkcjiGdyKonieczne() {
        argument.eksportujDoFunkcjiGdyKonieczne();
    }

    @Override
    public String wartoscToString() {
        return znakOperacji + " " + argument.wartoscToString();
    }
}
