/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author arilc
 */
public class Kalkulator extends javax.swing.JFrame {
    String angka;
    Double total,angka1,angka2;
    int pilih;
    /**
     * Creates new form Kalkulator
     */
    public Kalkulator() {
        initComponents();
        angka="";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tampil = new javax.swing.JTextField();
        cmd7 = new javax.swing.JButton();
        cmd8 = new javax.swing.JButton();
        cmd4 = new javax.swing.JButton();
        cmdpersen = new javax.swing.JButton();
        cmd1 = new javax.swing.JButton();
        cmd2 = new javax.swing.JButton();
        cmd5 = new javax.swing.JButton();
        cmd6 = new javax.swing.JButton();
        cmd3 = new javax.swing.JButton();
        cmdkoma = new javax.swing.JButton();
        cmd9 = new javax.swing.JButton();
        cmd0 = new javax.swing.JButton();
        cmdminplus = new javax.swing.JButton();
        cmdclear = new javax.swing.JButton();
        cmdtambah = new javax.swing.JButton();
        cmdkurang = new javax.swing.JButton();
        cmdkali = new javax.swing.JButton();
        cmdbagi = new javax.swing.JButton();
        cmdsamadengan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));

        cmd7.setBackground(new java.awt.Color(204, 204, 204));
        cmd7.setText("7");
        cmd7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd7ActionPerformed(evt);
            }
        });

        cmd8.setBackground(new java.awt.Color(204, 204, 204));
        cmd8.setText("8");
        cmd8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd8ActionPerformed(evt);
            }
        });

        cmd4.setBackground(new java.awt.Color(204, 204, 204));
        cmd4.setText("4");
        cmd4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd4ActionPerformed(evt);
            }
        });

        cmdpersen.setBackground(new java.awt.Color(0, 255, 204));
        cmdpersen.setText("%");
        cmdpersen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdpersenActionPerformed(evt);
            }
        });

        cmd1.setBackground(new java.awt.Color(204, 204, 204));
        cmd1.setText("1");
        cmd1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd1ActionPerformed(evt);
            }
        });

        cmd2.setBackground(new java.awt.Color(204, 204, 204));
        cmd2.setText("2");
        cmd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd2ActionPerformed(evt);
            }
        });

        cmd5.setBackground(new java.awt.Color(204, 204, 204));
        cmd5.setText("5");
        cmd5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd5ActionPerformed(evt);
            }
        });

        cmd6.setBackground(new java.awt.Color(204, 204, 204));
        cmd6.setText("6");
        cmd6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd6ActionPerformed(evt);
            }
        });

        cmd3.setBackground(new java.awt.Color(204, 204, 204));
        cmd3.setText("3");
        cmd3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd3ActionPerformed(evt);
            }
        });

        cmdkoma.setBackground(new java.awt.Color(204, 204, 204));
        cmdkoma.setText(".");
        cmdkoma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdkomaActionPerformed(evt);
            }
        });

        cmd9.setBackground(new java.awt.Color(204, 204, 204));
        cmd9.setText("9");
        cmd9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd9ActionPerformed(evt);
            }
        });

        cmd0.setBackground(new java.awt.Color(204, 204, 204));
        cmd0.setText("0");
        cmd0.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmd0ActionPerformed(evt);
            }
        });

        cmdminplus.setBackground(new java.awt.Color(0, 255, 204));
        cmdminplus.setText("+/-");
        cmdminplus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdminplusActionPerformed(evt);
            }
        });

        cmdclear.setBackground(new java.awt.Color(0, 255, 204));
        cmdclear.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmdclear.setText("c");
        cmdclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdclearActionPerformed(evt);
            }
        });

        cmdtambah.setBackground(new java.awt.Color(0, 255, 204));
        cmdtambah.setText("+");
        cmdtambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdtambahActionPerformed(evt);
            }
        });

        cmdkurang.setBackground(new java.awt.Color(0, 255, 204));
        cmdkurang.setText("-");
        cmdkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdkurangActionPerformed(evt);
            }
        });

        cmdkali.setBackground(new java.awt.Color(0, 255, 204));
        cmdkali.setText("x");
        cmdkali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdkaliActionPerformed(evt);
            }
        });

        cmdbagi.setBackground(new java.awt.Color(0, 255, 204));
        cmdbagi.setText("÷");
        cmdbagi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdbagiActionPerformed(evt);
            }
        });

        cmdsamadengan.setBackground(new java.awt.Color(0, 255, 204));
        cmdsamadengan.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cmdsamadengan.setText("=");
        cmdsamadengan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdsamadenganActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmd0, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdkoma, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdpersen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmd4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmd7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmd1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmd2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmd6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdtambah, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmd3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdkali, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cmd9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(cmdminplus)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmdkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmdbagi, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmdclear, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(cmdsamadengan, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(tampil, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd7, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd8, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd9, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdminplus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdclear, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdtambah, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdkurang, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmd3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdkali, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdbagi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmd0, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdkoma, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdpersen, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmdsamadengan, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmd0ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd0ActionPerformed
        // TODO add your handling code here:
        angka += "0";
        tampil.setText(tampil.getText()+"0");
    }//GEN-LAST:event_cmd0ActionPerformed

    private void cmd1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd1ActionPerformed
        // TODO add your handling code here:
        angka += "1";
        tampil.setText(tampil.getText()+"1");
    }//GEN-LAST:event_cmd1ActionPerformed

    private void cmd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd2ActionPerformed
        // TODO add your handling code here:
        angka += "2";
        tampil.setText(tampil.getText()+"2");
    }//GEN-LAST:event_cmd2ActionPerformed

    private void cmd3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd3ActionPerformed
        // TODO add your handling code here:
        angka += "3";
        tampil.setText(tampil.getText()+"3");
    }//GEN-LAST:event_cmd3ActionPerformed

    private void cmd4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd4ActionPerformed
        // TODO add your handling code here:
        angka += "4";
        tampil.setText(tampil.getText()+"4");
    }//GEN-LAST:event_cmd4ActionPerformed

    private void cmd5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd5ActionPerformed
        // TODO add your handling code here:
        angka += "5";
        tampil.setText(tampil.getText()+"5");
    }//GEN-LAST:event_cmd5ActionPerformed

    private void cmd6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd6ActionPerformed
        // TODO add your handling code here:
        angka += "6";
        tampil.setText(tampil.getText()+"6");
    }//GEN-LAST:event_cmd6ActionPerformed

    private void cmd7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd7ActionPerformed
        // TODO add your handling code here:
        angka += "7";
        tampil.setText(tampil.getText()+"7");
    }//GEN-LAST:event_cmd7ActionPerformed

    private void cmd8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd8ActionPerformed
        // TODO add your handling code here:
        angka += "8";
        tampil.setText(tampil.getText()+"8");
    }//GEN-LAST:event_cmd8ActionPerformed

    private void cmd9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmd9ActionPerformed
        // TODO add your handling code here:
        angka += "9";
        tampil.setText(tampil.getText()+"9");
    }//GEN-LAST:event_cmd9ActionPerformed

    private void cmdsamadenganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdsamadenganActionPerformed
        // TODO add your handling code here:
        switch(pilih)
        {
            case 1:
                angka2 = Double.parseDouble(angka);
                total = angka1 + angka2;
                angka = Double.toString(total);
                tampil.setText(angka);
                break;
            case 2:
                angka2 = Double.parseDouble(angka);
                total = angka1 - angka2;
                angka = Double.toString(total);
                tampil.setText(angka);
                break;
            case 3:
                angka2 = Double.parseDouble(angka);
                total = angka1 * angka2;
                angka = Double.toString(total);
                tampil.setText(angka);
                break;
            case 4:
                angka2 = Double.parseDouble(angka);
                total = angka1 / angka2;
                angka = Double.toString(total);
                tampil.setText(angka);
                break;
            case 5:
                angka2 = Double.parseDouble(angka);
                total = 0 - angka1;
                angka = Double.toString(total);
                tampil.setText(angka);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmdsamadenganActionPerformed

    private void cmdtambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdtambahActionPerformed
        // TODO add your handling code here:
        angka1 = Double.parseDouble(angka);
        tampil.setText(tampil.getText()+"+");
        angka = "";
        pilih = 1;
    }//GEN-LAST:event_cmdtambahActionPerformed

    private void cmdclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdclearActionPerformed
        // TODO add your handling code here:
        angka1 = 0.0;
        angka2 = 0.0;
        total = 0.0;
        angka = "";
        tampil.setText("");
    }//GEN-LAST:event_cmdclearActionPerformed

    private void cmdkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdkurangActionPerformed
        // TODO add your handling code here:
        angka1 = Double.parseDouble(angka);
        tampil.setText(tampil.getText()+"-");
        angka = "";
        pilih = 2;
    }//GEN-LAST:event_cmdkurangActionPerformed

    private void cmdkaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdkaliActionPerformed
        // TODO add your handling code here:
        angka1 = Double.parseDouble(angka);
        tampil.setText("x");
        angka = "";
        pilih = 3;
    }//GEN-LAST:event_cmdkaliActionPerformed

    private void cmdbagiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdbagiActionPerformed
        // TODO add your handling code here:
        angka1 = Double.parseDouble(angka);
        tampil.setText(tampil.getText()+"÷");
        angka = "";
        pilih = 4;
    }//GEN-LAST:event_cmdbagiActionPerformed

    private void cmdminplusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdminplusActionPerformed
        // TODO add your handling code here:
        angka2 = Double.parseDouble(angka);
        tampil.setText(tampil.getText()+"-");
        angka = Double.toString(total);
        total = 0-angka2;
        pilih = 5;
    }//GEN-LAST:event_cmdminplusActionPerformed

    private void cmdkomaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdkomaActionPerformed
        // TODO add your handling code here:
        angka += ".";
        tampil.setText(tampil.getText()+".");
    }//GEN-LAST:event_cmdkomaActionPerformed

    private void cmdpersenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdpersenActionPerformed
        // TODO add your handling code here:
        angka = Double.toHexString(total);
        tampil.setText(tampil.getText()+"%");
        angka2 = Double.parseDouble(angka);
        total = angka2/100;
    }//GEN-LAST:event_cmdpersenActionPerformed

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
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Kalkulator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Kalkulator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmd0;
    private javax.swing.JButton cmd1;
    private javax.swing.JButton cmd2;
    private javax.swing.JButton cmd3;
    private javax.swing.JButton cmd4;
    private javax.swing.JButton cmd5;
    private javax.swing.JButton cmd6;
    private javax.swing.JButton cmd7;
    private javax.swing.JButton cmd8;
    private javax.swing.JButton cmd9;
    private javax.swing.JButton cmdbagi;
    private javax.swing.JButton cmdclear;
    private javax.swing.JButton cmdkali;
    private javax.swing.JButton cmdkoma;
    private javax.swing.JButton cmdkurang;
    private javax.swing.JButton cmdminplus;
    private javax.swing.JButton cmdpersen;
    private javax.swing.JButton cmdsamadengan;
    private javax.swing.JButton cmdtambah;
    private javax.swing.JTextField tampil;
    // End of variables declaration//GEN-END:variables
}
