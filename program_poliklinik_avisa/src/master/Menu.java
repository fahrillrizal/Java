/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
            
/**
 *
 * @author arilc
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu_Avisa
     */
    public Menu(String userName, String typeUser) {
        initComponents();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(this);
        Koneksi.tesConnect();
        userMenu.setVisible(false);
        userMenu.setEnabled(false);
        dataMenu.setVisible(false);
        dataMenu.setEnabled(false);
        logoutMenu.setVisible(false);
        logoutMenu.setEnabled(false);
        
        isLogin(userName,typeUser);   
    }
    
     public void isLogin(String user, String type){
        if(type.equals("Admin")){
            logoutMenu.setVisible(true);
            logoutMenu.setEnabled(true);
            
            userMenu.setEnabled(true);
            userMenu.setVisible(true);
            dataMenu.setEnabled(true);
            dataMenu.setVisible(true);
            logoutMenu.setVisible(true);
            logoutMenu.setEnabled(true);
            loginbtn.setVisible(false);
//            textName.setText(user);
            text1.setText("anda login sebagai "+type);          
        }
        
        if(type.equals("Petugas")){
            logoutMenu.setVisible(true);
            logoutMenu.setEnabled(true);
            
            userMenu.setVisible(false);
            userMenu.setEnabled(false);
            dataMenu.setVisible(true);
            dataMenu.setEnabled(true);
            loginbtn.setVisible(false);
//            textName.setText(user);
            text1.setText("anda login sebagai "+type);
        }
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginbtn = new javax.swing.JButton();
        banner = new javax.swing.JLabel();
        text1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        menubar = new javax.swing.JMenuBar();
        userMenu = new javax.swing.JMenu();
        userItem = new javax.swing.JMenuItem();
        dataMenu = new javax.swing.JMenu();
        pegawaiItem = new javax.swing.JMenuItem();
        logoutMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        loginbtn.setText("Login");
        loginbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginbtnActionPerformed(evt);
            }
        });
        getContentPane().add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, -1, -1));

        banner.setFont(new java.awt.Font("Bookman Old Style", 1, 25)); // NOI18N
        banner.setForeground(new java.awt.Color(51, 51, 51));
        banner.setText("Selamat datang di Poliklinik Mitra Medika");
        getContentPane().add(banner, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, -1, -1));

        text1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        text1.setForeground(new java.awt.Color(255, 51, 51));
        text1.setText("Silahkan login terlebih dahulu");
        getContentPane().add(text1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 150, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\arilc\\OneDrive\\Pictures\\Saved Pictures\\rs.jpg")); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        userMenu.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-users-settings-20.png")); // NOI18N
        userMenu.setText("User");

        userItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        userItem.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-add-user-male-20.png")); // NOI18N
        userItem.setText("New User");
        userItem.setDoubleBuffered(true);
        userItem.setFocusPainted(true);
        userItem.setFocusable(true);
        userItem.setMaximumSize(new java.awt.Dimension(300, 32767));
        userItem.setMultiClickThreshhold(1L);
        userItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userItemActionPerformed(evt);
            }
        });
        userMenu.add(userItem);

        menubar.add(userMenu);

        dataMenu.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-file-20.png")); // NOI18N
        dataMenu.setText("Data");
        dataMenu.setRequestFocusEnabled(false);

        pegawaiItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        pegawaiItem.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-employee-20.png")); // NOI18N
        pegawaiItem.setLabel("Pegawai");
        pegawaiItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegawaiItemActionPerformed(evt);
            }
        });
        dataMenu.add(pegawaiItem);

        menubar.add(dataMenu);

        logoutMenu.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-logout-15.png")); // NOI18N
        logoutMenu.setText("Logout");
        logoutMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                logoutMenuMousePressed(evt);
            }
        });
        menubar.add(logoutMenu);

        setJMenuBar(menubar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userItemActionPerformed
        // TODO add your handling code here:
        new user().setVisible(true);
    }//GEN-LAST:event_userItemActionPerformed

    private void pegawaiItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pegawaiItemActionPerformed
        // TODO add your handling code here:
        new pegawai().setVisible(true);
    }//GEN-LAST:event_pegawaiItemActionPerformed

    private void logoutMenuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutMenuMousePressed
        new login().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_logoutMenuMousePressed

    private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginbtnActionPerformed
    new login().setVisible(true);
        
    }//GEN-LAST:event_loginbtnActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu("","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel banner;
    private javax.swing.JMenu dataMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton loginbtn;
    private javax.swing.JMenu logoutMenu;
    private javax.swing.JMenuBar menubar;
    private javax.swing.JMenuItem pegawaiItem;
    private javax.swing.JLabel text1;
    private javax.swing.JMenuItem userItem;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables
}
