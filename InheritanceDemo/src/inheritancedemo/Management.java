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
public class Management {
    private Person[] persons;
    public static final int MAX = 10;
    public static final int OK = 0;
    public static final int NOT_FOUND = -1;
    public static final int INSERTING_ERROR = -2;
        
   
    public Management() {
        this(MAX);
    }
   
    public Management(int size) {
        persons = new Person[size];
    }

    public int add(String firstName, String lastName) {
       
        return add(new Person(firstName, lastName));
    }
   
    public int add(String firstName, String lastName, 
        int year, int month, int day) {
       
        return add(new Person(firstName, lastName, year, month, day));
    }
   
    public int add(String firstName, String lastName, 
        String school, String course, int num) {
       
        return add(new Student(firstName, lastName, school, course, num));
    }

    public int add(String firstName, String lastName, 
        int year, int month, int day, String school, String course, int num) {
       
        return add(new Student(firstName, lastName, year, month, day, school, course, num));
    }
   
    public int add(Person p) {
        int freeID = findFreeID();
        if (freeID != NOT_FOUND) {
            persons[freeID] = p;
            return OK;
        }
       
        return INSERTING_ERROR;
    }
         
    public void printAll() {
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] != null)
                System.out.println(persons[i]);
        }
    }
   
    public void reset() {
        persons = new Person[persons.length];
    }
    
    public Person search(String firstName, String lastName) {
        int foundID = findPerson(firstName, lastName);
        if (foundID != NOT_FOUND)
            return persons[foundID];
        return null;
    }

    private int delete(String firstName, String lastName) {
        int foundID = findPerson(firstName, lastName);
        if (foundID != NOT_FOUND) {
            persons[foundID] = null;
            return OK;
        }
        return NOT_FOUND;
    }
    
    private int findPerson(String firstName, String lastName) {
        for (int i = 0; i < persons.length; i++) {
            if (
                (persons[i] != null) &&
                (persons[i].getFirstName().equals(firstName)) &&
                (persons[i].getFirstName().equals(lastName))
               )
                return i;
        }
        return NOT_FOUND;
    }
    
    private int findFreeID() {
        for (int i = 0; i < persons.length; i++)
            if (persons[i] == null)
                return i;
       
        return NOT_FOUND;
    }
    
    @Override
    public boolean equals(Object o) {
        return false;
    }
   
   
}
