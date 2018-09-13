/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;
import uulib.Console;
/**
 *
 * @author csf17don
 */
public class Question4 {
    public static void main(String[] args){
        int yearEntered = Console.getInt("Year");
        if(yearEntered % 100 == 0){
            if(yearEntered%400== 0){
                System.out.println("Leap Year");
            }
            else{
                System.out.println("Not Leap Year");
            }
        }else{
            if (yearEntered%4 ==0){
                System.out.println("Leap Year");
            }
            else{
                System.out.println("Not Leap Year");
            }
            
        }
        
    }
}
