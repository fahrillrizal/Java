/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author arilc
 */
public class Fahril_IO_Scanner {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a, t; 
        float x;
        System.out.print("Pembuat Program: ");
        String nama = input.nextLine();
        System.out.print("Masukkan Panjang Alas: ");
        a = input.nextInt();
        System.out.print("Masukkan Tinggi: ");
        t = input.nextInt();
        x = (a*t)/2;
        System.out.println("Luas Segitiga = "+x);
    }
}
