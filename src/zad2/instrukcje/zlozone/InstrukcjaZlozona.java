package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;

public abstract class InstrukcjaZlozona extends Instrukcja {

    protected transient boolean czyFunkcja;
    protected transient int nrFunkcji;

    public InstrukcjaZlozona() {
        czyFunkcja = false;
    }

    protected String nazwaFunkcji() {
        return "funkcja" + nrFunkcji + "()";
    }

    public abstract String deklaracjaFunkcjiToString();

    @Override
    public String wartoscLogicznaToString() {
        return stringLiczbaNaLogiczna();
    }

    @Override
    public void deklarujJakoFunkcje() {
        czyFunkcja = true;
        nrFunkcji = program.dodajFunkcje(this);
    }

    @Override
    public String wartoscLiczbowaToString() {
        if(czyFunkcja)
            return nazwaFunkcji();
        else
            return this.toString();
    }
}
