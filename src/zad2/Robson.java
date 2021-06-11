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
        this.program = new Program();
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
            program = new Program();
            instrukcja.przydzielProgram(program);

        } catch (Exception e) {
            throw new NieprawidlowyProgram();
        }

    }

    public double wykonaj() throws BladWykonania {
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

        s.append("package tests.outJava;\n\n") // UWAGA - USUNĄĆ??
         .append("public class " + filename + " { \n\n")
         .append(program.zmienneToString() + "\n")
         .append(program.funkcjeToString() + "\n")
         .append("public static void main(String[] args) {\n")
         .append("System.out.println( "+ instrukcja.wartoscToString() + " );\n")
         .append("}\n}");

        toFile(filename + java_ext, s.toString());
    }

    private static String executeJava(File file) {
        Scanner scanner = null;
        try {
            Process process = Runtime.getRuntime().exec("javac " + file.getPath());
            process.waitFor();
            process = Runtime.getRuntime().exec("java " + file.getPath());
            process.waitFor();
            scanner = new Scanner(process.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return scanner.nextLine();
    }

    private static void testujTests(String dirName) {
        Robson robson = new Robson();

        String testDir = "src/" + dirName + "/";

        File dir = new File(testDir + "inJSON");

        File[] inJSONs = dir.listFiles();

        for(File test : inJSONs) {

            try {
                robson.fromJSON(test.getPath());
                System.out.println(test.getPath());
            } catch (NieprawidlowyProgram e) {
                e.printStackTrace();
            }

            double wykonaj;
            try {
                wykonaj = robson.wykonaj();
                System.out.println(wykonaj);
            } catch (BladWykonania e) {
                e.printStackTrace();
            }

            robson.toJSON(testDir + "outJSON/" + test.getName());

            String javaName = test.getName().substring(0, test.getName().length() - ".json".length());
            javaName = javaName.substring(0, 1).toUpperCase() + javaName.substring(1) + ".java";

            robson.toJava(javaName);

            File fileJava = new File(javaName);
            fileJava.renameTo(new File(testDir + "outJava/" + javaName));
            fileJava = new File(testDir + "outJava/" + javaName);

            System.out.println(executeJava(fileJava));
        }
    }

    private static void testujRandom(int ile, int glebokosc) {
        Robson robson = new Robson();

        String testDir = "src/random_tests/";

        File dir = new File(testDir + "inJSON");

        File[] inJSONs = dir.listFiles();

        for(int i = 0; i < ile; i++) {

            File test = new File(testDir + "inJSON/" + "test" + i + ".json");

            robson.instrukcja = Instrukcja.dajLosowa(glebokosc);
            robson.instrukcja.przydzielProgram(robson.program);

            robson.toJSON(testDir + "inJSON/" + test.getName());

            double wykonaj;
            try {
                wykonaj = robson.wykonaj();
                System.out.println(wykonaj);
            } catch (BladWykonania e) {
                e.printStackTrace();
            }

            String javaName = test.getName().substring(0, test.getName().length() - ".json".length());
            javaName = javaName.substring(0, 1).toUpperCase() + javaName.substring(1) + ".java";

            System.out.println(javaName);
            robson.toJava(javaName);

            File fileJava = new File(javaName);
            fileJava.renameTo(new File(testDir + "outJava/" + javaName));
            fileJava = new File(testDir + "outJava/" + javaName);

            System.out.println(executeJava(fileJava));
        }
    }

    public static void main(String[] args) {
        testujTests("random_debug");
        //testujRandom(3, 5);
    }
}
