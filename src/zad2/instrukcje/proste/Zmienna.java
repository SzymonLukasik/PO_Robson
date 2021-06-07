package zad2.instrukcje.proste;

import zad2.Program;
import zad2.instrukcje.bledy.BladWykonania;

public class Zmienna extends InstrukcjaProsta{

    private String nazwa;

    public Zmienna(String nazwa) {
        this.nazwa = nazwa;
    }

    public String nazwa() {
        return nazwa;
    }

    @Override
    public void przydzielProgram(Program program) {
        super.przydzielProgram(program);
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
}
