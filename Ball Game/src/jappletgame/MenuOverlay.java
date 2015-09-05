package jappletgame;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class MenuOverlay {
    
    private static int height;
    private static int width;
    private static int x;
    private static int y;
    private static int selected;
    public static final int NO_OF_OPTIONS = 3;
    private static final int MENU_ITEM_MARGIN = 5;
    private volatile boolean visible;
    protected Field userName;

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public MenuOverlay(int width , int height)
    {
        MenuOverlay.height = height;
        MenuOverlay.width = width;
        x = (Resources.sp.getWidth()-width)>>1;
        y = (Resources.sp.getHeight()-height)>>1;
        selected = 1;
        visible = true;
        userName = new Field(370 , 380 , 10 , 20);
        userName.setVisible(true);
    }
    
    public void setSelected(int x)
    {
        selected = x;
    }
    
    public int getSelected()
    {
        return selected;
    }
    
    public void paint(Graphics g) {
        if(visible)
        {
            userName.setVisible(true);
            g.setColor(new Color(0,0,0,200));
            g.fillRoundRect(x, y, width, height , 20 ,20);

            g.setColor(new Color(100, 100 , 100 , 128));
            g.fillRoundRect(x , y+((selected-1)*40), width, 40 , 15 , 15 );

            g.setFont(new Font("Calibri",Font.PLAIN , 24));
            g.setColor((selected != 1)?Color.GREEN : Color.RED);
            g.drawString("Play", x + 50, y+g.getFont().getSize());
            g.setColor((selected != 2)?Color.GREEN : Color.RED);
            g.drawString("HighScores", x + 15, y+2*g.getFont().getSize()+20-MENU_ITEM_MARGIN);
            g.setColor((selected != 3)?Color.GREEN : Color.RED);
            g.drawString("Credits", x + 35, y+3*g.getFont().getSize()+40-MENU_ITEM_MARGIN);
            
            g.setColor(Color.BLACK);
            g.drawString("Name: ", 300, 400);
            userName.paint(g);
        } else {
            userName.setVisible(false);
        }
    }

}
