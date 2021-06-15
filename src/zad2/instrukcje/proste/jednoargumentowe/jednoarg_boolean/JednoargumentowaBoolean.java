package zad2.instrukcje.proste.jednoargumentowe.jednoarg_boolean;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.proste.jednoargumentowe.Jednoargumentowa;

public abstract class JednoargumentowaBoolean extends Jednoargumentowa {

    public JednoargumentowaBoolean(Instrukcja argument) {
        super(argument);
    }

    @Override
    public String wartoscLiczbowaToString() {
        return stringLogicznaNaLiczbe();
    }

    @Override
    public String wartoscLogicznaToString() {
        return toString();
    }


    @Override
    public String voidToString() {
        return dummyLogicznaToString();
    }
}
