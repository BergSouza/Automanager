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
import view.Novojogo;

/**
 *
 * @author Bergson
 */
public class Pneu {
    public static String baseP(String db, int idpneu, String sav, int linha) throws IOException{
        try {
                FileReader fr = new FileReader("c:/automanager/"+sav+"/"+db+"/pneus/"+idpneu+".ampn");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                return br.readLine();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static String getNome(String db,int idpneu, String sav) throws IOException{
        return baseP(db, idpneu, sav, 1);
    }
    public static String getVelocidade(String db,int idpneu, String sav) throws IOException{
        return baseP(db, idpneu, sav, 2);
    }
    public static int getAderencia(String db,int idpneu, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpneu, sav, 3));
    }
    public static int getDesgaste(String db,int idpneu, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpneu, sav, 4));
    }
    public static ImageIcon getImagem(String db, int idpneu, String sav) throws IOException{
        ImageIcon ico = new ImageIcon("c:/automanager/"+sav+"/"+db+"/pneus/"+idpneu+".png");
        return ico;
    }
    public static ImageIcon getImagem3(String db, int idpneu, String sav) throws IOException{
        ImageIcon ico = new ImageIcon("c:/automanager/"+sav+"/"+db+"/pneus/"+idpneu+"_3.png");
        return ico;
    }
}
