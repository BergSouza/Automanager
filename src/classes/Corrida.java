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
    public static String baseP(String db, String numerocorrida, int linha, String sav) throws IOException{
        //"+sav+"/"+db+"o \/
        //"+sav+"/"+db+"
        try {
            FileReader fr = new FileReader("C:/automanager/"+sav+"/"+db+"/corridas/"+numerocorrida+".amc");
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
    public static ImageIcon getBandeira(String db, String numerocorrida, String sav){
        ImageIcon icon = new ImageIcon("C:/automanager/"+sav+"/"+db+"/corridas/"+numerocorrida+".png");
        return icon;
    }
    public static String getPais(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 1, sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getPista(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 2, sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getVoltas(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 3,sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getCurvasPorc(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 4,sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getPneu1(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 5,sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getPneu2(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 6,sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getPneu3(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 7,sav);
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getDistancia(String db, String numerocorrida, String sav){
        try {
            return baseP(db, numerocorrida, 8,sav)+" km";
        } catch (IOException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public static String getTotalCorridas(String db, String sav) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/"+sav+"/"+db+"/corridas/cinfo.amdb");
            BufferedReader br = new BufferedReader(fr);
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Corrida.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
}
