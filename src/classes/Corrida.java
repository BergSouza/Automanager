/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Bergson
 */
public class Corrida {
    public static String baseP(String db, String numerocorrida, int linha) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/db/"+db+"/corridas/"+numerocorrida+".amc");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static ImageIcon getBandeira(String db, String numerocorrida){
        ImageIcon icon = new ImageIcon("C:/automanager/db/"+db+"/corridas/"+numerocorrida+".png");
        return icon;
    }
    public static String getTotalCorridas(String db) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/db/"+db+"/corridas/cinfo.amdb");
            BufferedReader br = new BufferedReader(fr);
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
