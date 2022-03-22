/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minautomat;

import javax.swing.text.StyledEditorKit;
import java.util.HashMap;

/**
 *
 * @author sebas
 */
public class MinAutomat {

    private static class BooleanWrapper {
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        HashMap<String, HashMap<String, BooleanWrapper>> hm = new HashMap<String, HashMap<String, BooleanWrapper>>();

        hm.put("z0", new HashMap<String, BooleanWrapper>());
        hm.put("z1", new HashMap<String, BooleanWrapper>());
        hm.put("z2", new HashMap<String, BooleanWrapper>());
        hm.put("z3", new HashMap<String, BooleanWrapper>());
        hm.put("z4", new HashMap<String, BooleanWrapper>());

        hm.get("z0").put("z1", new BooleanWrapper(false));
        hm.get("z0").put("z2", new BooleanWrapper(true));
        hm.get("z0").put("z3", new BooleanWrapper(false));
        hm.get("z0").put("z4", new BooleanWrapper(false));

        hm.get("z1").put("z2", new BooleanWrapper(false));
        hm.get("z1").put("z3", new BooleanWrapper(true));
        hm.get("z1").put("z4", new BooleanWrapper(false));

        hm.get("z2").put("z3", new BooleanWrapper(false));
        hm.get("z2").put("z4", new BooleanWrapper(false));

        hm.get("z3").put("z4", new BooleanWrapper(false));

        for (String i : hm.keySet()) {
            System.out.println("");
            for (String j : hm.get(i).keySet()) {
                System.out.println(i + ": " + j + ": " + hm.get(i).get(j));
            }
        }
    }
    
}
