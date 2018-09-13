package draw;

 

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.io.Serializable;

/*	AView objects are invisible panes for grouping ALibrary objects 
    Author:  David Riley -- July, 2000 */
    
/*	class invariant
            getWidth() >= 0  AND  getHeight() >= 0  */
    	
class AView extends JComponent  
			 implements AShape,  Serializable, MouseListener, MouseMotionListener {

	private Color privateColor = Color.black;
	private boolean isToFill;
	// The variables implement a unique ID nnumber for each AView 
	private static int idShared = 0;
	private int idNum;

// Constructor methods
	/*  postcondition 
                isFilled is false
                AND  getColor() == Color.black 
                AND  getX() == 0   AND  getY() == 0   
                AND  getWidth() == 10  AND  getHeight() == 10   */
	public AView()  {
            super();
            setToOutline();
            addMouseListener(this);
            addMouseMotionListener(this);
            setBounds(0, 0, 10, 10);
            setOpaque( false );
            AView.idShared++;
            idNum = AView.idShared;
	}  

	/*  postcondition 
                isFilled is false
                AND  getColor == Color.black 
                AND  getX() == x   AND  getY() == y   
                AND  getWidth() == w  AND  getHeight() == h   */
	public AView(int x, int y, int w, int h)  {
            super();
            setToOutline();
            addMouseListener(this);
            addMouseMotionListener(this);
            setBounds(x, y, w, h);  //Note: see getX & getY for explanation of "+1"
            setOpaque( false );
            AView.idShared++;
            idNum = AView.idShared;
	}  

// Attributes
	/*  postcondition
                result == the color attribute of this */
	public Color getColor()  {
            return privateColor;
	} 

	/*  postcondition
                result == isFilled attribute of this */
	public boolean isFilled() {
            return isToFill;
	} 

	/*  postcondition
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



// Class Methods
	/*  postcondition
			getColor() == c */
	public void setColor(Color c)  {
            privateColor = c;
	}

	/*  postcondition
			isFilled() is true */
	public void setToFill()  {
            isToFill = true;
	} 

	/*  postcondition
   		isFilled() is false */
	public void setToOutline()  {
            isToFill = false;
	}  

	/*  precondition
                sw >= 0.0  AND  sh >= 0.0   
            postcondition
      		getWidth() == old getWidth() * sw   
      		AND   getHeight() == old getHeight() * sh */
	public void scale(double sw, double sh)  {
            setBounds(getX(), getY(),
            (int)(getWidth() * sw),
            (int)(getHeight() * sh));
	} 

	/*  postcondition
                getX() == old getX() + tx   
                AND   getY() == old getY() + ty  */
	public void translate(double tx, double ty)  {
            setLocation((int)(getX() + tx), (int)(getY() + ty));
	} 
   
	/*  postcondition
                this is added to the c container */
	public void place(Container c)  {
            c.add(this,0);  //zero places at front of list
	}

	/*  postcondition
                this is removed from where it is placed  
                AND  parentContainer() == null  */
	public void remove()  {
            if  (getParent() != null)
                getParent().remove(this);
	}
   
	/*  postcondition
                result == the attributes of this object   */
	public String toString()   {
            String  result = "AView object .... (#V" + idNum + ")" + "\n";
            result = result + "     x: " + getX() +",   y: "+getY();
            result = result + "     width: " + getWidth() +",   height: "+getHeight() + "\n";
            if (parentContainer() == null)   {
                result = result + "     not placed ";
            } else   {
                result = result + "     is placed ";
            }
            return result;
   	}	


// Auxiliary Methods (for drawing) 
	/* This operation is designed to be redefined by the  
            subclass to define what is drawn when isFilled == false  
            The stroke() function is not normally called directly.  
            (In order to update the image repaint() should be called.)  */
	public void stroke(Graphics g)
	{ }

	/* This operation is designed to be redefined by the  
            subclass to define what is drawn when isFilled == true  
            The fill() function is not normally called directly.  
            (In order to update the image repaint() should be called.)   */
	public void fill(Graphics g)
	{ } 

	/* The stroke() and fill() functions define the image to be  
            drawn for AShape objects.  
            The draw() function is not normally called directly.  
            (In order to update the image repaint() should be called.)  */
	public final void draw(Graphics g)
	{
            //g.setClip(0, 0, getWidth()+1, getHeight()+1);
            g.setColor(getColor());
            if (isFilled())
                fill(g);
            else
                stroke(g);
	}

	/* The stroke() and fill() functions define the image to be  
            drawn for AShape objects.  
            The paint() function is not normally called directly.  
            (In order to update the image repaint() should be called.) */
	public final void paint(Graphics g)
	{
            draw(g);
            paintChildren(g);
	}  


// Mouse event handlers
	public void mouseClicked(MouseEvent e)
	{}

	public void mousePressed(MouseEvent e)
	{}

	public void mouseReleased(MouseEvent e)
	{}

	public void mouseEntered(MouseEvent e)
	{}

	public void mouseExited(MouseEvent e)
	{}

// Mouse motion event handlers
	public void mouseDragged(MouseEvent e)
	{}

	public void mouseMoved(MouseEvent e)
	{}
   
}