package zad2.instrukcje;

import zad2.Program;
import zad2.instrukcje.bledy.BladWykonania;

public abstract class Instrukcja {

    protected transient Program program;

    public void przydzielProgram(Program program) {
        this.program = program;
    }

    public boolean wartoscLogiczna() {
        return this.wykonaj() == 1.;
    }

    public abstract void eksportujDoFunkcjiGdyKonieczne();

    public abstract double wykonaj() throws BladWykonania;

    public abstract String wartoscToString();
}
