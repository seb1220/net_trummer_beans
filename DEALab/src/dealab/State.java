/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dealab;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author sebastian kawicher
 */
public class State {
    private String desc;
    private boolean endState;
    private HashMap<String, State> successor;

    public State(String description, boolean endState) { // Konstruktor
        desc = description;
        this.endState = endState;
        successor = new HashMap<String, State>();
    }

    // Getter und Setter
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setEndState(boolean endState) {
        this.endState = endState;
    }

    public boolean addSuccessor(String input, State successor) { // Fuegt zu einem Zustand einen Uebergang hinzu
        if (this.successor.containsKey(input))
            return false;
        this.successor.put(input, successor);
        return true;
    }
    
    public State getSuccessor(String input) { // Liefert den Nachfolger angesichts des uebergebenen Uebergangs zurueck
        if (successor.containsKey(input))
            return successor.get(input);
        return null;
    }
    
    public boolean isEndState() { // Liefert zurueck, ob es sich bei dem Zustand um einen Endzustand handelt
        return endState;
    }
    
    public boolean isValidState(String[] input) { // Ueberprueft, ob es sich bei dem Zustand um einen gueltigen Zustand handelt (mit allen Uebergaengen)
        for (String i : input)
            if (successor.get(i) == null)
                return false;
        return true;
    }
    
    @Override
    public String toString() {
        return desc;
    }
    
    public void print() {
        System.out.println(desc + ": endstate=" + isEndState());
        
        for(Map.Entry<String, State> entry : successor.entrySet()) {
            System.out.println("  " + entry.getKey() + ": " + entry.getValue());
        }
        
    }
}
