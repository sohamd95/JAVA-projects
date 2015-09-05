package jappletgame;

import java.awt.Graphics;
import java.util.Random;

public abstract class Item {
    //An 'Item' is basically a power-up
    
    private int x , y , dx , radius;
    private JAppletGame sp;
    private boolean createNew = false;

    //Setters & Getters
    public boolean isCreateNew() {
        return createNew;
    }
    public void setCreateNew(boolean createNew) {
        this.createNew = createNew;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }
    
    
    /*  This method is abstract because different items will have
    *   a different impact on gameplay and so all classes that
    *   extend the item class will have to implement this method
    */
    public abstract void performAction(Ball b);
    

    public Item(int x) {
        this.x = x;
        Random r = new Random();
        y = r.nextInt(400) + radius;
        this.radius = 10;
        dx = -2;
    }
    
    public void update(JAppletGame sp , Ball b) {
        x += dx;
        this.sp = sp;
        checkForCollision(b);
        //Check if platform has gone off screen
        //if so , reuse it by setting x position to right side of applet
        if(x < 0-radius) {
            createNew = true;
        }
    }

    private void checkForCollision(Ball b) {
        int ballY = b.getY();
        int ballX = b.getX();
        int ballR = b.getDiameter()/2;
        //Use pythogoras theorem to check for collison
        //c = sqrt(a^2 + b^2) where c is dist b/w centers of item and the ball
        //a , b = radius of ball , item respectively
        int a = x - ballX;
        int bb = y - ballY;
        int collide = radius + ballR;
        double c = Math.sqrt((double)(a*a) + (double)(bb*bb));
        
        if(c < collide){
            //perform action is overridden in any class that extends item
            performAction(b);
            createNew = true;
        }
    }
    
    public void paint(Graphics g) {
        g.fillOval(x, y, 2*radius, 2*radius);
    }
}
