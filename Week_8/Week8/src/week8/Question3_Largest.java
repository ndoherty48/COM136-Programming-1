/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week8;
import uulib.*;
/**
 *
 * @author csf17don
 */
public class Question3_Largest {
    public static void main(String[] args){
        final int SENTINEL = 0;
        int largestNum = 0, num;
        num = GUI.getInt("Enter a number");
        while(num!=SENTINEL){
            largestNum = largest(num,largestNum);
            num = GUI.getInt("Enter a number");
        }
        GUI.show("The Largest number that you have entered is "+largestNum);
    }
    public static int largest(int a, int b){
        int rValue;
        if(a>b){ 
            rValue = a;
        }else{
            rValue = b;
        }
        return rValue;
    }
}
