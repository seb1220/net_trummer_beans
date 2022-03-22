/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dealab;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sebas
 */
public class MinTable {
    private String[] alphabet;
    private HashMap<String, HashMap<String, BooleanWrapper>> hm;
    private HashMap<String, State> states;
    
    public MinTable(String[] alphabet, HashMap<String, State> states) { // Konstruktor
        hm = new HashMap<String, HashMap<String, BooleanWrapper>>();
        this.states = states;
        this.alphabet = alphabet;
        initialize();
        fill();
        //print();
    }
    
    public boolean set(String z0, String z1, boolean minOk) { // festlegen, ob eine Kombination zusammenfassbar ist
        if (z0.equals(z1))
            return false;
        
        if (z0.compareTo(z1) > 0) {
            String z = z0;
            z0 = z1;
            z1 = z;
        }
        
        if (!hm.containsKey(z0)) {
            hm.put(z0, new HashMap<String, BooleanWrapper>());
            hm.get(z0).put(z1, new BooleanWrapper(minOk));
            return true;
        } else if (hm.containsKey(z0)) {
            hm.get(z0).put(z1, new BooleanWrapper(minOk));
            return true;
        }
        return false;
    }
    
    public boolean get(String z0, String z1) { // liefert zurück, ob Kombination laut HashMap zusammenfassbar ist
        if (hm.get(z0) != null)
            if (hm.get(z0).get(z1) != null)
                return hm.get(z0).get(z1).getValue();
        return false;
    }
    
    private void initialize() { // fuegt alle Zustaende zur HashMap hinzu und zusaetzlich, ob sie zusammenfassbar sind,
        for (State i : states.values()) { // in Bezug darauf, ob die Zustaende selbst End / Anfangszustaende sind
            for (State j : states.values()) {
                set(i.getDesc(), j.getDesc(), i.isEndState() == j.isEndState());
            }
        }
    }
    
    private void fill() { // fuegt die Zusammenfassbarkeit der Zustaende, in Bezug auf Nachfolger fest
        boolean change = true;
        while (change) {
            for (State i : states.values()) {
                for (State j : states.values()) {
                    if (!get(i.getDesc(), j.getDesc()))
                        continue;
                    for (String k : alphabet) {
                        if (i.getSuccessor(k).isEndState() != j.getSuccessor(k).isEndState()) {
                            set(i.getDesc(), j.getDesc(), false);
                            change = true;
                            break;
                        } else {
                            change = false;
                        }
                    }
                    if (!change)
                        set(i.getDesc(), j.getDesc(), true);
                }
            }
        }
        
    }
    
    public ArrayList<HashSet<String>> getCombinations() { // ueberprueft die HashMap und liefert eine ArrayList mit
        ArrayList<HashSet<String>> al = new ArrayList<>(); // HashSets, den moeglichen Kombinationen, zurueck
        boolean change = true;
        while (change)
            for (String i : hm.keySet())
                for (String j : hm.get(i).keySet()) {
                    if (i.compareTo(j) > 0) continue;
                    if (i.equals(j)) continue;
                    if (get(i, j)) {
                        HashSet<String> hs = new HashSet<String>();

                        hs.add(i);
                        hs.add(j);
                        al.add(hs);
                    } else {
                        change = false;
                    }
                }
        return al;
    }
    
    private void print() { // gibt die HashMap aus
        for (String s : hm.keySet()) {
            System.out.print(s);
            HashMap<String, BooleanWrapper> hm2 = hm.get(s);
            System.out.print(hm2.keySet());
            System.out.println(hm2.values());
        }
    }
}
