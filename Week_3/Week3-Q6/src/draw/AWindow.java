package draw;

/* NOTE
	This version of AWindow does not inherit JFrame as described in the textbook.
	This is an unfortunate consequence of a change in SDK Version 1.4 that 
	makes it impractical, if not impossible, to override the getHeight
	and getWidth methods in a meaningful way.  */

 

import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.*;
import java.io.Serializable;

/*	AWindow objects are screen windows designed for placing other objects. 
    Author:  David Riley -- July, 2000 */
    
/*	class invariant
		A run-time menu with a "Quit" entry is included with an AWindow object.
		AND  the first AWindow created in a program has its close button inactivated.
    	AND  getWidth() >= 0  AND  getHeight() >= 0  */
public class AWindow extends Container
		 implements AShape,  Serializable, ActionListener, MouseInputListener, KeyListener {


	private JFrame theWin;
	//  NOTE: theWin is the proxy for this window.

   	// privateWidth is the width of the ContentPane within the window
	private int privateWidth;
   	// privateHeight is the height of the ContentPane within the window
	private int privateHeight;
	// The two variables below assign each window a sequence number
	private int windowNumber;
	private static int windowCounter = 0;
	private MenuItem quitItem;


// Attributes
	/* 	postcondition
   			result == the parent object upon which this is placed   */
	public Container parentContainer()  {
		return null;
	} 

// Constructor methods
	/*	postcondition 
   			this AWindow is instantiated
			AND  getForeground() == Color.black 
			AND  getBackground() == Color.white 
			AND  getX() == 0   AND  getY() == 0   
			AND  getWidth() == 10  AND  getHeight() == 10   
			AND  getTitle == "AWindow"   */
	public AWindow() {  
		theWin = newWindow(0, 0, 10, 10);
		theWin.show();
	}  

	/*	postcondition 
   			this AWindow is instantiated
			AND  getForeground() == Color.black 
			AND  getBackground() == Color.white 
			AND  getX() == x   AND  getY() == y   
			AND  getWidth() == w  AND  getHeight() == h   
			AND  getTitle == "AWindow"   */
	public AWindow(int x, int y, int w, int h) {  
		theWin = newWindow(x, y, w, h); 
		theWin.show();
	}  

// Private operation used by constructors
	/*	postcondition
			AND  getForeground() == Color.black 
			AND  getBackground() == Color.white 
			AND  getX() == x   AND  getY() == y   
			AND  getWidth() == w  AND  getHeight() == h   
			AND  getTitle == "AWindow"   */
	private JFrame newWindow(int x, int y, int w, int h) { 
		JFrame result = new JFrame(); 
		APanel privateCanvas = new APanel(this);
                result.setContentPane( privateCanvas );
		result.getContentPane().setLayout(null);
		if (w < 10)  {
			privateWidth = 10;
		} else {
			privateWidth = w;
		}
		if (h < 10)  {
			privateHeight = 10;
		} else {
			privateHeight = h;
		}
		result.setTitle("AWindow");
		result.setBounds( x, y, privateWidth, privateHeight );

		result.setVisible(true);
		result.getContentPane().setBackground(Color.white);
     
		MenuBar myBar = new MenuBar();
		Menu theMenu = new Menu("JavaRun");
		quitItem = new MenuItem("Quit");
		theMenu.add(quitItem);
		quitItem.addActionListener(this);
		myBar.add(theMenu);
		result.setMenuBar(myBar);

		windowCounter++;
		windowNumber = windowCounter;
   
		result.getContentPane().addMouseListener(this);
		result.getContentPane().addMouseMotionListener(this);
                result.addKeyListener( this );
		adjustWindowSize(result);
		result.getContentPane().repaint();
		result.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose(); 
			}
		});
		result.addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				privateWidth = theWin.getContentPane().getBounds().width;
				privateHeight = theWin.getContentPane().getBounds().height;
				theWin.getContentPane().setBounds(
					theWin.getContentPane().getX(), 
					theWin.getContentPane().getY(), privateWidth, privateHeight);
			}
		});
		result.show();
		result.getContentPane().repaint(1);
		return result;
	} 

// Private Methods
	/* postcondition
			f and its content pane are adjusted in size to privateWidth and privateHeight
			this is resized to match the size of privateCanvas + insets */
	private void adjustWindowSize(JFrame f)   {
      		f.setSize( privateWidth+f.getInsets().left+f.getInsets().right, 
      					privateHeight+f.getInsets().top+f.getInsets().bottom );
		f.getContentPane().setBounds(
			f.getContentPane().getX(), 
			f.getContentPane().getY(), privateWidth, privateHeight);
	}


// Query Methods
	/*	postcondition
 			result == privateWidth */
	public int getWidth()   {
            return privateWidth;
	} 

	/*	postcondition
   			result == privateHeight */
	public int getHeight()   {
            return privateHeight;
	}

	/*	postcondition
			result == theWin.getX() */
	public int getX()  {
		return theWin.getX();
	}


	/*	postcondition
			result == theWin.getY() */
	public int getY()  {
		return theWin.getY();
	}

	/*	postcondition
			result == theWin.getText() */
	public String getTitle()  {
		return theWin.getTitle();
	}

	/*	postcondition
			result == theWin.getText() */
	public String getText()  {
		return theWin.getTitle();
	}


	/*	postcondition
			result == theWin.getBackground() */
	public Color getBackground()  {
		return theWin.getContentPane().getBackground();
	}


	/*	postcondition
			result == theWin.getForeground() */
	public Color getForeground()  {
		return theWin.getContentPane().getForeground();
	}


	/*	postcondition
			result == getBackground() */
	public Color getColor() {
		return getBackground();
	}

// Update Methods
	/*	postcondition
   			does nothing */
	public void place(Container c)   {
	}
	
	public void remove()  {
	}

	public void show() {
                theWin.paintAll( theWin.getGraphics() );
		theWin.show();
	}

	/*	postcondition
			getForeground() == c  */
	public void setForeground(Color c)  {
		theWin.getContentPane().setForeground(c);
	} 

	/*	postcondition
			getBackground() == c  */
	public void setBackground(Color c)  {
		theWin.getContentPane().setBackground(c);
	} 
   
	/*	postcondition
			getColor() == c  */
	public void setColor(Color c)  {
		setBackground(c);
	} 
   
	/*	postcondition
			getX() == x  AND  getY() == y  */
	public void setLocation(int x, int y)  {
		theWin.setLocation(x, y);
	} 

	/*	postcondition
			getText() == s  */
	public void setTitle(String s)  {
		theWin.setTitle(s);
	} 

	/*	postcondition
			getText() == s  */
	public void setText(String s)  {
		theWin.setTitle(s);
	} 

	/* 	precondition
   			sx >= 0.0  AND  sy >= 0.0   
		postcondition
      			getWidth() == old getWidth() * sw   
      			AND   getHeight() == old getHeight() * sh */
	public void scale(double sw, double sh)  {
		privateWidth = (int)(privateWidth * sw);
   		privateHeight = (int)(privateHeight * sh);
   		adjustWindowSize(theWin);
	} 
   
	/* 	precondition
   			w >= 0  AND  h >= 0   
		postcondition
			getWidth() == w   
      		AND   getHeight() == old getHeight() * sy */
	public final void setSize(int w, int h)  {
		privateWidth = w;
		privateHeight = h;
		adjustWindowSize(theWin);
	} 

	/* 	postcondition
   			getX() == old getX() + tx   
   			AND   getY() == old getY() + ty  */
	public void translate(double tx, double ty)  {
		theWin.setLocation((int)(getX() + tx), (int)(getY() + ty));
	} 
	
	/* 	postcondition
			result == the attributes of this object   */
	public String toString()   {
		String  result = "AWindow object .... (#W" + windowNumber + ")" + "\n";
   		result = result + "     title: " + getTitle() + "\n";
   		result = result + "     x: " + getX() +",   y: "+getY();
   		result = result + "     width: " + privateWidth +",   height: "+privateHeight + "\n";
   		result = result + "     color: "+colorString(getColor());
		return result;
   	}	
   	
	/* 	postcondition
			this window is closed
			AND windowCounter == old windowCounter - 1
			AND windowCounter == 0   IMPLIES  the application terminates */
	public void dispose()   {
   		theWin.dispose();
        windowCounter--;
        if (windowCounter == 0)  // no windows remin active
             System.exit(0);
   	}
    
    public static int getWindowCounter()   {
        return windowCounter;
    }
	
	public void removeAll()  {
		theWin.getContentPane().removeAll();
	}
	
	public Component add(Component c)  {
		theWin.getContentPane().add(c);
		return c;
	}
	
	public Component add(Component c, int j)  {
		theWin.getContentPane().add(c, j);
		return c;
	}

	public void repaint()   {
		theWin.repaint();
	}
   		


//Menu Operation Event Handler
	public void actionPerformed(ActionEvent e)  {
		if (e.getSource() == quitItem)
			System.exit(0);
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

// Keystroke event handlers (Use e.getKeyCode() to access keystroke as int
//  or e.getKeyChar() access keystroke as char.)
	public void keyPressed(KeyEvent e)
	{}

	public void keyReleased(KeyEvent e)
	{}

	public void keyTyped(KeyEvent e)
	{}
   
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
}
