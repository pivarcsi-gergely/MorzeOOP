package hu.petrik.morzeoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static HashMap<String, String> morzeAbcReversed;
    public static HashMap<String, String> morzeAbc;
    public static HashMap<String, String> morzeIdezetek;
    public static HashMap<String, String> kodoltMorzeIdezetek;
    public static String searchKar;

    public static void main(String[] args) {
        BeolvasABC();
        KiirABC();
        System.out.println("3. feladat: A morze abc " + morzeAbc.size() + " db karakter kódját tartalmazza.");
        bekertKarMorzekodja();
        BeolvasIdezet();
        System.out.println("7. feladat: Az első idézet szerzője: " + MorzeToSzoveg(".-   .-.   ..   ...   --..   -   ---   -   .   .-..   ..-..   ...   --.."));
    }

    public static void BeolvasABC() {
        morzeAbc = new HashMap<>();
        morzeAbcReversed = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("morzeabc.txt"));
            String[] szavak = br.readLine().split(";");
            String sor = br.readLine();
            while (sor != null){
                String[] st = sor.split("\\t", -1);
                String betu = st[0];
                String morzeJel = st[1];
                morzeAbc.put(betu, morzeJel);
                morzeAbcReversed.put(morzeJel, betu);
                sor = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public static void KiirABC() {
        for (Map.Entry<String, String> entry : morzeAbc.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public static void bekertKarMorzekodja() {
        System.out.print("4. feladat: Kérek egy karaktert: ");
        Scanner sc = new Scanner(System.in);
        searchKar = sc.nextLine();
        if (morzeAbc.containsKey(searchKar)){
            System.out.println("A " + searchKar + " karakter morze kódja: " + morzeAbc.get(searchKar));
        }
        else {
            System.out.println("Nem található a kódtárban ilyen karakter!");
        }
    }

    public static void BeolvasIdezet() {
        morzeIdezetek = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("morze.txt"));
            String sor = br.readLine();
            while (sor != null){
                String[] st = sor.split(";", -1);
                String szerzo = st[0];
                String szoveg = st[1];
                morzeIdezetek.put(szerzo, szoveg);
                sor = br.readLine();
            }
            br.close();
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public static String MorzeToSzoveg(String kodoltSzoveg) {
        String[] st = kodoltSzoveg.split("   ", -1);
        kodoltSzoveg = "";
        for (int i = 0; i < st.length; i++) {
            kodoltSzoveg += morzeAbcReversed.get(st[i]);
        }
        return kodoltSzoveg;
    }

}
