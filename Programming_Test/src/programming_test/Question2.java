/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programming_test;

/**
 *
 * @author csf17don
 */
public class Question2 {
  public static int scoresBelow(int value, int[] scores) {
     // complete this method
     int count = 0;
     for(int i = 0;i<scores.length;i++){
         if(scores[i]<value){
             count++;
         }
     }
     return count;
  }
  
  public static int average(int[] scores) {
    // complete this method
    int average=0;
    for(int i=0;i<scores.length;i++){
        average = average +scores[i];
    }
    average = (average/scores.length);
    return average;
  }

  
  public static void main(String[] args) {
  
    // set of test scores
    int[] scores = { 40, 39, 62, 49, 67, 80, 59, 36, 68, 71 };

    // printing mark statistics
    System.out.println(scoresBelow(40,scores)+" marks are below 40");
    System.out.println(average(scores)+ "is the average mark");
    
  }
}
