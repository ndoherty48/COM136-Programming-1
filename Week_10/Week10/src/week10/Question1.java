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
public class Question1 {

    public static String getCoinValue(int coin) {
        String returnValue = "invalid "+coin;
        if (coin == 1){
            returnValue = "one penny";
        }else if(coin == 2){
            returnValue = "two pence";
        }else if(coin == 5){
            returnValue = "five pence";
        }else if(coin == 10){
            returnValue = "ten pence";
        }else if(coin == 20){
            returnValue = "twenty pence";
        }else if(coin == 50){
            returnValue = "fifty pence";
        }else if(coin == 100){
            returnValue = "one pound";
        }else if(coin == 200){
            returnValue = "two pounds";
        }
        
        return returnValue;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        final int SENTINEL = 0;
        int coin = Console.getInt("coin");
        while(coin != SENTINEL){
            System.out.println(getCoinValue(coin));
            coin = Console.getInt("coin");
        }
    }
    
}
