/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import static classes.Equipe.baseP;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import view.Novojogo;

/**
 *
 * @author Bergson
 */
public class Piloto {
    public static String baseP2(String db,int idpiloto, String sav, int linha) throws IOException{
        try {
                FileReader fr = new FileReader("c:/automanager/"+sav+"/"+db+"/pilotos/"+idpiloto+".amp");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                String pnomep1 = br.readLine();
                char[] pnomechar = pnomep1.toCharArray();
                return pnomechar[0]+". ";
            } catch (FileNotFoundException ex) {
                return null;
            }
    }
    public static String baseP(String db,int idpiloto, String sav, int linha) throws IOException{
        try {
                FileReader fr = new FileReader("c:/automanager/"+sav+"/"+db+"/pilotos/"+idpiloto+".amp");
                BufferedReader br = new BufferedReader(fr);
                for (int i = 0; i < linha-1; i++) {
                br.readLine();
            }
                String pnomep1 = br.readLine();
                return pnomep1;
            } catch (FileNotFoundException ex) {
                return null;
            }
    }
    public static int getIDEquipe(String db,int idpiloto, String sav) throws IOException{
            
            int linha = 9;
            int c = 0;
            int aa = 0;
            for (int i = 1; i <= FuncoesGerais.totalequipes(sav); i++) {
                int o = Equipe.getIdP1(db, i, sav);
                int p = Equipe.getIdP2(db, i, sav);
                if(idpiloto == o || idpiloto == p){
                    aa = i;
                }
            }
            return aa;   
    }
    public static String getLetraNome(String db,int idpiloto, String sav) throws IOException{
        return baseP2(db, idpiloto, sav, 1);
    }
    public static String getLetraSobrenome(String db,int idpiloto, String sav) throws IOException{
        return baseP2(db, idpiloto, sav, 2);
    }
    public static String getNome(String db,int idpiloto, String sav) throws IOException{
        return baseP(db, idpiloto, sav, 1);
    }
    public static String getSobrenome(String db,int idpiloto, String sav) throws IOException{
        return baseP(db, idpiloto, sav, 2);
    }
    
    public static ImageIcon getImagem(String db, int idpiloto, String sav) throws IOException{
        ImageIcon ico = new ImageIcon("c:/automanager/"+sav+"/"+db+"/pilotos/"+idpiloto+".png");
        return ico;
    }
    
    public void baseInsere(String db, int idpiloto, String sav, int linha, String novovalor) throws FileNotFoundException, IOException{
        File fileaux = new File("C:/automanager/"+sav+"/"+db+"/pilotos/aux.amp");
        FileReader fr = new FileReader("C:/automanager/"+sav+"/"+db+"/pilotos/"+idpiloto+".amp");
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("C:/automanager/"+sav+"/"+db+"/pilotos/"+idpiloto+".amp");
        BufferedWriter bw = new BufferedWriter(fw);
        FileWriter fwa = new FileWriter("C:/automanager/"+sav+"/"+db+"/pilotos/aux.amp");
        BufferedWriter bwa = new BufferedWriter(fw);
        FileReader fra = new FileReader("C:/automanager/"+sav+"/"+db+"/pilotos/aux.amp");
        BufferedReader bra = new BufferedReader(fr);
        /*if(fileaux.exists()){
            
        }else{
            fileaux.mkdir();
        }*/
        for (int i = 0; i < 21; i++) {
            bwa.write(br.readLine());
            bwa.newLine();
        }
        for (int i = 1; i < 22; i++){
            if(i == linha){
                bw.write(novovalor);
                br.readLine();
            }else{
                bw.write(br.readLine());
            }
        }
        bw.close();
        bwa.close();
    }
    
    public static int getConcentracao(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto, sav, 10));
    }
    public void setConcentracao(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 10, novovalor);
    }
    public static int getResistencia(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto, sav, 11));
    }
    public void setResistencia(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 11, novovalor);
    }
    public static int getAgressividade(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto, sav,  12));
    }
    public void setAgressividade(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 12, novovalor);
    }
    public static int getUltrapassagem(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 13));
    }
    public void setUltrapassagem(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 13, novovalor);
    }
    public static int getVelocidade(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 14));
    }
    public void setVelocidade(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 14, novovalor);
    }
    public static int getConstancia(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 15));
    }
    public void setConstancia(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 15, novovalor);
    }
    public static int getExperiencia(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 16));
    }
    public void setExperiencia(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 16, novovalor);
    }
    public static int getLargada(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 17));
    }
    public void setLargada(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 17, novovalor);
    }
    public static int getAcerto(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 18));
    }
    public void setAcerto(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 18, novovalor);
    }
    public static int getFisico(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto,sav, 19));
    }
    public void setFisico(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 19, novovalor);
    }
    public static int getChuva(String db, int idpiloto, String sav) throws IOException{
        return Integer.parseInt(baseP(db, idpiloto, sav, 20));
    }
    public void setChuva(String db, int idpiloto, String sav, String novovalor) throws IOException{
        baseInsere(db, idpiloto, sav, 20, novovalor);
    }
}
