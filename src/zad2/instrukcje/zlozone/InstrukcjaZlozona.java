package zad2.instrukcje.zlozone;

import zad2.instrukcje.Instrukcja;

public abstract class InstrukcjaZlozona extends Instrukcja {

    protected transient boolean czyFunkcja;
    protected transient int nrFunkcji;

    public void zadeklarujJakoFunkcje() {
        nrFunkcji = program.dodajFunkcje(this);
    }

    @Override
    public String wartoscToString() {
        if(czyFunkcja)
            return "funkcja" + nrFunkcji + "()";
        else
            return this.toString();
    }
}
