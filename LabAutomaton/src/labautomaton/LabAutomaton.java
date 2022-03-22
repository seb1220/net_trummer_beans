/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labautomaton;

/**
 *
 * @author Kawicher.Sebastian
 */
public class LabAutomaton {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Automaton a = new Automaton(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
        
        a.AddState("z0", false);
        a.AddState("z1", false);
        a.AddState("z2", false);
        a.AddState("z3", false);
        a.AddState("z4", true);
        a.AddState("z5", true);
        a.AddState("z6", true);
        a.AddState("z7", false);
        a.AddState("z99", false);
        
        a.AddSuccessor("z0", "0", "z0");
        a.AddSuccessor("z0", "1", "z1");
        a.AddSuccessor("z0", "2", "z1");
        a.AddSuccessor("z0", "3", "z1");
        a.AddSuccessor("z0", "4", "z2");
        a.AddSuccessor("z0", "5", "z3");
        a.AddSuccessor("z0", "6", "z3");
        a.AddSuccessor("z0", "7", "z3");
        a.AddSuccessor("z0", "8", "z3");
        a.AddSuccessor("z0", "9", "z3");
        
        a.AddSuccessor("z1", "0", "z5");
        a.AddSuccessor("z1", "1", "z7");
        a.AddSuccessor("z1", "2", "z7");
        a.AddSuccessor("z1", "3", "z7");
        a.AddSuccessor("z1", "4", "z7");
        a.AddSuccessor("z1", "5", "z7");
        a.AddSuccessor("z1", "6", "z7");
        a.AddSuccessor("z1", "7", "z7");
        a.AddSuccessor("z1", "8", "z7");
        a.AddSuccessor("z1", "9", "z7");
        
        a.AddSuccessor("z2", "0", "z5");
        a.AddSuccessor("z2", "1", "z99");
        a.AddSuccessor("z2", "2", "z99");
        a.AddSuccessor("z2", "3", "z99");
        a.AddSuccessor("z2", "4", "z99");
        a.AddSuccessor("z2", "5", "z99");
        a.AddSuccessor("z2", "6", "z99");
        a.AddSuccessor("z2", "7", "z99");
        a.AddSuccessor("z2", "8", "z99");
        a.AddSuccessor("z2", "9", "z99");
        
        a.AddSuccessor("z3", "0", "z4");
        a.AddSuccessor("z3", "1", "z99");
        a.AddSuccessor("z3", "2", "z99");
        a.AddSuccessor("z3", "3", "z99");
        a.AddSuccessor("z3", "4", "z99");
        a.AddSuccessor("z3", "5", "z99");
        a.AddSuccessor("z3", "6", "z99");
        a.AddSuccessor("z3", "7", "z99");
        a.AddSuccessor("z3", "8", "z99");
        a.AddSuccessor("z3", "9", "z99");
        
        a.AddSuccessor("z4", "0", "z99");
        a.AddSuccessor("z4", "1", "z99");
        a.AddSuccessor("z4", "2", "z99");
        a.AddSuccessor("z4", "3", "z99");
        a.AddSuccessor("z4", "4", "z99");
        a.AddSuccessor("z4", "5", "z99");
        a.AddSuccessor("z4", "6", "z99");
        a.AddSuccessor("z4", "7", "z99");
        a.AddSuccessor("z4", "8", "z99");
        a.AddSuccessor("z4", "9", "z99");
        
        a.AddSuccessor("z5", "0", "z6");
        a.AddSuccessor("z5", "1", "z99");
        a.AddSuccessor("z5", "2", "z99");
        a.AddSuccessor("z5", "3", "z99");
        a.AddSuccessor("z5", "4", "z99");
        a.AddSuccessor("z5", "5", "z99");
        a.AddSuccessor("z5", "6", "z99");
        a.AddSuccessor("z5", "7", "z99");
        a.AddSuccessor("z5", "8", "z99");
        a.AddSuccessor("z5", "9", "z99");
        
        a.AddSuccessor("z6", "0", "z99");
        a.AddSuccessor("z6", "1", "z99");
        a.AddSuccessor("z6", "2", "z99");
        a.AddSuccessor("z6", "3", "z99");
        a.AddSuccessor("z6", "4", "z99");
        a.AddSuccessor("z6", "5", "z99");
        a.AddSuccessor("z6", "6", "z99");
        a.AddSuccessor("z6", "7", "z99");
        a.AddSuccessor("z6", "8", "z99");
        a.AddSuccessor("z6", "9", "z99");
        
        a.AddSuccessor("z7", "0", "z6");
        a.AddSuccessor("z7", "1", "z99");
        a.AddSuccessor("z7", "2", "z99");
        a.AddSuccessor("z7", "3", "z99");
        a.AddSuccessor("z7", "4", "z99");
        a.AddSuccessor("z7", "5", "z99");
        a.AddSuccessor("z7", "6", "z99");
        a.AddSuccessor("z7", "7", "z99");
        a.AddSuccessor("z7", "8", "z99");
        a.AddSuccessor("z7", "9", "z99");
        
        a.AddSuccessor("z99", "0", "z99");
        a.AddSuccessor("z99", "1", "z99");
        a.AddSuccessor("z99", "2", "z99");
        a.AddSuccessor("z99", "3", "z99");
        a.AddSuccessor("z99", "4", "z99");
        a.AddSuccessor("z99", "5", "z99");
        a.AddSuccessor("z99", "6", "z99");
        a.AddSuccessor("z99", "7", "z99");
        a.AddSuccessor("z99", "8", "z99");
        a.AddSuccessor("z99", "9", "z99");
        
        System.out.println(a.run(new String[]{"4", "0", "0"}));
        
        int valid = 0;
        
        for (int i = 1; i < 600; ++i) {
            if (a.run((""+i).split(""))) valid++;
        }
        
        for (int i = 1; i < 600; ++i) {
            if (a.run((""+i).split("")) && i % 10 != 0 && i <= 400) valid++;
        }
        
        System.out.println(valid);
        
        int[] abc = new int[]{};
        for (int i = 1; i < 41; ++i)
            abc[i+1] = i;
        
        int valid1 = 0;
        for (int i = 1; i < 600; ++i) {
            if (a.run((""+i).split("")) && (i / 10) == 5) ++valid;
        }
        
        System.out.println(valid1);
    }
    
}
