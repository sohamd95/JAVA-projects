package jappletgame;

import java.awt.Color;
import java.awt.Graphics;

public class AgilDown extends Item{
    //Class that creates a gravity power-up item
    public AgilDown(int x) {
        super(x);
    }

    @Override
    public void performAction(Ball b) {
        if(b.getAgility() >= 2){
        b.setAgility(b.getAgility() - 1);
        }
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.red);
        super.paint(g);
    }
    
}
