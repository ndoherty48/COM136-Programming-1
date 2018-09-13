package draw;

 

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/* 	APanel is a class with package scope that is used only by AWindow.
    Author:  David Riley -- July, 2000 */

class APanel extends JPanel
                implements AShape,  Serializable  {
				
	private AWindow window;

// Constructor 
	/*	postcondition
			this Panel object is instantiated
   			window == w   */
	public APanel(AWindow w) {  
		super();  
		window = w;
	}
    
    
// Attribute
	/*	postcondition
   			result == the parent object upon which this is placed   */
	public Container parentContainer()   {
   		return null;
	}

	/*	postcondition
   			result == window   */
	public Container getAWindow()   {
		return window;
	}

// Class Methods 
   /* 	postcondition
   			this is added to the c container */
	public void place(Container c)   {
	}
	
	public void remove()  {
	}
   
	/* 	postcondition
			getX() == x   AND   getY() == y  */
	public void setLocation(int x, int y)   {
   		window.setLocation(x, y);
	}
 
	/* 	postcondition
   			getWidth() == w   AND   getHeight() == h  */
   	public void setSize(int w, int h)   {
   		window.setSize(w, h);
	}

	/*	precondition
   			sw >= 0.0  AND  sh >= 0.0   
		postcondition
			getWidth() == old getWidth() * sw   
      		AND   getHeight() == old getHeight() * sh */
	public void scale(double sw, double sh)   {
   		window.scale(sw, sh);
	}

	/* 	postcondition
   			getX() == old getX() + tx   
   			AND   getY() == old getY() + ty  */
	public void translate(double tx, double ty)   {
   		window.translate(tx, ty);
	}
	
	/* 	postcondition
			result == the attributes of this object   */
	public String toString()   {
		return window.toString();
   	}	
}