/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.FDSTelaPneus;

/**
 *
 * @author Bergson
 */
public class FimSemana {
    private static int numerototalpilotos = 0;
    public void guardaPneus(File file) throws IOException{
        int p1 = 1 + (int)(Math.random() * 10);
        int p2 = 1 + (int)(Math.random() * 10);
        while (p1 < 4){
            p1 = 1 + (int)(Math.random() * 10);
        }
        while (p2+p1 > 13 || p2 < 3){
            p2 = 1 + (int)(Math.random() * 10);
        }
        int p3 = 13-p1-p2;
        if(p3 == 0){
            p3++;
            p2--;
        }
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Integer.toString(p1));
        bw.newLine();
        bw.write(Integer.toString(p2));
        bw.newLine();
        bw.write(Integer.toString(p3));
        bw.newLine();
        bw.close();
    }
    
    public static void guardaRelacao(String db , String save,String idcorrida, int idpiloto) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus/"+idpiloto+".db");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus/"+idpiloto+".db");
            BufferedWriter bw = new BufferedWriter(fw);
            int a = Integer.parseInt(br.readLine());
            for (int i = 0; i < a; i++) {
                bw.write(Corrida.getPneu1(db, idcorrida, save));
                bw.newLine();
            }
            int b = Integer.parseInt(br.readLine());
            for (int i = 0; i < b; i++) {
                bw.write(Corrida.getPneu2(db, idcorrida, save));
                bw.newLine();
            }
            int c = Integer.parseInt(br.readLine());
            for (int i = 0; i < c; i++) {
                bw.write(Corrida.getPneu3(db, idcorrida, save));
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FimSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String retornaRelacao(String save,int idpiloto, int numpneusequencia) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/"+save+"/temp/fimdesemana/relacaopneus/"+idpiloto+".db");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < numpneusequencia-1; i++) {
                br.readLine();
            }
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FimSemana.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void guardaDesgaste(String db , String save,String idcorrida, int idpiloto, int desgaste) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus/"+idpiloto+".db");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("C:/automanager/"+save+"/"+db+"/fimdesemana/desgastepneus/"+idpiloto+".db");
            BufferedWriter bw = new BufferedWriter(fw);
            int a = (int) br.lines().count();
            for (int i = 0; i < a; i++) {
                bw.write(Integer.toString(desgaste));
                bw.newLine();
            }
            bw.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FimSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String retornaDesgaste(String save,int idpiloto, int numpneusequencia) throws IOException{
        try {
            FileReader fr = new FileReader("C:/automanager/"+save+"/temp/fimdesemana/desgastepneus/"+idpiloto+".db");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i < numpneusequencia-1; i++) {
                br.readLine();
            }
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FimSemana.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public static void escolhePneu(String save, int idpiloto, int numpneusequencia) throws IOException{
        File file = new File("C:/automanager/"+save+"/temp/fimdesemana/escolhapneus");
        if(file.exists()){
            
        }else{
            file.mkdir();
        }
        FileWriter fw = new FileWriter(file+"/"+idpiloto+".db");
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(Integer.toString(numpneusequencia));
        bw.close();
    }
    
    public static int retornapneuescolhido(String save, int idpiloto) throws FileNotFoundException, IOException{
        File file = new File("C:/automanager/"+save+"/temp/fimdesemana/escolhapneus/"+idpiloto+".db");
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        return Integer.parseInt(br.readLine());
    }
    
    public void salvaPneus(String db,int equipe,String save,int quantidade_p11,int quantidade_p21,int quantidade_p31,int quantidade_p12,int quantidade_p22,int quantidade_p32, String idcorrida) throws IOException{
        int p1 = Equipe.getIdP1(db, equipe, save);
        int p2 = Equipe.getIdP2(db, equipe, save);
        
        FileReader fr = new FileReader("C:/automanager/"+save+"/temp/dbinfo.amdi");
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        br.readLine();
        int a = Integer.parseInt(br.readLine());
        //JOptionPane.showMessageDialog(null, a);
        for (int i = 1; i < a+1; i++) {
            if(i == p1){
                File file = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus/"+i+".db");
                File file2 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus/"+i+".db");
                File file3 = new File("C:/automanager/"+save+"/"+db+"fimdesemana/desgastepneus/"+i+".db");
                File diretorio = new File("C:/automanager/"+save+"/"+db+"/fimdesemana");
                File diretorio2 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus");
                File diretorio3 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus");
                File diretorio4 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/desgastepneus");
                if(diretorio.exists()){
                    
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p11));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p21));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p31));
                    bw.close();
                }else{
                    diretorio.mkdir();
                    diretorio2.mkdir();
                    diretorio3.mkdir();
                    
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p11));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p21));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p31));
                    bw.close();
                    
                }
                if(diretorio3.exists()){
                    
                }else{
                    diretorio3.mkdir();
                }
                if(file3.exists()){
                    
                }else{
                    diretorio4.mkdir();
                }
            }else if(i == p2){
                File file = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus/"+i+".db");
                File file2 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus/"+i+".db");
                File file3 = new File("C:/automanager/"+save+"/"+db+"fimdesemana/desgastepneus/"+i+".db");
                File diretorio = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/");
                File diretorio2 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus");
                File diretorio3 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus");
                File diretorio4 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/desgastepneus");
                if(file.exists()){
                    
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p12));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p22));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p32));
                    bw.close();
                }else{
                    diretorio.mkdir();
                    diretorio2.mkdir();
                    
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p21));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p22));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p32));
                    bw.close();
                    
                }if(file2.exists()){
                    
                }else{
                    diretorio3.mkdir();
                }
                if(file3.exists()){
                    
                }else{
                    diretorio4.mkdir();
                }
            }else{
                File diretorio = new File("C:/automanager/"+save+"/"+db+"/fimdesemana");
                File diretorio2 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus");
                File diretorio3 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus");
                File diretorio4 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/desgastepneus");
                File file = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/pneus/"+i+".db");
                File file2 = new File("C:/automanager/"+save+"/"+db+"/fimdesemana/relacaopneus/"+i+".db");
                File file3 = new File("C:/automanager/"+save+"/"+db+"fimdesemana/desgastepneus/"+i+".db");
                if(file.exists()){
                    
                }else{
                    diretorio.mkdir();
                    diretorio2.mkdir();
                }
                if(file2.exists()){
                    
                }else{
                    diretorio3.mkdir();
                }
                if(file3.exists()){
                    
                }else{
                    diretorio4.mkdir();
                }
                guardaPneus(file);
                
            }
            guardaRelacao(db, save, idcorrida, i);
            guardaDesgaste(db, save, idcorrida, i, 100);
            escolhePneu(save, i, 1);
        }
        FDSTelaPneus tela = new FDSTelaPneus();
        tela.recebedados(db, equipe, idcorrida, save);
        tela.mousedrag(tela);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }
    
     public static void salvatempo(String db , String save , int idpiloto, int minuto, int segundo, int milesimo) throws IOException{
        
            File file = new File("C:/automanager/"+save+"/"+db+"/melhortempotreino/");
            if(file.exists()){
                
            }else{
                file.mkdir();
            }
            FileWriter fw = new FileWriter("C:/automanager/"+save+"/"+db+"/melhortempotreino/"+idpiloto+".db");
            BufferedWriter bw = new BufferedWriter(fw);
            FileReader fr = new FileReader("C:/automanager/"+save+"/"+db+"/melhortempotreino/"+idpiloto+".db");
            BufferedReader br = new BufferedReader(fr);
            String minutolido = br.readLine();
            String segundolido = br.readLine();
            String milesimolido = br.readLine();
            int ml = Integer.parseInt(minutolido);
            int sl = Integer.parseInt(segundolido);
            int mi = Integer.parseInt(milesimolido);
            if(minuto > ml && segundo > sl && milesimo > mi){
                bw.write(minutolido);
                bw.newLine();
                bw.write(segundolido);
                bw.newLine();
                bw.write(milesimolido);
                bw.newLine();
                bw.close();
            }
            if(ml == 0 && sl == 0 && mi == 0){
                bw.write(minutolido);
                bw.newLine();
                bw.write(segundolido);
                bw.newLine();
                bw.write(milesimolido);
                bw.newLine();
                bw.close();
            }
            
    }
    
    public static int pegapneusfimsemana(int idpiloto, int pneu, String save) throws FileNotFoundException, IOException{
        
            FileReader frr = new FileReader("C:/automanager/"+save+"/temp/fimdesemana/pneus/"+idpiloto+".db");
            BufferedReader brr = new BufferedReader(frr);
            for (int i = 0; i < pneu-1; i++) {
            brr.readLine();
        }
            return Integer.parseInt(brr.readLine());
        
    }
}
