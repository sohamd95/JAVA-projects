package jappletgame;

import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.net.URI;
import java.net.URL;

public class Resources {
    //This is a resources class to contain all resources like background image,
    //platform image etc
    //Vars are static so that they can be acessed directly
    static Image platform , ball , back , back2 , back3 , back4;
    static HighscoreManager hm;
    static Image gravUp , gravDown;
    static JAppletGame sp;
    static int level = 1;
    static Font GAME_MENU_FONT = new Font("Calibri" , Font.PLAIN , 26);
    static String HIGHSCORE_FILE;
    static File highscore_file;
    URL url;

    public Resources(JAppletGame sp) {
        try {
            url = sp.getDocumentBase();
            System.out.println(url);
        } catch (Exception e) {
        }
        this.sp = sp;
        //System.out.println(url.toString());
        HIGHSCORE_FILE = "scores.dat";
        platform = sp.getImage(url , "Images/brick.PNG");
        //back = sp.getImage(url , "Images/back.PNG");
        //back2 = sp.getImage(url , "Images/back2.PNG");
        back3 = sp.getImage(url , "Images/back3.PNG");
        back4 = sp.getImage(url , "Images/back4.PNG");
        ball = sp.getImage(url , "Images/ball.PNG");
        gravUp = sp.getImage(url , "Images/gravUp.PNG");
        gravDown = sp.getImage(url , "Images/gravDown.PNG");
        hm = new HighscoreManager();
        
        
    }
    
}
