/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread_fahril;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author arilc
 */
public class Thread_fahril {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread_fahril tf = new Thread_fahril();
        String[] no = {"01", "05", "09", "14", "20", "22"};
        String[] nama = {"Rizal", "Aji", "Dimas", "Fahril", "Wildan", "Alwi"};
        String kelas = "XII RPL 2";
        
        tf.pSatu(no, nama, kelas);
    }
    void pSatu(String[]no, String[] nama, String kelas){
        Thread t = new Thread(){
            public void run(){
                int a = 4;
                try{
                    for(int i=0; i<=a; i++){
                        System.out.println("Nomor "+(i+1));
                        System.out.println("====================");
                        System.out.println("No \t: "+no[i]);
                        System.out.println("Nama \t: "+nama[i]);
                        System.out.println("Kelas \t: "+kelas);
                        sleep(1000);
                    }
                }catch (InterruptedException ex){
                    Logger.getLogger(Thread_fahril.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        t.start();
    }
}
