package draw;

import java.awt.*;

/*  DrawingTool is like a drawing pen that 
can be moved around a drawing canvas
This is similar to a turtle from the 
LOGO programming language.  

Class Invariant
parentContainer == window
AND  up <= direction <= left */

public class DrawingTool extends AView {
    private static AWindow window;
    private int locX, locY;
    private boolean isDrawing;
    private int direction;
    public static final int UP = 0;
    public static final int RIGHT = 1;
    public static final int DOWN = 2;
    public static final int LEFT = 3;

    /*  postcondition    
    old window != null  IMPLIES  window == old window
    AND  window.getWidth()==400  AND  window.getHeight()==300 
    AND  getX()==195  AND  getY()==141  AND getWidth()==getHeight()==9
    AND  isDrawing  
    AND  direction == up
    AND  getColor() == Color.green  */

    public DrawingTool() {
        super(96, 66, 9, 9);
        if  ( AWindow.getWindowCounter() == 0 )   {
            window = new AWindow(10, 10, 200, 150);
            window.setTitle( "Drawing Canvas" );
        }
        locX = 100;
        locY = 75;
        penDown();
        direction = UP;
        place(window);
        repaint();
        window.show();
        window.repaint();
    }

    /**
     * Set drawingtool colour
     * @param color - valid colours are green, red, blue, black, yellow
     */
    public void setColor(String color)
    {
        if (color == "green")
            setColor(Color.green);
        else if (color == "red")
            setColor(Color.red);
        else if (color == "blue")
            setColor(Color.blue);
        else if (color == "black")
            setColor(Color.black);
        else if (color == "yellow")
            setColor(Color.yellow);

        window.repaint();         
    }

    /*  postconditon
    isDrawing
    AND  getColor == Color.green */ 
    public void penDown()   {
        isDrawing = true;
        setColor( Color.green );
        window.repaint();
    }

    /*  postconditon
    NOT isDrawing
    AND  getColor == Color.red */ 
    public void penUp()   {
        isDrawing = false;
        setColor( Color.red );
        window.repaint();
    }

    /*  postconditon
    direction == a 90 clockwise rotation from old direction */
    public void turnRight()   {
        direction = (direction + 1) % 4;
        adjustArrow();
        repaint();
        window.repaint();
        delay500();
    }

    /*  postconditon
    direction == a 90 counterclockwise rotation from old direction */
    public void turnLeft()   {
        if (direction == 0)   {
            direction = 4;
        }
        direction--;
        adjustArrow();
        repaint();
        window.repaint();
        delay500();
    }

    public int getDirection() {
        return direction;
    }
    
    /*  postconditon
    the arrow is placed so that it is positioned in front
    of the (locX, locY) position. */
    private void adjustArrow()   {
        if (direction == UP)   {
            setLocation(locX-4, locY-9);
        } else if (direction == RIGHT)   {
            setLocation(locX, locY-4);
        } else if (direction == DOWN)   {
            setLocation(locX-4, locY);
        } else   {
            setLocation(locX-9, locY-4);
        }
        repaint();
        delay500();
    }

    /*  postconditon
    (locX, locY) is a point that is d units from (old locX, old locY)
    moving according to direction
    AND  isDrawing IMPLIES a line segment is drawn connecting (locX, locY)
    with (old locX, old locY) */
    public void moveForwardBy( int d )   {
        ALine line;
        int newX, newY;
        newX = locX;
        newY = locY;
        if  ( direction == UP )   {
            newY = locY - d;
        } else if  ( direction == RIGHT )   {
            newX = locX + d;
        } else if  ( direction == DOWN )   {
            newY = locY + d;
        } else    {
            newX = locX - d;
        }
        if  ( isDrawing )   {
            line = new ALine(locX, locY, newX, newY);
            line.place(window);
            line.repaint();
        }
        locX = newX;
        locY = newY;
        adjustArrow();
        window.repaint();
    }

    /*  postconditon
    (locX, locY) is a point that is 20 units from (old locX, old locY)
    moving according to direction
    AND  isDrawing IMPLIES a line segment is drawn connecting (locX, locY)
    with (old locX, old locY) */
    public void moveForward()   {
        moveForwardBy(20);
        delay500();
    }

    /* postconditon
    this AView is drawn as an arrow using the given getColor() */
    public void stroke(Graphics g)  {
        g.setColor(getColor());
        if ( direction == UP )   {
            g.drawLine(1, 6, 4, 0);  
            g.drawLine(4, 0, 7, 6);  
            g.drawLine(4, 0, 4, 8);  
            g.drawLine(3, 2, 5, 2);  
            g.drawLine(3, 3, 5, 3);  
            g.drawLine(2, 4, 6, 4);  
            g.drawLine(2, 5, 6, 5);  
        }  else if  ( direction == RIGHT ) {
            g.drawLine(2, 1, 8, 4);  
            g.drawLine(8, 4, 2, 7);  
            g.drawLine(0, 4, 8, 4);  
            g.drawLine(6, 3, 6, 5);  
            g.drawLine(5, 3, 5, 5);  
            g.drawLine(4, 2, 4, 6);  
            g.drawLine(3, 2, 3, 6);  
        }  else if  ( direction == DOWN ) {
            g.drawLine(1, 2, 4, 8);  
            g.drawLine(4, 8, 7, 2);  
            g.drawLine(4, 0, 4, 8);  
            g.drawLine(3, 6, 5, 6);  
            g.drawLine(3, 5, 5, 5);  
            g.drawLine(2, 4, 6, 4);  
            g.drawLine(2, 3, 6, 3);  
        }  else {
            g.drawLine(6, 1, 0, 4);  
            g.drawLine(0, 4, 6, 7);  
            g.drawLine(0, 4, 8, 4);  
            g.drawLine(2, 3, 2, 5);  
            g.drawLine(3, 3, 3, 5);  
            g.drawLine(4, 2, 4, 6);  
            g.drawLine(5, 2, 5, 6);  
        }
    }

    
    /*   postconditon
    this AView is drawn as an arrow using the given getColor() */
    public void fill(Graphics g)  {
        stroke(g);
    }

    /*   postconditon
    window == null */
    public void finalize()  {
        window = null;
    }

    private void delay500() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {}
    }
}