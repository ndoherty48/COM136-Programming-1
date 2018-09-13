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
public class Question1_TemperatureConv1 {
    public static void main (String[] Args){
        double tempC = GUI.getDouble("What is the temperature in C you wish to convert?");
        while(tempC > -99){
            double farenheit = 9.0/5.0*tempC+32;
            GUI.show("The Temperature of "+Num.format(tempC,2)+"C is "+Num.format(farenheit,2)+"F");
            tempC = GUI.getDouble("What is the temperature in C you wish to convert?");
           
        }
        if(tempC == -99){
            double farenheit = 9.0/5.0*tempC+32;
            GUI.show("The Temperature of "+Num.format(tempC,2)+"C is "+Num.format(farenheit,2)+"F");
        }
        
    }
}
