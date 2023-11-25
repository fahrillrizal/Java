/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package OpFile;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
/**
 *
 * @author arilc
 */
public class Fahril_OpFile {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir")+"\\src\\OpFile\\siswa.txt");
        Scanner sc = new Scanner(file);
        sc.useDelimiter("\\z");
        System.out.println(sc.next());
    }
}
