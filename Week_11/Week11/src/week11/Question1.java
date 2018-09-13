/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week11;
import uulib.Console;
/**
 *
 * @author csf17don
 */
public class Question1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] temps = {12, 3, 9, -2, 8, 2, 15, -3, 7, -1, 9, 4, 14, 5};
        Console.println(countCold(temps)+" cold nights");
        Console.println(countWarm(temps)+" warm nights");
        Console.println(averageTemp(temps)+" average temp");
    }
    // return number of nights when temperature was < 1 (cold)
    public static int countCold(int[] temps) { 
        int X=0;
        for(int i =0;i<temps.length;i++){
            if(temps[i]<1){
                X++;
            }
        }
        return X;
    }
    // return number of nights when temperature was > 10 (warm)
    public static int countWarm(int[] temps) {
        int Y = 0;
        for(int i=0;i<temps.length;i++){
            if(temps[i]>10){
                Y++;
            }
        }
        return Y;
    }
    // return the average of the temperatures passed in the array
    public static int averageTemp(int[] temps) {
        int X= 0,Z = 0;
        for(int i=0;i<temps.length;i++){
            X = X+temps[i];
        }
        Z= (X / temps.length);
        return Z;
    }
}
