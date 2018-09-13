/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week6;

import uulib.GUI;
import uulib.Num;

/**
 *
 * @author csf17don
 */
public class Question3_Purchase1 {
    public static void main(String[] args){
        //user inputs the price and how much was tendered into system
        double price = GUI.getDouble("What is the purchase price:");
        double tendered = GUI.getDouble("What is the cash amount tendered:");
        double change = 0.00, amount_due = 0.00;
        //
        if(price < tendered){
            change = tendered - price;
            GUI.show("Thank you for your purchase, your change is £"+Num.format(change, 2));  
        }else if(price > tendered){
            amount_due = price - tendered;
            GUI.show("A Further £"+Num.format(amount_due,2) +" is Required");
        }else if(price == tendered){
            GUI.show("Thank you for your purchase, Exact amount tendered!");
        }
    }
}
