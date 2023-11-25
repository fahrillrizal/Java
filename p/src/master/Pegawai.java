package master;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.*;
import java.awt.Dimension; 
import java.awt.Toolkit; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
/**
 *
 * @author arilc
 */
public class Pegawai extends javax.swing.JFrame {
    public Connection con;
    public Statement stt;
    public ResultSet rs;
    public String SQL;
    public static int Kondisilogin=3;
    public static String UserLogin="Tidak Terdeteksi";
    /**
     * Creates new form Pegawai
     */
    public Pegawai() {
       initComponents();
        this.setLocationRelativeTo(null); 
        this.setSize(900,768);   
        Tabel.setModel(tblModel);         
        Tabel(Tabel,new int[]{150,200,210,150,200,210,90});         
        setDefaultTable(); 
        normal();
    }
    
    String tgl_lahir;
    public void tanggal() {
    if (TglLahir.getDate()!=null ){
        String Tampilan = "yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(Tampilan);
        tgl_lahir = String.valueOf(fm.format(TglLahir.getDate()));
    } 
}
    
    public void tanggal_lahir(){
        try {
           stt = (Statement) koneksi.GetConnection().createStatement();              
             SQL ="Select* from pegawai where nip ='"+NIP.getText()+"'";             
             rs= stt.executeQuery(SQL);  
            while (rs.next()) {
                TglLahir.setDate(rs.getDate("tgl_lahir"));
                
            }
        } catch (Exception e) {
        }
    }
    
     private javax.swing.table.DefaultTableModel tblModel=getDefaulTableModel();
     private void Tabel(javax.swing.JTable tb, int lebar[]){             
         tb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);             
         int kolom=tb.getColumnCount();             
         for(int i=0;i<kolom;i++){                 
             javax.swing.table.TableColumn tbc=tb.getColumnModel().getColumn(i);                 
             tbc.setPreferredWidth(lebar[i]);                 
             tb.setRowHeight(17);             
         }         
     } 
 
    private javax.swing.table.DefaultTableModel getDefaulTableModel(){         
        return new javax.swing.table.DefaultTableModel(                 
                new Object[][]{},                 
                new String[]{"NIP","Nama","Alamat","Telepon","Tanggal Lahir","Jenis Kelamin"}  ){            
                    boolean[] canEdit=new boolean[]{                 
                        false,false,false,false,false,false             
                    };             
                    public boolean isCellEditable(int rowIndex, int columnIndex){                 
                        return canEdit[columnIndex];             
                    }     
                };     
    } 
    public void normal(){         
        NIP.setText("");     
        Nama.setText(""); 
        Alamat.setText("");     
        Telp.setText("");
        TglLahir.setDate(null);
        Jenkel.setSelectedItem("");
        NIP.setEnabled(false);   
        Nama.setEnabled(false);  
        Alamat.setEnabled(false);   
        Telp.setEnabled(false); 
        TglLahir.setEnabled(false);
        Jenkel.setEnabled(false);  
        Tambah.setEnabled(true);    
        Simpan.setEnabled(false);   
        Ubah.setEnabled(false);      
        Hapus.setEnabled(false);  
        Batal.setEnabled(false);    
        Keluar.setEnabled(true);       
    }          
    int row = 0;     
    public void Tampil(){ 
        row= Tabel.getSelectedRow();         
        NIP.setText(tblModel.getValueAt(row,0).toString());         
        Nama.setText(tblModel.getValueAt(row,1).toString());         
        Telp.setText(tblModel.getValueAt(row,2).toString());         
        Alamat.setText(tblModel.getValueAt(row,3).toString()); 
        TglLahir.setDate(AmbilTanggalDariTabel(Tabel, 4));
        Jenkel.setSelectedItem(tblModel.getValueAt(row,5).toString());    
        
        NIP.setEnabled(true);   
        Nama.setEnabled(true);  
        Alamat.setEnabled(true);   
        Telp.setEnabled(true); 
        TglLahir.setEnabled(true); 
        Jenkel.setEnabled(true);     
    } 
     public static java.util.Date AmbilTanggalDariTabel(JTable table,int kolom){
        JTable tabel = table;
        String str_tgl = String.valueOf(tabel.getValueAt(tabel.getSelectedRow(), kolom));
        java.util.Date tanggal = null;
        try {
            tanggal =  new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
        } catch (ParseException ex) {
            Logger.getLogger(Pegawai.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tanggal;
        
    }
    String data[]=new String[6];          
    public void setDefaultTable(){         
        try{            
            stt = (Statement) koneksi.GetConnection().createStatement();             
             SQL ="Select*from pegawai order by nip asc";             
            ResultSet res= stt.executeQuery(SQL);             
            while(res.next()){                 
                data[0]=res.getString(1);                 
                data[1]=res.getString(2);                 
                data[2]=res.getString(3);
                data[3]=res.getString(4);                 
                data[4]=res.getString(5);                 
                data[5]=res.getString(6);
                tblModel.addRow(data);             
            }             
            res.close();             
            stt.close();             
            con.close();             
        } catch(Exception exc){             
            System.err.println(exc.getMessage());         
        }     
    }   
    
    public void Search(){
        try{    
                   String cari=txtcari.getText();          
                   stt = (Statement) koneksi.GetConnection().createStatement(); 
                   SQL ="select * from pegawai where nip like '"+cari+"'";     
                   ResultSet res=stt.executeQuery(SQL);     
                   if(res.next()){     
                       NIP.setText(res.getString(1));          
                       Nama.setText(res.getString(2));   
                       Alamat.setText(res.getString(3));          
                       Telp.setText(res.getString(4)); 
                       TglLahir.setDate(res.getDate(5));          
                       Jenkel.setSelectedItem(res.getString(6));     
                       NIP.setEnabled(true);   
                       Nama.setEnabled(true);  
                       Alamat.setEnabled(true);   
                       Telp.setEnabled(true); 
                       TglLahir.setEnabled(true); 
                       Jenkel.setEnabled(true);           
                       Batal.setEnabled(true);          
                       Hapus.setEnabled(true);             
                       Ubah.setEnabled(true);             
                       txtcari.setText("");         
                   }else{             
                       JOptionPane.showMessageDialog(null,"Data Tidak Ditemukan");  
                   }            
                   stt.close();    
                   con.close();         
                   }catch (Exception e){         
                       System.out.println("Error."+e);      
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

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        NIP = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tabel = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        cari = new javax.swing.JButton();
        txtcari = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Ubah = new javax.swing.JButton();
        Hapus = new javax.swing.JButton();
        Batal = new javax.swing.JButton();
        Keluar = new javax.swing.JButton();
        Tambah = new javax.swing.JButton();
        Simpan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Nama = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Telp = new javax.swing.JTextField();
        Jenkel = new javax.swing.JComboBox();
        cetak = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Alamat = new javax.swing.JTextArea();
        TglLahir = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel1.setText("POLIKLINIK A");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(308, 308, 308))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 255));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel2.setText("NIP/NIK");

        jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel3.setText("Nama Pegawai");

        Tabel.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        Tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NIP/NIK", "Nama", "Alamat", "No Telp", "Tanggal Lahir", "Jenis Kelamin"
            }
        ));
        Tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Tabel);

        jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel4.setText("Alamat");

        cari.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cari.setText("Cari");
        cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cariActionPerformed(evt);
            }
        });

        txtcari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcariActionPerformed(evt);
            }
        });

        Ubah.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Ubah.setText("Ubah");
        Ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UbahActionPerformed(evt);
            }
        });

        Hapus.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Hapus.setText("Hapus");
        Hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HapusActionPerformed(evt);
            }
        });

        Batal.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Batal.setText("Batal");
        Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalActionPerformed(evt);
            }
        });

        Keluar.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Keluar.setText("Keluar");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });

        Tambah.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Tambah.setText("Tambah");
        Tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TambahActionPerformed(evt);
            }
        });

        Simpan.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        Simpan.setText("Simpan");
        Simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(Tambah)
                .addGap(42, 42, 42)
                .addComponent(Simpan)
                .addGap(40, 40, 40)
                .addComponent(Ubah)
                .addGap(48, 48, 48)
                .addComponent(Hapus)
                .addGap(42, 42, 42)
                .addComponent(Batal)
                .addGap(45, 45, 45)
                .addComponent(Keluar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Ubah)
                    .addComponent(Hapus)
                    .addComponent(Batal)
                    .addComponent(Keluar)
                    .addComponent(Tambah)
                    .addComponent(Simpan))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 18)); // NOI18N
        jLabel5.setText("DATA PEGAWAI");

        jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 15)); // NOI18N
        jLabel7.setText("Detail Pegawai");

        jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 13)); // NOI18N
        jLabel8.setText("Masukkan NIP/NIK Pegawai");

        jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel9.setText("No Telp");

        jLabel10.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel10.setText("Tanggal Lahir");

        jLabel11.setFont(new java.awt.Font("Comic Sans MS", 1, 12)); // NOI18N
        jLabel11.setText("Jenis Kelamin");

        Jenkel.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--Pilih--", "Laki-Laki", "Perempuan" }));

        cetak.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        cetak.setText("Laporan");

        Alamat.setColumns(20);
        Alamat.setRows(5);
        jScrollPane2.setViewportView(Alamat);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel9)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(cari)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(314, 314, 314))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(TglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(NIP, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Telp, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(483, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cetak)
                                .addGap(50, 50, 50))))))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(NIP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(68, 68, 68)
                                .addComponent(jLabel9))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Telp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cari))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(cetak))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TglLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Jenkel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(41, 41, 41)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(423, Short.MAX_VALUE))
        );

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 14)); // NOI18N
        jLabel6.setText("SELAMAT DATANG !, SILAHKAN ISI DATA DENGAN BENAR");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(202, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(159, 159, 159))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){         
             Tampil();
         }         
//         Telp.setEnabled(true);        
         Tambah.setEnabled(false);       
         Simpan.setEnabled(false);       
         Ubah.setEnabled(true);        
         Batal.setEnabled(true);      
         Hapus.setEnabled(true);    
         Keluar.setEnabled(false); 
    }//GEN-LAST:event_TabelMouseClicked

    private void SimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanActionPerformed
         String nm=NIP.getText();     
        String ps=Nama.getText();   
        String Tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(Tampilan);
        String Tanggal =String.valueOf(fm.format(TglLahir.getDate()));
        if((nm.isEmpty())|(ps.isEmpty())){   
            JOptionPane .showMessageDialog(null,"Masih Ada nilai yang kosong,silahkann dilengkapi");    
            Telp.requestFocus();       
        }else{     
            Object[]options = {"YA","TIDAK"};     
            int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Menyimpan Data??","konfirmasi",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,options,options[0]);  
            if(konfirmasi==JOptionPane.YES_OPTION){
                try{    
                    stt = (Statement) koneksi.GetConnection().createStatement(); 
                    SQL ="insert into pegawai values('"+NIP.getText()+""
                            + "','"+Nama.getText()+
                            "','"+Alamat.getText()+
                            "','"+Telp.getText()+
                            "','"+Tanggal+
                            "','"+Jenkel.getSelectedItem()+"')";  
                    stt.executeUpdate(SQL);  
                    data[0]=NIP.getText();     
                    data[1]=Nama.getText();  
                    data[2]=Alamat.getText();     
                    data[3]=Telp.getText(); 
                    data[4]=Tanggal;     
                    data[5]=Jenkel.getSelectedItem().toString();  
                    tblModel.insertRow(0,data);       
                    normal();                 
                    stt.close();             
                    con.close();        
                }catch(Exception exc){          
                    System.err.println(exc.getMessage());    
                }  
            }     
        }
    }//GEN-LAST:event_SimpanActionPerformed

    private void TambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TambahActionPerformed
        // TODO add your handling code here:
        NIP.requestFocus();        
        NIP.setEnabled(true);   
        Nama.setEnabled(true);  
        Alamat.setEnabled(true);   
        Telp.setEnabled(true); 
        TglLahir.setEnabled(true); 
        Jenkel.setEnabled(true);         
        Tambah.setEnabled(false);         
        Simpan.setEnabled(true);         
        Ubah.setEnabled(false);         
        Batal.setEnabled(true);         
        Hapus.setEnabled(false);         
        Keluar.setEnabled(false);   
    }//GEN-LAST:event_TambahActionPerformed

    private void cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cariActionPerformed
            // TODO add your handling code here:
          Search();
    }//GEN-LAST:event_cariActionPerformed

    private void UbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UbahActionPerformed
        // TODO add your handling code here:
       Object[]options = {"YA","TIDAK"};  
        String Tampilan ="yyyy-MM-dd";
        SimpleDateFormat fm = new SimpleDateFormat(Tampilan);
        String Tanggal =String.valueOf(fm.format(TglLahir.getDate()));
        int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Mengupdate Data??",
                "konfirmasi",JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]); 
        if(konfirmasi==JOptionPane.YES_OPTION){    
            try{             
             stt = (Statement) koneksi.GetConnection().createStatement();              
             SQL="update pegawai set nama ='"+Nama.getText()+
                     "',  alamat ='"+Alamat.getText()+
                     "',  telp ='"+Telp.getText()+
                     "',  tgl_lahir ='"+Tanggal+
                     "', jenkel='"+Jenkel.getSelectedItem()+
                     "' where nip='"+NIP.getText()+"'";   
                stt.executeUpdate(SQL);          
                data[0]=NIP.getText();     
                data[1]=Nama.getText();  
                data[2]=Alamat.getText();     
                data[3]=Telp.getText(); 
                data[4]=Tanggal;     
                data[5]=Jenkel.getSelectedItem().toString();   
                tblModel.removeRow(row);             
                tblModel.insertRow(row, data);     
                normal();                  
                stt.close();                
                con.close();     
            }catch(Exception exc){    
                System.err.println(exc.getMessage());   
            }      
        }    
        normal();
    }//GEN-LAST:event_UbahActionPerformed

    private void HapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HapusActionPerformed
         Object[]options = {"YA","TIDAK"};   
        int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Menghapus Data??",
                "konfirmasi",JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,null,options,options[0]);   
        if(konfirmasi==JOptionPane.YES_OPTION){ 
            try{          
                stt = (Statement) koneksi.GetConnection().createStatement();  
                SQL="delete from pegawai where nip ='"+NIP.getText()+"'";  
                stt.executeUpdate(SQL);     
                tblModel.removeRow(row);       
                normal();               
                stt.close();         
                con.close();     
            }catch(Exception exc){    
                System.err.println(exc.getMessage());       
            }       
        }    
    }//GEN-LAST:event_HapusActionPerformed

    private void BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalActionPerformed
        // TODO add your handling code here:
        normal();    
          NIP.setEnabled(false);    
          NIP.setText("");     
          Nama.setEnabled(false);      
          Nama.setText("");   
          Alamat.setEnabled(false);    
          Alamat.setText("");     
          Telp.setEnabled(false);      
          Telp.setText(""); 
          TglLahir.setEnabled(false);    
          TglLahir.setDate(null);     
          Jenkel.setSelectedItem(false); 
          Jenkel.setSelectedItem(""); 
    }//GEN-LAST:event_BatalActionPerformed

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        // TODO add your handling code her
        Object[]options = {"YA","TIDAK"};    
           int konfirmasi=JOptionPane.showOptionDialog(null,"Apakah Anda Yakin Ingin Keluar?",
                   "konfirmasi",
                   JOptionPane.YES_NO_OPTION,
                   JOptionPane.QUESTION_MESSAGE,
                   null,options,options[0]);         
           if(konfirmasi==JOptionPane.YES_OPTION){ 
//               new Login().setVisible(true);
               dispose();        
           }  
    }//GEN-LAST:event_KeluarActionPerformed

    private void txtcariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcariActionPerformed
        // TODO add your handling code here:
         Search();
    }//GEN-LAST:event_txtcariActionPerformed

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
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pegawai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pegawai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea Alamat;
    private javax.swing.JButton Batal;
    private javax.swing.JButton Hapus;
    private javax.swing.JComboBox Jenkel;
    private javax.swing.JButton Keluar;
    private javax.swing.JTextField NIP;
    private javax.swing.JTextField Nama;
    private javax.swing.JButton Simpan;
    private javax.swing.JTable Tabel;
    private javax.swing.JButton Tambah;
    private javax.swing.JTextField Telp;
    private com.toedter.calendar.JDateChooser TglLahir;
    private javax.swing.JButton Ubah;
    private javax.swing.JButton cari;
    private javax.swing.JButton cetak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
}
