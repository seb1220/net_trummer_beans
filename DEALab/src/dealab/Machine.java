package dealab;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sebastian kawicher
 */
public class Machine {
    private HashMap<String, State> states;
    private State startState;
    private String[] input;

    public Machine(String[] input) { // Konstruktor mit Alphabet
        this();
        this.input = input;
    }
    
    public Machine(String fileName) { // Konstruktor mit Datei
        this();
        ImportMachine(fileName);
    }

    public Machine() { // Konstruktor
        states = new HashMap<String, State>();
    }

    // getter und setter
    public HashMap<String, State> getStates() {
        return states;
    }

    public State getStartState() {
        return startState;
    }

    public String[] getInput() {
        return input;
    }

    private void setStates(HashMap<String, State> states) {
        this.states = states;
    }

    public void setStartState(State startState) {
        this.startState = startState;
    }

    public void setInput(String[] input) {
        this.input = input;
    }
    
    public Machine getMinMachine() {
        Machine m = new Machine(input);
        MinTable mt = new MinTable(input, states);
        
        ArrayList<HashSet<String>> nodes = new ArrayList<>();
        ArrayList<HashSet<String>> combinations = mt.getCombinations();
        
        for (HashSet<String> hs : combinations) { // erstellt aus Combinations Nodes, wobei Nodes die Zustaende des
            String[] s = hs.toArray(new String[0]); // MinDEAs darstellt
            boolean found = false;
            for (HashSet<String> hs1 : nodes) {
                
                if (hs1.contains(s[0]) || hs1.contains(s[1])) {
                    found = true;
                    hs1.add(s[0]);
                    hs1.add(s[1]);
                }
                
            }
            if (!found) {
                HashSet<String> n = new HashSet<>();
                n.add(s[0]);
                n.add(s[1]);
                nodes.add(n);
            }
        }
        
        boolean change = true;
        while (change) { // verhindert Cluster, die eigentlich 'ident' sind
            for (int j = 0; j < nodes.size(); ++j) {
                for (int i = 0; i < nodes.size(); ++i) {
                    if (i == j)
                        continue;
                    change = false;
                    for (String val : nodes.get(j)) {
                        if (nodes.get(i).contains(val))
                            change = true;
                    }
                    if (change) {
                        for (String copy : nodes.get(i)) {
                            nodes.get(j).add(copy);
                        }
                        nodes.remove(i);
                    }

                }
            }
        }
        
        for(String s : states.keySet()){ // fuegt die Zustaende zu Nodes hinzu, die in Combiantions noch nicht entahlten
            boolean con = false; // waren, also nicht kombiniert werden

            for(int i=0; i < nodes.size(); i++){
                if(nodes.get(i).contains(s)){
                    con = true;
                }
            }
            if(!con){
                HashSet<String> hs = new HashSet<String>();
                hs.add(s);
                nodes.add(hs);
            }
        }
        
        for (HashSet<String> hs : nodes) { // erstellt Zustaende aus den einzelnen HashSets von Nodes
            String name = "";
            boolean isEnd = false;
            for (String s : hs) {
                name += s;
                if (states.get(s).isEndState()) isEnd = true;
            }
            m.addState(name, isEnd);
        }
        
        int i = -1;
        for (String s : m.states.keySet()) { // fuegt fuer die Zustaende noch Uebergaenge hinzu
            ++i;
            HashSet<String> hs = nodes.get(i);
            String[] sa = hs.toArray(new String[0]);
            
            for (String a : input) {
                String suc = states.get(sa[0]).getSuccessor(a).getDesc();

                String nameSuc = "";
                for (String s2 : m.states.keySet()) {
                    if (s2.contains(suc))
                        nameSuc = s2;
                }
                m.addInput(s, a, nameSuc);
            }

        }

        return m; // liefert den Dea zurueck
    }
    
    public boolean addState(String description, boolean endState) { // Einen Zustand hinzufuegen
        if (states.containsKey(description))
            return false;
        State state = new State(description, endState);
        states.put(description, state);
        if (states.size() == 1)
            startState = state;
        return true;
    }

    public boolean addInput(String state, String input, String successor) { // Uebergaenge fuer einen Zustand hinzufuegen
        if (states.get(state) == null || 
            states.get(successor) == null || 
            !isInInput(input))
            return false; // wenn input schon vorhanden oder einer der Beiden States == null
        return states.get(state).addSuccessor(input, states.get(successor));
    }

    public boolean checkMachine() { // Untersucht, ob alle Zustaende die zugehoerigen Uebergaenge besitzen
        if (startState == null)
            return false;
        for (String i : states.keySet())
            if (!states.get(i).isValidState(input))
                return false;
        return true;
    }

    public boolean run(String[] input) { // Laesst den Automaten ein uebergebenes Wort ueberpruefen
        State state = getStartState();
        for (String i : input) {
            if (state == null)
                return false;
            state = state.getSuccessor(i);
        }
        return state.isEndState();
    }

    public void ImportMachine (String fileName) { // holt sich die Zustaende und Uebergaenge aus einer Datei
        String line;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            
            line = br.readLine();
            String[] parts;
            parts = line.split("-");
            input = parts;
            line = br.readLine();
            
            while (line != null) {
                parts = line.split("-");

                if (parts.length == 1) {
                    if (parts[0].charAt(0) == '(') {
                        addState(parts[0].substring(1, parts[0].length() - 1), true);
                    } else {
                        addState(parts[0], false);
                    }
                } else if (parts.length == 3) {
                    addInput(parts[0], parts[1], parts[2]);
                } else {
                    System.err.println("Invalid type " + line);
                }

                line = br.readLine();
            }
            
            br.close();
            
        }
        catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
    
    private boolean isInInput(String input) { // Ueberprueft, ob der String Teil des Alphabetes ist
        for (int i = 0; i < this.input.length; ++i) {
            if (this.input[i].equals(input))
                return true;
        }
        return false;
    }

    /*@Override
    public String toString() {
        String s = "Alphabet: ";
        for (String i : input)
            s += "{" + i + "}";
        for
    }*/
    
    public void print() {
        for(State s : states.values()) {
            s.print();
        }
    }
}