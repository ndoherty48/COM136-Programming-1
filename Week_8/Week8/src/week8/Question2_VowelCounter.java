/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;
import uulib.*;
/**
 *
 * @author csf17don
 */
public class Question2_VowelCounter {
    public static void main(String[] args) {
        //Program Starts Here
        //Variables are declared here
        final char SENTINEL = '.';          //This variable is final and cannot be changed at a later stage
        int count =0;
        boolean result;
        //variable input asks for user to input a character
        char input = Console.getChar("Enter character");
        //While loop starts aslong as the user has not inputed the SENTINEL Character
        while(input != SENTINEL){
            result = isVowel(input);
            if(result == true){
                //adds 1 to count if it is a vowel because this method returns true if it is a vowel
                count++;
            }
            //prompts user to re-enter a character
            input = Console.getChar("Enter character");
        }
        //outputs how many vowels have been entered after the user has entered the SENTINEL value
        System.out.println(count+" vowels entered");
        
    }
    
    
    public static boolean isVowel(char input){
        //This Method checks the users input in order to check whether it is a vowel or not and returns true if it is a vowel
        boolean rValue = false;                 //Default boolean value that will be used if it is not a vowel

        //if statement that cheks users input and will execute if it contains a vowel
        if(input == 'A'||input == 'a'||input=='E'||input =='e'||input=='I'||input  == 'i'|| input =='O'|| input=='o'||input =='U'||input=='u'){
            //boolean variable from aboves value is changed to true;
            rValue = true;
        }
        return rValue;                          //Value is returned to where method was called
    }
}
