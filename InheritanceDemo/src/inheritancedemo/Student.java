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
public class Student extends Person {
    private String school;
    private String course;
    private int num;
    
    public Student(String firstName, String lastName, 
                   int year, int month, int day, 
                   String school, String course, int num) {
        super(firstName, lastName, year, month, day);
        setSchool(school);
        setCourse(course);
        setNum(num);
    }

    public Student(String firstName, String lastName,
                   String school, String course, int num){
        super(firstName, lastName);
        setSchool(school);
        setCourse(course);
        setNum(num);        
    }
    
    public void setSchool(String school) {
        this.school = school;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setNum(int num) {
        this.num = num;
    }
    
    public String getSchool() {
        return school;
    }
    
    public String getCourse() {
        return course;
    }
    
    public int getNum() {
        return num;
    }
    
    @Override
    public String toString() {
        String result = "";
        
        result += getSchool() + ", ";
        result += getCourse() + ", ";
        result += getNum();
        
        return super.toString() + ", " + result;
    }
}
