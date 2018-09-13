/**
 *
 * @author aiden
 */
import draw.*;
import java.util.Scanner;
public class Q6 {
    
    public static void main(String[] args) {
        int x,y,z;
        System.out.println("What is size of First Square?");
        Scanner reader = new Scanner(System.in);
        x = reader.nextInt();
        System.out.println("What is size of Second Square?");
        y = reader.nextInt();
        z = y/4;
        DrawingTool tool = new DrawingTool();
        tool.moveForwardBy(x);
        tool.turnRight();
        tool.moveForwardBy(x);
        tool.turnRight();
        tool.moveForwardBy(x);
        tool.turnRight();
        tool.moveForwardBy(x);
        tool.turnLeft();
        tool.penUp();
        tool.moveForwardBy(z);
        tool.turnRight();
        tool.moveForwardBy(z);
        tool.turnRight();
        tool.penDown();
        tool.moveForwardBy(y);
        tool.turnRight();
        tool.moveForwardBy(y);
        tool.turnRight();
        tool.moveForwardBy(y);
        tool.turnRight();
        tool.moveForwardBy(y);
        tool.turnRight();
        // manipulate the pen by calling its methods    
    
    }
}
