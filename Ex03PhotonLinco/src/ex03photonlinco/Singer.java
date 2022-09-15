/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex03photonlinco;

/**
 *
 * @author PHOTON
 */
public class Singer {
    String name;
    int noOfPerformances;
    double earnings;
    Song favoriteSong;

    public Singer(String n) {
        name = n;
        noOfPerformances = 0;
        earnings = 0.0;
    }
    
    public void performForAudience(int numPeople) {
        noOfPerformances += 1;
        earnings += 100*numPeople;
    }
    
    public void changeFavSong(Song s) {
        favoriteSong = s;
    }
        
}
