/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.JOptionPane;
/**
 *
 * @author arilc
 */
public class Fahril_IO_JOptionPane {
    public static void main(String[] args){
      String nama, kelas, umur;
      nama = JOptionPane.showInputDialog("Nama Saya : ");
      kelas = JOptionPane.showInputDialog("Kelas : ");
      umur = JOptionPane.showInputDialog("Umur : ");
      JOptionPane.showMessageDialog(null,String.format("Nama Saya : %s, Kelas : %s, Umur : %s",nama,kelas,umur));
    }
}
