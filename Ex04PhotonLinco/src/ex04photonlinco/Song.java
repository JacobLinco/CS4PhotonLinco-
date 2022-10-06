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
public class Song {
    //fields
    private final String title;
    private final int views;
    private final int pubYear;

    
    //main method
    public Song(String t, int s, int p) {
        title = t;
        views = s;
        pubYear = p;
    }
    
    //accessor methods
    public String getTitle() {
        return title;
    }
    
    public int getViews() {
        return views;
    }

    public int getPubYear() {
        return pubYear;
    }
    
}
