package german;

import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AddMenu extends javax.swing.JFrame {
    
    Connection con;
    int Records;
    
    public AddMenu() {
        initComponents();
        this.Records = f_eins.Records;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rb_der = new javax.swing.JRadioButton();
        rb_die = new javax.swing.JRadioButton();
        rb_das = new javax.swing.JRadioButton();
        tf_sing = new javax.swing.JTextField();
        tf_plu = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ss = new javax.swing.JButton();
        au = new javax.swing.JButton();
        ee = new javax.swing.JButton();
        uu = new javax.swing.JButton();
        AA = new javax.swing.JButton();
        AU = new javax.swing.JButton();
        UU = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Entry");
        setPreferredSize(new java.awt.Dimension(520, 140));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        buttonGroup1.add(rb_der);
        rb_der.setText("Der");

        buttonGroup1.add(rb_die);
        rb_die.setText("Die");

        buttonGroup1.add(rb_das);
        rb_das.setText("Das");

        tf_sing.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_singKeyTyped(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_singKeyReleased(evt);
            }
        });

        tf_plu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_pluActionPerformed(evt);
            }
        });

        btn_add.setText("Add");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Singular");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Plural");

        ss.setText("ß");
        ss.setFocusable(false);
        ss.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ssActionPerformed(evt);
            }
        });

        au.setText("ö");
        au.setFocusable(false);
        au.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                auActionPerformed(evt);
            }
        });

        ee.setText("ä");
        ee.setFocusable(false);
        ee.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eeActionPerformed(evt);
            }
        });

        uu.setText("ü");
        uu.setFocusable(false);
        uu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uuActionPerformed(evt);
            }
        });

        AA.setText("Ä");
        AA.setFocusable(false);
        AA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AAActionPerformed(evt);
            }
        });

        AU.setText("Ö");
        AU.setFocusable(false);
        AU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AUActionPerformed(evt);
            }
        });

        UU.setText("Ü");
        UU.setFocusable(false);
        UU.setMaximumSize(new java.awt.Dimension(41, 23));
        UU.setMinimumSize(new java.awt.Dimension(41, 23));
        UU.setPreferredSize(new java.awt.Dimension(41, 23));
        UU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UUActionPerformed(evt);
            }
        });

        jButton2.setText("Close");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rb_die)
                    .addComponent(rb_der)
                    .addComponent(rb_das, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jLabel1)
                        .addGap(153, 153, 153)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tf_sing, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tf_plu, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ee, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(uu, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AA, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(AU, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(UU, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btn_add, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(rb_der)
                .addGap(0, 0, 0)
                .addComponent(rb_die)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rb_das)
                .addContainerGap(71, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_sing, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(tf_plu, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(UU, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ss, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(au, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ee, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(uu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AA, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(AU, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf_pluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_pluActionPerformed
        
    }//GEN-LAST:event_tf_pluActionPerformed

    private void ssActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ssActionPerformed
        
        JTextField c =(JTextField) getFocusOwner();
        int pos=c.getCaretPosition();
        c.setText(c.getText()+"ß");
    }//GEN-LAST:event_ssActionPerformed

    private void auActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_auActionPerformed
        // TODO add your handling code here:
        JTextField c =(JTextField) getFocusOwner();
        c.setText(c.getText()+"ö");
    }//GEN-LAST:event_auActionPerformed

    private void eeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eeActionPerformed
        // TODO add your handling code here:
        JTextField c =(JTextField) getFocusOwner();
        c.setText(c.getText()+"ä");
    }//GEN-LAST:event_eeActionPerformed

    private void uuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uuActionPerformed
        // TODO add your handling code here:
        JTextField c =(JTextField) getFocusOwner();
        c.setText(c.getText()+"ü");
    }//GEN-LAST:event_uuActionPerformed

    private void AAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AAActionPerformed
        // TODO add your handling code here:
        JTextField c =(JTextField) getFocusOwner();
        c.setText(c.getText()+"Ä");
    }//GEN-LAST:event_AAActionPerformed

    private void AUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AUActionPerformed
        // TODO add your handling code here:
        JTextField c =(JTextField) getFocusOwner();
        c.setText(c.getText()+"Ö");
    }//GEN-LAST:event_AUActionPerformed

    private void UUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UUActionPerformed
        // TODO add your handling code here:
        JTextField c =(JTextField) getFocusOwner();
        c.setText(c.getText()+"Ü");
    }//GEN-LAST:event_UUActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        int Artikel;
        Statement stmt;
        
        String q1 = "SELECT * FROM Artikel WHERE Noun = '" + tf_sing.getText() + "';";
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.next()) {
                JOptionPane.showMessageDialog(null, "Already Exists!");
                return;
            }
        } catch (SQLException ex) {
        }
        
        if(rb_der.isSelected())
            Artikel = 1;
        else if(rb_die.isSelected())
            Artikel = 2;
        else 
            Artikel = 3;
        String query= "INSERT INTO Artikel VALUES("+Artikel+",'"+tf_sing.getText()+"',"+Records+",'"+tf_plu.getText()+"')";
        System.out.println(query);
        
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
             try {
            FileOutputStream out = new FileOutputStream("records.txt",false);
                try {
                    out.write(Records+48);
                } catch (IOException ex) {
                    Logger.getLogger(AddMenu.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (FileNotFoundException ex) {
                Logger.getLogger(AddMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AddMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        Records++;
        f_eins.Records++;
        tf_sing.setText("");
        tf_plu.setText("");
        tf_sing.grabFocus();
    }//GEN-LAST:event_btn_addActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            createConn();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Oops... Something went wrong!");
        }
    }//GEN-LAST:event_formWindowOpened

    private void tf_singKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_singKeyTyped

    }//GEN-LAST:event_tf_singKeyTyped

    private void tf_singKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_singKeyReleased

    }//GEN-LAST:event_tf_singKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(AddMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        AddMenu.this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddMenu().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AA;
    private javax.swing.JButton AU;
    private javax.swing.JButton UU;
    private javax.swing.JButton au;
    private javax.swing.JButton btn_add;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton ee;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton rb_das;
    private javax.swing.JRadioButton rb_der;
    private javax.swing.JRadioButton rb_die;
    private javax.swing.JButton ss;
    private javax.swing.JTextField tf_plu;
    private javax.swing.JTextField tf_sing;
    private javax.swing.JButton uu;
    // End of variables declaration//GEN-END:variables

    private void createConn() throws IOException {
         try{
            Class.forName("java.sql.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/German","root","qwerty");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Could not load Database, \nApplication will now close."); 
            System.exit(0);
        }    
    }
}
