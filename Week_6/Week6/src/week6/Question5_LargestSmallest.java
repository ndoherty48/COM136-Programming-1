/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;
import uulib.*;
/**
 *
 * @author csf17don
 */
public class Question5_LargestSmallest {
    public static void main(String[] args){
        int num1 = Console.getInt("What is the First Number"),
                num2 = Console.getInt("What is the Second Number"),
                num3 = Console.getInt("What is the Third Number");
        
        if(num1>=num2 && num1>=num3){
           if(num2>num3){
               Console.println("The Largest number is "+num1+"\nThe smallest Number is "+num3);
           }else if(num3>num2){
               Console.println("The Largest number is "+num1+"\nThe smallest Number is "+num2);
           }else if (num3==num2){
               Console.println("The Largest number is "+num1+"\nThe smallest Number is "+num2);
           }           
        }else if(num2>=num1 && num2>=num3){
            if(num1>num3){
               Console.println("The Largest number is "+num2+"\nThe smallest Number is "+num3);
           }else if(num3>num1){
               Console.println("The Largest number is "+num2+"\nThe smallest Number is "+num1);
           }  else if (num3==num1){
               Console.println("The Largest number is "+num1+"\nThe smallest Number is "+num2);
           }     
        }else if(num3>=num1 &&num3>=num2){
             if(num1>num2){
               Console.println("The Largest number is "+num3+"\nThe smallest Number is "+num2);
           }else if(num2>num1){
               Console.println("The Largest number is "+num3+"\nThe smallest Number is "+num1);
           }else if (num1==num2){
               Console.println("The Largest number is "+num1+"\nThe smallest Number is "+num2);
           }       
        }else if(num1==num2&&num2==num3){
            Console.println("The Largest number is "+num1+"\nThe Smallest Number is "+num2);
        }
    }
}
