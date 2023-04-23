package exercise15photonlincojacob;

import java.util.*;
/**
 * A Subject contains the units and grades of a student for that subject
 * @author Linco
 */
public class Subject {  
   
    private String name, imgFileName;
    private double units, grade;
    protected static ArrayList<Subject> subjectList = new ArrayList();
    
    /**
    *Constructs a new subject
    * @param n Name of the new subject
    * @param i File name of the icon of the new subject
    * @param u Units of the new subject
    * @param g Grade of the student for the new subject
    */
    public Subject(String n, String i, double u, double g){
        name = n;
        imgFileName = i;
        units = u;
        grade = g;
        subjectList.add(this);
    }
    
    /**
    * @return this Subject's name
    */
    public String getName() {
        return name;
    }
    /**
    * @return this Subject's imgFileName
    */
    public String getImgFileName(){
        return imgFileName;
    }
    /**
    * @return this Subject's units
    */
    public double getUnits() {
        return units;
    }
    /**
    *changes this Subject's units
    * @param units this Subject's new units
    */
    public void setUnits(double units) {
        units = units;
    }
    /**
    * @return this Subject's units
    */
    public double getGrade() {
        return grade;
    }
    /**
    *changes the grades of the student for this Subject
    * @param grade this Subject's new grades
    */
    public void setGrade(double grade) {
        grade = grade;
    }
    
    /**
    *@return the subjectList's array size
    */
    public static int getListLength() {
        return subjectList.size();
    }
    /**
    *gets a subject from the subjectList given an index
    * @param index index of the subject in subjectList
    * @return Subject with the corresponding index
    */
    public static Subject getSubjectByIndex(int index){
        return subjectList.get(index);
    }
    /**
    *gets the index of a subject in this subjectList given a subject
    * @param s subject to get the index of
    * @return Subject with the corresponding index
    * @throws NullPointerException
    */
    public static int getSubjectIndex(Subject s) throws NullPointerException {
        if(subjectList.contains(s)) return subjectList.indexOf(s);
        else throw new NullPointerException();
    }
    /**
    *gets the index of a subject in the subjectList given a subject name
    * @param s name of the subject to get the index of
    * @return Subject with the corresponding index
    * @throws NullPointerException
    */
    public static int getSubjectIndex(String s) throws NullPointerException {
        if(subjectList.contains(searchSubject(s))) return subjectList.indexOf(s);
        else throw new NullPointerException();
    }
    /**
    *searches for a subject in the subjectList given a subject name
    * @param search name of the subject to search
    * @return Subject that has a matching name with the parameter
    * @throws NullPointerException
    */
    public static Subject searchSubject(String search) throws NullPointerException {
        for(Subject s : subjectList){
            if(s.getName().equalsIgnoreCase(search)) return s;
        }
        throw new NullPointerException();
    }
}
