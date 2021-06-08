package zad2;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.bledy.NieprawidlowyProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Robson {

    private Instrukcja instrukcja;
    private Program program;

    public Robson() {
        this.instrukcja = null;
        this.program = null;
    }

    void fromJSON(String filename) throws NieprawidlowyProgram {

        JsonAdapter<Instrukcja> adapter = Instrukcja.moshi().adapter(Instrukcja.class);

        File file = new File(filename);
        String jsonString = null;
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\\Z");
            jsonString = scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            instrukcja = adapter.fromJson(jsonString);
        } catch (Exception e) {
            throw new NieprawidlowyProgram();
        }

    }

    double wykonaj() throws BladWykonania {
        return instrukcja.wykonaj();
    }

    public static void main(String[] args) {
        Robson robson = new Robson();

        try {
            robson.fromJSON("przyklad2");
        } catch (NieprawidlowyProgram e) {
            e.printStackTrace();
        }

        try {
            System.out.println(robson.wykonaj());
        } catch (BladWykonania e) {
            e.printStackTrace();
        }
    }
}
