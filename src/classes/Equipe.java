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
public class Equipe {    
    public static String baseP(String db, int idequipe, int b) throws IOException{
        FileReader frp;
        try {
            frp = new FileReader("C:/automanager/db/"+db+"/equipes/"+idequipe+".amt");
            BufferedReader brp = new BufferedReader(frp);
            for (int i = 1; i < b; i++) {
                brp.readLine();
            }
            String d = brp.readLine();
            return d;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Equipe.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static ImageIcon getImagem(String db, int idequipe){
        ImageIcon icon = new ImageIcon("c:/automanager/db/"+db+"/equipes/"+idequipe+".png");
        return icon;
    }
    public static ImageIcon getImagemP1(String db, int idequipe) throws IOException{
        String d = baseP(db, idequipe, 9);
        ImageIcon ico = new ImageIcon("c:/automanager/db/"+db+"/pilotos/"+d+".png");
        return ico;
    }
    public static ImageIcon getImagemP2(String db, int idequipe) throws IOException{
        String d = baseP(db, idequipe, 10);
        ImageIcon ico = new ImageIcon("c:/automanager/db/"+db+"/pilotos/"+d+".png");
        return ico;
    }
    public static ImageIcon getImagemPA1(String db, int idequipe) throws IOException{
        String d = baseP(db, idequipe, 11);
        ImageIcon ico = new ImageIcon("c:/automanager/db/"+db+"/patrocinios/"+d+".png");
        return ico;
    }
     public static ImageIcon getImagemPA2(String db, int idequipe) throws IOException{
        String d = baseP(db, idequipe, 12);
        ImageIcon ico = new ImageIcon("c:/automanager/db/"+db+"/patrocinios/"+d+".png");
        return ico;
    }
    public static ImageIcon getImagemPA3(String db, int idequipe) throws IOException{
        String d = baseP(db, idequipe, 13);
        ImageIcon ico = new ImageIcon("c:/automanager/db/"+db+"/patrocinios/"+d+".png");
        return ico;
    }
    public static String getP1(String db, int idequipe, int linha) throws IOException{
        String d = baseP(db, idequipe, linha);
        try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/pilotos/"+d+".amp");
                BufferedReader br = new BufferedReader(fr);
                String pnomep1 = br.readLine();
                char[] pn1 = pnomep1.toCharArray();
                String nomep1 = pn1[0]+". "+br.readLine();
                return nomep1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static String getP2(String db, int idequipe, int linha) throws IOException{
        String d = baseP(db, idequipe, linha);
        try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/pilotos/"+d+".amp");
                BufferedReader br = new BufferedReader(fr);
                String pnomep1 = br.readLine();
                char[] pn1 = pnomep1.toCharArray();
                String nomep1 = pn1[0]+". "+br.readLine();
                return nomep1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static String getPA1(String db, int idequipe, int linha) throws IOException{
        String d = baseP(db, idequipe, 11);
        try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/patrocinios/"+d+".ampa");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                String nomepa1 = br.readLine();
                return nomepa1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static String getPA2(String db, int idequipe, int linha) throws IOException{
        String d = baseP(db, idequipe, 12);
        try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/patrocinios/"+d+".ampa");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                String nomepa1 = br.readLine();
                return nomepa1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static String getPA3(String db, int idequipe, int linha) throws IOException{
        String d = baseP(db, idequipe, 13);
        try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/patrocinios/"+d+".ampa");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                String nomepa1 = br.readLine();
                return nomepa1;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
    }
    public static String getCor1(String db, int idequipe) throws IOException{
        String d = "#"+baseP(db, idequipe, 14);
        if(d.equals("#ffffff") || d.equals("#eeeeee") || d.equals("#dddddd")){
            d = getCor2(db, idequipe);
            }
        return d;
    }  public static String getCor2(String db, int idequipe) throws IOException{
        String d = "#"+baseP(db, idequipe, 15);
        return d;
    }
     
    
}
