/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collection;

/**
 *
 * @author fahril
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Collection {

    /**
     * @param args the command line arguments
     */
    
    public static class Siswa{
        public String nis;
        public String nama;
        public String kelas;
        public String agama;
    }

    public static void main(String[] args) {
        Siswa siswa_1 = new Siswa();
        siswa_1.nis = "1234";
        siswa_1.nama = "Fahril";
        siswa_1.kelas = "XII RPL 2";
        siswa_1.agama = "Islam";

        Siswa siswa_2 = new Siswa();
        siswa_2.nis = "1235";
        siswa_2.nama = "Aji";
        siswa_2.kelas = "XII RPL 2";
        siswa_2.agama = "Islam";

        Siswa siswa_3 = new Siswa();
        siswa_3.nis = "1236";
        siswa_3.nama = "Rizal";
        siswa_3.kelas = "XII RPL 2";
        siswa_3.agama = "Islam";
        
        Siswa siswa_4 = new Siswa();
        siswa_4.nis = "1237";
        siswa_4.nama = "Taufiq";
        siswa_4.kelas = "XII RPL 2";
        siswa_4.agama = "Islam";
        
        List<Siswa> list = new ArrayList<Siswa>();
        list.add(siswa_4);
        list.add(siswa_2);
        list.add(siswa_3);
        list.add(siswa_1);
            
        for(Iterator iterator = list.iterator();iterator.hasNext();){
            System.out.println("\t====================");
            Siswa siswa = (Siswa)iterator.next();
            System.out.println("\tNIS   = " +siswa.nis);
            System.out.println("\tNama  = " +siswa.nama);
            System.out.println("\tKelas = " +siswa.kelas);
            System.out.println("\tAgama = " +siswa.agama);
        }    
    }
}

