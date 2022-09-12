/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lecture1;

/**
 *
 * @author PHOTON
 */
public class Student {

    String name;
    int age, friendship;
    double grade, money;
    Student bff;
    
    public Student(String name) {
        this.name = name;
        this.age = 14;
        this.friendship = 0;
        this.grade = 2.5;
        this.money = 5000;
        this.bff = Student josh;
        System.out.println("A new student has enrolled.");
    }
    
    public Student (String name, int age) {
      this.name = name;
      this.age = 14;
      this.friendship = 0;
      this.grade = 2.5;
      this.money = 5000;  
    }
    public void introduce() {
        System.out.printf("Hi, my name is %s.%n",name);
    }
    
    public double getGrade() {
        return grade;
    }
    
    public void talk(int hours) {
        friendship += hours;
    }
}
