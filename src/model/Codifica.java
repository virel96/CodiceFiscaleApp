
package model;
import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Carica [codici;descrizioni] da un file CSV
 * e li decodifica attraverso un HashMap
 * @author Sandro
 */
public class Codifica {

    private boolean ok = true;
    private HashMap<String, String> codifica;

    public Codifica(String csvfilename, int idxKey, int idxVal) {
        Scanner lettore;
        String str;
        String[] lst;
        codifica = new HashMap<>();
        try {
            lettore = new Scanner(new File(csvfilename));
        } catch (java.io.FileNotFoundException ex) { ok=false; return; }
        // lettore.useDelimiter(";");
        while (lettore.hasNextLine()) {
            str = lettore.nextLine();
            lst = str.split(";");
            codifica.put( lst[idxKey], lst[idxVal] );
        }
        // lettore.close();
    }

    String decode(String key) {
        if (!ok) return "ERR";
        return codifica.get(key.toUpperCase());
    }

}
