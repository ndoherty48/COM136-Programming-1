/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week10;
import uulib.Console;
/**
 *
 * @author csf17don
 */
public class Question2 {
    
    public static void drawLine(int length,char c){
        for(int i=0;i<length;i++){
            System.out.print(c);
        }
    }
    
    public static void drawTriangle(int height){
        int star = 1, spaces = height-1;
        
        for(int i =0;i<height;i++){
            drawLine(spaces,' ');
            drawLine(star,'*');
            drawLine(spaces,' ');
            System.out.print("\n");
            star = star+2;
            spaces = spaces-1;
        }
        
    }
    
    public static void main(String[] args){
       final int SENTINEL = 0; 
       int input = Console.getInt("What is the height of the triangle");
       while(input !=0){
           drawTriangle(input);
           input = Console.getInt("What is the height of the triangle");
       }
       
    }
}
