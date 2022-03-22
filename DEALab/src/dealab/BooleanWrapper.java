/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dealab;

/**
 *
 * @author sebas
 */
public class BooleanWrapper {
    private boolean value;
    
    public BooleanWrapper(boolean value) {
        setValue(value);
    }
    
    public boolean getValue() {
        return value;
    }
    
    public void setValue(boolean value) {
        this.value = value;
    }
    
    @Override
    public String toString() {
        return "" + getValue();
    }
}
