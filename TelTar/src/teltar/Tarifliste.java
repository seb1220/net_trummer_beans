/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teltar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import static teltar.Tarif.GetTarif;

/**
 *
 * @author Kawicher.Sebastian
 */
public class Tarifliste {
    private static final int MAX = 10;
    private static final int NOT_FOUND = -1;
    
    Tarif[] tarifArray;
    
    Tarifliste(int size) {
        tarifArray = new Tarif[size];
    }
    
    Tarifliste() {
        this(MAX);
    }
    
    public boolean AddTarif(String bez, String telnr, int gg) {
        return addTarif(GetTarif(bez, telnr, gg));
    }
    
    public boolean AddTarif(String bez, String telnr, double gg, double mg) {
        return addTarif(GetTarif(bez, telnr, gg, mg));
    }
    
    private boolean addTarif(Tarif t) {
        if (t == null)
            return false;
        int i = findFreeIndex();
        if (i == NOT_FOUND)
            return false;
        tarifArray[i] = t;
        return true;
    }
    
    public void PrintAufstellung() {
        for (int i = 0; i < tarifArray.length; ++i)
            if (tarifArray[i] != null)
                System.out.println(tarifArray[i].GetInfo());
    }
    
    public void PrintAufstellung(int x) {
        for (int i = 0; i < tarifArray.length; ++i) {
            if (tarifArray[i] != null)
                System.out.println(tarifArray[i].GetInfo() + ", Kosten fuer das Monat: " + 
                        tarifArray[i].GetKosten(x) + ", Bonuspunkte fuer das Monat: " +
                        tarifArray[i].GetBonuspunkte(x));
        }
    }
    
    public void Reset() {
        tarifArray = new Tarif[tarifArray.length];
    }
    
    public void ReadFromFile(String FileName) {
        String line;
        String[] parts;
        
        try {        
            BufferedReader br = new BufferedReader(new FileReader(FileName));
            
            line = br.readLine();
            while (line != null) {
                parts = line.split(";");

                if (parts.length == 3) {
                    AddTarif(parts[0], parts[1], Integer.parseInt(parts[2]));
                } else if (parts.length == 4) {
                    AddTarif(parts[0], parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
                } else {
                    System.err.println("Invalid type");
                }
                
                System.out.println();
                line = br.readLine();
            }
            
            br.close();
            
        }
        catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    
    private int findFreeIndex() {
        for (int i = 0; i < tarifArray.length; ++i) {
            if (tarifArray[i] == null)
                return i;
        }
        return NOT_FOUND;
    }
}
