/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labautomaton;

import java.util.HashMap;

/**
 *
 * @author Kawicher.Sebastian
 */
public class Automaton {
    private HashMap<String, State> states;
    private State startState;
    private String[] alphabet;
    
    public Automaton(String[] alphabet) {
        states = new HashMap<String, State>();
        this.alphabet = alphabet;
    }
    
    public boolean AddState(String description, boolean isEndState) {
        if (states.containsKey(description))
            return false;
        
        State s = new State(description, isEndState);
        states.put(description, s);
        if (states.size() == 1)
            startState = s;
        
        return true;
    }
    
    public boolean AddSuccessor(String state, String input, String successor) {
        
        if (
                (!states.containsKey(state)) ||
                (!states.containsKey(successor)) ||
                (!isInAlphabet(input))
            )
            return false;
        
        State from = states.get(state);
        State to = states.get(successor);
        
        return from.AddSuccessor(input, to);
    }
    
    public boolean run(String[] input) {
        State s = startState;
        
        for (int i = 0; i < input.length; ++i)
            s = s.getSuccessors(input[i]);
        
        return s.isEndState();
    }
    
    private boolean isInAlphabet(String input) {
        for (int i = 0; i < alphabet.length; ++i) {
            if (alphabet[i].equals(input))
                return true;
        }
        return false;
    }
}
