package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;

public abstract class InstrukcjaZlozona extends Instrukcja {

    protected transient boolean czyFunkcja;
    protected transient int nrFunkcji;


    protected String nazwaFunkcji() {
        return "funkcja" + nrFunkcji + "()";
    }

    public abstract String deklaracjaFunkcji();

    @Override
    public void zadeklarujJakoFunkcje() {
        nrFunkcji = program.dodajFunkcje(this);
    }

    @Override
    public String wartoscToString() {
        if(czyFunkcja)
            return nazwaFunkcji();
        else
            return this.toString();
    }

    @Override
    public String voidToString() {
        return toString();
    }
}
