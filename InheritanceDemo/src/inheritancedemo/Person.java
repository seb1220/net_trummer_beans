/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inheritancedemo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author tb
 */
public class Person {
    private String firstName;
    private String lastName;
    private Date birthDate;
    
    public Person(String firstName, String lastName, int year, int month, int day) {
        this(firstName, lastName);
        setBirthDate(year, month, day);
        
    }

    public Person(String firstName, String lastName) {
        setFirstName(firstName);
        setLastName(lastName);
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDate(int year, int month, int day) {
        birthDate = new Date(year, month, day);
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Date getBirthDate() {
        return birthDate;
    }
    
    @Override
    public String toString() {
        String result = "";
        result += getFirstName() + " ";
        result += getLastName();
        
        if (birthDate != null) {
            result += ", ";
            result += birthDate.getDay() + ".";
            result += birthDate.getMonth() + ".";
            result += birthDate.getYear();
        }
                
        return result;
    }
    
    
}
