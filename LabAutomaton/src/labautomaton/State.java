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
public class State {
    private String description;
    private boolean isEndState;
    private HashMap<String, State> successors;
    
    public State(String description, boolean isEndState) {
        this.description = description;
        this.isEndState = isEndState;
        successors = new HashMap<String, State>();
    }
    
    public boolean AddSuccessor(String input, State successor) {
        if (successors.containsKey(input))
            return false;
        successors.put(input, successor);
        return true;
    }
    
    public State getSuccessors(String input) {
        if (!successors.containsKey(input))
            return null;
        
        return successors.get(input);
    }
    
    public boolean isEndState() {
        return isEndState;
    }
}
