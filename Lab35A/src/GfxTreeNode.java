import java.awt.*;

public class GfxTreeNode
{
    private int x;					// x coordinate of node
    private int y;					// y coordinate of node
    private final int width;		// width of the gfx node
    private final int height;		// heigth of the gfx node
    private final int time;			// delay time between displays
    char letter;

    public GfxTreeNode(Graphics g, int tlx, int tly, int clr, int dt)
    {
        x = tlx;
        y = tly;
        width = 45;
        height = width / 3;

        time = dt;
        drawNode(g,clr);
    }
    private void drawNode(Graphics g, int clr)
    {
        g.setColor(getColor(clr));
        g.drawRect(x,y,width,height);
        g.drawLine(x+height,y,x+height,y+height);
        g.drawLine(x+2*height,y,x+2*height,y+height);
        delay(time);
    }
    private Color getColor(int clr)
    {
        Color temp = Color.white;
        switch (clr)
        {
            case 0:  temp = Color.black;	break;
            case 1:  temp = Color.red; 		break;
            case 2:  temp = Color.green; 	break;
            case 3:  temp = Color.blue; 	break;
            case 4:  temp = Color.orange; 	break;
            case 5:  temp = Color.cyan; 	break;
            case 6:  temp = Color.magenta; 	break;
            case 7:  temp = Color.yellow; 	break;
            case 8:  temp = Color.pink; 	break;
            case 9:  temp = Color.white;	break;
        }
        return temp;
    }

    public int getx()
    {
        return x;
    }


    // Method getY returns the top-left Y-coordinate of a linked list node.
    public int gety()
    {
        return y;
    }

    public void drawRootPointer(Graphics g, int clr)
    {
        int mid = x + 3 * height / 2;
        g.setColor(getColor(clr));
        drawLetter(g,'R',mid-22,y-32);
        drawLetter(g,'O',mid-10,y-32);
        drawLetter(g,'O',mid+2,y-32);
        drawLetter(g,'T',mid+14,y-32);
        int y1 = y - 20;
        int y2 = y - 2;
        g.setColor(getColor(clr));
        g.drawLine(mid,y1,mid,y2);
        g.drawLine(mid,y2,mid-3,y2-3);
        g.drawLine(mid,y2,mid+3,y2-3);
        delay(time);
    }

    // Method drawPointer draws the reference that is being used to traverse the Tree Node
    public void drawPointer(Graphics g, char ltr, int clr)
    {
        int x1 = x - 18;
        int yy = y + 5;
        int x2 = x-1;
        g.setColor(getColor(clr));
        g.drawLine(x1,yy,x2,yy);
        g.drawLine(x2,yy,x2-3,yy-3);
        g.drawLine(x2,yy,x2-3,yy+3);
        drawLetter(g,ltr,x-30,yy-5);
        if (clr < 9)
            delay(time);
    }


    // Method getLetter return the letter stored in the Tree Node
    public void enterData(Graphics g, char ltr, int clr)
    {
        g.setColor(getColor(clr));
        drawLetter(g,ltr,x+height+3,y+3);
        delay(time);
        letter = ltr;
    }

    // Method getLetter return the letter stored in the Tree Node
    public char getLetter()
    {
        return letter;
    }


    // Method drawLeftLink draws a link from the parent to the left child.
    public void drawLeftLink(Graphics g, GfxTreeNode endNode, int clr)
    {
        int x1,x2,y1,y2;
        int hh = height/2;
        x1 = this.getx() + hh;
        y1 = this.gety() + hh;
        x2 = endNode.getx() + 3*hh;
        y2 = endNode.gety();
        g.setColor(getColor(clr));
        g.drawLine(x1,y1,x2,y2);
        delay(time);
    }


    // Method drawRightLink draws a link from the parent to the right child.
    public void drawRightLink(Graphics g, GfxTreeNode endNode, int clr)
    {
        int x1,x2,y1,y2;
        int hh = height/2;
        x1 = this.getx() + 5*hh;
        y1 = this.gety() + hh;
        x2 = endNode.getx() + 3*hh;
        y2 = endNode.gety();
        g.setColor(getColor(clr));
        g.drawLine(x1,y1,x2,y2);
        delay(time);
    }


    // Method drawLeftNull draws a diagonal g.drawLine in the Left field of a tree node,
    // to indicate a NULL value.
    public void drawLeftNull(Graphics g, int clr)
    {
        g.setColor(getColor(clr));
        g.drawLine(x+1,y+1,x+height-1,y+height-1);
        delay(time);
    }

    // Method drawLeftNull draws a diagonal g.drawLine in the Left field of a tree node,
    //to indicate a NULL value.
    public void drawRightNull(Graphics g, int clr)
    {
        g.setColor(getColor(clr));
        g.drawLine(x+2*height+1,y+1,x+width-1,y+height-1);
        delay(time);
    }
    //  Method drawLetter upper-case Letter characters.  The characters
    //  are drawn in a 9x9 pixel box.
    //  The (x,y) parameters indicate the coordinate of the top-left corner
    //  of the box.  Only capital letters and numbers are drawn.
    public void drawLetter(Graphics g, char ltr, int x, int y)
    {
        switch (ltr)
        {
            case 'A' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+4,x+8,y+4);
                break;
            case 'B' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+5,y);
                g.drawLine(x,y+8,x+5,y+8);
                g.drawLine(x,y+4,x+5,y+4);
                g.drawLine(x+5,y,x+8,y+2);
                g.drawLine(x+5,y+8,x+8,y+6);
                g.drawLine(x+5,y+4,x+8,y+2);
                g.drawLine(x+5,y+4,x+8,y+6);
                break;
            case 'C' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+8,x+8,y+8);
                break;
            case 'D' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+4,y);
                g.drawLine(x,y+8,x+4,y+8);
                g.drawLine(x+4,y,x+8,y+4);
                g.drawLine(x+4,y+8,x+8,y+4);
                break;
            case 'E' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x,y+4,x+6,y+4);
                break;
            case 'F' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+4,x+6,y+4);
                break;
            case 'G' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+6,y);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x+8,y+8,x+8,y+4);
                g.drawLine(x+8,y+4,x+4,y+4);
                break;
            case 'H' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y+4,x+8,y+4);
                break;
            case 'I' :
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x+4,y,x+4,y+8);
                break;
            case 'J' :
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x,y+8,x,y+4);
                break;
            case 'K' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+1,y+4);
                g.drawLine(x+8,y+8,x+1,y+4);
                break;
            case 'L' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y+8,x+8,y+8);
                break;
            case 'M' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y,x+5,y+5);
                g.drawLine(x+8,y+1,x+4,y+4+1);
                break;
            case 'N' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y,x+9-1,y+8);
                break;
            case 'O' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+8,x+8,y+8);
                break;
            case 'P' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+4,x+8,y+4);
                g.drawLine(x+8,y,x+8,y+4);
                break;
            case 'Q' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x+3,y+5,x+8,y+10);
                break;
            case 'R' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+4,x+8,y+4);
                g.drawLine(x+8,y,x+8,y+4);
                g.drawLine(x,y+4,x+9,y+8);
                break;
            case 'S' :
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+4,x+8,y+4);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x,y,x,y+4);
                g.drawLine(x+8,y+4,x+8,y+8);
                break;
            case 'T' :
                g.drawLine(x,y,x+8,y);
                g.drawLine(x+4,y,x+4,y+8);
                break;
            case 'U' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+8);
                g.drawLine(x,y+8,x+8,y+8);
                break;
            case 'V' :
                g.drawLine(x,y,x+4,y+8);
                g.drawLine(x+8,y,x+4,y+8);
                break;
            case 'W' :
                g.drawLine(x,y,x,y+8);
                g.drawLine(x+8,y,x+8,y+9-1);
                g.drawLine(x,y+8,x+4,y+4);
                g.drawLine(x+8,y+8,x+4,y+4);
                break;
            case 'X' :
                g.drawLine(x,y,x+9,y+8);
                g.drawLine(x,y+8,x+8,y);
                break;
            case 'Y' :
                g.drawLine(x,y,x+5-1,y+4);
                g.drawLine(x+8,y,x+4,y+4);
                g.drawLine(x+4,y+4,x+4,y+8);
                break;
            case 'Z' :
                g.drawLine(x,y,x+8,y);
                g.drawLine(x,y+8,x+8,y+8);
                g.drawLine(x+8,y,x,y+8);
                break;
            default :
                g.fillRect(x,y,8,8);
        }

    }

    private void delay(double n)
    {
        for (double k = 1; k < n; k+=0.00001);
    }


}