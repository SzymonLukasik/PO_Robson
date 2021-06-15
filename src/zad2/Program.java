package zad2;

import zad2.instrukcje.zlozone.InstrukcjaZlozona;
import zad2.instrukcje.proste.proste_double.Zmienna;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class Program {

    private Map<String, Double> zmienne;
    private ArrayList<InstrukcjaZlozona> funkcje;

    public Program() {
        this.zmienne = new TreeMap<>();
        this.funkcje = new ArrayList<>();
    }

    public void dodajZmienna(Zmienna z) {
        if(!zmienne.containsKey(z.nazwa()))
            zmienne.put(z.nazwa(), 0.);
    }

    public void dodajZmienna(String nazwa) {
        if(!zmienne.containsKey(nazwa))
            zmienne.put(nazwa, 0.);
    }

    public double przypiszZmiennejWartosc(String nazwa, Double wartosc) {
        zmienne.put(nazwa, wartosc);
        return wartosc;
    }

    public double dajWartoscZmiennej(String nazwa) {
        return zmienne.get(nazwa);
    }

    public int dodajFunkcje(InstrukcjaZlozona funkcja) {
        funkcje.add(funkcja);
        return funkcje.size() - 1;
    }

    public String boolDummyToString() {
        return "bool_dummy";
    }

    public String doubleDummyToString() {
        return "double_dummy";
    }

    public String zmienneToString() {
        StringBuilder s = new StringBuilder();

        s.append("private static boolean " + boolDummyToString() + " = false;\n")
         .append("private static double " + doubleDummyToString() + " = 0;\n");

        for(String zmienna : zmienne.keySet()) {
            s.append("private static double " + zmienna + " = 0;\n");
        }

        return s.toString();
    }

    public String funkcjeToString() {
        StringBuilder s = new StringBuilder();

        for(int i = 0; i < funkcje.size(); i++) {
            s.append(funkcje.get(i).deklaracjaFunkcjiToString() + "\n" + ((i == funkcje.size() - 1) ? "" : "\n"));
        }

        return s.toString();
    }
}
