package zad2.instrukcje.zlozone;

import zad2.Program;
import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

import java.util.ArrayList;
import java.util.List;

public class Blok extends InstrukcjaZlozona {

    private List<Instrukcja> instrukcje;

    public Blok(ArrayList<Instrukcja> instrukcje) {
        super();
        this.instrukcje = instrukcje;
    }

    private String toStringReturn() {
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < instrukcje.size() - 1; i++)
            s.append(instrukcje.get(i).voidToString() + "\n");

        if(!instrukcje.isEmpty())
            s.append("return \n")
                    .append(instrukcje.get(instrukcje.size() - 1).wartoscToString() + ";");

        return s.toString();
    }

    @Override
    public void przydzielProgram(Program program) {
        this.program = program;
        for(Instrukcja i : instrukcje) {
            i.przydzielProgram(program);
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < instrukcje.size(); i++)
            s.append(instrukcje.get(i).voidToString() + (i == instrukcje.size() - 1 ? "" : "\n"));

        return s.toString();
    }

    @Override
    public String wartoscToString() {
        if(czyFunkcja)
            return nazwaFunkcji();
        else
            return toStringReturn();
    }

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {
        if(!instrukcje.isEmpty())
            instrukcje.get(instrukcje.size() - 1).zadeklarujJakoFunkcje();

        for(Instrukcja i : instrukcje) {
            i.deklarujPodrzedneWyrazeniaJakoFunkcje();
        }
    }

    @Override
    public double wykonaj() throws BladWykonania {
        double wynik = 0;

        for(Instrukcja i : instrukcje)
            wynik = i.wykonaj();

        return wynik;
    }

    @Override
    public String deklaracjaFunkcji() {
        StringBuilder s = new StringBuilder();

        s.append("private static double " + this.nazwaFunkcji() + " {\n")
         .append(this.toStringReturn() +"\n}");

        return s.toString();
    }
}
