
package jappletgame;

import com.sun.java.accessibility.util.AWTEventMonitor;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Field implements KeyListener{
    
    private static final int MARGIN = 5;
    private StringBuffer text;
    private int x , y;
    private int width , height , maxChars, fontSize;
    private boolean visible;
    
    public Field(int x , int y , int maxChars , int fontSize) {
        this.x = x; 
        this.y = y;
        this.maxChars = maxChars;
        this.fontSize = fontSize;
        this.width = (int) ((fontSize/2 + 0.15 * fontSize)*maxChars);
        this.height= (int) (fontSize + 0.33*fontSize);
        this.visible = false;
        text = new StringBuffer();
    }
    
    public Field(int x , int y) {
        this(x , y, 10 , 24);
    }
    
    public Field(int x , int y , int maxChars) {
        this(x , y , maxChars , 24);
    }
    
    public void paint(Graphics g) {
        
        if (visible) {
            g.setColor(Color.WHITE);
            g.drawRect(x, y, width, height);
            g.setColor(new Color(0,0,0,200));
            g.fillRect(x, y, width, height);
            g.setColor(Color.WHITE);
            g.setFont(new Font("Calibri" , Font.PLAIN , fontSize));
            g.drawString(text.toString(), x+MARGIN, y+height-MARGIN);
        }
    }
    
    public String getText() {
        return text.toString();
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if(visible){
            if(e.getKeyChar() == '\b' && text.length() > 0)
            {
                text.deleteCharAt(text.length()-1);
            }
            else if(text.length() <= maxChars && e.getKeyChar() != '\b')
            {
                text.append(e.getKeyChar());
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}
