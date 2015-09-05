
package jappletgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

public class HighscoreOverlay {
    
    private volatile boolean visible;
    private ArrayList<Score> scores;
    private int x , y;

    public HighscoreOverlay() {
        x = 100;
        y = 150;
        visible = false;
        scores = Resources.hm.getScores();
    }
    
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    public void setScoreSource(ArrayList<Score> list) {
        this.scores = list;
    }
    
    public void paint(Graphics g) {
        if(visible)
        {
            g.setColor(new Color(0,0,0,200));
            g.fillRoundRect(x , y , 600 , 350 , 20 , 20);
            g.setColor(Color.YELLOW);
            g.setFont(new Font("Jokerman" , Font.PLAIN , 36));
            g.drawString("HIGHSCORES", 280, y+45);
            
            g.setColor(Color.WHITE);
            g.setFont(new Font("Calibri" , Font.BOLD , 32));
            
            for(int i = 0 ; i<min(5,scores.size()) ; i++)
            {
                g.drawString(""+ (i+1) + ")   " + scores.get(i).getNaam(), 110, y+90+55*i);
                g.drawString(""+scores.get(i).getScore(), 610, y+90+55*i);
            }
        }
    }
    
    private int min(int a , int b) {
        return (a<b)?a:b;
    }

    public boolean isVisible() {
        return visible;
    }
}
