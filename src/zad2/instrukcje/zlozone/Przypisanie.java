package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;

public class Przypisanie extends InstrukcjaZlozona{

    private String nazwa;
    private Instrukcja wartosc;

    public Przypisanie(String nazwa, Instrukcja wartosc) {
        this.nazwa = nazwa;
        this.wartosc = wartosc;
    }

    @Override
    public void eksportujDoFunkcjiGdyKonieczne() {
        this.zadeklarujJakoFunkcje();
        wartosc.eksportujDoFunkcjiGdyKonieczne();
    }

    @Override
    public double wykonaj() throws BladWykonania {
        return program.przypiszZmiennejWartosc(nazwa, wartosc.wykonaj());
    }

    @Override
    public String toString() {
        return nazwa + " = " + wartosc.wartoscToString();
    }
}
