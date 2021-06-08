package zad2.instrukcje.proste.inne;

import zad2.Program;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.InstrukcjaProsta;

public class False extends InstrukcjaProsta {

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {}

    @Override
    public double wykonaj() throws BladWykonania {
        return 0;
    }

    @Override
    public String toString() {
        return "false";
    }

    @Override
    public String voidToString() {
        return program.boolDummyToString() + " = " + this + ";";
    }



}
