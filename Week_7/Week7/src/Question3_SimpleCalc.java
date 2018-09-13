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
public class Question3_SimpleCalc {
    public static void main(String[] args){
        //variables to hold the contents for the calculations
        int num1 = Console.getInt("num1"),
                num2,
                answer;
        char op;
        
        //this command will execute aslong as the first number isnt 0. if so program will terminate
        while(num1 != 0){                       //Sentinel loop that only executes if num1 not equal to 0
            op = Console.getChar("op");         //User enters operator using a char for program to use
            
            num2 = Console.getInt("num2");      //User enters the second number
            switch (op) {
                case '+':
                    //Adds num1 & num2 if the operator = +
                    answer = num1+num2;
                    break;
                case '-':
                    //Subtracts num1 & num2 if the operator = -
                    answer = num1-num2;
                    break;
                case '*':
                    //Multiplies num1 & num2 if the operator = *
                    answer = num1*num2;
                    break;
                case '/':
                    //Divides num1 & num2 if the operator = /
                    answer = num1/num2;
                    break;
                default:
                    //Default statement if the user has inputed a char that does not match + - * /
                    answer = 0;
                    break;
            }
            Console.println("= "+answer);       //Prints the answer to the console
            num1 = Console.getInt("num1");      //Asks the user to re-enter their first number
        }
    }
}
