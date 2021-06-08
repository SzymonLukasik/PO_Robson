package zad2.instrukcje;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;
import moshi_przyklad.EmptyNode;
import moshi_przyklad.FullNode;

import zad2.Program;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.dwuargumentowe.arytmetyczne.Dzielenie;
import zad2.instrukcje.proste.dwuargumentowe.arytmetyczne.Minus;
import zad2.instrukcje.proste.dwuargumentowe.arytmetyczne.Plus;
import zad2.instrukcje.proste.dwuargumentowe.arytmetyczne.Razy;
import zad2.instrukcje.proste.dwuargumentowe.logiczne.And;
import zad2.instrukcje.proste.dwuargumentowe.logiczne.Or;
import zad2.instrukcje.proste.dwuargumentowe.porownania.*;
import zad2.instrukcje.proste.inne.*;
import zad2.instrukcje.proste.jednoargumentowe.Not;
import zad2.instrukcje.zlozone.Blok;
import zad2.instrukcje.zlozone.If;
import zad2.instrukcje.zlozone.While;

public abstract class Instrukcja {

    protected transient Program program;

    public void przydzielProgram(Program program) {
        this.program = program;
    }

    public boolean wartoscLogiczna() {
        return this.wykonaj() == 1.;
    }

    public abstract void deklarujPodrzedneWyrazeniaJakoFunkcje();

    public abstract void zadeklarujJakoFunkcje();

    public abstract double wykonaj() throws BladWykonania;

    public abstract String wartoscToString();

    public abstract String voidToString();

    public static Moshi moshi() {
         return new Moshi.Builder()
                .add(
                        PolymorphicJsonAdapterFactory.of(Instrukcja.class, "typ")
                                .withSubtype(Blok.class, "Blok")
                                .withSubtype(If.class, "If")
                                .withSubtype(While.class, "While")
                                .withSubtype(Przypisanie.class, "Przypisanie")
                                .withSubtype(Plus.class, "Plus")
                                .withSubtype(Minus.class, "Minus")
                                .withSubtype(Razy.class, "Razy")
                                .withSubtype(Dzielenie.class, "Dzielenie")
                                .withSubtype(And.class, "And")
                                .withSubtype(Or.class, "Or")
                                .withSubtype(Mniejsze.class, "<")
                                .withSubtype(Wieksze.class, ">")
                                .withSubtype(MniejszeRowne.class, "<=")
                                .withSubtype(WiekszeRowne.class, ">=")
                                .withSubtype(Rowne.class, "==")
                                .withSubtype(Not.class, "Not")
                                .withSubtype(Liczba.class, "Liczba")
                                .withSubtype(True.class, "True")
                                .withSubtype(False.class, "False")
                                .withSubtype(Zmienna.class, "Zmienna")

                )
                .build();
    }
}
