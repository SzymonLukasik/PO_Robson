package zad2.instrukcje.proste.inne;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;
import zad2.instrukcje.proste.jednoargumentowe.Not;
import zad2.instrukcje.zlozone.Blok;

import java.util.ArrayList;

public class True extends InstrukcjaProsta {

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {}

    @Override
    public double wykonaj() throws BladWykonania {
        return 1;
    }

    @Override
    public String toString() {
        return "true";
    }

    @Override
    public String voidToString() {
        return program.boolDummyToString() + " = " + this + ";";
    }

    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());

        return new True();
    };
}
