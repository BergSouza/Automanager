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
    public static String getNome(String db,int idpneu, String sav) throws IOException{
        try {
                int linha = 1;
                FileReader fr = new FileReader("c:/automanager/"+sav+"/"+db+"/pneus/"+idpneu+".ampn");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                String pnomep1 = br.readLine();
                return pnomep1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static ImageIcon getImagem(String db, int idpneu, String sav) throws IOException{
        ImageIcon ico = new ImageIcon("c:/automanager/"+sav+"/"+db+"/pneus/"+idpneu+".png");
        return ico;
    }
}
