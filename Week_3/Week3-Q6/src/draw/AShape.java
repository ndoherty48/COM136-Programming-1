package draw;

import javax.swing.*;
import java.awt.*;

/* 	AShape defines a rectangular drawable region
Author:  David Riley -- July, 2000    */

/* class invariant
getX() >= 0  AND  getY() >= 0 
AND  getWidth() >= 0  AND  getHeight() >= 0  */
interface AShape   {

    // Attribute
    /*	postcondition
    result == the parent object upon which this is placed   */
    public Container parentContainer();

    // Class Methods 
    /* 	postcondition
    this is added to the c container */
    public void place(Container c);

    /* 	postcondition
    getX() == x   AND   getY() == y  */
    public void setLocation(int x, int y);

    /* 	postcondition
    getWidth() == w   AND   getHeight() == h  */
    public void setSize(int w, int h);

    /* 	precondition
    sw >= 0.0  AND  sh >= 0.0   
    postcondition
    getWidth() == old getWidth() * sw   
    AND   getHeight() == old getHeight() * sh */
    public void scale(double sw, double sh);

    /* 	postcondition
    getX() == old getX() + tx   
    AND   getY() == old getY() + ty  */
    public void translate(double tx, double ty);
}