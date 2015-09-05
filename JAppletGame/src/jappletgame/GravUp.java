package jappletgame;

import java.awt.Graphics;

public class GravUp extends Item{
    //Class that creates a gravity power-up item
    public GravUp(int x) {
        super(x);
    }

    @Override
    public void performAction(Ball b) {
        b.setGravity(b.getGravity() + 3);
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(Resources.gravUp, super.getX(), super.getY(), super.getRadius()*2, super.getRadius()*2, Resources.sp);
       // g.setColor(Color.red);
        //super.paint(g);
    }
    
}
