package hu.petrik.morzeoop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        BeolvasABC();
    }

    public static void BeolvasABC() {
        HashMap<String, String> morzeAbc = new HashMap<>();
        HashMap<String, String > morzeAbcReversed = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("morzeabc.txt"));
            String sor = br.readLine();
            while (sor != null){
                br.readLine();
                String[] st = sor.split("\t");
                String betu = st[0];
                String morzeJel = st[0];
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
}
