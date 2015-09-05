package jappletgame;

import java.awt.Color;
import java.awt.Graphics;

public class AgilUp extends Item{
    //Class that creates a gravity power-up item
    public AgilUp(int x) {
        super(x);
    }

    @Override
    public void performAction(Ball b) {
        
        if(b.getAgility() < 8){
            b.setAgility(b.getAgility() + 1);   
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.CYAN);
        super.paint(g);
    }
    
}
