package zad2.instrukcje.zlozone;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.dwuargumentowe.arytmetyczne.Plus;
import zad2.instrukcje.proste.dwuargumentowe.porownania.MniejszeRowne;
import zad2.instrukcje.proste.inne.Liczba;
import zad2.instrukcje.proste.inne.Przypisanie;
import zad2.instrukcje.proste.inne.Zmienna;

import java.util.ArrayList;
import java.util.Random;

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

    @Override
    public String voidToString() {
        return toString();
    }


    private static Blok petla(int n) {

        if(n <= 0)
            return new Blok(new ArrayList<>());

        ArrayList<Instrukcja> instrukcje = new ArrayList<>();
        String zmienna = "zmienna" + new Random().nextInt();

        instrukcje.add(new Zmienna(zmienna));
        instrukcje.add(new Przypisanie(zmienna, new Plus(new Zmienna(zmienna), new Liczba(1))));
        instrukcje.add(new MniejszeRowne(new Zmienna(zmienna), new Liczba(n)));

        return new Blok(instrukcje);
    }
    public static Instrukcja getRandom(int glebokosc) {
        if(glebokosc == 0)
            return new Blok(new ArrayList<>());
        return new While(petla(4), Instrukcja.dajLosowa(glebokosc - 1));
    };
}
