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
    
    public void salvaPneus(String db,int equipe,String save,int quantidade_p11,int quantidade_p21,int quantidade_p31,int quantidade_p12,int quantidade_p22,int quantidade_p32, String idcorrida) throws IOException{
        int p1 = Equipe.getIdP1(db, equipe, save);
        int p2 = Equipe.getIdP2(db, equipe, save);
        
        FileReader fr = new FileReader("C:/automanager/db/temp/dbinfo.amdi");
        BufferedReader br = new BufferedReader(fr);
        br.readLine();
        br.readLine();
        int a = Integer.parseInt(br.readLine());
        //JOptionPane.showMessageDialog(null, a);
        for (int i = 1; i < a+1; i++) {
            if(i == p1){
                File file = new File("C:/automanager/db/"+db+"/fimdesemana/pneus/"+i+".db");
                File diretorio = new File("C:/automanager/db/"+db+"/fimdesemana");
                File diretorio2 = new File("C:/automanager/db/"+db+"/fimdesemana/pneus");
                if(diretorio.exists()){
                    diretorio.mkdir();
                    diretorio2.mkdir();
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p11));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p21));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p31));
                    bw.close();
                }else{
                    
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p11));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p21));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p31));
                    bw.close();
                }
            }else if(i == p2){
                File file = new File("C:/automanager/db/"+db+"/fimdesemana/pneus/"+i+".db");
                File diretorio = new File("C:/automanager/db/"+db+"/fimdesemana/");
                File diretorio2 = new File("C:/automanager/db/"+db+"/fimdesemana/pneus");
                if(file.exists()){
                    diretorio.mkdir();
                    diretorio2.mkdir();
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p12));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p22));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p32));
                    bw.close();
                }else{
                    FileWriter fw = new FileWriter(file);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write(Integer.toString(quantidade_p21));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p22));
                    bw.newLine();
                    bw.write(Integer.toString(quantidade_p32));
                    bw.close();
                }
            }else{
                File diretorio = new File("C:/automanager/db/"+db+"/fimdesemana");
                File diretorio2 = new File("C:/automanager/db/"+db+"/fimdesemana/pneus");
                File file = new File("C:/automanager/db/"+db+"/fimdesemana/pneus/"+i+".db");
                if(file.exists()){
                    
                    guardaPneus(file);
                }else{
                    diretorio.mkdir();
                    diretorio2.mkdir();
                    guardaPneus(file);
                }
            }
        }
        FDSTelaPneus tela = new FDSTelaPneus();
        tela.recebedados(db, equipe, idcorrida);
        tela.mousedrag(tela);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }
    public static int pegapneusfimsemana(int idpiloto, int pneu) throws FileNotFoundException, IOException{
        
            FileReader frr = new FileReader("C:/automanager/db/temp/fimdesemana/pneus/"+idpiloto+".db");
            BufferedReader brr = new BufferedReader(frr);
            for (int i = 0; i < pneu-1; i++) {
            brr.readLine();
        }
            return Integer.parseInt(brr.readLine());
        
    }
}
