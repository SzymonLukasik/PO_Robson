package zad2;

import zad2.instrukcje.zlozone.InstrukcjaZlozona;
import zad2.instrukcje.proste.Zmienna;

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
        zmienne.put(z.nazwa(), 0.);
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
}
