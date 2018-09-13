/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import uulib.*;
/**
 *
 * @author Nathan Doherty csf17don B00736742
 */
public class Question4_Guess1 {
    
    public static void main(String[]args){
        final int NUMTOGUESS = (int)(Math.random()*100+1);  //creates a constant int with a random number figure
        int guess = Console.getInt("Enter a guess");        //Asks user to input what they think the number is
        int counter = 1;
        while(guess != NUMTOGUESS){                         //While loop that executes as long as the user hasnt inputted correct num
            if(guess<NUMTOGUESS){                           //Statement that prints that the guess is too low if it is less than the int
                Console.println("You guessed too low!");
            }else if (guess>NUMTOGUESS){
                Console.println("You guessed too High!");
            }
            guess = Console.getInt("Enter a guess");        //Statement that prints that the guess is too high if it is more than the int
            
            counter++;                                      //counts the guesses
        }
        Console.println("It took you "+counter+" attempts to get the number!"); //Code that outputs how many attempts it took the user
    }
}
