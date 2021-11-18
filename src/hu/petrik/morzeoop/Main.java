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
    public static String searchKar;

    public static void main(String[] args) {
        BeolvasABC();
        KiirABC();
        System.out.println("3. feladat: A morze abc " + morzeAbc.size() + " db karakter kódját tartalmazza.");
        System.out.print("4. feladat: Kérek egy karaktert: ");
        Scanner sc = new Scanner(System.in);
        searchKar = sc.nextLine();
        System.out.println("A " + searchKar + " karakter morze kódja: " + morzeAbc.get(searchKar));
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
}
