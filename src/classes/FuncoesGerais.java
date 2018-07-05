/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Principal;

/**
 *
 * @author Bergson
 */
public class FuncoesGerais {
    public String retornalinha(String arquivo, int linha) throws IOException{
        try {
            FileReader fr = new FileReader(arquivo);
            BufferedReader br = new BufferedReader(fr);
            int a = linha;
            for (int i = 0; i < a-1; i++) {
                br.readLine();
            }
            return br.readLine();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FuncoesGerais.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    public void carregajogo(String save) throws IOException{
        String arquivo = ("C:/automanager/saves/"+save+"/save.ams");
        File file = new File(arquivo);
        if(file.exists()){
            int idequipe = Integer.parseInt(retornalinha(arquivo, 1));
            String nome = retornalinha(arquivo, 2);
            String sexo = retornalinha(arquivo, 3);
            String db = retornalinha(arquivo, 4);
            Principal p = new Principal();
            p.recebedados(nome, sexo, save, idequipe, "saves");
            p.setVisible(true);
            p.setLocationRelativeTo(null);
            p.mousedrag(p);
        }
    }
}
