package hu.petrik.morzeoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static HashMap<String, String> morzeAbcReversed;
    public static HashMap<String, String> morzeAbc;

    public static void main(String[] args) {
        BeolvasABC();
        KiirABC();
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

    private static void KiirABC() {
        for (Map.Entry<String, String> entry : morzeAbc.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
