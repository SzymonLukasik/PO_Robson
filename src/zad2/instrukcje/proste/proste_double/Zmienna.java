package zad2.instrukcje.proste.proste_double;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;
import java.util.Random;

public class Zmienna extends ProstaDouble {

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

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new Zmienna("zmienna" + new Random().nextInt(5));
    };
}
