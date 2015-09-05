package jappletgame;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Random;

public class JAppletGame extends Applet implements Runnable, KeyListener , MouseMotionListener , MouseListener {
   
    private Image i;
    private Graphics doubleG;
    private Ball b;
    private Platform p[] = new Platform[7];
    private Item item[] = new Item[3];
    private URL url;
    private Image back;
    private MenuOverlay menu;
    private HighscoreOverlay ho;
    private Field nameField;
    private int score,levelCheck;
    private double backX = 0 , backDx = .3;
    private volatile boolean mouseIn = false ,pause = false , gameOver = false;
    private volatile boolean started = false , scoreAdded = false , mouseIn2 = false;
    
    //Called upon intitalization
    @Override
    public void init() {
        //Trigger the resources constructor 
        Resources resources = new Resources(this);
        setSize(800, 600);
        
        //Add Listeners on Applet
        addKeyListener(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        
        try {
            url = getDocumentBase();
        } catch (Exception e) {
        }
        
        menu = new MenuOverlay(150 , 120);
        addKeyListener(menu.userName);
        nameField = new Field(200, 200);
        back = Resources.back4;
        ho = new HighscoreOverlay();
        addKeyListener(nameField);
    }
    
    //Called to start the applet
    @Override
    public void start() {
        //reset score
        score = 0;
        
        //Create ball
        b = new Ball();
        
        //Create platforms
        for(int i = 0 ; i<p.length ; i++){
            //Randomize the position
            Random r = new Random();
            p[i] = new Platform(i*120 , 300);
            //Patforms y positon is towards the bottom of screen
            //p[i] = new Platform(getWidth() + 200*i , getHeight() - r.nextInt(400) - 40);
        }
        
        for(int i = 0 ; i<item.length ; i++){
            Random r = new Random();
            
            switch(r.nextInt(5)) {
                case 0: 
                    item[i] = new GravUp(getWidth() + 10*r.nextInt(500));
                    break;
                case 1:
                    item[i] = new GravDown(getWidth() + 10*r.nextInt(500));
                    break;
                case 2:
                    item[i] = new AgilUp(getWidth() + 10*r.nextInt(500));
                    break;
                case 3:
                    item[i] = new AgilDown(getWidth() + 10*r.nextInt(500));
                    break;
                case 4:
                    item[i] = new ScorePlus(getWidth() + 10*r.nextInt(500) , this);
                    break;
            }
        }
        Thread thread = new Thread(this);
        thread.start();
    }
    
    @Override
    public void run() {
        while(true) {
            
            gameOver = b.isGameOver();
            
            if(gameOver)
            {
                if(!scoreAdded)
                {
                    String name = menu.userName.getText();
                    if("".equals(name))
                        name = "Username";
                    Resources.hm.addScore(name, score);
                    ho.setScoreSource(Resources.hm.getScores());
                    scoreAdded = true;
                }
                ho.setVisible(true);
            }
            
            if(!started) {
            } else menu.setVisible(false);
            
            //Paused?
            if(!gameOver && pause)
            {
                repaint();
                while(true){
                    if(pause == false)
                        break;
                }
            }
            
            //Increase level
            if(!gameOver && started) {
                if(levelCheck > 1500) {
                    Resources.level++;
                    levelCheck = 0;
                }
                levelCheck++;
            }
            
            //Background Motion
            if(backX > -back.getWidth(this)) {
                backX -= backDx;
            } else {
                backX = 0;
            }
            
            Random r = new Random();
            
            //Check if an item has gone off the screen
            //If so , re-init the item
            for(int i = 0 ; i<item.length ; i++) {
                if(item[i].isCreateNew()) {
                    //Delete the item by setting the reference null
                    //Java Garbage collector will do the rest!
                    item[i] = null;
                    //Create a new random item;
                    int t = r.nextInt(5);
                    
                    switch(t) {
                        case 0:
                            item[i] = new GravUp(getWidth() + 10*r.nextInt(500));
                            break;
                        case 1:
                            item[i] = new GravDown(getWidth() + 10*r.nextInt(500));
                            break;
                        case 2:
                            item[i] = new AgilUp(getWidth() + 10*r.nextInt(500));
                            break;
                        case 3:
                            item[i] = new AgilDown(getWidth() + 10*r.nextInt(500));
                            break;
                        case 4: 
                            item[i] = new ScorePlus(getWidth() + 10*r.nextInt(500) , this);
                            break;
                    }
                    item[i].setCreateNew(false);
                }
            }
            //Update score, ball and platform
            if(started && !gameOver) {
                b.update();
                score++;
            }
            
            for (Platform p1 : p) {
                p1.update(b);
            }
            
            for (Item item1 : item) {
                item1.update(this, b);
            }
         
            repaint();
            //Repaint calls update() which clears screen and then calls paint()
            //So sometimes the update can take a long time and cause flickering
            //To fix this problem , we can use something called double Buffering
            try {
                //Sleep for 17 ms for a frame rate of roughly 60fps
                Thread.sleep(17);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    //Override update() and use double buffering to reduce flickering
    @Override
    public void update(Graphics g) {
        //instead of completly clearing screen
        //we keep the old screen until paint() is called again
        
        if(i == null) {
            i = createImage(this.getSize().width , this.getSize().height);
            doubleG = i.getGraphics();
        }
        paint(doubleG);
        g.drawImage(i, 0, 0, this);
    }    
    
    //To paint the frame
    @Override
    public void paint(Graphics g) {
            
        
        //Paint the background:
        g.drawImage(back, (int)backX, 0, this);
        g.drawImage(back , (int) backX + back.getWidth(this) , 0 , this);
       
        //Paint the platforms
        for(int i = 0 ; i<p.length ; i++) {
            if(p[i] != null)
                p[i].paint(g);
        }
        //Paint the items
        for(int i = 0 ; i<item.length ; i++) {
            if(item[i] != null)
                item[i].paint(g);
        }
        menu.paint(g);
        
        if(started)
        {
        //And ofcourse... paint the ball
        b.paint(g);
        //Paint the score
        String s = Integer.toString(score);
        //Set a cool looking font
        Font font = new Font("Jokerman" , Font.BOLD , 32);
        g.setFont(font);        
        //For the shadow
        g.setColor(Color.GRAY);
        g.drawString(s, getWidth() - 110+2, 50+2);
        
        g.setColor(Color.ORANGE);
        g.drawString(s, getWidth() - 110, 50);
        
        //Check if Game is over
        if(gameOver) {
            g.setFont(new Font("Berlin Sans FB", Font.PLAIN , 34));
            g.setColor(Color.black);
            g.drawString("GAME OVER SUCKA!", 245, 100);
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(135, 520, 200, 40);
            g.fillRect(465, 520, 200, 40);
            
            if(mouseIn) {
                g.setFont(Resources.GAME_MENU_FONT);
                g.setColor(Color.green);
                g.drawString("Play Again?", 175, 545);
            } else {
                g.setFont(Resources.GAME_MENU_FONT);
                g.setColor(Color.red);
                g.drawString("Play Again?", 175, 545);
            }
            
            if(mouseIn2) {
                g.setFont(Resources.GAME_MENU_FONT);
                g.setColor(Color.green);
                g.drawString("Main Menu", 505, 545);
            } else {
                g.setFont(Resources.GAME_MENU_FONT);
                g.setColor(Color.red);
                g.drawString("Main Menu", 505, 545);
            }
        }
        
        if(!gameOver && pause) {
            g.setFont(new Font("Berlin Sans FB", Font.PLAIN , 24)); 
            g.setColor(new Color(0, 0, 0, 150));
            g.fillRect(285, 310, 200, 40);
            g.setColor(Color.red);
            g.drawString("GAME PAUSED", 300, 340);
        }
       }
       ho.paint(g);
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        //getKeyCode() returns key code of the key that was pressed
        switch(e.getKeyCode()) {
            
            case KeyEvent.VK_LEFT:
                b.moveLeft();
                break;
                
            case KeyEvent.VK_RIGHT:
                b.moveRight();
                break;
                
            case KeyEvent.VK_ENTER:
                if(gameOver) {
                    reset();
                }
                else if(!started)
                {
                    switch(menu.getSelected())
                    {
                        case 1:
                            started = true;
                            break;
                        case 2:
                            menu.setVisible(false);
                            ho.setVisible(true);
                            break;
                    }
                }
                break;
                
            case KeyEvent.VK_SPACE:
                if(started && pause == false)
                {
                    pause = true;
                }
                else pause = false;
                break;
                
            case KeyEvent.VK_UP:
                if(!started)
                {
                    menu.setSelected((menu.getSelected()-1 == 0) ? (menu.NO_OF_OPTIONS) : (menu.getSelected()-1));
                }
                break;
                
            case KeyEvent.VK_DOWN:
                if(!started)
                {
                    menu.setSelected((menu.getSelected()+1 == menu.NO_OF_OPTIONS+1) ? 1 : (menu.getSelected()+1));
                }
                break;
                
            case KeyEvent.VK_BACK_SPACE:
                if(!started && ho.isVisible())
                {
                    ho.setVisible(false);
                    menu.setVisible(true);
                }
                break;
        }
    }
    
    @Override
    public void mouseMoved(MouseEvent e) {
        if(e.getY() > 520 && e.getY() < 560) {
            if(gameOver && e.getX() >135 && e.getX() < 335) {
                mouseIn = true;
                mouseIn2 = false;
            } else if(gameOver && e.getX() >465 && e.getX() < 665){
                mouseIn = false;
                mouseIn2 = true;
            } else {
                mouseIn = mouseIn2 = false;
            }
        } else {
             mouseIn = mouseIn2 = false;
        }
    }
    
    private void pause() {
        pause = true;
    }
    
    private void reset() {
            pause = false;
            b = new Ball();
            score = 0;
            scoreAdded = false;
            Resources.level = 1;
            ho.setVisible(false);
        for(int i = 0 ; i<p.length ; i++){
            Random r = new Random();
            p[i] = new Platform(i*120 , 300);
        }
        
        for(int i = 0 ; i<item.length ; i++){
            Random r = new Random();
            switch(r.nextInt(5)) {
                case 0: 
                    item[i] = new GravUp(getWidth() + 10*r.nextInt(500));
                    break;
                case 1:
                    item[i] = new GravDown(getWidth() + 10*r.nextInt(500));
                    break;
                case 2:
                    item[i] = new AgilUp(getWidth() + 10*r.nextInt(500));
                    break;
                case 3:
                    item[i] = new AgilDown(getWidth() + 10*r.nextInt(500));
                    break;
                case 4: 
                    item[i] = new ScorePlus(getWidth() + 10*r.nextInt(500) , this);
                    break;
            }
        }
        mouseIn = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(mouseIn) {
            reset();
        } else if(mouseIn2) {
            reset();
            menu.setVisible(true);
            started = false;
        }
    }
    
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //Used for stopping the applet
    @Override
    public void stop() {
        
    }
    
    //Called just before exiting.
    //Can be used for stuff like saving the state of the game
    @Override
    public void destroy() {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
   
    }

    @Override
    public void mousePressed(MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }
}
