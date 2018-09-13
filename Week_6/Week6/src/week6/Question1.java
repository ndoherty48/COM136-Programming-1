/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;
import uulib.GUI;
/**
 *
 * @author csf17don
 */
public class Question1{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int number = GUI.getInt("Please enter an integer");
        
        if(number%3 ==0){
            GUI.show("This number is divisible by 3");
        }
        else{
            GUI.show("This number is not divisible by 3");
        }
    }
    
}
