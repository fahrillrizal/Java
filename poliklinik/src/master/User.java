package master;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.*;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author arilc

 */
public class User extends javax.swing.JFrame {

    /**
     * Creates new form User
     */
    
    public User() {
        initComponents();
        tglskrg();
        Koneksi.tesConnect();
        getData("SELECT * FROM login","null","null");
        typeuserCmb.setOpaque(false);
        typeuserCmb.setBorder(null);
        clear();
        disableEnable(false,true,false,false,false,false,true);        
        
        comboboxnip();


    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        return new javax.swing.table.DefaultTableModel(
            new Object [][]{},
            new String []{"ID", "Username", "Password","Nip", "Typeuser"}
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
                        rs.getString("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("nip"),
                        rs.getString("typeuser")
                    });                    
                    jtabel.setModel(tbl);
                    
                }
                if (jtabel.getColumnModel().getColumnCount() > 0) {
                    jtabel.getColumnModel().getColumn(0).setMaxWidth(30);
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txttgl = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        nip = new javax.swing.JComboBox<>();
        typeuserCmb = new javax.swing.JComboBox<>();
        txtcari = new javax.swing.JTextField();
        showcheck = new javax.swing.JCheckBox();
        cari = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtabel = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        simpanbtn = new javax.swing.JButton();
        ubahbtn = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        keluarbtn = new javax.swing.JButton();
        batalbtn = new javax.swing.JButton();
        tambahbtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        laporan = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new Color(0,0,0,70));
        jPanel1.setOpaque(false);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new Color(0,0,0,70));
        jPanel2.setOpaque(false);

        jLabel2.setText("Username");

        jLabel3.setText("Password");

        jLabel5.setText("TypeUser");

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Edwardian Script ITC", 0, 36)); // NOI18N
        jLabel6.setText("Input User");

        txttgl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txttgl.setText("TANGGAL");

        username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        password.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N

        nip.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--NIP--" }));

        typeuserCmb.setBackground(new java.awt.Color(0, 0, 153));
        typeuserCmb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--typeuser--", "admin", "petugas" }));
        typeuserCmb.setOpaque(false);

        txtcari.setBackground(new Color(0,0,0,1));
        txtcari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcari.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        showcheck.setText("Show");
        showcheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showcheckActionPerformed(evt);
            }
        });

        cari.setText("CARI");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Username", "Password", "TypeUser"
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
        if (jtabel.getColumnModel().getColumnCount() > 0) {
            jtabel.getColumnModel().getColumn(0).setMaxWidth(30);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        simpanbtn.setText("SIMPAN");
        simpanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbtnActionPerformed(evt);
            }
        });

        ubahbtn.setText("UBAH");
        ubahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahbtnActionPerformed(evt);
            }
        });

        hapusbtn.setText("HAPUS");
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        keluarbtn.setText("KELUAR");
        keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarbtnActionPerformed(evt);
            }
        });

        batalbtn.setText("BATAL");
        batalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalbtnActionPerformed(evt);
            }
        });

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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(hapusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(keluarbtn)
                        .addGap(0, 9, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(simpanbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(batalbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
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

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jLabel4.setText("Inputan Data");

        laporan.setText("Laporan");

        jLabel7.setText("NIP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(333, 333, 333))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(13, 13, 13)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel2)
                                                    .addComponent(jLabel3))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(username)
                                                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(showcheck))
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel7))
                                                .addGap(31, 31, 31)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(nip, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(typeuserCmb, javax.swing.GroupLayout.Alignment.TRAILING, 0, 171, Short.MAX_VALUE))))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari)
                        .addGap(40, 40, 40)
                        .addComponent(laporan)))
                .addGap(80, 80, 80))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(txttgl)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showcheck))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(typeuserCmb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cari)
                    .addComponent(laporan))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, -1));

        jPanel4.setBackground(new Color(0,0,0,60));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    
    private void clear(){
        username.setText("");
        password.setText("");
        typeuserCmb.setSelectedIndex(0);
        nip.setSelectedIndex(0);
        txtcari.setText("");
    }
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

    private void ubahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahbtnActionPerformed
        
        if(jtabel.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di ubah");
        }else{
            if(username.getText().equals("")||password.getText().equals("")||nip.getSelectedItem().toString().equals("--NIP--")||typeuserCmb.getSelectedItem().toString().equals("--typeuser--")){
                JOptionPane.showMessageDialog(null, "Harap di isi Semua");
            }else{
                DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
                String query = String.format("UPDATE login SET username='%s', password='%s', nip='%s', typeuser='%s' where id='%s'", username.getText(), password.getText(),nip.getSelectedItem().toString(),typeuserCmb.getSelectedItem().toString(), tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
                manData(query, "Data berhasil di ubah", "Data gagal di ubah");
                disableEnable(false,true,false,false,false,false,true);
                clear();
            }
        }
    }//GEN-LAST:event_ubahbtnActionPerformed

    private void jtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelMouseClicked

        disableEnable(true,false,true,true,true,true,true);
        username.requestFocus();
        DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
        username.setText(tabel.getValueAt(jtabel.getSelectedRow(), 1).toString());
        password.setText(tabel.getValueAt(jtabel.getSelectedRow(), 2).toString());
        nip.setSelectedItem(tabel.getValueAt(jtabel.getSelectedRow(), 3).toString());
        typeuserCmb.setSelectedItem(tabel.getValueAt(jtabel.getSelectedRow(), 4).toString());
    }//GEN-LAST:event_jtabelMouseClicked

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed

        if(jtabel.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di hapus");
        }else{
            DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
            String query = String.format("DELETE FROM login WHERE id='%s'",tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
            manData(query, "Data berhasil di hapus", "Data gagal di hapus");
            disableEnable(false,true,false,false,false,false,true);
            clear();
        }
    }//GEN-LAST:event_hapusbtnActionPerformed

    private void keluarbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarbtnActionPerformed
    
        if(JOptionPane.showConfirmDialog(null, "yakin ingin keluar!",null,0)==0){
//            System.exit(0);
            this.dispose();

        }
    }//GEN-LAST:event_keluarbtnActionPerformed
        
    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        txtcari.requestFocus();
        String query = "SELECT * FROM login WHERE id LIKE '%"+txtcari.getText()+"%' or username like '%"+txtcari.getText()+"%' or typeuser like '%"+txtcari.getText()+"%' or nip like '%"+txtcari.getText()+"%' or password like '%"+txtcari.getText()+"%'";
        getData(query,"null","null");
        
    }//GEN-LAST:event_cariActionPerformed

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased

        String query = "SELECT * FROM login WHERE id LIKE '%"+txtcari.getText()+"%' or username like '%"+txtcari.getText()+"%' or typeuser like '%"+txtcari.getText()+"%' or nip like '%"+txtcari.getText()+"%' or password like '%"+txtcari.getText()+"%'";
        getData(query,"null","data null");
    }//GEN-LAST:event_txtcariKeyReleased

    private void showcheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showcheckActionPerformed
        if(showcheck.isSelected()==false){
            password.setEchoChar('*');
        }else{
            password.setEchoChar((char)0);
        }
    }//GEN-LAST:event_showcheckActionPerformed

    private void batalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalbtnActionPerformed
        clear();
        disableEnable(false,true,false,false,false,false,true);

    }//GEN-LAST:event_batalbtnActionPerformed

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtnActionPerformed
        username.requestFocus();
        disableEnable(true,false,true,true,false,false,false);
    }//GEN-LAST:event_tambahbtnActionPerformed

    public void disableEnable(boolean input, boolean tambah, boolean simpan, boolean batal,boolean ubah, boolean hapus, boolean keluar){
        username.setEnabled(input);
        password.setEnabled(input);
        showcheck.setEnabled(input);
        typeuserCmb.setEnabled(input);
        nip.setEnabled(input);

        tambahbtn.setEnabled(tambah);
        simpanbtn.setEnabled(simpan);
        batalbtn.setEnabled(batal);
        ubahbtn.setEnabled(ubah);
        hapusbtn.setEnabled(hapus);
        keluarbtn.setEnabled(keluar);
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
            java.util.logging.Logger.getLogger(input_data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(input_data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(input_data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(input_data_siswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User().setVisible(true);
            }
        });
    }
    public void tglskrg(){
        Date skrg = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd MMMM yyyy");
        String tgl = format.format(skrg);
        txttgl.setText(tgl);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton batalbtn;
    private javax.swing.JButton cari;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jtabel;
    private javax.swing.JButton keluarbtn;
    private javax.swing.JButton laporan;
    private javax.swing.JComboBox<String> nip;
    private javax.swing.JPasswordField password;
    private javax.swing.JCheckBox showcheck;
    private javax.swing.JButton simpanbtn;
    private javax.swing.JButton tambahbtn;
    private javax.swing.JTextField txtcari;
    private javax.swing.JLabel txttgl;
    private javax.swing.JComboBox<String> typeuserCmb;
    private javax.swing.JButton ubahbtn;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
    private void setIconImage(String image) {
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource(image)));
    }
}
