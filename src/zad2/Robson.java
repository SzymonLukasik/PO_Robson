package zad2;

import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory;

import zad2.instrukcje.Instrukcja;
import zad2.instrukcje.bledy.BladWykonania;
import zad2.instrukcje.bledy.NieprawidlowyProgram;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class Robson {

    private Instrukcja instrukcja;
    private Program program;
    private JsonAdapter<Instrukcja> adapter;

    public Robson() {
        this.instrukcja = null;
        this.program = null;
        this.adapter = Instrukcja.moshi().adapter(Instrukcja.class);
    }

    public void fromJSON(String filename) throws NieprawidlowyProgram {

        File file = new File(filename);
        String jsonString = null;

        try (Scanner scanner = new Scanner(file)){
            scanner.useDelimiter("\\Z");
            jsonString = scanner.next();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            instrukcja = adapter.fromJson(jsonString);
            program = null;
        } catch (Exception e) {
            throw new NieprawidlowyProgram();
        }

    }

    public double wykonaj() throws BladWykonania {

        if(program == null) {
            program = new Program();
            instrukcja.przydzielProgram(program);
        }

        return instrukcja.wykonaj();
    }

    private void toFile(String filename, String content) {
        File file = new File(filename);

        try {
            file.createNewFile();

            FileWriter fileWriter = new FileWriter(file, false);
            fileWriter.write(content);
            fileWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }

    public void toJSON(String filename) {
        toFile(filename, adapter.indent(" ").toJson(instrukcja));
    }

    public void toJava(String filename) {

        String java_ext = ".java";

        try {
            if (!filename.endsWith(java_ext) || Character.isLowerCase(filename.toCharArray()[0]))
                throw new IOException();
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

        filename = filename.substring(0, filename.length() - ".java".length());

        StringBuilder s = new StringBuilder();

        instrukcja.deklarujPodrzedneWyrazeniaJakoFunkcje();
        instrukcja.zadeklarujJakoFunkcje();

        s.append("public class " + filename + " { \n\n")
         .append(program.zmienneToString() + "\n")
         .append(program.funkcjeToString() + "\n")
         .append("public static void main(String[] args) {\n")
         .append("System.out.println( "+ instrukcja.wartoscToString() + " );\n")
         .append("}\n}");

        toFile(filename + java_ext, s.toString());
    }

    public static void main(String[] args) {
        Robson robson = new Robson();

        File dir = new File("src/tests/inJSON");

        File[] inJSONs = dir.listFiles();

        for(File test : inJSONs) {

            try {
                robson.fromJSON(test.getPath());
            } catch (NieprawidlowyProgram e) {
                e.printStackTrace();
            }

            try {
                System.out.println(robson.wykonaj());
            } catch (BladWykonania e) {
                e.printStackTrace();
            }

            robson.toJSON("src/tests/outJSON/" + test.getName());

            String javaName = test.getName().substring(0, test.getName().length() - ".json".length());
            javaName = javaName.substring(0, 1).toUpperCase() + javaName.substring(1) + ".java";

            robson.toJava(javaName);

            File fileJava = new File(javaName);
            fileJava.renameTo(new File("src/tests/outJava/" + javaName));
        }
    }
}
