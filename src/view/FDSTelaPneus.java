/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Corrida;
import classes.Equipe;
import classes.FimSemana;
import classes.FuncoesGerais;
import classes.Piloto;
import classes.Pneu;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bergson
 */
public class FDSTelaPneus extends javax.swing.JFrame {
    private static Point point = new Point();
    private static JFrame frame = new JFrame();
    private static int numtotalpilotos = 0;
    private static int pagina = 1;
    private static String dbb = null;
    private static String savee = null;
    
    public void mousedrag(JFrame fram){
        frame = fram;
    }
    public void mousedragg(MouseEvent evt){
        Point p = frame.getLocation();
        frame.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
    /**
     * Creates new form FDSTelaPneus
     */
    public FDSTelaPneus() {
        initComponents();
    }
    
    public void recebedados(String db, int idequipe, String idcorrida, String save) throws IOException{
        savee = save;
        int idp1 = Equipe.getIdP1(db, idequipe, savee);
        int idp2 = Equipe.getIdP2(db, idequipe, savee);
        dbb = db;
        
        int pneu1 = Integer.parseInt(Corrida.getPneu1(db, idcorrida, savee));
        int pneu2 = Integer.parseInt(Corrida.getPneu2(db, idcorrida, savee));
        int pneu3 = Integer.parseInt(Corrida.getPneu3(db, idcorrida, savee));
        imgpneu1.setIcon(Pneu.getImagem(db, pneu1, savee));
        imgpneu2.setIcon(Pneu.getImagem(db, pneu2, savee));
        imgpneu3.setIcon(Pneu.getImagem(db, pneu3, savee));
        txtpneu1.setText(Pneu.getNome(db, pneu1, savee));
        txtpneu2.setText(Pneu.getNome(db, pneu2, savee));
        txtpneu3.setText(Pneu.getNome(db, pneu3, savee));
        
        setapilotos(db);
        setacores(db,idequipe);
        setatotal();
        
    }
    public void setavisivel(){
        txtp1.setVisible(true);
        txtp2.setVisible(true);
        txtp3.setVisible(true);
        txtp4.setVisible(true);
        txtp5.setVisible(true);
        txtp6.setVisible(true);
        txtp7.setVisible(true);
        txtp8.setVisible(true);
        txtp9.setVisible(true);
        txtp10.setVisible(true);
        txtp11.setVisible(true);
        separador1.setVisible(true);
        separador2.setVisible(true);
        separador3.setVisible(true);
        separador4.setVisible(true);
        separador5.setVisible(true);
        separador6.setVisible(true);
        separador7.setVisible(true);
        separador8.setVisible(true);
        separador9.setVisible(true);
        separador10.setVisible(true);
        separador11.setVisible(true);
        
        txtpn11.setVisible(true);
        txtpn21.setVisible(true);
        txtpn31.setVisible(true);
        
        txtpn12.setVisible(true);
        txtpn22.setVisible(true);
        txtpn32.setVisible(true);
        
        txtpn13.setVisible(true);
        txtpn23.setVisible(true);
        txtpn33.setVisible(true);
        
        txtpn14.setVisible(true);
        txtpn24.setVisible(true);
        txtpn34.setVisible(true);
        
        txtpn15.setVisible(true);
        txtpn25.setVisible(true);
        txtpn35.setVisible(true);
        
        txtpn16.setVisible(true);
        txtpn26.setVisible(true);
        txtpn36.setVisible(true);
        
        txtpn17.setVisible(true);
        txtpn27.setVisible(true);
        txtpn37.setVisible(true);
        
        txtpn18.setVisible(true);
        txtpn28.setVisible(true);
        txtpn38.setVisible(true);
        
        txtpn19.setVisible(true);
        txtpn29.setVisible(true);
        txtpn39.setVisible(true);
        
        txtpn110.setVisible(true);
        txtpn210.setVisible(true);
        txtpn310.setVisible(true);
        
        txtpn111.setVisible(true);
        txtpn211.setVisible(true);
        txtpn311.setVisible(true);
    }
    
    public void setatotal() throws IOException{
        setavisivel();
        int totalpilotos = FuncoesGerais.totalpilotos(savee);
        if(pagina == 2){
            if (totalpilotos < 22) {
                txtp11.setVisible(false);
                txtpn111.setVisible(false);
                txtpn211.setVisible(false);
                txtpn311.setVisible(false);
                separador11.setVisible(false);
            }
            if (totalpilotos < 21) {
                txtp10.setVisible(false);
                txtpn110.setVisible(false);
                txtpn210.setVisible(false);
                txtpn310.setVisible(false);
                separador10.setVisible(false);
            }
            if (totalpilotos < 20) {
                txtp9.setVisible(false);
                txtpn19.setVisible(false);
                txtpn29.setVisible(false);
                txtpn39.setVisible(false);
                separador9.setVisible(false);
            }
            if (totalpilotos < 19) {
                txtp8.setVisible(false);
                txtpn18.setVisible(false);
                txtpn28.setVisible(false);
                txtpn38.setVisible(false);
                separador8.setVisible(false);
            }
            if (totalpilotos < 18) {
                txtp7.setVisible(false);
                txtpn17.setVisible(false);
                txtpn27.setVisible(false);
                txtpn37.setVisible(false);
                separador7.setVisible(false);
            }
            if (totalpilotos < 17) {
                txtp6.setVisible(false);
                txtpn16.setVisible(false);
                txtpn26.setVisible(false);
                txtpn36.setVisible(false);
                separador6.setVisible(false);
            }
            if (totalpilotos < 16) {
                txtp5.setVisible(false);
                txtpn15.setVisible(false);
                txtpn25.setVisible(false);
                txtpn35.setVisible(false);
                separador5.setVisible(false);
            }
            if (totalpilotos < 15) {
                txtp4.setVisible(false);
                txtpn14.setVisible(false);
                txtpn24.setVisible(false);
                txtpn34.setVisible(false);
                separador4.setVisible(false);
            }
            if (totalpilotos < 14) {
                txtp3.setVisible(false);
                txtpn13.setVisible(false);
                txtpn23.setVisible(false);
                txtpn33.setVisible(false);
                separador3.setVisible(false);
            }
            if (totalpilotos < 13) {
                txtp2.setVisible(false);
                txtpn12.setVisible(false);
                txtpn22.setVisible(false);
                txtpn32.setVisible(false);
                separador2.setVisible(false);
            }
            if (totalpilotos < 12) {
                txtp1.setVisible(false);
                txtpn11.setVisible(false);
                txtpn21.setVisible(false);
                txtpn31.setVisible(false);
                separador1.setVisible(false);
                jButton2.setVisible(false);
            }
        }
        if(pagina == 1){
            if (totalpilotos < 11) {
                txtp11.setVisible(false);
                txtpn111.setVisible(false);
                txtpn211.setVisible(false);
                txtpn311.setVisible(false);
                separador11.setVisible(false);
            }
            if (totalpilotos < 10) {
                txtp10.setVisible(false);
                txtpn110.setVisible(false);
                txtpn210.setVisible(false);
                txtpn310.setVisible(false);
                separador10.setVisible(false);
            }
            if (totalpilotos < 9) {
                txtp9.setVisible(false);
                txtpn19.setVisible(false);
                txtpn29.setVisible(false);
                txtpn39.setVisible(false);
                separador9.setVisible(false);
            }
            if (totalpilotos < 8) {
                txtp8.setVisible(false);
                txtpn18.setVisible(false);
                txtpn28.setVisible(false);
                txtpn38.setVisible(false);
                separador8.setVisible(false);
            }
            if (totalpilotos < 7) {
                txtp7.setVisible(false);
                txtpn17.setVisible(false);
                txtpn27.setVisible(false);
                txtpn37.setVisible(false);
                separador7.setVisible(false);
            }
            if (totalpilotos < 6) {
                txtp6.setVisible(false);
                txtpn16.setVisible(false);
                txtpn26.setVisible(false);
                txtpn36.setVisible(false);
                separador6.setVisible(false);
            }
            if (totalpilotos < 5) {
                txtp5.setVisible(false);
                txtpn15.setVisible(false);
                txtpn25.setVisible(false);
                txtpn35.setVisible(false);
                separador5.setVisible(false);
            }
            if (totalpilotos < 4) {
                txtp4.setVisible(false);
                txtpn14.setVisible(false);
                txtpn24.setVisible(false);
                txtpn34.setVisible(false);
                separador4.setVisible(false);
            }
            if (totalpilotos < 3) {
                txtp3.setVisible(false);
                txtpn13.setVisible(false);
                txtpn23.setVisible(false);
                txtpn33.setVisible(false);
                separador3.setVisible(false);
            }
            if (totalpilotos < 2) {
                txtp2.setVisible(false);
                txtpn12.setVisible(false);
                txtpn22.setVisible(false);
                txtpn32.setVisible(false);
                separador2.setVisible(false);
            }
            if (totalpilotos < 1) {
                txtp1.setVisible(false);
                txtpn11.setVisible(false);
                txtpn21.setVisible(false);
                txtpn31.setVisible(false);
                separador1.setVisible(false);
            }
        }
        
    }
    
    public void setacores(String db,int idequipe) throws IOException{
        String cor = Equipe.getCor1(db, idequipe, savee);
        jPanel2.setBackground(Color.decode(cor));
        jLabel5.setForeground(Color.decode(cor));
        jLabel6.setForeground(Color.decode(cor));
        txtp1.setForeground(Color.decode(cor));
        txtp2.setForeground(Color.decode(cor));
        txtp3.setForeground(Color.decode(cor));
        txtp4.setForeground(Color.decode(cor));
        txtp5.setForeground(Color.decode(cor));
        txtp6.setForeground(Color.decode(cor));
        txtp7.setForeground(Color.decode(cor));
        txtp8.setForeground(Color.decode(cor));
        txtp9.setForeground(Color.decode(cor));
        txtp10.setForeground(Color.decode(cor));
        txtp11.setForeground(Color.decode(cor));
        
        txtpneu1.setForeground(Color.decode(cor));
        txtpneu2.setForeground(Color.decode(cor));
        txtpneu3.setForeground(Color.decode(cor));
        
        txtpn11.setForeground(Color.decode(cor));
        txtpn21.setForeground(Color.decode(cor));
        txtpn31.setForeground(Color.decode(cor));
        
        txtpn12.setForeground(Color.decode(cor));
        txtpn22.setForeground(Color.decode(cor));
        txtpn32.setForeground(Color.decode(cor));
        
        txtpn13.setForeground(Color.decode(cor));
        txtpn23.setForeground(Color.decode(cor));
        txtpn33.setForeground(Color.decode(cor));
        
        txtpn14.setForeground(Color.decode(cor));
        txtpn24.setForeground(Color.decode(cor));
        txtpn34.setForeground(Color.decode(cor));
        
        txtpn15.setForeground(Color.decode(cor));
        txtpn25.setForeground(Color.decode(cor));
        txtpn35.setForeground(Color.decode(cor));
        
        txtpn16.setForeground(Color.decode(cor));
        txtpn26.setForeground(Color.decode(cor));
        txtpn36.setForeground(Color.decode(cor));
        
        txtpn17.setForeground(Color.decode(cor));
        txtpn27.setForeground(Color.decode(cor));
        txtpn37.setForeground(Color.decode(cor));
        
        txtpn18.setForeground(Color.decode(cor));
        txtpn28.setForeground(Color.decode(cor));
        txtpn38.setForeground(Color.decode(cor));
        
        txtpn19.setForeground(Color.decode(cor));
        txtpn29.setForeground(Color.decode(cor));
        txtpn39.setForeground(Color.decode(cor));
        
        txtpn110.setForeground(Color.decode(cor));
        txtpn210.setForeground(Color.decode(cor));
        txtpn310.setForeground(Color.decode(cor));
        
        txtpn111.setForeground(Color.decode(cor));
        txtpn211.setForeground(Color.decode(cor));
        txtpn311.setForeground(Color.decode(cor));
        
        jButton1.setBackground(Color.decode(cor));
        jButton2.setBackground(Color.decode(cor));
        jButton3.setBackground(Color.decode(cor));
    }
    
    public void setapilotos(String db) throws IOException{
        if (numtotalpilotos < 1) {
            txtp1.setText(Piloto.getLetraNome(db, 1, savee)+Piloto.getSobrenome(db, 1, savee));
        }
        if (numtotalpilotos < 2){
            txtp2.setText(Piloto.getLetraNome(db, 2, savee)+Piloto.getSobrenome(db, 2, savee));
        }
        if (numtotalpilotos < 3) {
            txtp3.setText(Piloto.getLetraNome(db, 3, savee)+Piloto.getSobrenome(db, 3, savee));
        }
        if (numtotalpilotos < 4){
            txtp4.setText(Piloto.getLetraNome(db, 4, savee)+Piloto.getSobrenome(db, 4, savee));
        }
        if (numtotalpilotos < 5) {
            txtp5.setText(Piloto.getLetraNome(db, 5, savee)+Piloto.getSobrenome(db, 5, savee));
        }
        if (numtotalpilotos < 6){
            txtp6.setText(Piloto.getLetraNome(db, 6, savee)+Piloto.getSobrenome(db, 6, savee));
        }
        if (numtotalpilotos < 7) {
            txtp7.setText(Piloto.getLetraNome(db, 7, savee)+Piloto.getSobrenome(db, 7, savee));
        }
        if (numtotalpilotos < 8){
            txtp8.setText(Piloto.getLetraNome(db, 8, savee)+Piloto.getSobrenome(db, 8, savee));
        }
        if (numtotalpilotos < 9) {
            txtp9.setText(Piloto.getLetraNome(db, 9, savee)+Piloto.getSobrenome(db, 9, savee));
        }
        if (numtotalpilotos < 10){
            txtp10.setText(Piloto.getLetraNome(db, 10, savee)+Piloto.getSobrenome(db, 10, savee));
        }
        if (numtotalpilotos < 11) {
            txtp11.setText(Piloto.getLetraNome(db, 11, savee)+Piloto.getSobrenome(db, 11, savee));
        }
        setapneus();
        setatotal();
{
            
        }
    }
    
    public void setapilotos2(String db) throws IOException{
        if (numtotalpilotos < 12) {
            txtp1.setText(Piloto.getLetraNome(db, 12, savee)+Piloto.getSobrenome(db, 12, savee));
        }
        if (numtotalpilotos < 13) {
            txtp2.setText(Piloto.getLetraNome(db, 13, savee)+Piloto.getSobrenome(db, 13, savee));
        }
        if (numtotalpilotos < 14){
            txtp3.setText(Piloto.getLetraNome(db, 14, savee)+Piloto.getSobrenome(db, 14, savee));
        }
        if (numtotalpilotos < 15) {
            txtp4.setText(Piloto.getLetraNome(db, 15, savee)+Piloto.getSobrenome(db, 15, savee));
        }
        if (numtotalpilotos < 16){
            txtp5.setText(Piloto.getLetraNome(db, 16, savee)+Piloto.getSobrenome(db, 16, savee));
        }
        if (numtotalpilotos < 17) {
            txtp6.setText(Piloto.getLetraNome(db, 17, savee)+Piloto.getSobrenome(db, 17, savee));
        }
        if (numtotalpilotos < 18){
            txtp7.setText(Piloto.getLetraNome(db, 18, savee)+Piloto.getSobrenome(db, 18, savee));
        }
        if (numtotalpilotos < 19) {
            txtp8.setText(Piloto.getLetraNome(db, 19, savee)+Piloto.getSobrenome(db, 19, savee));
        }
        if (numtotalpilotos < 20){
            txtp9.setText(Piloto.getLetraNome(db, 20, savee)+Piloto.getSobrenome(db, 20, savee));
        }
        if (numtotalpilotos < 21) {
            try {
                txtp10.setText(Piloto.getLetraNome(db, 21, savee)+Piloto.getSobrenome(db, 21, savee));
            } catch (Exception e) {
            }
        }
        if (numtotalpilotos < 22){
            try {
                txtp11.setText(Piloto.getLetraNome(db, 22, savee)+Piloto.getSobrenome(db, 22, savee));
            } catch (Exception e) {
            }
            
        }
        
        setapneus2();
        setatotal();
{
            
        }
    }
    
    public void setapneus() throws IOException {
        if(numtotalpilotos < 2){
            txtpn11.setText(Integer.toString(FimSemana.pegapneusfimsemana(1 , 1, savee)));
            txtpn21.setText(Integer.toString(FimSemana.pegapneusfimsemana(1 , 2, savee)));
            txtpn31.setText(Integer.toString(FimSemana.pegapneusfimsemana(1 , 3, savee)));
        }
        if(numtotalpilotos < 3){
        txtpn12.setText(Integer.toString(FimSemana.pegapneusfimsemana(2 , 1, savee)));
        txtpn22.setText(Integer.toString(FimSemana.pegapneusfimsemana(2 , 2, savee)));
        txtpn32.setText(Integer.toString(FimSemana.pegapneusfimsemana(2 , 3, savee)));
        }
        if(numtotalpilotos < 4){
        txtpn13.setText(Integer.toString(FimSemana.pegapneusfimsemana(3 , 1, savee)));
        txtpn23.setText(Integer.toString(FimSemana.pegapneusfimsemana(3 , 2, savee)));
        txtpn33.setText(Integer.toString(FimSemana.pegapneusfimsemana(3 , 3, savee)));
        }
        if(numtotalpilotos < 5){
        txtpn14.setText(Integer.toString(FimSemana.pegapneusfimsemana(4 , 1, savee)));
        txtpn24.setText(Integer.toString(FimSemana.pegapneusfimsemana(4 , 2, savee)));
        txtpn34.setText(Integer.toString(FimSemana.pegapneusfimsemana(4 , 3, savee)));
        }
        if(numtotalpilotos < 6){
        txtpn15.setText(Integer.toString(FimSemana.pegapneusfimsemana(5 , 1, savee)));
        txtpn25.setText(Integer.toString(FimSemana.pegapneusfimsemana(5 , 2, savee)));
        txtpn35.setText(Integer.toString(FimSemana.pegapneusfimsemana(5 , 3, savee)));
        }
        if(numtotalpilotos < 7){
        txtpn16.setText(Integer.toString(FimSemana.pegapneusfimsemana(6 , 1, savee)));
        txtpn26.setText(Integer.toString(FimSemana.pegapneusfimsemana(6 , 2, savee)));
        txtpn36.setText(Integer.toString(FimSemana.pegapneusfimsemana(6 , 3, savee)));
        }
        if(numtotalpilotos < 8){
        txtpn17.setText(Integer.toString(FimSemana.pegapneusfimsemana(7 , 1, savee)));
        txtpn27.setText(Integer.toString(FimSemana.pegapneusfimsemana(7 , 2, savee)));
        txtpn37.setText(Integer.toString(FimSemana.pegapneusfimsemana(7 , 3, savee)));
        }
        if(numtotalpilotos < 9){
        txtpn18.setText(Integer.toString(FimSemana.pegapneusfimsemana(8 , 1, savee)));
        txtpn28.setText(Integer.toString(FimSemana.pegapneusfimsemana(8 , 2, savee)));
        txtpn38.setText(Integer.toString(FimSemana.pegapneusfimsemana(8 , 3, savee)));
        }
        if(numtotalpilotos < 10){
        txtpn19.setText(Integer.toString(FimSemana.pegapneusfimsemana(9 , 1, savee)));
        txtpn29.setText(Integer.toString(FimSemana.pegapneusfimsemana(9 , 2, savee)));
        txtpn39.setText(Integer.toString(FimSemana.pegapneusfimsemana(9 , 3, savee)));
        }
        if(numtotalpilotos < 11){
        txtpn110.setText(Integer.toString(FimSemana.pegapneusfimsemana(10 , 1, savee)));
        txtpn210.setText(Integer.toString(FimSemana.pegapneusfimsemana(10 , 2, savee)));
        txtpn310.setText(Integer.toString(FimSemana.pegapneusfimsemana(10 , 3, savee)));
        }
        if(numtotalpilotos < 12){
        txtpn111.setText(Integer.toString(FimSemana.pegapneusfimsemana(11 , 1, savee)));
        txtpn211.setText(Integer.toString(FimSemana.pegapneusfimsemana(11 , 2, savee)));
        txtpn311.setText(Integer.toString(FimSemana.pegapneusfimsemana(11 , 3, savee)));
        }
    }
    public void setapneus2() throws IOException{
        if(numtotalpilotos < 13){
        txtpn11.setText(Integer.toString(FimSemana.pegapneusfimsemana(12 , 1, savee)));
        txtpn21.setText(Integer.toString(FimSemana.pegapneusfimsemana(12 , 2, savee)));
        txtpn31.setText(Integer.toString(FimSemana.pegapneusfimsemana(12 , 3, savee)));
        }
        if(numtotalpilotos < 14){
        txtpn12.setText(Integer.toString(FimSemana.pegapneusfimsemana(13 , 1, savee)));
        txtpn22.setText(Integer.toString(FimSemana.pegapneusfimsemana(13 , 2, savee)));
        txtpn32.setText(Integer.toString(FimSemana.pegapneusfimsemana(13 , 3, savee)));
        }
        if(numtotalpilotos < 15){
        txtpn13.setText(Integer.toString(FimSemana.pegapneusfimsemana(14 , 1, savee)));
        txtpn23.setText(Integer.toString(FimSemana.pegapneusfimsemana(14 , 2, savee)));
        txtpn33.setText(Integer.toString(FimSemana.pegapneusfimsemana(14 , 3, savee)));
        }
        if(numtotalpilotos < 16){
        txtpn14.setText(Integer.toString(FimSemana.pegapneusfimsemana(15 , 1, savee)));
        txtpn24.setText(Integer.toString(FimSemana.pegapneusfimsemana(15 , 2, savee)));
        txtpn34.setText(Integer.toString(FimSemana.pegapneusfimsemana(15 , 3, savee)));
        }
        if(numtotalpilotos < 17){
        txtpn15.setText(Integer.toString(FimSemana.pegapneusfimsemana(16 , 1, savee)));
        txtpn25.setText(Integer.toString(FimSemana.pegapneusfimsemana(16 , 2, savee)));
        txtpn35.setText(Integer.toString(FimSemana.pegapneusfimsemana(16 , 3, savee)));
        }
        if(numtotalpilotos < 18){
        txtpn16.setText(Integer.toString(FimSemana.pegapneusfimsemana(17 , 1, savee)));
        txtpn26.setText(Integer.toString(FimSemana.pegapneusfimsemana(17 , 2, savee)));
        txtpn36.setText(Integer.toString(FimSemana.pegapneusfimsemana(17 , 3, savee)));
        }
        if(numtotalpilotos < 19){
        txtpn17.setText(Integer.toString(FimSemana.pegapneusfimsemana(18 , 1, savee)));
        txtpn27.setText(Integer.toString(FimSemana.pegapneusfimsemana(18 , 2, savee)));
        txtpn37.setText(Integer.toString(FimSemana.pegapneusfimsemana(18 , 3, savee)));
        }
        if(numtotalpilotos < 20){
        txtpn18.setText(Integer.toString(FimSemana.pegapneusfimsemana(19 , 1, savee)));
        txtpn28.setText(Integer.toString(FimSemana.pegapneusfimsemana(19 , 2, savee)));
        txtpn38.setText(Integer.toString(FimSemana.pegapneusfimsemana(19 , 3, savee)));
        }
        if(numtotalpilotos < 21){
        txtpn19.setText(Integer.toString(FimSemana.pegapneusfimsemana(20 , 1, savee)));
        txtpn29.setText(Integer.toString(FimSemana.pegapneusfimsemana(20 , 2, savee)));
        txtpn39.setText(Integer.toString(FimSemana.pegapneusfimsemana(20 , 3, savee)));
        }
        if(numtotalpilotos < 22){
            try {
                txtpn110.setText(Integer.toString(FimSemana.pegapneusfimsemana(21 , 1, savee)));
                txtpn210.setText(Integer.toString(FimSemana.pegapneusfimsemana(21 , 2, savee)));
                txtpn310.setText(Integer.toString(FimSemana.pegapneusfimsemana(21 , 3, savee)));
            } catch (Exception e) {
            }
        
        }
        if(numtotalpilotos < 23){
            try {
                txtpn111.setText(Integer.toString(FimSemana.pegapneusfimsemana(22 , 1, savee)));
                txtpn211.setText(Integer.toString(FimSemana.pegapneusfimsemana(22 , 2, savee)));
                txtpn311.setText(Integer.toString(FimSemana.pegapneusfimsemana(22 , 3, savee)));
            } catch (Exception e) {
            }
        
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        imgpneu3 = new javax.swing.JLabel();
        imgpneu2 = new javax.swing.JLabel();
        imgpneu1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        txtpneu3 = new javax.swing.JLabel();
        txtpneu1 = new javax.swing.JLabel();
        txtpneu2 = new javax.swing.JLabel();
        txtp1 = new javax.swing.JLabel();
        txtpn11 = new javax.swing.JLabel();
        txtpn21 = new javax.swing.JLabel();
        txtpn31 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        txtp2 = new javax.swing.JLabel();
        separador2 = new javax.swing.JSeparator();
        txtpn12 = new javax.swing.JLabel();
        txtpn22 = new javax.swing.JLabel();
        txtpn32 = new javax.swing.JLabel();
        txtp3 = new javax.swing.JLabel();
        separador3 = new javax.swing.JSeparator();
        txtpn13 = new javax.swing.JLabel();
        txtpn23 = new javax.swing.JLabel();
        txtpn33 = new javax.swing.JLabel();
        txtp4 = new javax.swing.JLabel();
        separador4 = new javax.swing.JSeparator();
        txtpn14 = new javax.swing.JLabel();
        txtpn24 = new javax.swing.JLabel();
        txtpn34 = new javax.swing.JLabel();
        txtp5 = new javax.swing.JLabel();
        separador5 = new javax.swing.JSeparator();
        txtpn15 = new javax.swing.JLabel();
        txtpn25 = new javax.swing.JLabel();
        txtpn35 = new javax.swing.JLabel();
        txtp6 = new javax.swing.JLabel();
        separador6 = new javax.swing.JSeparator();
        txtpn16 = new javax.swing.JLabel();
        txtpn26 = new javax.swing.JLabel();
        txtpn36 = new javax.swing.JLabel();
        txtp7 = new javax.swing.JLabel();
        separador7 = new javax.swing.JSeparator();
        txtpn17 = new javax.swing.JLabel();
        txtpn27 = new javax.swing.JLabel();
        txtpn37 = new javax.swing.JLabel();
        txtp8 = new javax.swing.JLabel();
        separador8 = new javax.swing.JSeparator();
        txtpn18 = new javax.swing.JLabel();
        txtpn28 = new javax.swing.JLabel();
        txtpn38 = new javax.swing.JLabel();
        txtp9 = new javax.swing.JLabel();
        separador9 = new javax.swing.JSeparator();
        txtpn19 = new javax.swing.JLabel();
        txtpn29 = new javax.swing.JLabel();
        txtpn39 = new javax.swing.JLabel();
        txtp10 = new javax.swing.JLabel();
        separador10 = new javax.swing.JSeparator();
        txtpn110 = new javax.swing.JLabel();
        txtpn210 = new javax.swing.JLabel();
        txtpn310 = new javax.swing.JLabel();
        txtp11 = new javax.swing.JLabel();
        separador11 = new javax.swing.JSeparator();
        txtpn111 = new javax.swing.JLabel();
        txtpn211 = new javax.swing.JLabel();
        txtpn311 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ANUNCIO! ESCOLHA DOS PNEUS PARA O FINAL DE SEMANA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 630, -1));

        imgpneu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(imgpneu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        imgpneu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imgpneu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(imgpneu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 100, -1));

        imgpneu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(imgpneu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("PILOTO ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 160, -1));
        jPanel1.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 230, 660, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setText("PNEUS");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, -1, -1));

        txtpneu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu3.setText("PNEU 3");
        jPanel1.add(txtpneu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 180, 100, -1));

        txtpneu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu1.setText("PNEU 1");
        jPanel1.add(txtpneu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 180, 100, -1));

        txtpneu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu2.setText("PNEU 2");
        jPanel1.add(txtpneu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 100, -1));

        txtp1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp1.setText("PILOTO 1");
        jPanel1.add(txtp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 170, 30));

        txtpn11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn11.setText("0");
        jPanel1.add(txtpn11, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 200, 80, 30));

        txtpn21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn21.setText("0");
        jPanel1.add(txtpn21, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 80, 30));

        txtpn31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn31.setText("0");
        jPanel1.add(txtpn31, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 200, 80, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 200, 660, 10));

        txtp2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp2.setText("PILOTO 2");
        jPanel1.add(txtp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 170, 30));
        jPanel1.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 650, 10));

        txtpn12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn12.setText("0");
        jPanel1.add(txtpn12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 230, 80, 30));

        txtpn22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn22.setText("0");
        jPanel1.add(txtpn22, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 80, 30));

        txtpn32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn32.setText("0");
        jPanel1.add(txtpn32, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 230, 80, 30));

        txtp3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp3.setText("PILOTO 3");
        jPanel1.add(txtp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 170, 30));
        jPanel1.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 650, 10));

        txtpn13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn13.setText("0");
        jPanel1.add(txtpn13, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 260, 80, 30));

        txtpn23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn23.setText("0");
        jPanel1.add(txtpn23, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 260, 80, 30));

        txtpn33.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn33.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn33.setText("0");
        jPanel1.add(txtpn33, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 260, 80, 30));

        txtp4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp4.setText("PILOTO 4");
        jPanel1.add(txtp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, 170, 30));
        jPanel1.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 320, 660, 10));

        txtpn14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn14.setText("0");
        jPanel1.add(txtpn14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, 80, 30));

        txtpn24.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn24.setText("0");
        jPanel1.add(txtpn24, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 290, 80, 30));

        txtpn34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn34.setText("0");
        jPanel1.add(txtpn34, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 290, 80, 30));

        txtp5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp5.setText("PILOTO 5");
        jPanel1.add(txtp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 170, 30));
        jPanel1.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 350, 660, 10));

        txtpn15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn15.setText("0");
        jPanel1.add(txtpn15, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 320, 80, 30));

        txtpn25.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn25.setText("0");
        jPanel1.add(txtpn25, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 320, 80, 30));

        txtpn35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn35.setText("0");
        jPanel1.add(txtpn35, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 80, 30));

        txtp6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp6.setText("PILOTO 6");
        jPanel1.add(txtp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 170, 30));
        jPanel1.add(separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 380, 660, 10));

        txtpn16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn16.setText("0");
        jPanel1.add(txtpn16, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 350, 80, 30));

        txtpn26.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn26.setText("0");
        jPanel1.add(txtpn26, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 80, 30));

        txtpn36.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn36.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn36.setText("0");
        jPanel1.add(txtpn36, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 350, 80, 30));

        txtp7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp7.setText("PILOTO 7");
        jPanel1.add(txtp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 170, 30));
        jPanel1.add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 410, 660, 10));

        txtpn17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn17.setText("0");
        jPanel1.add(txtpn17, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 380, 80, 30));

        txtpn27.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn27.setText("0");
        jPanel1.add(txtpn27, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 380, 80, 30));

        txtpn37.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn37.setText("0");
        jPanel1.add(txtpn37, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 80, 30));

        txtp8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp8.setText("PILOTO 8");
        jPanel1.add(txtp8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 170, 30));
        jPanel1.add(separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 440, 660, 10));

        txtpn18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn18.setText("0");
        jPanel1.add(txtpn18, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 410, 80, 30));

        txtpn28.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn28.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn28.setText("0");
        jPanel1.add(txtpn28, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 410, 80, 30));

        txtpn38.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn38.setText("0");
        jPanel1.add(txtpn38, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 410, 80, 30));

        txtp9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp9.setText("PILOTO 9");
        jPanel1.add(txtp9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 170, 30));
        jPanel1.add(separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 470, 660, 10));

        txtpn19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn19.setText("0");
        jPanel1.add(txtpn19, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 440, 80, 30));

        txtpn29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn29.setText("0");
        jPanel1.add(txtpn29, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 440, 80, 30));

        txtpn39.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn39.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn39.setText("0");
        jPanel1.add(txtpn39, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 440, 80, 30));

        txtp10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp10.setText("PILOTO 10");
        jPanel1.add(txtp10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 170, 30));
        jPanel1.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 500, 650, 10));

        txtpn110.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn110.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn110.setText("0");
        jPanel1.add(txtpn110, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 470, 80, 30));

        txtpn210.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn210.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn210.setText("0");
        jPanel1.add(txtpn210, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 80, 30));

        txtpn310.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn310.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn310.setText("0");
        jPanel1.add(txtpn310, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 80, 30));

        txtp11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtp11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp11.setText("PILOTO 11");
        jPanel1.add(txtp11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 170, 30));
        jPanel1.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 530, 660, 10));

        txtpn111.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn111.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn111.setText("0");
        jPanel1.add(txtpn111, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 80, 30));

        txtpn211.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn211.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn211.setText("0");
        jPanel1.add(txtpn211, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 500, 80, 30));

        txtpn311.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpn311.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpn311.setText("0");
        jPanel1.add(txtpn311, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 500, 80, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Próxima Página");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 150, 40));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 540, 90, 40));

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Voltar Página");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 540, 150, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
        setVisible(false);
        FDSTreino treino = new FDSTreino();
        treino.setVisible(true);
        treino.setLocationRelativeTo(null);
        treino.recebedados(dbb,savee);
        treino.mousedrag(treino);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point.x = evt.getX();
        point.y = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        mousedragg(evt);        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            pagina = 2;
            jButton1.setVisible(false);
            jButton3.setVisible(true);
            try {
                setapilotos2(dbb);
            } catch (IOException ex) {
                Logger.getLogger(FDSTelaPneus.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
            pagina = 1;
            jButton1.setVisible(true);
            jButton3.setVisible(false);
            try {
                setapilotos(dbb);
            } catch (IOException ex) {
                Logger.getLogger(FDSTelaPneus.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FDSTelaPneus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDSTelaPneus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDSTelaPneus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDSTelaPneus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDSTelaPneus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgpneu1;
    private javax.swing.JLabel imgpneu2;
    private javax.swing.JLabel imgpneu3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador10;
    private javax.swing.JSeparator separador11;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador6;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador8;
    private javax.swing.JSeparator separador9;
    private javax.swing.JLabel txtp1;
    private javax.swing.JLabel txtp10;
    private javax.swing.JLabel txtp11;
    private javax.swing.JLabel txtp2;
    private javax.swing.JLabel txtp3;
    private javax.swing.JLabel txtp4;
    private javax.swing.JLabel txtp5;
    private javax.swing.JLabel txtp6;
    private javax.swing.JLabel txtp7;
    private javax.swing.JLabel txtp8;
    private javax.swing.JLabel txtp9;
    private javax.swing.JLabel txtpn11;
    private javax.swing.JLabel txtpn110;
    private javax.swing.JLabel txtpn111;
    private javax.swing.JLabel txtpn12;
    private javax.swing.JLabel txtpn13;
    private javax.swing.JLabel txtpn14;
    private javax.swing.JLabel txtpn15;
    private javax.swing.JLabel txtpn16;
    private javax.swing.JLabel txtpn17;
    private javax.swing.JLabel txtpn18;
    private javax.swing.JLabel txtpn19;
    private javax.swing.JLabel txtpn21;
    private javax.swing.JLabel txtpn210;
    private javax.swing.JLabel txtpn211;
    private javax.swing.JLabel txtpn22;
    private javax.swing.JLabel txtpn23;
    private javax.swing.JLabel txtpn24;
    private javax.swing.JLabel txtpn25;
    private javax.swing.JLabel txtpn26;
    private javax.swing.JLabel txtpn27;
    private javax.swing.JLabel txtpn28;
    private javax.swing.JLabel txtpn29;
    private javax.swing.JLabel txtpn31;
    private javax.swing.JLabel txtpn310;
    private javax.swing.JLabel txtpn311;
    private javax.swing.JLabel txtpn32;
    private javax.swing.JLabel txtpn33;
    private javax.swing.JLabel txtpn34;
    private javax.swing.JLabel txtpn35;
    private javax.swing.JLabel txtpn36;
    private javax.swing.JLabel txtpn37;
    private javax.swing.JLabel txtpn38;
    private javax.swing.JLabel txtpn39;
    private javax.swing.JLabel txtpneu1;
    private javax.swing.JLabel txtpneu2;
    private javax.swing.JLabel txtpneu3;
    // End of variables declaration//GEN-END:variables
}
