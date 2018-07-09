/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Bergson
 */
public class IA {
    private static int segundovoltaa = 0;
    private static int minutovoltaa = 0;
    private static int milesimovoltaa = 0;
    
    public void selecionacomposto(String db, String idcorrida) throws IOException{
        String save = "temp";
        int totalpilotos = FuncoesGerais.totalpilotos(save);
        int pneu1 = Integer.parseInt(Corrida.getPneu1(save, idcorrida, save));
        int pneu2 = Integer.parseInt(Corrida.getPneu1(save, idcorrida, save));
        int pneu3 = Integer.parseInt(Corrida.getPneu1(save, idcorrida, save));
        
        int p1 = Equipe.getIdP1(db, Equipe.getID(db, save), save);
        int p2 = Equipe.getIdP2(db, Equipe.getID(db, save), save);
        
        for (int i = 1; i <= totalpilotos; i++) {
            if(i == p1 || i == p2){
                
            }else{
                int selecionapneu = (1 + (int)(Math.random() * 100)/20);
                while(selecionapneu > 13){
                    selecionapneu = 1 + (int)(Math.random() * 100);
                }
                FimSemana.escolhePneu("temp", i, 0);
            }
        }
    }
    public static String fazvolta(String db, String numerocorrida, String sav, int idpiloto) throws IOException{
        int minutobase = Integer.parseInt(Corrida.getMinuto(db, numerocorrida, sav));
        int segundobase = Integer.parseInt(Corrida.getSegundo(db, numerocorrida, sav));
        int milesimobase = Integer.parseInt(Corrida.getMilesimo(db, numerocorrida, sav));
        
        int minutovolta = minutobase;
        int segundovolta = segundobase;
        int milesimovolta = milesimobase;
        
        int idequipe = Piloto.getIDEquipe(db, idpiloto, sav);
        
        int concentracao = Piloto.getConcentracao(db, idpiloto, sav);
        int resistencia = Piloto.getResistencia(db, idpiloto, sav);
        int agressividade = Piloto.getAgressividade(db, idpiloto, sav);
        int ultrapasagem = Piloto.getUltrapassagem(db, idpiloto, sav);
        int velocidade = Piloto.getVelocidade(db, idpiloto, sav);
        int constancia = Piloto.getConstancia(db, idpiloto, sav);
        int experiencia = Piloto.getExperiencia(db, idpiloto, sav);
        int largada = Piloto.getLargada(db, idpiloto, sav);
        int acerto = Piloto.getAcerto(db, idpiloto, sav);
        int fisico = Piloto.getFisico(db, idpiloto, sav);
        int chuva = Piloto.getChuva(db, idpiloto, sav);
        
        int aerodinamicac = Carro.getAerodinamica(db, idequipe, sav);
        int suspensaoc = Carro.getSuspensao(db, idequipe, sav);
        int refrigeracaoc = Carro.getRefrigeracao(db, idequipe, sav);
        int desgastepneusc = Carro.getDesgastePneu(db, idequipe, sav);
        int direcaoc = Carro.getDirecao(db, idequipe, sav);
        int freioc = Carro.getFreio(db, idequipe, sav);
        int confiabilidadec = Carro.getConfiabilidade(db, idequipe, sav);
        int sistemaeletricoc = Carro.getSistemaEletrico(db, idequipe, sav);
        
        int confiabilidadem = Motor.getConfiabilidade(db, Equipe.getMotor(db, idequipe, sav), sav);
        int velocidadem = Motor.getVelocidade(db, Equipe.getMotor(db, idequipe, sav), sav);
        int aceleracaom = Motor.getAceleracao(db, Equipe.getMotor(db, idequipe, sav), sav);
        
        
        int pneuescolhido = FimSemana.retornapneuescolhido(sav, idpiloto);
        int desgastetotalpneu = Integer.parseInt(FimSemana.retornaDesgaste(sav, idpiloto, pneuescolhido));
        
        int idpneuescolhido = Integer.parseInt(FimSemana.retornaRelacao(sav, idpiloto, pneuescolhido));
        
        int velocidadepneu = Integer.parseInt(Pneu.getVelocidade(db, idpneuescolhido, sav));
        int aderencia = Pneu.getAderencia(db, idpneuescolhido, sav);
        int desgaste = Pneu.getDesgaste(db, idpneuescolhido, sav);
        
        minutovoltaa = minutovolta;
        segundovoltaa = segundovolta;
        
        int porcurvas;
        porcurvas = Integer.parseInt(Corrida.getCurvasPorc(db, Integer.toString(Corrida.getCorridaAtual(db, sav)), sav));
        
        milesimovolta -=(velocidade*10 + velocidadepneu)*(1+Math.random()*(-constancia/10));
        verificamilesimo(milesimovolta);
        milesimovolta +=(70-desgastetotalpneu)*21.89;
        verificamilesimo(milesimovolta);
        milesimovolta -= ((porcurvas+aderencia)/(100-porcurvas) + (aerodinamicac*2/velocidade)*10);
        verificamilesimo(milesimovolta);
        /*
        milesimovolta = (milesimovolta-((velocidade+velocidadepneu*(aderencia))/desgaste-fisico));
        milesimovolta = verificamilesimo(milesimovolta);
        milesimovolta += constancia * ( 1 + Math.random()*5);
        milesimovolta = verificamilesimo(milesimovolta);
        */
        milesimovoltaa = milesimovolta;
        
        FimSemana.salvatempo(db, sav, idpiloto, minutovoltaa, segundovoltaa, milesimovoltaa);
        
        return minutovoltaa+":"+segundovoltaa+"."+milesimovoltaa;
    }
    public static int verificamilesimo(int milesimovolta){
        int seg = 0;
        for (int i = 0; i < 30; i++) {
            if(milesimovolta < seg){
            segundovoltaa--;
            milesimovolta = (1000-(milesimovolta*-1));
            seg -= 1000;
        }
            else{
            }
        }
        int seg2 = 1000;
        for (int i = 0; i < 30; i++) {
            if(milesimovolta > seg){
            segundovoltaa++;
            milesimovolta = ((milesimovolta-seg2)*-1);
            seg += 1000;
        }
            else{
            }
        }
        return milesimovolta;
    }
   
}
