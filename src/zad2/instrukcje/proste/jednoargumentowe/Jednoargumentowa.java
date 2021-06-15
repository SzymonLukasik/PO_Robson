package zad2.instrukcje.proste.jednoargumentowe;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.InstrukcjaProsta;

public abstract class Jednoargumentowa extends InstrukcjaProsta {
    protected Instrukcja argument;

    public Jednoargumentowa(Instrukcja argument) {
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
        argument.deklarujJakoFunkcje();
        argument.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }
}
