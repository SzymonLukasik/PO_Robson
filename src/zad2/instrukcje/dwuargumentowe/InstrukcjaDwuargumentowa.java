package zad2.instrukcje.dwuargumentowe;

import zad2.instrukcje.Instrukcja;

public abstract class InstrukcjaDwuargumentowa extends Instrukcja {

    protected transient String znakOperacji;
    protected Instrukcja argument1;
    protected Instrukcja argument2;

    public InstrukcjaDwuargumentowa(Instrukcja argument1, Instrukcja argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    @Override
    public void eksportujDoFunkcjiGdyKonieczne() {
        argument1.eksportujDoFunkcjiGdyKonieczne();
        argument2.eksportujDoFunkcjiGdyKonieczne();
    }

    @Override
    public String wartoscToString() {
        return "( " + argument1.wartoscToString() +
                " " + znakOperacji + " " +
                argument2.wartoscToString() + " )";
    }
}
