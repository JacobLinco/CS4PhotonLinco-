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
public class favAnime {
    String title;
    double plot,characters,dialogue,overall;
    int followerNum;
    
    public favAnime (String t, double r, int f) {
        title = t;
        overall = r;
        followerNum = f;
    }
    
    public void changeRating(double p, double c, double d) {
        plot = p;
        characters = c;
        dialogue = d;
        overall = (p+c+d)/3;
    }
    
    
}
