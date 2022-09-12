/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex02photonlinco;
import java.util.Scanner;

/**
 *
 * @author PHOTON
 */
public class Ex02PhotonLinco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       //define needed variables. welcome text
       System.out.printf("Welcome to Higher or Lower. ");
       boolean cont = true;
       int gNum = 3;
       int range = 10;
       int Nguess = 3;
       String sInput = "";
       
       //start while loop for game option
       while(!sInput.equals("e")) {
        System.out.printf("What do you want to do?(input the letter in parenthesis) %n-play game(p)%n-change settings(s)%n-end application(e)%n");
        sInput = sc.nextLine();
        switch(sInput) {
            case "p":

                 //while loop for the game itself
                 while(cont) {
                     int random = (int) Math.floor(Math.random()*range) + 1;
                     if(gNum==0) {
                         gNum+=3;
                     }
                     //while loop for guessing, to separate end game conditions
                     while(gNum!=0){
                         System.out.printf("You have %d guess(es) left. What is your guess? ", gNum);
                         var gInput = sc.nextInt();
                         sc.nextLine();

                         if(gInput>random){
                            System.out.printf("lower%n");
                            gNum-=1;
                         }
                         if(gInput<random){
                            System.out.printf("higher%n");
                            gNum-=1;
                         }
                         if(gNum==0) {
                             System.out.printf("you have no more guesses. ");
                         }
                         if(gInput==random){
                            System.out.print("Correct! ");
                            gNum = 0;
                         } 
                     }
                     
                     //game end condition
                     System.out.printf("Would you like to play one more?(y/n) ");
                     String contInput = sc.nextLine();
                     switch(contInput) {
                            case "n":
                                 System.out.printf("Thank you for playing!");
                                 cont = false;
                                 sInput = "e";
                                 break;   
                        }
                 }
                 break;
                 
            case "s":
                //change range or guess number
                System.out.printf("What would you like to change?%n-range(r)%n-number of guesses(g)%n");
                var setInput = sc.nextLine();
                switch(setInput) {
                    case "r":
                        System.out.printf("Input new range: ");
                        var Nrange = sc.nextInt();
                        sc.nextLine();
                        range = Nrange;
                        break;
                        
                    case "g":
                        System.out.printf("Input new number of guesses: ");
                        Nguess = sc.nextInt();
                        sc.nextLine();
                        gNum = Nguess;
                        break;
                }
                
            case "e":
                //end app
                 System.out.printf("applcation ended.");
                 break;
        }
       }

    }
    
}
