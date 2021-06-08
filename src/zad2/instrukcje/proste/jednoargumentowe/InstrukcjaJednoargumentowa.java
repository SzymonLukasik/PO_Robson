package zad2.instrukcje.proste.jednoargumentowe;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.InstrukcjaProsta;

public abstract class InstrukcjaJednoargumentowa extends InstrukcjaProsta {

    protected Instrukcja argument;

    public InstrukcjaJednoargumentowa(Instrukcja argument) {
        this.argument = argument;
    }

    protected abstract String znakOperacji();

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        argument.przydzielProgram(program);
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        argument.zadeklarujJakoFunkcje();
        argument.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    @Override
    public String toString() {
        return znakOperacji() + " " + argument.wartoscToString();
    }
}
