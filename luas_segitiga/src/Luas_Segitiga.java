/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.text.DecimalFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author arilc
 */
public class Luas_Segitiga extends javax.swing.JFrame {

    /**
     * Creates new form Luas_Segitiga
     */ 
   public Luas_Segitiga() {
        initComponents();
        tglskrg();
        hasil.setEnabled(false);
        baru.setEnabled(false);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        tanggal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        alas = new javax.swing.JTextField();
        tinggi = new javax.swing.JTextField();
        hasil = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        hitung = new javax.swing.JButton();
        baru = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Calligraphy", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 255));
        jLabel1.setText("Menghitung Luas Segitiga");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 280, -1));

        tanggal.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        tanggal.setForeground(new java.awt.Color(51, 255, 255));
        tanggal.setText("Tanggal");
        getContentPane().add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 140, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 255));
        jLabel2.setText("Panjang Alas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 110, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 255, 255));
        jLabel3.setText("Tinggi");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 255));
        jLabel4.setText("Hasil");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        alas.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(alas, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 140, 100, -1));

        tinggi.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(tinggi, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 100, -1));

        hasil.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        getContentPane().add(hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 140, -1));

        jLabel5.setForeground(new java.awt.Color(51, 255, 255));
        jLabel5.setText("cm");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 30, -1));

        jLabel6.setForeground(new java.awt.Color(51, 255, 255));
        jLabel6.setText("cm");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, 30, -1));

        jLabel7.setForeground(new java.awt.Color(51, 255, 255));
        jLabel7.setText("cm2");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        hitung.setBackground(new java.awt.Color(51, 51, 255));
        hitung.setFont(new java.awt.Font("Segoe Print", 0, 16)); // NOI18N
        hitung.setText("Hitung");
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        getContentPane().add(hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, -1));

        baru.setBackground(new java.awt.Color(102, 255, 102));
        baru.setFont(new java.awt.Font("Segoe Print", 0, 16)); // NOI18N
        baru.setText("Baru");
        baru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                baruActionPerformed(evt);
            }
        });
        getContentPane().add(baru, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, -1, -1));

        keluar.setBackground(new java.awt.Color(255, 51, 51));
        keluar.setFont(new java.awt.Font("Segoe Print", 0, 16)); // NOI18N
        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        getContentPane().add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 255, 255));
        jLabel8.setText("By : Fahril");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, -1, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 255, 255));
        jLabel9.setText("XII RPL 2");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/OIP.jpg"))); // NOI18N
        bg.setText("jLabel3");
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -30, 550, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        if (!alas.getText().equals("") && !tinggi.getText().equals("")){
            alas.setEnabled(false);
            tinggi.setEnabled(false);
            hasil.setEnabled(false);
            baru.setEnabled(true);
            DecimalFormat h = new DecimalFormat("#.##");
            hasil.setText(String.valueOf(h.format(0.5*(Double.parseDouble(alas.getText())*Double.parseDouble(tinggi.getText())))));
        
        }else{
            JOptionPane.showMessageDialog(this, "Tinggi dan Alas belum di isi !");
        }
        alas.setText("");
        tinggi.setText("");
    }//GEN-LAST:event_hitungActionPerformed

    private void baruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_baruActionPerformed
        alas.setEnabled(true);
        tinggi.setEnabled(true);
        hitung.setEnabled(true);
        baru.setEnabled(false);
        hasil.setText("");
        hasil.setEnabled(false);
        alas.requestFocus();
    }//GEN-LAST:event_baruActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Keluar?", "Konfirmasi", 0);
        if (confirm == 0){}
        System.exit(0);
    }//GEN-LAST:event_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(Luas_Segitiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Luas_Segitiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Luas_Segitiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Luas_Segitiga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Luas_Segitiga().setVisible(true);
            }
        });
    }
    
    public void tglskrg(){
        Date skrg = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String tgl = format.format(skrg);
        tanggal.setText(format.format(skrg));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alas;
    private javax.swing.JButton baru;
    private javax.swing.JLabel bg;
    private javax.swing.JTextField hasil;
    private javax.swing.JButton hitung;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton keluar;
    private javax.swing.JLabel tanggal;
    private javax.swing.JTextField tinggi;
    // End of variables declaration//GEN-END:variables
}
