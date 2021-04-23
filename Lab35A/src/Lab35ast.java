
import java.awt.*;
import java.awt.event.*;


public class Lab35ast
{
    public static void main(String args[])
    {
        GfxApp gfx = new GfxApp();
        gfx.setSize(800,600);
        gfx.addWindowListener(new WindowAdapter() {public void
        windowClosing(WindowEvent e) {System.exit(0);}});
        gfx.show();
    }
}


class GfxApp extends Frame
{

    private int td 	  = 500;		// time delay to slow down graphics display
    String title      = "";
    String oldTitle   = "";
    String process    = "";
    String oldProcess = "";
    String output     = "";

    public void paint (Graphics g)
    {
        g.setFont(new Font("ARIAL",Font.BOLD,20));
        displayTitle(g,"DRAWING A BINARY TREE");


    }


    public void displayTitle(Graphics g, String t)
    {
        oldTitle = title;
        title = t;
        g.setColor(Color.white);
        g.drawString(oldTitle,50,50);
        g.setColor(Color.black);
        g.drawString(title,50,50);
    }

    public void displayProcess(Graphics g, String p)
    {
        oldProcess = process;
        process = p;
        g.setColor(Color.white);
        g.drawString(oldProcess,100,500);
        g.setColor(Color.black);
        g.drawString(process,100,500);
    }

    public void displayOutput(Graphics g, String output)
    {
        g.setColor(Color.black);
        g.drawString(output,100,570);
    }

    public void movePointer(Graphics g, GfxTreeNode oldTreeNode, GfxTreeNode newTreeNode)
    {
        oldTreeNode.drawPointer(g,'P',9);
        newTreeNode.drawPointer(g,'P',0);
    }
}

