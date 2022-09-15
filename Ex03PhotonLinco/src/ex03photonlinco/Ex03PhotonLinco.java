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
public class Ex03PhotonLinco {
    
    
    
    public static void main(String[] args) {
        favAnime fav1 = new favAnime("Bunny Girl Senpai",8.26,1514643);
        favAnime fav2 = new favAnime("k-on!!",8.17,968242);
        favAnime fav3 = new favAnime("Odd Taxi",8.72,335143);
        
        Song song1 = new Song("Let it go",810728369,2013);
        Song song2 = new Song("A Whole New World",4334990,1992);
        Singer singer1 = new Singer("Bruno Mars");
        singer1.favoriteSong = song1;
        
        System.out.printf("singer name: %s%nsinger earnings: %.1f%nsinger's favorite song: %s%n%n",singer1.name,singer1.earnings,singer1.favoriteSong.title);
        
        singer1.performForAudience(12);
        singer1.changeFavSong(song2);
        
        System.out.printf("singer name: %s%nsinger earnings: %,.1f%nsinger's favorite song: %s%n%n",singer1.name,singer1.earnings,singer1.favoriteSong.title);   
    }
}
