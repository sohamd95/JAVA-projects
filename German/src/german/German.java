/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package german;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Soham
 */
public class German {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                try {
                    new f_eins().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(German.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}
