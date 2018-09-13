/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practical3;

/**
 *
 * @author csf17don
 */
public class Question5 
{
    public static void main(String[] args)
    {
        int total = 0;
        int number = 12;
        while(total < 5)
        {
            if(number % 2 ==1)
            {
                number = number - 10;
            }
            else
            {
                number = number + 1;
            }
            total = total +1;
            System.out.println("Total = " +total + " and Number = " +number);
        }
    }
    
}

