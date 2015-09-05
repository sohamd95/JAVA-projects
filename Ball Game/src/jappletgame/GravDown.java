package jappletgame;

import java.awt.Color;
import java.awt.Graphics;

public class GravDown extends Item{
    //Class that creates a gravity power-up item
    public GravDown(int x) {
        super(x);
    }

    @Override
    public void performAction(Ball b) {
        //Decrease gravity and make sure it's not too low
        if(b.getGravity() > 5) {
            b.setGravity(b.getGravity() - 2);
            if(b.getGravity() < 5) {
                b.setGravity(5);
            }
        }
        
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Resources.gravDown, super.getX(), super.getY(), 2*super.getRadius(), 2*super.getRadius(), Resources.sp);
        //g.setColor(Color.MAGENTA);
        //super.paint(g);
    }
    
}
