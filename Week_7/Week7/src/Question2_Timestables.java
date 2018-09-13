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
public class Question2_Timestables {

    public static void main(String[] Args) {
        int counter = 1,
                userInput = Console.getInt("Which timestables would you like to see"),
                calc;
        //Enhancement Code that makes sure that user inputs a number between 1 & 12
        while(userInput <1 || userInput>12){
            userInput = Console.getInt("Which timestables would you like to see, \n NB: it must be between 1 & 12");
        }
        
        // Code that works out what results of that timetable is and outputs it to the console
        while (counter <= 12) {
            calc = userInput*counter;
            Console.println(userInput + " * "+counter+" = "+calc);
            counter++;
        }
    }
}
