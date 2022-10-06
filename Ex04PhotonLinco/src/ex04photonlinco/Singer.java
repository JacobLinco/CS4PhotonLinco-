/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex04photonlinco;

/**
 *
 * @author PHOTON
 */
public class Singer {
    private final String name;
    private int noOfPerformances;
    private double earnings;
    private Song favoriteSong;
    private static int totalPerformances;
    //main method
    public Singer(String n) {
        name = n;
        noOfPerformances = 0;
        earnings = 0.0;
    }
    
    //accessor methods
    public String getName() {
        return name;
    }
    
    public Double getEarnings() {
        return earnings;
    }
 
    public Song getFavSong() {
        return favoriteSong;
    }
    
    public static int getTotalPerformances() {
        return totalPerformances;
    }
    //setter methods
    public void changeFavSong(Song s) {
        favoriteSong = s;
    }
    
    //methods
    public void performForAudience(int numPeople) {
        noOfPerformances += 1;
        earnings += 100*numPeople;
        totalPerformances++;
    }
    
    public void performForAudience(Singer anotherSinger, int numPeople) {
        noOfPerformances += 1;
        anotherSinger.noOfPerformances += 1; 
        earnings += 100*numPeople/2;
        anotherSinger.earnings += 100*numPeople/2;
        totalPerformances++;
    }
    

        
}
