package draw;

 

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/*  An ALine object is designed to display line segment on AShape or window objects 
	Author:  David Riley -- July, 2000   */


/* class invariant
		getX() >= 0  AND  getY() >= 0  
		AND  getWidth() >= 0  AND  getHeight() >= 0  
		AND a line segment is drawn to connect point
				(x(), y()) to point (x()+width(), y()+height())*/
/*	ALine objects are designed to display line segments. 
    Author:  David Riley -- May, 2000 */
    
/*	class invariant
    	getWidth() >= 0  AND  getHeight() >= 0 
            AND  isMajorDiagonal IMPLIES
            		a line segment is drawn connecting point (getX(), getY())
            		with point (getX()+getWidth()-1, getY()+getHeight()-1) 
            AND  (NOT isMajorDiagonal) IMPLIES 
            		a line segment is drawn connecting point (getX()+getWidth()-1, getY())
            		with point (getX(), getY()+getHeight()-1) */
public class ALine extends JComponent 
	 implements AShape,  Serializable  {

	private int leftx;
	private int lefty;
	private int rightx;
	private int righty;
	private Color privateColor;
	private boolean isMajorDiagonal;
	// The variables implement a unique ID nnumber for each ARectangle 
	private static int idShared = 0;
	private int idNum;

// Attributes:
	/* 	postcondition
   			result == the color attribute of this */
	public Color getColor()  {
		return privateColor;
	} 

	/* 	postcondition
			result == the parent object upon which this is placed   */
	public Container parentContainer()  {
		Container c;
   		c = getParent();
   		if (c instanceof APanel)   {
   			return ((APanel)c).getAWindow();
   		} else {
   			return c;
   		}
	} 


// Constructor method
	/*	postcondition 
   			a line object is instantiated to connect
               points (x1, y1) and (x2, y2)
            AND  isMajorDiagonal IMPLIES 
            		(getX()==x1 & getY()==y1 & getWidth()=(x2-x1)+1 & getHeight()=(y2-y1)+1)
            		OR (getX()==x2 & getY()==y2 & getWidth()=(x1-x2)+1 & getHeight()=(y1-y2)+1)
            AND  (NOT isMajorDiagonal) IMPLIES 
            		(getX()==x1 & getY()==y2 & getWidth()=(x2-x1)+1 & getHeight()=(y1-y2)+1)
            		OR (getX()==x2 & getY()==y1 & getWidth()=(x1-x2)+1 & getHeight()=(y2-y1)+1)
			AND  getColor() == Color.black */
	public ALine(int x1, int y1, int x2, int y2)  {
		super();
		if (x1 < x2)   {
			leftx = x1;
			lefty = y1;
			rightx = x2;
			righty = y2;
		} else {
			leftx = x2;
			lefty = y2;
			rightx = x1;
			righty = y1;
		}
		setColor(Color.black);
		rightx++;
		if (lefty > righty)   {
			lefty++;
		} else {
			righty++;
		}
		isMajorDiagonal = (lefty < righty);
		if (isMajorDiagonal)  {
			setBounds(leftx, lefty, rightx-leftx, righty-lefty);
		} else {
			setBounds(leftx, righty, rightx-leftx, lefty-righty);
		} 
		idShared++;
		idNum = idShared;
	}


// Class Methods
	/*	postcondition
			getColor() == c */
	public void setColor(Color c)  {
		privateColor = c;
	}

	/* 	precondition
			sw >= 0.0  AND  sh >= 0.0   
		postcondition
      		getWidth() == old getWidth() * sw   
      		AND   getHeight() == old getHeight() * sh */
	public void scale(double sw, double sh)  {
		setBounds(getX(), getY(),
					(int)(getWidth() * sw),
					(int)(getHeight() * sh));
	} 

	/* 	postcondition
			getX() == old getX() + tx   
			AND   getY() == old getY() + ty  */
	public void translate(double tx, double ty)  {
		setLocation((int)(getX() + tx), (int)(getY() + ty));
	} 
   
	/* 	postcondition
   			this is added to the c container */
	public void place(Container c)  {
		c.add(this,0);  //zero places at front of list
	}

	/* postcondition
   		this is removed from where it is placed  
		AND  parentContainer() == null  */
	public void remove()  {
		if  (getParent() != null)
			getParent().remove(this);
	}
   
	/* 	postcondition
			result == the attributes of this object   */
	public String toString()   {
		String  result = "ALine object .... (#LN" + idNum + ")" + "\n";
   		result = result + "     left endpoint: (" + leftx +", "+lefty+")";
   		result = result + "     right endpoint: (" + rightx +", "+righty+")" + "\n";
		if (parentContainer() == null)   {
   			result = result + "     not placed, ";
   		} else   {
   			result = result + "     is placed, ";
   		}
   		result = result + "   color: "+colorString(getColor());
		return result;
   	}	


   	
// private methods
	private String colorString( Color c )   {
		if (c == Color.black)   {
			return "black";
		} else if (c == Color.blue)   {
			return "blue";
		} else if (c == Color.cyan)   {
			return "cyan";
		} else if (c == Color.darkGray)   {
			return "dark gray";
		} else if (c == Color.gray)   {
			return "gray";
		} else if (c == Color.green)   {
			return "green";
		} else if (c == Color.lightGray)   {
			return "light gray";
		} else if (c == Color.magenta)   {
			return "magenta";
		} else if (c == Color.orange)   {
			return "orange";
		} else if (c == Color.pink)   {
			return "pink";
		} else if (c == Color.red)   {
			return "red";
		} else if (c == Color.white)   {
			return "white";
		} else if (c == Color.yellow)   {
			return "yellow";
		} else {
			return "redness: "+c.getRed() + "   greeness: "+c.getGreen()+"   blueness: "+c.getBlue();
		}
	}




// Auxiliary Methods
	/*	postcondition
   			this line segment is drawn using the given getColor() */
	public void paint(Graphics g)  {
		g.setColor(getColor());
		if (isMajorDiagonal)  {
			g.drawLine(0, 0, getWidth()-1, getHeight()-1);  
		}  else  {
			g.drawLine(0, getHeight()-1, getWidth()-1, 0);  
		}
	} 
}
