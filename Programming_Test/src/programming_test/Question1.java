/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming_test;
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
        int value = Console.getInt("enter a number");
        
        if(value % 2 == 0){
          System.out.println(value+" is an even number");
        }
        else{
           System.out.println(value+" is an odd number");
        }
        
        
    }
    
}
