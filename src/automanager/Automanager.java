/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automanager;

import view.Inicio;
/**
 *
 * @author Bergson
 */
public class Automanager {

    public static String getVersao(){
        String versao = "Pre-Alpha 0.0.1"; 
        return versao;
    }
   
   
    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
    }
    
}
