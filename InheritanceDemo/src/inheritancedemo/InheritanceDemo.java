/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancedemo;

/**
 *
 * @author tb
 */
public class InheritanceDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person p1 = new Person("Hans", "Mayer");
        Person p2 = new Person("Franz", "Müller", 1996, 5, 10);
        
        
        Person s1 = new Student("Hans", "Student1", "HTL Wr. Neustadt", "3BHIF", 42);
        Person s2 = new Student("Franz", "Student2", 1996, 5, 10, "HTL Krems", "3BHIF", 44);
        
        System.out.println(p1);
        System.out.println(p2);        
        System.out.println(s1);
        System.out.println(s2);        
        
    }
    
}

