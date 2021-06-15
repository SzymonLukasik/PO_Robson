package zad2.instrukcje.proste.dwuargumentowe;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.InstrukcjaProsta;

public abstract class Dwuargumentowa extends InstrukcjaProsta {

    protected Instrukcja argument1;
    protected Instrukcja argument2;

    public Dwuargumentowa(Instrukcja argument1, Instrukcja argument2) {
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
        argument1.deklarujJakoFunkcje();
        argument1.deklarujPodrzedneWyrazeniaJakoFunkcje();

        argument2.deklarujJakoFunkcje();
        argument2.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    protected abstract String znakOperacji();
}
