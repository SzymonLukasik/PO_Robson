package zad2.instrukcje.zlozone;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

public class While extends InstrukcjaZlozona{

    private Instrukcja warunek;
    private Instrukcja blok;

    public While(Instrukcja warunek, Instrukcja blok) {
        super();
        this.warunek = warunek;
        this.blok = blok;
    }

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        warunek.przydzielProgram(program);
        blok.przydzielProgram(program);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("while ( " + warunek.wartoscToString() + " ) {\n")
         .append(blok.voidToString() + "\n}");

        return s.toString();
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        warunek.zadeklarujJakoFunkcje();
        warunek.deklarujPodrzedneWyrazeniaJakoFunkcje();

        blok.deklarujPodrzedneWyrazeniaJakoFunkcje();
    }

    @Override
    public double wykonaj() throws BladWykonania {
        while(warunek.wartoscLogiczna()) {
            blok.wykonaj();
        }
        return 0;
    }

    @Override
    public String deklaracjaFunkcji() {
        StringBuilder s = new StringBuilder();

        s.append("private static double " + this.nazwaFunkcji() + " {\n")
         .append(this)
         .append("\nreturn 0;\n}");

        return s.toString();
    }
}
