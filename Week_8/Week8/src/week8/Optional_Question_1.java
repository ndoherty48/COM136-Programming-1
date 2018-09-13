/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;
import uulib.GUI;
/**
 *
 * @author csf17don
 */
public class Optional_Question_1 {
    public static void main(String[] args) {
        //Program Starts Here
        String Verse = verses("Dog","Woof")+verses("Cow","Moo")+verses("Duck","Quack");
        GUI.show(Verse);
    }
    public static String verses(String animal, String sound){
        
        //Using the console this prints the nursery rhyme verses with the parameters given by user
        String Verse = "Old McDonald had a farm, E-I-E-I-O"+"\n"+
                "And on the farm he had a "+animal+", E-I-E-I-O "+"\n"+
                "With a "+sound+" "+sound+" here and a "+sound+" "+sound+" there"+"\n"+
                "Here a "+sound+", there a "+sound+", everywhere a "+sound+" "+sound+"\n"+
                "Old McDonald had a farm, E-I-E-I-O "+"\n\n";
        
        return Verse;
        
    }
}
