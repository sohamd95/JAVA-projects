package german;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.KeyEvent;

public class f_eins extends javax.swing.JFrame {
    Connection con;
    String noun,PluralForm;
    boolean tried=false;
    int artikel, correct = 0, total = 0;
    public static int Records;
    File f = new File("records.txt");
    FileInputStream in;
    Random r = new Random();
    
    public f_eins() throws SQLException {
        initComponents();
        createConn();
        String q = "SELECT COUNT(Noun) FROM Artikel;";
        Statement stmt = con.createStatement();

        ResultSet rs = stmt.executeQuery(q);
        while(rs.next())
        {
            Records = rs.getInt(1);
            System.out.println(artikel);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        disp_txt = new javax.swing.JLabel();
        btn_der = new javax.swing.JButton();
        btn_die = new javax.swing.JButton();
        btn_das = new javax.swing.JButton();
        lbl_corr = new javax.swing.JLabel();
        lbl_outof = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_next = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mi_new_entry = new javax.swing.JMenuItem();
        mi_records = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Guess the Artikel");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        disp_txt.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        disp_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btn_der.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_der.setText("der");
        btn_der.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_derActionPerformed(evt);
            }
        });

        btn_die.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_die.setText("die");
        btn_die.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dieActionPerformed(evt);
            }
        });

        btn_das.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        btn_das.setText("das");
        btn_das.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dasActionPerformed(evt);
            }
        });

        lbl_corr.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_corr.setForeground(new java.awt.Color(0, 204, 0));
        lbl_corr.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_corr.setText("0");

        lbl_outof.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbl_outof.setForeground(new java.awt.Color(255, 0, 51));
        lbl_outof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_outof.setText("0");

        jLabel4.setText("Out of");

        btn_next.setText(">");
        btn_next.setEnabled(false);
        btn_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nextActionPerformed(evt);
            }
        });

        jMenuBar1.setName(""); // NOI18N

        jMenu1.setText("File");

        mi_new_entry.setText("New Entry");
        mi_new_entry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_new_entryActionPerformed(evt);
            }
        });
        jMenu1.add(mi_new_entry);

        mi_records.setText("See Records");
        mi_records.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mi_recordsActionPerformed(evt);
            }
        });
        jMenu1.add(mi_records);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_der, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btn_die, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_das, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))
                    .addComponent(disp_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_corr, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbl_outof, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel4))
                            .addComponent(btn_next, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_corr, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbl_outof, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(disp_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_der)
                        .addComponent(btn_die, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_das))
                    .addComponent(btn_next, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_dieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dieActionPerformed
 if(!tried){
        if(artikel==2){
            btn_die.setForeground(new Color(100,220,20));
            btn_der.setForeground(Color.black);
            btn_das.setForeground(Color.black);
            lbl_corr.setText(""+(++correct));
            LoadNext();
        }
    else {
        tried = true;
        btn_die.setForeground(Color.red);
        switch(artikel){
        case 1:
            btn_das.setForeground(Color.black);
            btn_der.setForeground(new Color(100,220,20));
            break;
        case 3:
            btn_der.setForeground(Color.black);
            btn_das.setForeground(new Color(100,220,20));
            break;
        }
        btn_next.setEnabled(true);
    }
        lbl_outof.setText(""+(++total));
 }
    }//GEN-LAST:event_btn_dieActionPerformed

    private void mi_new_entryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_new_entryActionPerformed
        new AddMenu().setVisible(true);
    }//GEN-LAST:event_mi_new_entryActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        LoadNext();
    }//GEN-LAST:event_formWindowOpened
    
    private void btn_derActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_derActionPerformed
  if(!tried){
        if(artikel==1){
            btn_der.setForeground(new Color(100,220,20));
            btn_die.setForeground(Color.black);
            btn_das.setForeground(Color.black);
            lbl_corr.setText(""+(++correct));
            LoadNext();
        }
       else {
        tried = true;
        btn_der.setForeground(Color.red);
        switch(artikel){
        case 2:
            btn_das.setForeground(Color.black);
            btn_die.setForeground(new Color(100,220,20));
            break;
        case 3:
            btn_die.setForeground(Color.black);
            btn_das.setForeground(new Color(100,220,20));
            break;
        }
        btn_next.setEnabled(true);
    }
        lbl_outof.setText(""+(++total));
  }
    }//GEN-LAST:event_btn_derActionPerformed

    private void btn_dasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dasActionPerformed
if(!tried){
        if(artikel==3){
            btn_das.setForeground(new Color(100,220,20));
            btn_die.setForeground(Color.black);
            btn_der.setForeground(Color.black);
            lbl_corr.setText(""+(++correct));
            LoadNext();
        }
        else {
            tried=true;
        btn_das.setForeground(Color.red);
            switch(artikel){
                case 1:
                    btn_die.setForeground(Color.black);
                    btn_der.setForeground(new Color(100,220,20));
                    break;
                case 2:
                    btn_der.setForeground(Color.black);
                    btn_die.setForeground(new Color(100,220,20));
                    break;
            }
            btn_next.setEnabled(true);
        }
        lbl_outof.setText(""+(++total));
}
    }//GEN-LAST:event_btn_dasActionPerformed

    private void btn_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nextActionPerformed
        btn_der.setForeground(Color.black);
        btn_die.setForeground(Color.black);
        btn_das.setForeground(Color.black);
        LoadNext();
    }//GEN-LAST:event_btn_nextActionPerformed

    private void mi_recordsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mi_recordsActionPerformed
        new f_records().setVisible(true);
    }//GEN-LAST:event_mi_recordsActionPerformed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(btn_der.hasFocus()) {
                btn_der.doClick();
            } else if (btn_die.hasFocus()) {
                btn_die.doClick();
            } else if (btn_das.hasFocus()) {
                btn_das.doClick();
            }
        }
    }//GEN-LAST:event_formKeyPressed

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(f_eins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(f_eins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(f_eins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(f_eins.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new f_eins().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(f_eins.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_das;
    private javax.swing.JButton btn_der;
    private javax.swing.JButton btn_die;
    private javax.swing.JButton btn_next;
    private javax.swing.JLabel disp_txt;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel lbl_corr;
    private javax.swing.JLabel lbl_outof;
    private javax.swing.JMenuItem mi_new_entry;
    private javax.swing.JMenuItem mi_records;
    // End of variables declaration//GEN-END:variables

private void LoadNext() {
        btn_next.setEnabled(false);
        tried = false;
        try {
            Statement stmt=con.createStatement();
            int PKey = r.nextInt(Records);
            String query="Select * FROM Artikel WHERE PKey="+PKey+";";
            ResultSet rs = stmt.executeQuery(query);
            
            while(rs.next()){
                artikel=rs.getInt(1);
                noun=rs.getString(2);
                PluralForm=rs.getString(4);
            }
            disp_txt.setText(""+noun);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Something Went Wrong");
        }
    }
    
public void createConn()
{
    try
    {
        Class.forName("java.sql.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost/German","root","qwerty");
        Statement stmt =con.createStatement();
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"Could not load Database, \nApplication will now close."); 
        System.exit(0);
    } 
}
    @SuppressWarnings("empty-statement")
    public void wait(int n){
    try{Thread.sleep(n*1000);
    }catch(Exception e){};
}
}
