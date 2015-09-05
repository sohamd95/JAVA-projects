package jappletgame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Ball {
    
    private int x;
    private int y;
    private int radius = 20;
    private int agility = 3;
    private int maxSpeed = 20;
    private double dx = 0;
    private double dy = 0;
    private double gameDy = -75;
    private double gravity = 12;
    private double energyloss = 0.8;
    private double dt = .2;             //Change in time
    private double xFriction = 0.9;
    private boolean gameOver = false;
    
    public Ball() {
        this.x = 100;
        this.y = 40;
    }
    
    public Ball(int x , int y) {
        this.x = x;
        this.y = y;
    }    
    
    public void moveRight() {
        //Cap the speed at maxSpeed
        if(dx+agility < maxSpeed) {
            dx += agility;
        }
    }
    
     public void moveLeft() {
        if(dx-agility > -maxSpeed) {
            dx -= agility;
        }
    }
    
    public void update() {
        //Confine ball to width , height of applet
            //Check if ball is within the screen
            JAppletGame sp = Resources.sp;
            if(x + dx > sp.getWidth() - 2*radius - 1) {
                x = sp.getWidth() - 2*radius - 1;
                dx *= -1;
            }
            else if(x + dx < 0) {
               x = 0;
               dx *= -1;
            }
            else {
                x += dx;
            }
            
            if(y == sp.getHeight() - 2*radius - 1) {
                dx *= xFriction;
                if(Math.abs(dx) < 0.8) {
                    dx = 0;
                }
            }
            
            if(y-100 > sp.getHeight() - 2*radius - 1) {
//                y = sp.getHeight() - 2*radius - 1;
//                dy *= energyloss;
//                dy = gameDy;
                gameOver = true;
            }else{
                //velocity formula
                dy = dy + gravity * dt;
                //position formula
                y += dy*dt + 0.5*gravity*dt*dt;
            }
    }
    
    public void paint(Graphics g) {
        g.setColor(new Color(92 , 13 , 145));
        g.drawImage(Resources.ball, x, y, 2*radius, 2*radius , Resources.sp);
        //g.fillOval(x, y, 2*radius, 2*radius);
    }
    
    //Getter and Setter Methods

    public boolean isGameOver() {
        return gameOver;
    }
    
    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public double getGameDy() {
        return gameDy;
    }

    public void setGameDy(double gameDy) {
        this.gameDy = gameDy;
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
    public double getDx() {
        return dx;
    }
    public double getDy() {
        return dy;
    }
    public void setDx(double dx) {
        this.dx = dx;
    }
    public void setDy(double dy) {
        this.dy = dy;
    }
    public void setGravity(double gravity) {
        this.gravity = gravity;
    }
    public double getGravity() {
        return gravity;
    }
    public int getDiameter() {
        return 2*radius;
    }
}
