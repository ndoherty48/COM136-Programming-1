/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;

/**
 *
 * @author csf17don - Nathan Doherty - B00736742
 */
public class Question1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Program Starts Here
        verses("Dog","Woof");
        verses("Cow","Moo");
        verses("Duck","Quack");
        verses("Horse","Neigh");
    }
    public static void verses(String animal, String sound){
        
        //Using the console this prints the nursery rhyme verses with the parameters given by user
        System.out.println("Old McDonald had a farm, E-I-E-I-O ");
        System.out.println("And on the farm he had a "+animal+", E-I-E-I-O ");
        System.out.println("With a "+sound+" "+sound+" here and a "+sound+" "+sound+" there");
        System.out.println("Here a "+sound+", there a "+sound+", everywhere a "+sound+" "+sound);
        System.out.println("Old McDonald had a farm, E-I-E-I-O ");
        System.out.println("");
    }
    
}
