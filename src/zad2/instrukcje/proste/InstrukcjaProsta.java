package zad2.instrukcje.proste;

import zad2.instrukcje.Instrukcja;

public abstract class InstrukcjaProsta extends Instrukcja {

    @Override
    public void deklarujPodrzedneWyrazeniaJakoFunkcje() {}

    @Override
    public void zadeklarujJakoFunkcje() {}

    @Override
    public String wartoscToString() {
        return toString();
    }
}
