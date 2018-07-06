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
    public static String baseP(String db, int idequipe, int b, String sav) throws IOException{
        FileReader frp;
        //sav = "temp";
        String bo = null;
        bo = sav+"/"+db;
        
        //"+sav+"/"+db+" \/
        //"+sav+"/"+db+"
        try {
            frp = new FileReader("C:/automanager/"+bo+"/equipes/"+idequipe+".amt");
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
    public static String getCaixa(String db, int idequipe, String sav) throws IOException{
        String d = baseP(db, idequipe, 6,sav);
        d = "R$: "+d;
        return d;
    }
    
    public static ImageIcon getImagem(String db, int idequipe, String sav){
        ImageIcon icon = new ImageIcon("c:/automanager/"+sav+"/"+db+"/equipes/"+idequipe+".png");
        return icon;
    }
    public static int getIdP1(String db, int idequipe, String sav) throws IOException{
        String d = baseP(db, idequipe, 9,sav);
        int e = Integer.parseInt(d);
        return e;
    }
    public static int getIdP2(String db, int idequipe, String sav) throws IOException{
        String d = baseP(db, idequipe, 10, sav);
        int e = Integer.parseInt(d);
        return e;
    }
    public static int getIdPA1(String db, int idequipe,  String sav) throws IOException{
        String d = baseP(db, idequipe, 11, sav);
        int e = Integer.parseInt(d);
        return e;
    }
    public static int getIdPA2(String db, int idequipe,  String sav) throws IOException{
        String d = baseP(db, idequipe, 12, sav);
        int e = Integer.parseInt(d);
        return e;
    }
    public static int getIdPA3(String db, int idequipe,  String sav) throws IOException{
        String d = baseP(db, idequipe, 13, sav);
        int e = Integer.parseInt(d);
        return e;
    }
    public static String getCor1(String db, int idequipe, String sav) throws IOException{
        String d = "#"+baseP(db, idequipe, 14, sav);
        if(d.equals("#ffffff") || d.equals("#eeeeee") || d.equals("#dddddd")){
            d = getCor2(db, idequipe, sav);
            }
        return d;
    }  public static String getCor2(String db, int idequipe, String sav) throws IOException{
        String d = "#"+baseP(db, idequipe, 15, sav);
        return d;
    }
     
    
}
