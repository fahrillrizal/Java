/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author arilc
 */
public class gambar extends Canvas{
    public void paint (Graphics g){
        setBackground(Color.black);
        g.setColor(Color.GREEN);
            g.fillOval(220, 50, 220, 200); //kepala
            g.fillRect(220, 135, 220, 200); //badan
            g.fillRect(235, 335, 190, 15); //badan bawah
            g.fillOval(220, 320, 30, 30); //samping bawah1
            g.fillOval(410, 320, 30, 30); //samping bawah2
            g.fillRect(260, 340, 50, 70); //kakikiri
            g.fillRect(350, 340, 50, 70); //kakikanan
            g.fillOval(260, 390, 50, 50);//telapakkiri
            g.fillOval(350, 390, 50, 50);//telapakkanan
            g.fillRect(165, 180, 50, 80); //tangankiri
            g.fillRect(445, 180, 50, 80); //tangankanan
            g.fillOval(165, 155, 50, 50); //pundakkiri
            g.fillOval(445, 155, 50, 50); //pundakkanan
            g.fillOval(166, 240, 50, 50); //telapak tangankiri
            g.fillOval(445, 240, 50, 50); //telapak tangankanan
            g.fillOval(230, 35, 30, 50); //telingakiri
            g.fillOval(399, 35, 30, 50); //telingakanan
        g.setColor(Color.WHITE);
            g.fillRect(220, 140, 220, 10); //leher
            g.fillOval(270, 90, 25, 25); //matakanan
            g.fillOval(365, 90, 25, 25); //matakiri
        g.setColor(Color.GREEN);
            g.fillOval(275, 95, 15, 15); //bolamatakanan
            g.fillOval(370, 95, 15, 15); //bolamatakiri
        g.setColor(Color.BLACK);
            g.drawString("Nama: Mochammad Fahril Rizal", 10, 450);
            g.drawString("No:14", 10, 465);
            g.drawString("Kelas: XII RPL 2", 10, 480);
        g.setColor(Color.GRAY);
            g.fillRect(145, 280, 40, 6);//tiang
        g.setColor(Color.YELLOW);
            g.fillOval(140, 278, 10, 10);//pucuk tiang
        g.setColor(Color.RED);
            g.fillRect(148, 286, 8, 25);//bendera atas
        g.setColor(Color.WHITE);
            g.fillRect(155, 286, 8, 25);//bendera bawah
            
        }
}
