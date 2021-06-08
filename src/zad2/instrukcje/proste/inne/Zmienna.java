package zad2.instrukcje.proste.inne;

import zad2.Program;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;

public class Zmienna extends InstrukcjaProsta {

    private String nazwa;

    public Zmienna(String nazwa) {
        this.nazwa = nazwa;
    }

    public String nazwa() {
        return nazwa;
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {}

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        program.dodajZmienna(this);
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return program.dajWartoscZmiennej(nazwa);
    }

    @Override
    public String toString() {
        return nazwa;
    }

    @Override
    public String voidToString() {
        return program.doubleDummyToString() + " = " + this + ";";
    }
}
