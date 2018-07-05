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
public class Motor {
    public static String baseM(String db,int idmotor, int linha, String sav) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/"+sav+"/"+db+"/motores/"+idmotor+".amm");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
            String lida = br.readLine();
            return lida;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static String getId(String db,int idequipe,  String sav) throws IOException{
        try {
            String lida = Equipe.baseP(db, idequipe, 2, sav);
            return lida;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public static ImageIcon getImagemMotor(String db, int idequipe, String sav){
        try {
            int idmotor = Integer.parseInt(getId(db, idequipe, sav));
            ImageIcon icon = new ImageIcon("C:/automanager/"+sav+"/"+db+"/motores/"+idmotor+".png");
            return icon;
        } catch (IOException ex) {
            Logger.getLogger(Motor.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
