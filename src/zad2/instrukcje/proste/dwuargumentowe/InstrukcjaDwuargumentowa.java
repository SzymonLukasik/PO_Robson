package zad2.instrukcje.proste.dwuargumentowe;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.InstrukcjaProsta;

public abstract class InstrukcjaDwuargumentowa extends InstrukcjaProsta {

    protected Instrukcja argument1;
    protected Instrukcja argument2;

    public InstrukcjaDwuargumentowa(Instrukcja argument1, Instrukcja argument2) {
        this.argument1 = argument1;
        this.argument2 = argument2;
    }

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        argument1.przydzielProgram(program);
        argument2.przydzielProgram(program);
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        argument1.zadeklarujJakoFunkcje();
        argument1.deklarujPodrzedneWyrazeniaJakoFunkcje();

        argument2.zadeklarujJakoFunkcje();
        argument2.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    protected abstract String znakOperacji();

    @Override
    public String toString() {
        return "( " + argument1.wartoscToString() +
                " " + znakOperacji() + " " +
                argument2.wartoscToString() + " )";
    }
}
