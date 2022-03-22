/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inheritancedemo;

/**
 *
 * @author sebas
 */

public class PersonManagement {
    public static final int ERROR_NUMBER = -1;
    public static final int MAX = 10;
    
    private Person[] people;
    
    public PersonManagement(int size) {
        people = new Person[size];
    }

    public PersonManagement() {
        this(MAX);
    }
    
    public boolean add(String firstname, String lastname) {
        if (firstname != null && lastname != null)
            return addPerson(new Person(firstname, lastname));
        return false;
    }
    
    public boolean add(String firstname, String lastname, int year, int month, int day) {
        if (firstname != null && lastname != null)
            return addPerson(new Person(firstname, lastname, year, month, day));
        return false;
    }
    
    public boolean add(String firstname, String lastname, String school, String course, int KNr) {
        if (firstname != null && lastname != null && school != null && course != null)
            return addPerson(new Student(firstname, lastname, school, course, KNr));
        return false;
    }
    
    public boolean add(String firstname, String lastname, int year, int month, int day, String school, String course, int KNr) {
        if (firstname != null && lastname != null && school != null && course != null)
            return addPerson(new Student(firstname, lastname, year, month, day, school, course, KNr));
        return false;
    }
    
    public boolean add(Person p) {
        if (p.getFirstName() != null && p.getLastName() != null)
            return addPerson(p);
        return false;
    }
    
    private boolean addPerson(Person p) {
        int i = getFreeIndex();
        if (i == ERROR_NUMBER)
            return false;
        people[0] = p;
        return true;
    }
    
    public boolean delete(String firstname, String lastname) {
        for (int i = 0; i < people.length; ++i)
            if (people[i] != null && people[i].getFirstName().equals(firstname) && people[i].getLastName().equals(lastname)) {
                people[i] = null;
                return true;
            }
        return false;
    }
    
    public Person find(String firstname, String lastname) {
        for (int i = 0; i < people.length; ++i)
            if (people[i] != null && people[i].getFirstName().equals(firstname) && people[i].getLastName().equals(lastname))
                return people[i];
        return null;
    }
    
    public void printAll() {
        for (int i = 0; i < people.length; ++i)
            if (people[i] != null)
                System.out.println(people[i]);
    }
    
    public void reset() {
        people = new Person[people.length];
    }
    
    private int getFreeIndex() {
        for (int i = 0; i < people.length; ++i)
            if (people[i] == null)
                return i;
        return ERROR_NUMBER;
    }
}
