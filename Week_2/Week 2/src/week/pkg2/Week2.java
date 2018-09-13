/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package week.pkg2;

/**
 *
 * @author csf17don
 */
import java.util.Scanner;
public class Week2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        // TODO code application logic here
        Q2();
    }
    public static void Q1()
    {
        int Lowest, Highest, current, rangeNo = 0, Total = 0;
        System.out.println("What is the Lowest Temperature of today? ");
        Scanner reader = new Scanner(System.in);
        Lowest = reader.nextInt();
        System.out.println("What is the Highest Temperature of today? ");
        Highest = reader.nextInt();
        
        current = Lowest;
        while(current>=Lowest && current < Highest){
            Total = Total + current;
            current++;
            rangeNo++;
        }
        int Average = Total / rangeNo;
        System.out.println("The average of the Temperatures in the range is: "+Average);
    }
    
    public static void Q2()
    {
            double startReading, endReading, Mon, Tues, Wed, Thurs, Fri, WeeksMileage, FuelEff;
            System.out.println("What is the start Reading of the odometer?");
            Scanner reader = new Scanner(System.in);
            startReading = reader.nextInt();
            System.out.println("What is the End Reading of the odometer?");
            endReading = reader.nextInt();
            System.out.println("What is the Average Fuel Consumption of the Car?");
            FuelEff = reader.nextDouble();
            WeeksMileage = endReading - startReading;
            Mon = 10 * FuelEff;
            Tues = 16 *FuelEff;
            Wed = 11* FuelEff;
            Thurs = 15 *FuelEff;
            Fri = 20 * FuelEff;
            System.out.println("Mileage For Monday is "+Mon);
            System.out.println("Mileage For Tuesday is "+Tues);
            System.out.println("Mileage For Wednesday is "+Wed);
            System.out.println("Mileage For Thursday is "+Thurs);
            System.out.println("Mileage For Fri is "+Fri);
            double total = Mon+Tues+Wed+Thurs+Fri;
           
            System.out.println("The Total Mileage for this week is: "+total);
                
            
    }
    
}
    

