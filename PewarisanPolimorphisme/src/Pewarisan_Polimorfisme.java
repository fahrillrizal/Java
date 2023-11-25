/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pewarisan_polimorfisme;

import com.kalkulator.Kalkulator;

/**
 *
 * @author arilc
 */
public class Pewarisan_Polimorfisme {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        public class main {
public static void main (String [ ] args){
System.out.println("HONDA");
honda h = new honda();
h.tampilkan();
System.out.println("TOYOTA");
toyota t = new toyota();
t.tampilkan();
    }
    public class sedan {
private String merek;
private String warna;
private int jumlahpintu;
private String jenis;
public String getJenis() {
return jenis;
}
public void setJenis(String jenis) {
this.jenis = jenis;
}
public int getJumlahpintu() {
return jumlahpintu;
}
public void setJumlahpintu(int jumlahpintu) {
this.jumlahpintu = jumlahpintu;
}
public String getMerek() {
return merek;
}
public void setMerek(String merek) {
this.merek = merek;
public String getWarna() {
return warna;
}
public void setWarna(String warna) {
this.warna = warna;
}
public void tampilkandata(){
System.out.println("merek sedan" +getMerek());
System.out.println("warna sedan" +getWarna());
System.out.println("total pintu" +getJumlahpintu());
System.out.println("jenis sedan" +getJenis());
}
public void inputData(String m,String w,String j,int jp){
setMerek(m);
setWarna(w);
setJenis(j);
setJumlahpintu(jp);
}
public class honda extends sedan {
public void tampilkan(){
double besarsilinder = 5.5;
String bahanbakar ="Pertamax";
String kategori ="Sport";;
sedan s = new sedan();
s.inputData("CRV", "Hitam", "Mewah", 4);
s.tampilkandata();
System.out.println("silinder" +besarsilinder);
System.out.println("jenis bahan bakar" +bahanbakar);
System.out.println("jenis kategori" +kategori);
}
public class toyota extends sedan {
public void tampilkan(){
double besarsilinder;
String bahanbakar;
String kategori;
besarsilinder = 32.5;
bahanbakar = "solar";
kategori ="off-road";
sedan s = new sedan();
s.inputData("AVANZA","Merah","Ekonomis", 5);
s.tampilkandata();
System.out.println("silinder"+besarsilinder);
System.out.println("jenis bahan bakar" +bahanbakar);
System.out.println("jenis kategori" +kategori);
}
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


