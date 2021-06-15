package zad2.instrukcje.proste.proste_double;

import zad2.instrukcje.proste.InstrukcjaProsta;

public abstract class ProstaDouble extends InstrukcjaProsta {

    @Override
    public String wartoscLiczbowaToString() {
        return toString();
    }

    @Override
    public String wartoscLogicznaToString() {
        return stringLiczbaNaLogiczna();
    }

    @Override
    public String voidToString() {
        return "";
    }
}
