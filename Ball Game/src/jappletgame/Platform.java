package jappletgame;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;

public class Platform {
    
    private int dx , x , y , width , height;
    private Image plat;
    private URL url;
    private int frame = 0;
    float tester = 0;
    
    public Platform(int x , int y) {
        this.x = x;
        this.y = y;
        width = 120;
        height = 40;
        dx = -1;
        plat = Resources.platform;
    }
    
    public void update(Ball b) {
        tester = (float)(tester + .1);
        frame = ((int)tester) % 3;
        
        x += -(Resources.level);
        checkForCollision(b);
        //Check if platform has gone off screen
        //if so , reuse it by setting x position to right side of applet
        
        if(x < 0-width) {
            Random r = new Random();
            y = Resources.sp.getHeight() - 40 - r.nextInt(400);
            x = Resources.sp.getWidth() + r.nextInt(300);
        }
    }

    private void checkForCollision(Ball b) {
        int ballX = b.getX();
        int ballY = b.getY();
        int diameter = b .getDiameter();
        
        if(ballY + diameter > y && ballY+diameter < y + height) {
            if(ballX+diameter/2 > x && ballX < x+width) {
                b.setY(y - diameter);
                b.setDy(b.getGameDy());
            }
        }
    }
    
    public void paint(Graphics g) {
//        g.setColor(Color.BLUE);
//        g.fillRect(x, y, width, height);
        //Params: image , startX , startY , endX , endY , imgstrtX , imgstartY , imgendX , imgendY, ImgObserver
        g.drawImage(plat, x, y, x + width, y+height, 0, 36*(int)frame, 120, 36*(int)frame + 36, Resources.sp);
    }
}
