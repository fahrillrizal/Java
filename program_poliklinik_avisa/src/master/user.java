/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package master;

import java.sql.*;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

/**
 *
 * @author arilc
 */
public class user extends javax.swing.JFrame {

    /**
     * Creates new form user
     */
    public user() {
        initComponents();
        Koneksi.tesConnect();
        setLocationRelativeTo(this);
        getData("SELECT * FROM login","null","null");
        typeuserCmb.setOpaque(false);
        typeuserCmb.setBorder(null);
        clear();
        disableEnable(false,true,false,false,false,false,true);
                comboboxnip();

    }
        
    public void comboboxnip(){
        try
        {
            Statement st = (Statement) Koneksi.getConnection().createStatement();
            String query = "Select nip from pegawai";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){  
                nip.addItem(rs.getString(1));
            }  
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        return new javax.swing.table.DefaultTableModel(
            new Object [][]{},
            new String []{"Username", "Password","Nip", "Typeuser"}
            ){
            boolean[] canEdit = new boolean []{
                false, false, false, false, false, false
            };
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
            };              
                }
    
    public void manData(String query, String success, String error){
        try {            
            Connection con = (Connection) Koneksi.getConnection();
            PreparedStatement pst = con.prepareStatement(query);
            pst.execute();
            JOptionPane.showMessageDialog(null, success);
            clear();
            if(!query.contains("SELECT")){
                getData("SELECT * FROM login","null","null");
            }            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, error+"\n"+e.getMessage());
        }
    }
    public void getData(String query, String success, String error){
        
        ((DefaultTableCellRenderer) jtabel.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        try {
            Statement st = (Statement) Koneksi.getConnection().createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.last();
            if(rs.getRow()==0){                
                DefaultTableModel tbl = new DefaultTableModel();
                tbl.addColumn("DATA TIDAK DI TEMUKAN");
                jtabel.setModel(tbl);
                
            }else{
                rs.beforeFirst();
                DefaultTableModel tbl = getDefaultTabelModel();
                DefaultTableCellRenderer center = new DefaultTableCellRenderer();
                center.setHorizontalAlignment(JLabel.CENTER);                
                while(rs.next()){
                    tbl.addRow(new Object[] {
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nip"),
                        rs.getString("typeuser")
                    });                    
                    jtabel.setModel(tbl);
                    
                }
                if (jtabel.getColumnModel().getColumnCount() > 0) {
                    jtabel.getColumnModel().getColumn(0);
                }
            }
            
            if(!success.equals("null")){
                JOptionPane.showMessageDialog(null, success);
            }            
        } catch (Exception e) {
            if(!error.equals("null")){
                JOptionPane.showMessageDialog(null, error +"\n"+e.getMessage());
                System.exit(0);
            }
        }          
    }
    
    public void disableEnable(boolean input, boolean tambah, boolean simpan, boolean batal,boolean ubah, boolean hapus, boolean keluar){
        username.setEnabled(input);
        password.setEnabled(input);
        jButton1.setEnabled(input);
        typeuserCmb.setEnabled(input);
        nip.setEnabled(input);

        tambahbtn.setEnabled(tambah);
        simpanbtn.setEnabled(simpan);
        batalbtn.setEnabled(batal);
        ubahbtn.setEnabled(ubah);
        hapusbtn.setEnabled(hapus);
        keluarbtn.setEnabled(keluar);
    }
    
    
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        nip = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        typeuserCmb = new javax.swing.JComboBox<>();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtabel = new javax.swing.JTable();
        txtcari = new javax.swing.JTextField();
        cari = new javax.swing.JButton();
        laporan = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        simpanbtn = new javax.swing.JButton();
        ubahbtn = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        keluarbtn = new javax.swing.JButton();
        batalbtn = new javax.swing.JButton();
        tambahbtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(153, 0, 255));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Inputan Data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Username");

        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Password");

        password.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("NIP");

        nip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--NIP--" }));
        nip.setToolTipText("");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("TypeUser");

        typeuserCmb.setBackground(new java.awt.Color(0, 0, 153));
        typeuserCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--typeuser--", "Admin", "Petugas" }));
        typeuserCmb.setOpaque(false);

        jtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Username", "Password", "Type User"
            }
        ));
        jtabel.setGridColor(new java.awt.Color(91, 91, 96));
        jtabel.setOpaque(false);
        jtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtabel);

        txtcari.setBackground(new Color(0,0,0,1));
        txtcari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcari.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        cari.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-search-bar-30.png")); // NOI18N
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        laporan.setText("Laporan");

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        simpanbtn.setBackground(new java.awt.Color(51, 255, 255));
        simpanbtn.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-save-20.png")); // NOI18N
        simpanbtn.setText("SIMPAN");
        simpanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbtnActionPerformed(evt);
            }
        });

        ubahbtn.setBackground(new java.awt.Color(51, 51, 255));
        ubahbtn.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-edit-20.png")); // NOI18N
        ubahbtn.setText("UBAH");
        ubahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahbtnActionPerformed(evt);
            }
        });

        hapusbtn.setBackground(new java.awt.Color(255, 153, 51));
        hapusbtn.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-delete-20.png")); // NOI18N
        hapusbtn.setText("HAPUS");
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        keluarbtn.setBackground(new java.awt.Color(255, 0, 0));
        keluarbtn.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-exit-20.png")); // NOI18N
        keluarbtn.setText("KELUAR");
        keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarbtnActionPerformed(evt);
            }
        });

        batalbtn.setBackground(new java.awt.Color(255, 51, 51));
        batalbtn.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-cancel-20.png")); // NOI18N
        batalbtn.setText("BATAL");
        batalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalbtnActionPerformed(evt);
            }
        });

        tambahbtn.setBackground(new java.awt.Color(51, 255, 51));
        tambahbtn.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-add-20.png")); // NOI18N
        tambahbtn.setText("TAMBAH");
        tambahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tambahbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ubahbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hapusbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(simpanbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batalbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(keluarbtn)
                        .addGap(3, 3, 3))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(batalbtn)
                    .addComponent(simpanbtn)
                    .addComponent(tambahbtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ubahbtn)
                    .addComponent(hapusbtn)
                    .addComponent(keluarbtn))
                .addContainerGap())
        );

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-add-user-male-50.png")); // NOI18N
        jLabel6.setText("Input User");

        jButton1.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-eye-30.png")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(laporan)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel6Layout.createSequentialGroup()
                                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel6Layout.createSequentialGroup()
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel3)
                                                    .addComponent(jLabel7))
                                                .addGap(35, 35, 35)
                                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(36, 36, 36)
                                .addComponent(typeuserCmb, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(297, 297, 297)
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(typeuserCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(laporan)
                                .addGap(23, 23, 23))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtcari)
                                .addGap(19, 19, 19)))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 760, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtnActionPerformed
        username.requestFocus();
        disableEnable(true,false,true,true,false,false,false);
    }//GEN-LAST:event_tambahbtnActionPerformed

    private void batalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalbtnActionPerformed
        clear();
        disableEnable(false,true,false,false,false,false,true);
    }//GEN-LAST:event_batalbtnActionPerformed

    private void keluarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarbtnActionPerformed

        if(JOptionPane.showConfirmDialog(null, "yakin ingin keluar!",null,0)==0){
            this.dispose();
        }
    }//GEN-LAST:event_keluarbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed
        if(jtabel.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di hapus");
        }else{
            DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
            String query = String.format("DELETE FROM login WHERE username='%s'",tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
            manData(query, "Data berhasil di hapus", "Data gagal di hapus");
            disableEnable(false,true,false,false,false,false,true);
            clear();
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void ubahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahbtnActionPerformed
        if(jtabel.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di ubah");
        }else{
            if(username.getText().equals("")||password.getText().equals("")||nip.getSelectedItem().toString().equals("--NIP--")||typeuserCmb.getSelectedItem().toString().equals("--typeuser--")){
                JOptionPane.showMessageDialog(null, "Harap di isi Semua");
            }else{
                DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
                String query = String.format("UPDATE login SET username='%s', password='%s', nip='%s', typeuser='%s' where username='%s'", username.getText(), password.getText(),nip.getSelectedItem().toString(),typeuserCmb.getSelectedItem().toString(), tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
                manData(query, "Data berhasil di ubah", "Data gagal di ubah");
                disableEnable(false,true,false,false,false,false,true);
                clear();
            }
        }
    }//GEN-LAST:event_ubahbtnActionPerformed

    private void simpanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbtnActionPerformed

        if(username.getText().equals("")||password.getText().equals("")||nip.getSelectedItem().toString().equals("--NIP--")||typeuserCmb.getSelectedItem().toString().equals("--typeuser--")){
            JOptionPane.showMessageDialog(null, "Harap di isi Semua");
            username.requestFocus();
        }else{
            String query = String.format("INSERT INTO login(username,password,nip,typeuser) VALUES ('%s','%s','%s','%s')", username.getText(),password.getText(),nip.getSelectedItem().toString(),typeuserCmb.getSelectedItem().toString());
            manData(query, "Data berhasil di tambahkan", "Data gagal di tambahkan");
            disableEnable(false,true,false,false,false,false,true);
            clear();
        }
    }//GEN-LAST:event_simpanbtnActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        txtcari.requestFocus();
        String query = "SELECT * FROM login WHERE username LIKE '%"+txtcari.getText()+"%' or typeuser like '%"+txtcari.getText()+"%' or nip like '%"+txtcari.getText()+"%' or password like '%"+txtcari.getText()+"%'";
        getData(query,"null","null");
        
        disableEnable(true,false,true,true,true,true,true);
        username.requestFocus();
        DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
        username.setText(tabel.getValueAt(0, 0).toString());
        password.setText(tabel.getValueAt(0, 1).toString());
        nip.setSelectedItem(tabel.getValueAt(0, 2).toString());
        typeuserCmb.setSelectedItem(tabel.getValueAt(0, 3).toString());
        
        jtabel.setRowSelectionInterval(0, 0);
        
    }//GEN-LAST:event_cariActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased

        String query = "SELECT * FROM login WHERE username LIKE '%"+txtcari.getText()+"%' or typeuser like '%"+txtcari.getText()+"%' or nip like '%"+txtcari.getText()+"%' or password like '%"+txtcari.getText()+"%'";
        getData(query,"null","data null");
    }//GEN-LAST:event_txtcariKeyReleased

    private void jtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelMouseClicked

        disableEnable(true,false,true,true,true,true,true);
        username.requestFocus();
        DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
        username.setText(tabel.getValueAt(jtabel.getSelectedRow(), 1).toString());
        password.setText(tabel.getValueAt(jtabel.getSelectedRow(), 2).toString());
        nip.setSelectedItem(tabel.getValueAt(jtabel.getSelectedRow(), 3).toString());
        typeuserCmb.setSelectedItem(tabel.getValueAt(jtabel.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jtabelMouseClicked

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(password.getEchoChar()== '*'){
            password.setEchoChar((char)0);
        }else{
            password.setEchoChar('*');
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    
    private void clear(){
        username.setText("");
        password.setText("");
        typeuserCmb.setSelectedIndex(0);
        nip.setSelectedIndex(0);
        txtcari.setText("");
    }
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
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(user.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new user().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalbtn;
    private javax.swing.JButton cari;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtabel;
    private javax.swing.JButton keluarbtn;
    private javax.swing.JButton laporan;
    private javax.swing.JComboBox<String> nip;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton simpanbtn;
    private javax.swing.JButton tambahbtn;
    private javax.swing.JTextField txtcari;
    private javax.swing.JComboBox<String> typeuserCmb;
    private javax.swing.JButton ubahbtn;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
