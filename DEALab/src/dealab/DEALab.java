/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dealab;

/**
 *
 * @author sebastian kawicher
 */
public class DEALab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
/*
        //  Erster Automat mit Datei
        Machine m = new Machine("Bankomat.dea");

        System.out.println("Check: " + m.checkMachine());

        System.out.println("Word is accepted: " + m.run(new String[]{"5", "0", "0"}));

        //  Zweiter Automat ohne Datei
        Machine a = new Machine(new String[]{"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"});
        
        a.addState("z0", false);
        a.addState("z1", false);
        a.addState("z2", false);
        a.addState("z3", false);
        a.addState("z4", true);
        a.addState("z5", true);
        a.addState("z6", true);
        a.addState("z7", false);
        a.addState("z99", false);
        
        a.addInput("z0", "0", "z0");
        a.addInput("z0", "1", "z1");
        a.addInput("z0", "2", "z1");
        a.addInput("z0", "3", "z1");
        a.addInput("z0", "4", "z2");
        a.addInput("z0", "5", "z3");
        a.addInput("z0", "6", "z3");
        a.addInput("z0", "7", "z3");
        a.addInput("z0", "8", "z3");
        a.addInput("z0", "9", "z3");
        
        a.addInput("z1", "0", "z5");
        a.addInput("z1", "1", "z7");
        a.addInput("z1", "2", "z7");
        a.addInput("z1", "3", "z7");
        a.addInput("z1", "4", "z7");
        a.addInput("z1", "5", "z7");
        a.addInput("z1", "6", "z7");
        a.addInput("z1", "7", "z7");
        a.addInput("z1", "8", "z7");
        a.addInput("z1", "9", "z7");
        
        a.addInput("z2", "0", "z5");
        a.addInput("z2", "1", "z99");
        a.addInput("z2", "2", "z99");
        a.addInput("z2", "3", "z99");
        a.addInput("z2", "4", "z99");
        a.addInput("z2", "5", "z99");
        a.addInput("z2", "6", "z99");
        a.addInput("z2", "7", "z99");
        a.addInput("z2", "8", "z99");
        a.addInput("z2", "9", "z99");
        
        a.addInput("z3", "0", "z4");
        a.addInput("z3", "1", "z99");
        a.addInput("z3", "2", "z99");
        a.addInput("z3", "3", "z99");
        a.addInput("z3", "4", "z99");
        a.addInput("z3", "5", "z99");
        a.addInput("z3", "6", "z99");
        a.addInput("z3", "7", "z99");
        a.addInput("z3", "8", "z99");
        a.addInput("z3", "9", "z99");
        
        a.addInput("z4", "0", "z99");
        a.addInput("z4", "1", "z99");
        a.addInput("z4", "2", "z99");
        a.addInput("z4", "3", "z99");
        a.addInput("z4", "4", "z99");
        a.addInput("z4", "5", "z99");
        a.addInput("z4", "6", "z99");
        a.addInput("z4", "7", "z99");
        a.addInput("z4", "8", "z99");
        a.addInput("z4", "9", "z99");
        
        a.addInput("z5", "0", "z6");
        a.addInput("z5", "1", "z99");
        a.addInput("z5", "2", "z99");
        a.addInput("z5", "3", "z99");
        a.addInput("z5", "4", "z99");
        a.addInput("z5", "5", "z99");
        a.addInput("z5", "6", "z99");
        a.addInput("z5", "7", "z99");
        a.addInput("z5", "8", "z99");
        a.addInput("z5", "9", "z99");
        
        a.addInput("z6", "0", "z99");
        a.addInput("z6", "1", "z99");
        a.addInput("z6", "2", "z99");
        a.addInput("z6", "3", "z99");
        a.addInput("z6", "4", "z99");
        a.addInput("z6", "5", "z99");
        a.addInput("z6", "6", "z99");
        a.addInput("z6", "7", "z99");
        a.addInput("z6", "8", "z99");
        a.addInput("z6", "9", "z99");
        
        a.addInput("z7", "0", "z6");
        a.addInput("z7", "1", "z99");
        a.addInput("z7", "2", "z99");
        a.addInput("z7", "3", "z99");
        a.addInput("z7", "4", "z99");
        a.addInput("z7", "5", "z99");
        a.addInput("z7", "6", "z99");
        a.addInput("z7", "7", "z99");
        a.addInput("z7", "8", "z99");
        a.addInput("z7", "9", "z99");
        
        a.addInput("z99", "0", "z99");
        a.addInput("z99", "1", "z99");
        a.addInput("z99", "2", "z99");
        a.addInput("z99", "3", "z99");
        a.addInput("z99", "4", "z99");
        a.addInput("z99", "5", "z99");
        a.addInput("z99", "6", "z99");
        a.addInput("z99", "7", "z99");
        a.addInput("z99", "8", "z99");
        a.addInput("z99", "9", "z99");


        //System.out.println("Check: " + a.checkMachine());
        //System.out.println("Word is accepted: " + a.run(new String[]{"4", "0", "0"}));
        
        Machine min = a.getMinMachine(); */

        
        String[] arr = {"0", "1"};
        Machine automat1 = new Machine(arr);
        
        automat1.addState("z0", false);
        automat1.addState("z1", false);
        automat1.addState("z2", false);
        automat1.addState("z3", false);
        automat1.addState("z4", true);

        
        automat1.addInput("z0", "0", "z1");
        automat1.addInput("z0", "1", "z2");
        
        automat1.addInput("z1", "0", "z4");
        automat1.addInput("z1", "1", "z2");
        
        automat1.addInput("z2", "0", "z3");
        automat1.addInput("z2", "1", "z2");
        
        automat1.addInput("z3", "0", "z4");
        automat1.addInput("z3", "1", "z0");
        
        automat1.addInput("z4", "0", "z4");
        automat1.addInput("z4", "1", "z4");

        automat1.print();
        
        System.out.println("-----------------");

        Machine minDEA = automat1.getMinMachine();
        minDEA.print();
    }
    
}
