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
public class Question2_FibonacciSequence {
    public static void main(String[] Args){
        int[] array1 = new int[5];
        int[] array2 = new int[15];
        int[] array3 = new int[25];
        fillFibonacci(array3);
        printFibonacci(array3);
        Console.println();
//        fillFibonacci(array2);
//        printFibonacci(array2);
//        Console.println();
//        fillFibonacci(array3);
//        printFibonacci(array3);
//        Console.println();
    }
    public static int[] fillFibonacci(int[] data){
        for(int i = 0;i<data.length;i++){
            if(i==0||i==1){
                data[i]=1;
            }else{
                data[i]= data[i-1]+data[i-2];
            }
        }
        return data;
    }
    public static void printFibonacci(int[] data){
        for(int i = 0;i<data.length;i++){
            Console.println(data[i]);
        }
    }
    
}
