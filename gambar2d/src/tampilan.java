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
public class tampilan extends JFrame {
    Dimension dimensi = Toolkit.getDefaultToolkit().getScreenSize();
    private Container konten = getContentPane();
    private gambar datar = new gambar();
    
    public tampilan() {
        super("Logo Android");
        setVisible(true);
        setSize(720,550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        this.setLocationRelativeTo(null);
        konten.add(datar);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        }catch (UnsupportedLookAndFeelException e)
        {
        }
        catch(ClassNotFoundException e)
        {
        }
        catch(InstantiationException e)
        {
        }
        catch(IllegalAccessException e)
        {
        }
        new tampilan();
        }
}
