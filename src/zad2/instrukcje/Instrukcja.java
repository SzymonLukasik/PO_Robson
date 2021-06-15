package zad2.instrukcje;

import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

import zad2.Program;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.arytmetyczne.Dzielenie;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.arytmetyczne.Minus;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.arytmetyczne.Plus;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_double.arytmetyczne.Razy;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.logiczne.And;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.logiczne.Or;
import zad2.instrukcje.proste.dwuargumentowe.dwuarg_boolean.porownania.*;
import zad2.instrukcje.proste.jednoargumentowe.jednoarg_boolean.Not;
import zad2.instrukcje.proste.proste_boolean.False;
import zad2.instrukcje.proste.proste_boolean.True;
import zad2.instrukcje.proste.proste_double.Liczba;
import zad2.instrukcje.proste.inne.Przypisanie;
import zad2.instrukcje.proste.proste_double.Zmienna;
import zad2.instrukcje.zlozone.Blok;
import zad2.instrukcje.proste.inne.If;
import zad2.instrukcje.zlozone.While;

import java.util.Random;

public abstract class Instrukcja {

    protected transient Program program;

    public boolean wartoscLogiczna() {
        return this.wykonaj() != 0.;
    }

    public abstract void przydzielProgram(Program program);

    public abstract void deklarujPodrzedneWyrazeniaJakoFunkcje();

    public abstract void deklarujJakoFunkcje();

    public abstract double wykonaj() throws BladWykonania;

    public abstract String wartoscLiczbowaToString();

    public abstract String wartoscLogicznaToString();

    public abstract String voidToString();

    protected String stringLogicznaNaLiczbe() {
        StringBuilder s = new StringBuilder();

        s.append("( " + wartoscLogicznaToString())
                .append(" ? 1" )
                .append(" : 0  )" );

        return s.toString();
    }

    protected String stringLiczbaNaLogiczna() {
        return "( " + wartoscLiczbowaToString() + " != 0 )";
    }

    protected String dummyLiczbaToString() {
        return program.doubleDummyToString() + " = " + wartoscLiczbowaToString() + ";";
    }

    protected String dummyLogicznaToString() {
        return program.boolDummyToString() + " = " + wartoscLogicznaToString() + ";";
    }

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


    public static Instrukcja dajLosowa(int glebokosc) {
        Random random = new Random();
        switch (random.nextInt(19)) {
            case 0 -> { return Blok.getRandom(glebokosc); }
            case 1 -> { return If.getRandom(glebokosc); }
            case 2 -> { return While.getRandom(glebokosc); }
            case 3 -> { return Przypisanie.getRandom(glebokosc); }
            case 4 -> { return Plus.getRandom(glebokosc); }
            case 5 -> { return Minus.getRandom(glebokosc); }
            case 6 -> { return Razy.getRandom(glebokosc); }
            // case 7 -> { return Dzielenie.getRandom(glebokosc); }
            case 7 -> { return And.getRandom(glebokosc); }
            case 8 -> { return Or.getRandom(glebokosc); }
            case 9 -> { return Mniejsze.getRandom(glebokosc); }
            case 10 -> { return Wieksze.getRandom(glebokosc); }
            case 11 -> { return MniejszeRowne.getRandom(glebokosc); }
            case 12 -> { return WiekszeRowne.getRandom(glebokosc); }
            case 13 -> { return Rowne.getRandom(glebokosc); }
            case 14 -> { return Not.getRandom(glebokosc); }
            case 15 -> { return Liczba.getRandom(glebokosc); }
            case 16 -> { return True.getRandom(glebokosc); }
            case 17 -> { return False.getRandom(glebokosc); }
            case 18 -> { return Zmienna.getRandom(glebokosc); }
            default -> {return null; }
        }
    }
}
