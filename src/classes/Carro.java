/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static classes.Pneu.baseP;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Novojogo;

/**
 *
 * @author Bergson
 */
public class Carro {
    public static String baseP(String db, int idequipe, String sav, int linha) throws IOException{
        try {
                FileReader fr = new FileReader("c:/automanager/"+sav+"/"+db+"/carros/"+idequipe+".amc");
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
    public static int getModelo(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 1));
    }
    public static int getAerodinamica(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 2));
    }
    public static int getSuspensao(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 3));
    }
    public static int getRefrigeracao(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 4));
    }
    public static int getDesgastePneu(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 5));
    }
    public static int getDirecao(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 6));
    }
    public static int getFreio(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 7));
    }
    public static int getConfiabilidade(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 8));
    }
    public static int getSistemaEletrico(String db,int idequipe, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idequipe, sav, 9));
    }
}
