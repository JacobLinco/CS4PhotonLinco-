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
public class Ex04PhotonLinco {
    
    
    
    public static void main(String[] args) {
        favAnime fav1 = new favAnime("Bunny Girl Senpai",8.26,1514643);
        favAnime fav2 = new favAnime("k-on!!",8.17,968242);
        favAnime fav3 = new favAnime("Odd Taxi",8.72,335143);
        
        Song song1 = new Song("Let it go",810728369,2013);
        Song song2 = new Song("A Whole New World",4334990,1992);
        Singer singer1 = new Singer("Bruno Mars");
        Singer singer2 = new Singer("Lady Gaga");
        singer1.changeFavSong(song1);
        singer2.changeFavSong(song1);
        
        System.out.printf("singer name: %s%nsinger earnings: %.1f%nsinger's favorite song: %s%n%n",singer1.getName(),singer1.getEarnings(),singer1.getFavSong().getTitle());
        
        singer1.performForAudience(12);
        singer1.changeFavSong(song2);
        
        System.out.printf("singer name: %s%nsinger earnings: %,.1f%nsinger's favorite song: %s%n%n",singer1.getName(),singer1.getEarnings(),singer1.getFavSong().getTitle());
        singer1.performForAudience(singer2, 12);
        
        System.out.printf("singer name: %s%nsinger earnings: %,.1f%nsinger's favorite song: %s%n%n",singer1.getName(),singer1.getEarnings(),singer1.getFavSong().getTitle());
        System.out.printf("singer name: %s%nsinger earnings: %,.1f%nsinger's favorite song: %s%n%n",singer2.getName(),singer2.getEarnings(),singer2.getFavSong().getTitle());
        System.out.println(Singer.getTotalPerformances());        
        
    }
}
