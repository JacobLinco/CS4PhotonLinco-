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
public class Lecture1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Student mark = new Student("Mark");
        
        Student josh = new Student("Josh, 17");
        
        mark.introduce();
        System.out.println(mark.bff.);
        
        double grade = mark.getGrade();
        System.out.println(grade);
        
        mark.talk(1);
        
        
        
    }
    
}
