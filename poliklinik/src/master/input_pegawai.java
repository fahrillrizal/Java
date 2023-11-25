package master;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Color;

import java.awt.Dimension;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author cholifah
 */
public class input_pegawai extends javax.swing.JFrame {

    /**
     * Creates new form input_pegawai
     */
    public input_pegawai() {
        initComponents();
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        setExtendedState(MAXIMIZED_BOTH);
        setLocationRelativeTo(this);
        getData("SELECT * FROM pegawai","null","null");
        disableEnable(false,true,false,false,false,false,true);
    }
    private void clear(){
        nip.setText("");
        nama.setText("");
        alamat.setText("");
        telp.setText("");
        tgl_lahir.setDate(null);
        jenkel.setSelectedIndex(0);
        txtcari.setText("");
    }
    
    public void disableEnable(boolean input, boolean tambah, boolean simpan, boolean batal,boolean ubah, boolean hapus, boolean keluar){
        nip.setEnabled(input);
        nama.setEnabled(input);
        alamat.setEnabled(input);
        telp.setEnabled(input);
        tgl_lahir.setEnabled(input);
        jenkel.setEnabled(input);

        tambahbtn.setEnabled(tambah);
        simpanbtn.setEnabled(simpan);
        batalbtn.setEnabled(batal);
        ubahbtn.setEnabled(ubah);
        hapusbtn.setEnabled(hapus);
        keluarbtn.setEnabled(keluar);
    }
    
    private javax.swing.table.DefaultTableModel getDefaultTabelModel(){
        return new javax.swing.table.DefaultTableModel(
            new Object [][]{},
            new String []{"NIP/NIK", "Nama Pegawai", "Alamat", "No Telp", "Tanggal Lahir", "Jenis Kelamin"}
            ){
            boolean[] canEdit = new boolean []{
                true, false, true, true, true, true
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
                getData("SELECT * FROM pegawai","null","null");
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
                        rs.getString("nip"),
                        rs.getString("nama"),
                        rs.getString("alamat"),
                        rs.getString("telp"),
                        rs.getString("tgl_lahir"),
                        rs.getString("jenkel")
                    });                    
                    jtabel.setModel(tbl);
                    
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
    
    public  Date AmbilTanggalDariTabel(int row,int kolom){
        String str_tgl = String.valueOf(jtabel.getValueAt(row, kolom));
        Date tanggal = null;
        try {
            tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (ParseException e) {
            System.out.println(e);;
        }
        return tanggal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        simpanbtn = new javax.swing.JButton();
        ubahbtn = new javax.swing.JButton();
        hapusbtn = new javax.swing.JButton();
        keluarbtn = new javax.swing.JButton();
        batalbtn = new javax.swing.JButton();
        tambahbtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtabel = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        nip = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        telp = new javax.swing.JTextField();
        jenkel = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        alamat = new javax.swing.JTextArea();
        tgl_lahir = new com.toedter.calendar.JDateChooser();
        txttgl = new javax.swing.JLabel();
        laporan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(102, 102, 102));

        simpanbtn.setBackground(new java.awt.Color(153, 153, 153));
        simpanbtn.setText("SIMPAN");
        simpanbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanbtnActionPerformed(evt);
            }
        });

        ubahbtn.setBackground(new java.awt.Color(153, 153, 153));
        ubahbtn.setText("UBAH");
        ubahbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahbtnActionPerformed(evt);
            }
        });

        hapusbtn.setBackground(new java.awt.Color(153, 153, 153));
        hapusbtn.setText("HAPUS");
        hapusbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusbtnActionPerformed(evt);
            }
        });

        keluarbtn.setBackground(new java.awt.Color(153, 153, 153));
        keluarbtn.setText("KELUAR");
        keluarbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarbtnActionPerformed(evt);
            }
        });

        batalbtn.setBackground(new java.awt.Color(153, 153, 153));
        batalbtn.setText("BATAL");
        batalbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalbtnActionPerformed(evt);
            }
        });

        tambahbtn.setBackground(new java.awt.Color(153, 153, 153));
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
                .addComponent(tambahbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(simpanbtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(hapusbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ubahbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(batalbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(keluarbtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanbtn)
                    .addComponent(tambahbtn)
                    .addComponent(hapusbtn)
                    .addComponent(ubahbtn)
                    .addComponent(batalbtn)
                    .addComponent(keluarbtn))
                .addGap(49, 49, 49))
        );

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Laporan / Report Data");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel2.setText("Data Pegawai");

        txtcari.setBackground(new Color(0,0,0,1));
        txtcari.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtcari.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 255, 255)));
        txtcari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtcariMouseClicked(evt);
            }
        });
        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel17.setText("Daftar Pegawai");

        cari.setText("CARI");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        jtabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtabel.setForeground(new java.awt.Color(102, 102, 102));
        jtabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIP/NIK", "Nama Pegawai", "Alamat", "Telp", "Tanggal Lahir", "Jenis Kelamin"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabel.setGridColor(new java.awt.Color(91, 91, 96));
        jtabel.setOpaque(false);
        jtabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtabel);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel6.setBackground(new java.awt.Color(0, 0, 0));
        jLabel6.setFont(new java.awt.Font("Ebrima", 1, 36)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\Unduhan\\icon netbeans\\icons8-employee-50.png")); // NOI18N
        jLabel6.setText("Data Pegawai");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(270, 270, 270)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel6)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 12)); // NOI18N
        jLabel3.setText("Input Data Pegawai");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("NIP/NIK");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setText("Nama Pegawai");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setText("Alamat");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setText("No Tlp");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setText("Tanggal Lahir");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setText("Jenis Kelamin");

        jenkel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Jenis Kelamin--", "Laki-laki", "Perempuan" }));

        alamat.setColumns(20);
        alamat.setRows(5);
        jScrollPane5.setViewportView(alamat);

        jScrollPane1.setViewportView(jScrollPane5);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14)
                            .addComponent(jLabel15)
                            .addComponent(jLabel16))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nama, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nip, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telp, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jenkel, javax.swing.GroupLayout.Alignment.LEADING, 0, 133, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(tgl_lahir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(20, 20, 20)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(tgl_lahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(0, 24, Short.MAX_VALUE))
        );

        txttgl.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        txttgl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        txttgl.setText("TANGGAL");

        laporan.setText("Laporan");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cari)
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttgl, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(laporan))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(txttgl)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari))
                        .addGap(35, 35, 35)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(6, 6, 6)
                        .addComponent(laporan)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased

        String query = "SELECT * FROM pegawai WHERE nip LIKE '%"+txtcari.getText()+"%' or nama like '%"+txtcari.getText()+"%' or alamat like '%"+txtcari.getText()+"%' or telp like '%"+txtcari.getText()+"%' or tgl_lahir like '%"+txtcari.getText()+"%' or jenkel like '%"+txtcari.getText()+"%'";
        getData(query,"null","data null");
    }//GEN-LAST:event_txtcariKeyReleased

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
        txtcari.requestFocus();
        String query = "SELECT * FROM pegawai WHERE nip LIKE '%"+txtcari.getText()+"%' or nama like '%"+txtcari.getText()+"%' or alamat like '%"+txtcari.getText()+"%' or telp like '%"+txtcari.getText()+"%' or tgl_lahir like '%"+txtcari.getText()+"%' or jenkel like '%"+txtcari.getText()+"%'";
        getData(query,"null","data null");
        
        
        disableEnable(true,false,true,true,true,true,true);
        nip.requestFocus();
        DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
        nip.setText(tabel.getValueAt(0, 0).toString());
        nama.setText(tabel.getValueAt(0, 1).toString());
        alamat.setText(tabel.getValueAt(0, 2).toString());
        telp.setText(tabel.getValueAt(0, 3).toString());
        tgl_lahir.setDate(AmbilTanggalDariTabel(0, 4));
        jenkel.setSelectedItem(tabel.getValueAt(0, 5).toString());
        
        jtabel.setRowSelectionInterval(0, 0);
    }//GEN-LAST:event_cariActionPerformed

    private void simpanbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanbtnActionPerformed
        if(nip.getText().equals("")||nama.getText().equals("")||alamat.getText().equals("")||telp.getText().equals("")||tgl_lahir.getDate().equals("")||jenkel.getSelectedItem().toString().equals("--Jenis Kelamin--")){
            JOptionPane.showMessageDialog(null, "Harap di isi Semua");
            nip.requestFocus();
        }else{
            String Tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(Tampilan);
            String Tanggal = String.valueOf(fm.format(tgl_lahir.getDate()));
            String query = String.format("INSERT INTO pegawai VALUES ('%s','%s','%s','%s','%s','%s')", nip.getText(),nama.getText(),alamat.getText(),telp.getText(),Tanggal,jenkel.getSelectedItem().toString());
            manData(query, "Data berhasil di tambahkan", "Data gagal di tambahkan");
            disableEnable(false,true,false,false,false,false,true);
            clear();
        }
    }//GEN-LAST:event_simpanbtnActionPerformed

    private void ubahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahbtnActionPerformed

        if(jtabel.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di ubah");
        }else{
            if(nip.getText().equals("")||nama.getText().equals("")||alamat.getText().equals("")||telp.getText().equals("")||tgl_lahir.getDate().equals("")||jenkel.getSelectedItem().toString().equals("--Jenis Kelamin--")){
                JOptionPane.showMessageDialog(null, "Harap di isi Semua");
            }else{
                String Tampilan = "yyyy-MM-dd";
                SimpleDateFormat fm = new SimpleDateFormat(Tampilan);
                String Tanggal = String.valueOf(fm.format(tgl_lahir.getDate()));
                DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
                String query = String.format("UPDATE pegawai SET nip='%s', nama='%s', alamat='%s', telp='%s', tgl_lahir='%s', jenkel='%s' where nip='%s'", nip.getText(),nama.getText(),alamat.getText(),telp.getText(),Tanggal,jenkel.getSelectedItem().toString(), tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
                manData(query, "Data berhasil di ubah", "Data gagal di ubah");
                disableEnable(false,true,false,false,false,false,true);
                clear();
            }
        }
    }//GEN-LAST:event_ubahbtnActionPerformed

    private void hapusbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusbtnActionPerformed

        if(jtabel.getSelectedRow()==-1){
            JOptionPane.showMessageDialog(null, "Pilih data yang akan di hapus");
        }else{
            String Tampilan = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat(Tampilan);
            String Tanggal = String.valueOf(fm.format(tgl_lahir.getDate()));
            DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
            String query = String.format("DELETE FROM pegawai WHERE nip='%s'",tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
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

    private void batalbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalbtnActionPerformed
        clear();
        disableEnable(false,true,false,false,false,false,true);
    }//GEN-LAST:event_batalbtnActionPerformed

    private void tambahbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahbtnActionPerformed
        nip.requestFocus();
        disableEnable(true,false,true,true,false,false,false);
    }//GEN-LAST:event_tambahbtnActionPerformed

    private void jtabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelMouseClicked

        disableEnable(true,false,true,true,true,true,true);
        nip.requestFocus();
        DefaultTableModel tabel = (DefaultTableModel) jtabel.getModel();
        nip.setText(tabel.getValueAt(jtabel.getSelectedRow(), 0).toString());
        nama.setText(tabel.getValueAt(jtabel.getSelectedRow(), 1).toString());
        alamat.setText(tabel.getValueAt(jtabel.getSelectedRow(), 2).toString());
        telp.setText(tabel.getValueAt(jtabel.getSelectedRow(), 3).toString());
        tgl_lahir.setDate(AmbilTanggalDariTabel(jtabel.getSelectedRow(), 4));
        jenkel.setSelectedItem(tabel.getValueAt(jtabel.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jtabelMouseClicked

    private void txtcariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtcariMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcariMouseClicked

   
    
    
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
            java.util.logging.Logger.getLogger(input_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(input_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(input_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(input_pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new input_pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamat;
    private javax.swing.JButton batalbtn;
    private javax.swing.JButton cari;
    private javax.swing.JButton hapusbtn;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JComboBox<String> jenkel;
    private javax.swing.JTable jtabel;
    private javax.swing.JButton keluarbtn;
    private javax.swing.JButton laporan;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nip;
    private javax.swing.JButton simpanbtn;
    private javax.swing.JButton tambahbtn;
    private javax.swing.JTextField telp;
    private com.toedter.calendar.JDateChooser tgl_lahir;
    private javax.swing.JTextField txtcari;
    private javax.swing.JLabel txttgl;
    private javax.swing.JButton ubahbtn;
    // End of variables declaration//GEN-END:variables
}
