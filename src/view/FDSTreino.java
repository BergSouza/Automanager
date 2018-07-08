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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Bergson
 */
public class FDSTreino extends javax.swing.JFrame {
    private static Point point = new Point();
    private static JFrame frame = new JFrame();
    private static String savee = null;
    private static String dbb = null;
    private static int maxpilotos = 0;
    private static int idequipee = 0;
    private static int idpneu11 = 0;
    private static int idpneu22 = 0;
    private static int idpneu33 = 0;
    private static int idp11 = 0;
    private static int idp22 = 0;
    private static int idcorridaa = 0;
    private static String desgastepneup11 = null;
    private static String desgastepneup22 = null;
    //private static int numtotalpilotos = 0;
    //private static int pagina = 1;
    //private static String dbb = null;
    //private static String savee = null;
    
    public void mousedrag(JFrame fram){
        frame = fram;
    }
    public void mousedragg(MouseEvent evt){
        Point p = frame.getLocation();
        frame.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
    /**
     * Creates new form FDSTreino
     */
    public FDSTreino() {
        initComponents();
    }
    
    public void recebedados(String db, String save){
        try {
            int idequipe = Equipe.getID(db, save);
            idequipee = idequipe;
            dbb = db;
            savee = save;
            setapilotos(db, save);
            setacores();
        } catch (IOException ex) {
            Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void setacores(){
        try {
            String cor = Equipe.getCor1(dbb, idequipee, savee);
            jPanel4.setBackground(Color.decode(cor));
            jPanel3.setBackground(Color.decode(cor));
            jPanel1.setBackground(Color.decode(cor));
            
            txtposi1.setForeground(Color.decode(cor));
            txtposi2.setForeground(Color.decode(cor));
            txtposi3.setForeground(Color.decode(cor));
            txtposi4.setForeground(Color.decode(cor));
            txtposi5.setForeground(Color.decode(cor));
            txtposi6.setForeground(Color.decode(cor));
            txtposi7.setForeground(Color.decode(cor));
            txtposi8.setForeground(Color.decode(cor));
            txtposi9.setForeground(Color.decode(cor));
            txtposi10.setForeground(Color.decode(cor));
            txtposi11.setForeground(Color.decode(cor));
            txtposi12.setForeground(Color.decode(cor));
            txtposi13.setForeground(Color.decode(cor));
            txtposi14.setForeground(Color.decode(cor));
            txtposi15.setForeground(Color.decode(cor));
            txtposi16.setForeground(Color.decode(cor));
            txtposi17.setForeground(Color.decode(cor));
            txtposi18.setForeground(Color.decode(cor));
            txtposi19.setForeground(Color.decode(cor));
            txtposi20.setForeground(Color.decode(cor));
            txtposi21.setForeground(Color.decode(cor));
            txtposi22.setForeground(Color.decode(cor));
            
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
            txtp12.setForeground(Color.decode(cor));
            txtp13.setForeground(Color.decode(cor));
            txtp14.setForeground(Color.decode(cor));
            txtp15.setForeground(Color.decode(cor));
            txtp16.setForeground(Color.decode(cor));
            txtp17.setForeground(Color.decode(cor));
            txtp18.setForeground(Color.decode(cor));
            txtp19.setForeground(Color.decode(cor));
            txtp20.setForeground(Color.decode(cor));
            txtp21.setForeground(Color.decode(cor));
            txtp22.setForeground(Color.decode(cor));
            txtp23.setForeground(Color.decode(cor));
            txtp24.setForeground(Color.decode(cor));
            
            txtep1.setForeground(Color.decode(cor));
            txtep2.setForeground(Color.decode(cor));
            txtep3.setForeground(Color.decode(cor));
            txtep4.setForeground(Color.decode(cor));
            txtep5.setForeground(Color.decode(cor));
            txtep6.setForeground(Color.decode(cor));
            txtep7.setForeground(Color.decode(cor));
            txtep8.setForeground(Color.decode(cor));
            txtep9.setForeground(Color.decode(cor));
            txtep10.setForeground(Color.decode(cor));
            txtep11.setForeground(Color.decode(cor));
            txtep12.setForeground(Color.decode(cor));
            txtep13.setForeground(Color.decode(cor));
            txtep14.setForeground(Color.decode(cor));
            txtep15.setForeground(Color.decode(cor));
            txtep16.setForeground(Color.decode(cor));
            txtep17.setForeground(Color.decode(cor));
            txtep18.setForeground(Color.decode(cor));
            txtep19.setForeground(Color.decode(cor));
            txtep20.setForeground(Color.decode(cor));
            txtep21.setForeground(Color.decode(cor));
            txtep22.setForeground(Color.decode(cor));
            txtep23.setForeground(Color.decode(cor));
            txtep24.setForeground(Color.decode(cor));
            
            txttempo1.setForeground(Color.decode(cor));
            txttempo2.setForeground(Color.decode(cor));
            txttempo3.setForeground(Color.decode(cor));
            txttempo4.setForeground(Color.decode(cor));
            txttempo5.setForeground(Color.decode(cor));
            txttempo6.setForeground(Color.decode(cor));
            txttempo7.setForeground(Color.decode(cor));
            txttempo8.setForeground(Color.decode(cor));
            txttempo9.setForeground(Color.decode(cor));
            txttempo10.setForeground(Color.decode(cor));
            txttempo11.setForeground(Color.decode(cor));
            txttempo12.setForeground(Color.decode(cor));
            txttempo13.setForeground(Color.decode(cor));
            txttempo14.setForeground(Color.decode(cor));
            txttempo15.setForeground(Color.decode(cor));
            txttempo16.setForeground(Color.decode(cor));
            txttempo17.setForeground(Color.decode(cor));
            txttempo18.setForeground(Color.decode(cor));
            txttempo19.setForeground(Color.decode(cor));
            txttempo20.setForeground(Color.decode(cor));
            txttempo21.setForeground(Color.decode(cor));
            txttempo22.setForeground(Color.decode(cor));
            txttempo23.setForeground(Color.decode(cor));
            txttempo24.setForeground(Color.decode(cor));
           
            separador1.setForeground(Color.decode(cor));
            separador2.setForeground(Color.decode(cor));
            separador3.setForeground(Color.decode(cor));
            separador4.setForeground(Color.decode(cor));
            separador5.setForeground(Color.decode(cor));
            separador6.setForeground(Color.decode(cor));
            separador7.setForeground(Color.decode(cor));
            separador8.setForeground(Color.decode(cor));
            separador9.setForeground(Color.decode(cor));
            separador10.setForeground(Color.decode(cor));
            separador11.setForeground(Color.decode(cor));
            separador12.setForeground(Color.decode(cor));
            separador13.setForeground(Color.decode(cor));
            separador14.setForeground(Color.decode(cor));
            separador15.setForeground(Color.decode(cor));
            separador16.setForeground(Color.decode(cor));
            separador17.setForeground(Color.decode(cor));
            separador18.setForeground(Color.decode(cor));
            separador19.setForeground(Color.decode(cor));
            separador20.setForeground(Color.decode(cor));
            separador21.setForeground(Color.decode(cor));
            separador22.setForeground(Color.decode(cor));
            separador23.setForeground(Color.decode(cor));
            separador24.setForeground(Color.decode(cor));
            
            btnAbandonar.setForeground(Color.decode(cor));
            btnAvancar.setForeground(Color.decode(cor));
            
            btnGaragem1.setForeground(Color.decode(cor));
            btnGaragem2.setForeground(Color.decode(cor));
            
            btnMandaPista1.setForeground(Color.decode(cor));
            btnMandaPista2.setForeground(Color.decode(cor));
            
            btnVoltas1.setForeground(Color.decode(cor));
            btnVoltas2.setForeground(Color.decode(cor));
            
            selecaocompostos1.setBackground(Color.decode(cor));
            selecaocompostos2.setBackground(Color.decode(cor));
            
            selecaopilotagem1.setBackground(Color.decode(cor));
            selecaopilotagem2.setBackground(Color.decode(cor));
        } catch (IOException ex) {
            Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setapilotos(String db, String sav) throws IOException{
        int numpilotos = FuncoesGerais.totalpilotos(sav);
        maxpilotos = numpilotos;
        setadadosequipe(db, sav);
        String semtempotxt = "SEM TEMPO";
        if(numpilotos > 0){
            txtp1.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 1, sav), sav));
            txtep1.setText((Equipe.getNome(db, 1, sav)));
            txttempo1.setText(semtempotxt);
            txtpneu1.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 1), sav));
        }else{
            txtp1.setVisible(false);
            txtep1.setVisible(false);
            txttempo1.setVisible(false);
            separador1.setVisible(false);
            txtposi1.setVisible(false);
            txtpneu1.setVisible(false);
        }
        if(numpilotos > 1){
            txtp2.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 1, sav), sav));
            txtep2.setText((Equipe.getNome(db, 1, sav)));
            txttempo2.setText(semtempotxt);
            txtpneu2.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 2), sav));
        }else{
            txtp2.setVisible(false);
            txtep2.setVisible(false);
            txttempo2.setVisible(false);
            separador2.setVisible(false);
            txtposi2.setVisible(false);
            txtpneu2.setVisible(false);
        }
        if(numpilotos > 2){
            txtp3.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 2, sav), sav));
            txtep3.setText((Equipe.getNome(db, 2, sav)));
            txttempo3.setText(semtempotxt);
            txtpneu3.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 3), sav));
        }else{
            txtp3.setVisible(false);
            txtep3.setVisible(false);
            txttempo3.setVisible(false);
            separador3.setVisible(false);
            txtposi3.setVisible(false);
            txtpneu3.setVisible(false);
        }
        if(numpilotos > 3){
            txtp4.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 2, sav), sav));
            txtep4.setText((Equipe.getNome(db, 2, sav)));
            txttempo4.setText(semtempotxt);
            txtpneu4.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 4), sav));
        }else{
            txtp4.setVisible(false);
            txtep4.setVisible(false);
            txttempo4.setVisible(false);
            separador4.setVisible(false);
            txtposi4.setVisible(false);
            txtpneu4.setVisible(false);
        }
        if(numpilotos > 4){
            txtp5.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 3, sav), sav));
            txtep5.setText((Equipe.getNome(db, 3, sav)));
            txttempo5.setText(semtempotxt);
            txtpneu5.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 5), sav));
        }else{
            txtp5.setVisible(false);
            txtep5.setVisible(false);
            txttempo5.setVisible(false);
            separador5.setVisible(false);
            txtposi5.setVisible(false);
            txtpneu5.setVisible(false);
        }
        if(numpilotos > 5){
            txtp6.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 3, sav), sav));
            txtep6.setText((Equipe.getNome(db, 3, sav)));
            txttempo6.setText(semtempotxt);
            txtpneu6.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 6), sav));
        }else{
            txtp6.setVisible(false);
            txtep6.setVisible(false);
            txttempo6.setVisible(false);
            separador6.setVisible(false);
            txtposi6.setVisible(false);
            txtpneu6.setVisible(false);
        }
        if(numpilotos > 6){
            txtp7.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 4, sav), sav));
            txtep7.setText((Equipe.getNome(db, 4, sav)));
            txttempo7.setText(semtempotxt);
            txtpneu7.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 7), sav));
        }else{
            txtp7.setVisible(false);
            txtep7.setVisible(false);
            txttempo7.setVisible(false);
            separador7.setVisible(false);
            txtposi7.setVisible(false);
            txtpneu7.setVisible(false);
        }
        if(numpilotos > 7){
            txtp8.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 4, sav), sav));
            txtep8.setText((Equipe.getNome(db, 4, sav)));
            txttempo8.setText(semtempotxt);
            txtpneu8.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 8), sav));
        }else{
            txtp8.setVisible(false);
            txtep8.setVisible(false);
            txttempo8.setVisible(false);
            separador8.setVisible(false);
            txtposi8.setVisible(false);
            txtpneu8.setVisible(false);
        }
        if(numpilotos > 8){
            txtp9.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 5, sav), sav));
            txtep9.setText((Equipe.getNome(db, 5, sav)));
            txttempo9.setText(semtempotxt);
            txtpneu9.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 9), sav));
        }else{
            txtp9.setVisible(false);
            txtep9.setVisible(false);
            txttempo9.setVisible(false);
            separador9.setVisible(false);
            txtposi9.setVisible(false);
            txtpneu9.setVisible(false);
        }
        if(numpilotos > 9){
            txtp10.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 5, sav), sav));
            txtep10.setText((Equipe.getNome(db, 5, sav)));
            txttempo10.setText(semtempotxt);
            txtpneu10.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 10), sav));
        }else{
            txtp10.setVisible(false);
            txtep10.setVisible(false);
            txttempo10.setVisible(false);
            separador10.setVisible(false);
            txtposi10.setVisible(false);
            txtpneu10.setVisible(false);
        }
        if(numpilotos > 10){
            txtp11.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 6, sav), sav));
            txtep11.setText((Equipe.getNome(db, 6, sav)));
            txttempo11.setText(semtempotxt);
            txtpneu11.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 11), sav));
        }else{
            txtp11.setVisible(false);
            txtep11.setVisible(false);
            txttempo11.setVisible(false);
            separador11.setVisible(false);
            txtposi11.setVisible(false);
            txtpneu11.setVisible(false);
        }
        if(numpilotos > 11){
            txtp12.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 6, sav), sav));
            txtep12.setText((Equipe.getNome(db, 6, sav)));
            txttempo12.setText(semtempotxt);
            txtpneu12.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 12), sav));
        }else{
            txtp12.setVisible(false);
            txtep12.setVisible(false);
            txttempo12.setVisible(false);
            separador12.setVisible(false);
            txtposi12.setVisible(false);
            txtpneu12.setVisible(false);
        }
        if(numpilotos > 12){
            txtp13.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 7, sav), sav));
            txtep13.setText((Equipe.getNome(db, 7, sav)));
            txttempo13.setText(semtempotxt);
            txtpneu13.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 13), sav));
        }else{
            txtp13.setVisible(false);
            txtep13.setVisible(false);
            txttempo13.setVisible(false);
            separador13.setVisible(false);
            txtposi13.setVisible(false);
            txtpneu13.setVisible(false);
        }
        if(numpilotos > 13){
            txtp14.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 7, sav), sav));
            txtep14.setText((Equipe.getNome(db, 7, sav)));
            txttempo14.setText(semtempotxt);
            txtpneu14.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 14), sav));
        }else{
            txtp14.setVisible(false);
            txtep14.setVisible(false);
            txttempo14.setVisible(false);
            separador14.setVisible(false);
            txtposi14.setVisible(false);
            txtpneu14.setVisible(false);
        }
        if(numpilotos > 14){
            txtp15.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 8, sav), sav));
            txtep15.setText((Equipe.getNome(db, 8, sav)));
            txttempo15.setText(semtempotxt);
            txtpneu15.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 15), sav));
        }else{
            txtp15.setVisible(false);
            txtep15.setVisible(false);
            txttempo15.setVisible(false);
            separador15.setVisible(false);
            txtposi15.setVisible(false);
            txtpneu15.setVisible(false);
        }
        if(numpilotos > 15){
            txtp16.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 8, sav), sav));
            txtep16.setText((Equipe.getNome(db, 8, sav)));
            txttempo16.setText(semtempotxt);
            txtpneu16.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 16), sav));
        }else{
            txtp16.setVisible(false);
            txtep16.setVisible(false);
            txttempo16.setVisible(false);
            separador16.setVisible(false);
            txtposi16.setVisible(false);
            txtpneu16.setVisible(false);
        }
        if(numpilotos > 16){
            txtp17.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 9, sav), sav));
            txtep17.setText((Equipe.getNome(db, 9, sav)));
            txttempo17.setText(semtempotxt);
            txtpneu17.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 17), sav));
        }else{
            txtp17.setVisible(false);
            txtep17.setVisible(false);
            txttempo17.setVisible(false);
            separador17.setVisible(false);
            txtposi17.setVisible(false);
            txtpneu17.setVisible(false);
        }
        if(numpilotos > 17){
            txtp18.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 9, sav), sav));
            txtep18.setText((Equipe.getNome(db, 9, sav)));
            txttempo18.setText(semtempotxt);
            txtpneu18.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 18), sav));
        }else{
            txtp18.setVisible(false);
            txtep18.setVisible(false);
            txttempo18.setVisible(false);
            separador18.setVisible(false);
            txtposi18.setVisible(false);
            txtpneu18.setVisible(false);
        }
        if(numpilotos > 18){
            txtp19.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 10, sav), sav));
            txtep19.setText((Equipe.getNome(db, 10, sav)));
            txttempo19.setText(semtempotxt);
            txtpneu19.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 19), sav));
        }else{
            txtp19.setVisible(false);
            txtep19.setVisible(false);
            txttempo19.setVisible(false);
            separador19.setVisible(false);
            txtposi19.setVisible(false);
            txtpneu19.setVisible(false);
        }
        if(numpilotos > 19){
            txtp20.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 10, sav), sav));
            txtep20.setText((Equipe.getNome(db, 10, sav)));
            txttempo20.setText(semtempotxt);
            txtpneu20.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 20), sav));
        }else{
            txtp20.setVisible(false);
            txtep20.setVisible(false);
            txttempo20.setVisible(false);
            separador20.setVisible(false);
            txtposi20.setVisible(false);
            txtpneu20.setVisible(false);
        }
        if(numpilotos > 20){
            txtp21.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 11, sav), sav));
            txtep21.setText((Equipe.getNome(db, 11, sav)));
            txttempo21.setText(semtempotxt);
            txtpneu21.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 21), sav));
        }else{
            txtp21.setVisible(false);
            txtep21.setVisible(false);
            txttempo21.setVisible(false);
            separador21.setVisible(false);
            txtposi21.setVisible(false);
            txtpneu21.setVisible(false);
        }
        if(numpilotos > 21){
            txtp22.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 11, sav), sav));
            txtep22.setText((Equipe.getNome(db, 11, sav)));
            txttempo22.setText(semtempotxt);
            txtpneu22.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 22), sav));
        }else{
            txtp22.setVisible(false);
            txtep22.setVisible(false);
            txttempo22.setVisible(false);
            separador22.setVisible(false);
            txtposi22.setVisible(false);
            txtpneu22.setVisible(false);
        }
        if(numpilotos > 22){
            txtp23.setText(Piloto.getSobrenome(db, Equipe.getIdP1(db, 12, sav), sav));
            txtep23.setText((Equipe.getNome(db, 12, sav)));
            txttempo23.setText(semtempotxt);
            txtpneu23.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 23), sav));
        }else{
            txtp23.setVisible(false);
            txtep23.setVisible(false);
            txttempo23.setVisible(false);
            separador23.setVisible(false);
            txtposi23.setVisible(false);
            txtpneu23.setVisible(false);
        }
        if(numpilotos > 23){
            txtp24.setText(Piloto.getSobrenome(db, Equipe.getIdP2(db, 12, sav), sav));
            txtep24.setText((Equipe.getNome(db, 12, sav)));
            txttempo24.setText(semtempotxt);
            txtpneu24.setIcon(Pneu.getImagem3(dbb, FimSemana.retornapneuescolhido(sav, 24), sav));
        }else{
            txtp24.setVisible(false);
            txtep24.setVisible(false);
            txttempo24.setVisible(false);
            separador24.setVisible(false);
            txtposi24.setVisible(false);
            txtpneu24.setVisible(false);
        }
        
    }
    
    public void setadadosequipe(String db, String sav){
        try {
            int idp1 = Equipe.getIdP1(db, Equipe.getID(db, sav), sav);
            idp11 = idp1;
            int idp2 = Equipe.getIdP2(db, Equipe.getID(db, sav), sav);
            idp22 = idp2;
            String idcorrida = Integer.toString(Corrida.getCorridaAtual(db, sav));
            int idpneu1 = Integer.parseInt(Corrida.getPneu1(db, idcorrida, sav));
            idpneu11 = idpneu1;
            int idpneu2 = Integer.parseInt(Corrida.getPneu2(db, idcorrida, sav));
            idpneu22 = idpneu2;
            int idpneu3 = Integer.parseInt(Corrida.getPneu3(db, idcorrida, sav));
            idpneu33 = idpneu3;
            txtbarrap1.setText(Piloto.getSobrenome(db, idp1, sav));
            txtbarrap2.setText(Piloto.getSobrenome(db, idp2, sav));
            imgbarrap1.setIcon(Piloto.getImagem(db, idp1, sav));
            imgbarrap2.setIcon(Piloto.getImagem(db, idp2, sav));
            imgpneu1.setIcon(Pneu.getImagem(db, idpneu1, sav));
            txtpneu1comdesgaste.setText(Pneu.getNome(db, idpneu1, sav));
            imgpneu2.setIcon(Pneu.getImagem(db, idpneu1, sav));
            txtpneu2comdesgaste.setText(Pneu.getNome(db, idpneu1, sav));
            
            setacompostosselecao();
        } catch (IOException ex) {
            Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setacompostosselecao() throws IOException{
        for (int i = 1; i < 14; i++) {
            String nomepneu1 = Pneu.getNome(dbb, idpneu11, savee);
            String desgastepneup1 = FimSemana.retornaDesgaste(savee, idp11, i);
            desgastepneup11 = desgastepneup1;
            String nomepneu2 = Pneu.getNome(dbb, idpneu22, savee);
            String desgastepneup2 = FimSemana.retornaDesgaste(savee, idp11, i);
            desgastepneup22 = desgastepneup2;
            String nomepneu3 = Pneu.getNome(dbb, idpneu33, savee);
            try {
                if(Integer.parseInt(FimSemana.retornaRelacao(savee, idp11, i)) == (idpneu11)){
                    selecaocompostos1.addItem("("+desgastepneup1+"%) "+nomepneu1);
                }
                if(Integer.parseInt(FimSemana.retornaRelacao(savee, idp11, i)) == (idpneu22)){
                    selecaocompostos1.addItem("("+desgastepneup1+"%) "+nomepneu2);
                }
                if(Integer.parseInt(FimSemana.retornaRelacao(savee, idp11, i)) == (idpneu33)){
                    selecaocompostos1.addItem("("+desgastepneup1+"%) "+nomepneu3);
                }
            } catch (IOException ex) {
                Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                if(Integer.parseInt(FimSemana.retornaRelacao(savee, idp22, i)) == (idpneu11)){
                    selecaocompostos2.addItem("("+desgastepneup2+"%) "+nomepneu1);
                }
                if(Integer.parseInt(FimSemana.retornaRelacao(savee, idp22, i)) == (idpneu22)){
                    selecaocompostos2.addItem("("+desgastepneup2+"%) "+nomepneu2);
                }
                if(Integer.parseInt(FimSemana.retornaRelacao(savee, idp22, i)) == (idpneu33)){
                    selecaocompostos2.addItem("("+desgastepneup2+"%) "+nomepneu3);
                }
            } catch (IOException ex) {
                Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
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

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        imgbarrap1 = new javax.swing.JLabel();
        txtbarrap1 = new javax.swing.JLabel();
        txtbarrap2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        imgbarrap2 = new javax.swing.JLabel();
        btnAbandonar = new javax.swing.JButton();
        btnMandaPista1 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btnMandaPista2 = new javax.swing.JButton();
        btnAvancar = new javax.swing.JButton();
        selecaopilotagem1 = new javax.swing.JComboBox<>();
        txdtultimavolta2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtultimavolta1 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        selecaopilotagem2 = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        selecaocompostos2 = new javax.swing.JComboBox<>();
        selecaocompostos1 = new javax.swing.JComboBox<>();
        txtpneu2comdesgaste = new javax.swing.JLabel();
        imgpneu2 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        imgpneu1 = new javax.swing.JLabel();
        txtpneuatual2 = new javax.swing.JLabel();
        txtpneuatual1 = new javax.swing.JLabel();
        txtpneu1comdesgaste = new javax.swing.JLabel();
        btnGaragem1 = new javax.swing.JButton();
        btnVoltas1 = new javax.swing.JButton();
        btnGaragem2 = new javax.swing.JButton();
        btnVoltas2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtp1 = new javax.swing.JLabel();
        txtep1 = new javax.swing.JLabel();
        txttempo1 = new javax.swing.JLabel();
        separador1 = new javax.swing.JSeparator();
        txtp2 = new javax.swing.JLabel();
        separador2 = new javax.swing.JSeparator();
        txtep2 = new javax.swing.JLabel();
        txttempo2 = new javax.swing.JLabel();
        txtp3 = new javax.swing.JLabel();
        separador3 = new javax.swing.JSeparator();
        txtep3 = new javax.swing.JLabel();
        txttempo3 = new javax.swing.JLabel();
        txtp4 = new javax.swing.JLabel();
        separador4 = new javax.swing.JSeparator();
        txtep4 = new javax.swing.JLabel();
        txttempo4 = new javax.swing.JLabel();
        txtp5 = new javax.swing.JLabel();
        separador5 = new javax.swing.JSeparator();
        txtep5 = new javax.swing.JLabel();
        txttempo5 = new javax.swing.JLabel();
        txtp6 = new javax.swing.JLabel();
        separador6 = new javax.swing.JSeparator();
        txtep6 = new javax.swing.JLabel();
        txttempo6 = new javax.swing.JLabel();
        txtp7 = new javax.swing.JLabel();
        separador7 = new javax.swing.JSeparator();
        txtep7 = new javax.swing.JLabel();
        txttempo7 = new javax.swing.JLabel();
        txtp8 = new javax.swing.JLabel();
        separador8 = new javax.swing.JSeparator();
        txtep8 = new javax.swing.JLabel();
        txttempo8 = new javax.swing.JLabel();
        txtp9 = new javax.swing.JLabel();
        separador9 = new javax.swing.JSeparator();
        txtep9 = new javax.swing.JLabel();
        txttempo9 = new javax.swing.JLabel();
        txtp10 = new javax.swing.JLabel();
        separador10 = new javax.swing.JSeparator();
        txtep10 = new javax.swing.JLabel();
        txttempo10 = new javax.swing.JLabel();
        txtp12 = new javax.swing.JLabel();
        separador12 = new javax.swing.JSeparator();
        txtep11 = new javax.swing.JLabel();
        txttempo11 = new javax.swing.JLabel();
        txtp13 = new javax.swing.JLabel();
        separador13 = new javax.swing.JSeparator();
        txtep12 = new javax.swing.JLabel();
        txtp11 = new javax.swing.JLabel();
        separador11 = new javax.swing.JSeparator();
        txttempo12 = new javax.swing.JLabel();
        txtp14 = new javax.swing.JLabel();
        txtep14 = new javax.swing.JLabel();
        txttempo14 = new javax.swing.JLabel();
        separador14 = new javax.swing.JSeparator();
        txtp15 = new javax.swing.JLabel();
        txtep15 = new javax.swing.JLabel();
        txttempo15 = new javax.swing.JLabel();
        separador15 = new javax.swing.JSeparator();
        txtp16 = new javax.swing.JLabel();
        txtep16 = new javax.swing.JLabel();
        txttempo16 = new javax.swing.JLabel();
        separador16 = new javax.swing.JSeparator();
        txtp17 = new javax.swing.JLabel();
        txtep17 = new javax.swing.JLabel();
        txttempo17 = new javax.swing.JLabel();
        separador17 = new javax.swing.JSeparator();
        txtp18 = new javax.swing.JLabel();
        txtep18 = new javax.swing.JLabel();
        txttempo18 = new javax.swing.JLabel();
        separador18 = new javax.swing.JSeparator();
        txtp19 = new javax.swing.JLabel();
        txtep19 = new javax.swing.JLabel();
        txttempo19 = new javax.swing.JLabel();
        separador19 = new javax.swing.JSeparator();
        txtp20 = new javax.swing.JLabel();
        txtep20 = new javax.swing.JLabel();
        txttempo20 = new javax.swing.JLabel();
        separador20 = new javax.swing.JSeparator();
        txtp21 = new javax.swing.JLabel();
        txtep21 = new javax.swing.JLabel();
        txttempo21 = new javax.swing.JLabel();
        separador21 = new javax.swing.JSeparator();
        txtp22 = new javax.swing.JLabel();
        txtep22 = new javax.swing.JLabel();
        txttempo22 = new javax.swing.JLabel();
        separador22 = new javax.swing.JSeparator();
        txtp23 = new javax.swing.JLabel();
        txtep23 = new javax.swing.JLabel();
        txttempo23 = new javax.swing.JLabel();
        separador23 = new javax.swing.JSeparator();
        txtp24 = new javax.swing.JLabel();
        txtep24 = new javax.swing.JLabel();
        txttempo24 = new javax.swing.JLabel();
        separador24 = new javax.swing.JSeparator();
        txtep13 = new javax.swing.JLabel();
        txttempo13 = new javax.swing.JLabel();
        txtposi1 = new javax.swing.JLabel();
        txtposi2 = new javax.swing.JLabel();
        txtposi3 = new javax.swing.JLabel();
        txtposi4 = new javax.swing.JLabel();
        txtposi5 = new javax.swing.JLabel();
        txtposi6 = new javax.swing.JLabel();
        txtposi7 = new javax.swing.JLabel();
        txtposi8 = new javax.swing.JLabel();
        txtposi9 = new javax.swing.JLabel();
        txtposi10 = new javax.swing.JLabel();
        txtposi11 = new javax.swing.JLabel();
        txtposi12 = new javax.swing.JLabel();
        txtposi13 = new javax.swing.JLabel();
        txtposi14 = new javax.swing.JLabel();
        txtposi15 = new javax.swing.JLabel();
        txtposi16 = new javax.swing.JLabel();
        txtposi17 = new javax.swing.JLabel();
        txtposi18 = new javax.swing.JLabel();
        txtposi19 = new javax.swing.JLabel();
        txtposi20 = new javax.swing.JLabel();
        txtposi21 = new javax.swing.JLabel();
        txtposi22 = new javax.swing.JLabel();
        txtposi23 = new javax.swing.JLabel();
        txtposi24 = new javax.swing.JLabel();
        txtpneu1 = new javax.swing.JLabel();
        txtpneu2 = new javax.swing.JLabel();
        txtpneu3 = new javax.swing.JLabel();
        txtpneu4 = new javax.swing.JLabel();
        txtpneu5 = new javax.swing.JLabel();
        txtpneu6 = new javax.swing.JLabel();
        txtpneu24 = new javax.swing.JLabel();
        txtpneu23 = new javax.swing.JLabel();
        txtpneu22 = new javax.swing.JLabel();
        txtpneu21 = new javax.swing.JLabel();
        txtpneu20 = new javax.swing.JLabel();
        txtpneu18 = new javax.swing.JLabel();
        txtpneu17 = new javax.swing.JLabel();
        txtpneu16 = new javax.swing.JLabel();
        txtpneu15 = new javax.swing.JLabel();
        txtpneu14 = new javax.swing.JLabel();
        txtpneu13 = new javax.swing.JLabel();
        txtpneu19 = new javax.swing.JLabel();
        txtpneu12 = new javax.swing.JLabel();
        txtpneu11 = new javax.swing.JLabel();
        txtpneu10 = new javax.swing.JLabel();
        txtpneu9 = new javax.swing.JLabel();
        txtpneu8 = new javax.swing.JLabel();
        txtpneu7 = new javax.swing.JLabel();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
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

        imgbarrap1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/piloto1.png"))); // NOI18N
        imgbarrap1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(imgbarrap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        txtbarrap1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtbarrap1.setForeground(new java.awt.Color(255, 255, 255));
        txtbarrap1.setText("PILOTO 1");
        jPanel1.add(txtbarrap1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 195, -1));

        txtbarrap2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtbarrap2.setForeground(new java.awt.Color(255, 255, 255));
        txtbarrap2.setText("PILOTO 2");
        jPanel1.add(txtbarrap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 215, 8));

        imgbarrap2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/piloto2.png"))); // NOI18N
        imgbarrap2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(imgbarrap2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        btnAbandonar.setBackground(new java.awt.Color(255, 255, 255));
        btnAbandonar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAbandonar.setText("Abandonar Treino");
        jPanel1.add(btnAbandonar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 210, 40));

        btnMandaPista1.setBackground(new java.awt.Color(255, 255, 255));
        btnMandaPista1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnMandaPista1.setForeground(new java.awt.Color(51, 51, 51));
        btnMandaPista1.setText("Mandar a Pista");
        jPanel1.add(btnMandaPista1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 100, 30));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 215, 8));

        btnMandaPista2.setBackground(new java.awt.Color(255, 255, 255));
        btnMandaPista2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnMandaPista2.setText("Mandar a Pista");
        jPanel1.add(btnMandaPista2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 410, 100, 30));

        btnAvancar.setBackground(new java.awt.Color(255, 255, 255));
        btnAvancar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAvancar.setText("Avançar 5 Minutos");
        jPanel1.add(btnAvancar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 570, 210, 40));

        selecaopilotagem1.setBackground(new java.awt.Color(51, 51, 51));
        selecaopilotagem1.setForeground(new java.awt.Color(255, 255, 255));
        selecaopilotagem1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agressivo", "Normal", "Poupar" }));
        jPanel1.add(selecaopilotagem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 140, 20));

        txdtultimavolta2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txdtultimavolta2.setForeground(new java.awt.Color(255, 255, 255));
        txdtultimavolta2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txdtultimavolta2.setText("ÚLTIMA VOLTA: XX:XX.XXX");
        jPanel1.add(txdtultimavolta2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 210, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("PILOTAGEM");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, 20));

        txtultimavolta1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtultimavolta1.setForeground(new java.awt.Color(255, 255, 255));
        txtultimavolta1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtultimavolta1.setText("ÚLTIMA VOLTA: XX:XX.XXX");
        jPanel1.add(txtultimavolta1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 210, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("PILOTAGEM");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 510, -1, 20));

        selecaopilotagem2.setBackground(new java.awt.Color(51, 51, 51));
        selecaopilotagem2.setForeground(new java.awt.Color(255, 255, 255));
        selecaopilotagem2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Agressivo", "Normal", "Poupar" }));
        jPanel1.add(selecaopilotagem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 510, 140, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("COMPOSTO");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, 20));

        selecaocompostos2.setBackground(new java.awt.Color(51, 51, 51));
        selecaocompostos2.setForeground(new java.awt.Color(255, 255, 255));
        selecaocompostos2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaocompostos2ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaocompostos2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 480, 140, 20));

        selecaocompostos1.setBackground(new java.awt.Color(51, 51, 51));
        selecaocompostos1.setForeground(new java.awt.Color(255, 255, 255));
        selecaocompostos1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaocompostos1ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaocompostos1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 60, 140, 20));

        txtpneu2comdesgaste.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu2comdesgaste.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu2comdesgaste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu2comdesgaste.setText("PNEU  (%XX)");
        jPanel1.add(txtpneu2comdesgaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 420, 120, 30));

        imgpneu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(imgpneu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("COMPOSTO");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 20));

        imgpneu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(imgpneu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, -1, -1));

        txtpneuatual2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneuatual2.setForeground(new java.awt.Color(255, 255, 255));
        txtpneuatual2.setText("PNEU ATUAL");
        jPanel1.add(txtpneuatual2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 30));

        txtpneuatual1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneuatual1.setForeground(new java.awt.Color(255, 255, 255));
        txtpneuatual1.setText("PNEU ATUAL");
        jPanel1.add(txtpneuatual1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, -1, 30));

        txtpneu1comdesgaste.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu1comdesgaste.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu1comdesgaste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu1comdesgaste.setText("PNEU (%XX)");
        jPanel1.add(txtpneu1comdesgaste, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 120, 120, 30));

        btnGaragem1.setBackground(new java.awt.Color(255, 255, 255));
        btnGaragem1.setForeground(new java.awt.Color(51, 51, 51));
        btnGaragem1.setText("GARAGEM");
        jPanel1.add(btnGaragem1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 100, 20));

        btnVoltas1.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltas1.setForeground(new java.awt.Color(51, 51, 51));
        btnVoltas1.setText("VOLTAS");
        jPanel1.add(btnVoltas1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 100, 20));

        btnGaragem2.setBackground(new java.awt.Color(255, 255, 255));
        btnGaragem2.setForeground(new java.awt.Color(51, 51, 51));
        btnGaragem2.setText("GARAGEM");
        jPanel1.add(btnGaragem2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 100, 20));

        btnVoltas2.setBackground(new java.awt.Color(255, 255, 255));
        btnVoltas2.setForeground(new java.awt.Color(51, 51, 51));
        btnVoltas2.setText("VOLTAS");
        jPanel1.add(btnVoltas2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 450, 100, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 0, 230, 670));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel2MouseDragged(evt);
            }
        });
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel2MousePressed(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("FIM DE SEMANA - TREINO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/relogio3.png"))); // NOI18N
        jLabel6.setText(" TEMPO RESTANTE: ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/relogio3.png"))); // NOI18N
        jLabel7.setText(" 60 MINUTOS");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 214, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 460, -1));

        jPanel4.setBackground(new java.awt.Color(51, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("TEMPOS");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 11, 386, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/usuario3.png"))); // NOI18N
        jLabel9.setText(" PILOTO");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 44, -1, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/relogio3.png"))); // NOI18N
        jLabel10.setText("MELHOR TEMPO");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 44, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("EQUIPE");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 47, 69, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("P");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 21, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3invertido.png"))); // NOI18N
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 30, 30));

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 460, -1));

        txtp1.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp1.setText("PILOTO 1");
        jPanel2.add(txtp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, 150, 20));

        txtep1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep1.setText("EQUIPE 1");
        jPanel2.add(txtep1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 100, 20));

        txttempo1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo1.setText("XX:XX:XXX");
        jPanel2.add(txttempo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 130, 20));
        jPanel2.add(separador1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 460, 10));

        txtp2.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp2.setText("PILOTO 2");
        jPanel2.add(txtp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 150, 20));
        jPanel2.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 460, 10));

        txtep2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep2.setText("EQUIPE 1");
        jPanel2.add(txtep2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 200, 100, 20));

        txttempo2.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo2.setText("XX:XX:XXX");
        jPanel2.add(txttempo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 130, 20));

        txtp3.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp3.setText("PILOTO 3");
        jPanel2.add(txtp3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 150, 20));
        jPanel2.add(separador3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 460, 10));

        txtep3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep3.setText("EQUIPE 2");
        jPanel2.add(txtep3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 220, 100, 20));

        txttempo3.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo3.setText("XX:XX:XXX");
        jPanel2.add(txttempo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, 130, 20));

        txtp4.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp4.setText("PILOTO 4");
        jPanel2.add(txtp4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 150, 20));
        jPanel2.add(separador4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 460, 10));

        txtep4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep4.setText("EQUIPE 2");
        jPanel2.add(txtep4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 100, 20));

        txttempo4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo4.setText("XX:XX:XXX");
        jPanel2.add(txttempo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 130, 20));

        txtp5.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp5.setText("PILOTO 5");
        jPanel2.add(txtp5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 260, 150, 20));
        jPanel2.add(separador5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 460, 10));

        txtep5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep5.setText("EQUIPE 3");
        jPanel2.add(txtep5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, 100, 20));

        txttempo5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo5.setText("XX:XX:XXX");
        jPanel2.add(txttempo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 260, 130, 20));

        txtp6.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp6.setText("PILOTO 6");
        jPanel2.add(txtp6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 150, 20));
        jPanel2.add(separador6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 460, 10));

        txtep6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep6.setText("EQUIPE 3");
        jPanel2.add(txtep6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 280, 100, 20));

        txttempo6.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo6.setText("XX:XX:XXX");
        jPanel2.add(txttempo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 280, 130, 20));

        txtp7.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp7.setText("PILOTO 7");
        jPanel2.add(txtp7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 150, 20));
        jPanel2.add(separador7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 460, 10));

        txtep7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep7.setText("EQUIPE 4");
        jPanel2.add(txtep7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 300, 100, 20));

        txttempo7.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo7.setText("XX:XX:XXX");
        jPanel2.add(txttempo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 130, 20));

        txtp8.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp8.setText("PILOTO 8");
        jPanel2.add(txtp8, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 320, 150, 20));
        jPanel2.add(separador8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 460, 10));

        txtep8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep8.setText("EQUIPE 4");
        jPanel2.add(txtep8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 320, 100, 20));

        txttempo8.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo8.setText("XX:XX:XXX");
        jPanel2.add(txttempo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 320, 130, 20));

        txtp9.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp9.setText("PILOTO 9");
        jPanel2.add(txtp9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 150, 20));
        jPanel2.add(separador9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 460, 10));

        txtep9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep9.setText("EQUIPE 5");
        jPanel2.add(txtep9, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 100, 20));

        txttempo9.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo9.setText("XX:XX:XXX");
        jPanel2.add(txttempo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 130, 20));

        txtp10.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp10.setText("PILOTO 10");
        jPanel2.add(txtp10, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 360, 150, 20));
        jPanel2.add(separador10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 460, 10));

        txtep10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep10.setText("EQUIPE 5");
        jPanel2.add(txtep10, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 100, 20));

        txttempo10.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo10.setText("XX:XX:XXX");
        jPanel2.add(txttempo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, 130, 20));

        txtp12.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp12.setText("PILOTO 12");
        jPanel2.add(txtp12, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 400, 150, 20));
        jPanel2.add(separador12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 460, 10));

        txtep11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep11.setText("EQUIPE 6");
        jPanel2.add(txtep11, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 380, 100, 20));

        txttempo11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo11.setText("XX:XX:XXX");
        jPanel2.add(txttempo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, 130, 20));

        txtp13.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp13.setText("PILOTO 13");
        jPanel2.add(txtp13, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 420, 150, 20));
        jPanel2.add(separador13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 460, 10));

        txtep12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep12.setText("EQUIPE 7");
        jPanel2.add(txtep12, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 400, 100, 20));

        txtp11.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp11.setText("PILOTO 11");
        jPanel2.add(txtp11, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 150, 20));
        jPanel2.add(separador11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 460, 10));

        txttempo12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo12.setText("XX:XX:XXX");
        jPanel2.add(txttempo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, 130, 20));

        txtp14.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp14.setText("PILOTO 14");
        jPanel2.add(txtp14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 150, 20));

        txtep14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep14.setText("EQUIPE 7");
        jPanel2.add(txtep14, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, 100, 20));

        txttempo14.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo14.setText("XX:XX:XXX");
        jPanel2.add(txttempo14, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 440, 130, 20));
        jPanel2.add(separador14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 460, 10));

        txtp15.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp15.setText("PILOTO 15");
        jPanel2.add(txtp15, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 460, 150, 20));

        txtep15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep15.setText("EQUIPE 8");
        jPanel2.add(txtep15, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 460, 100, 20));

        txttempo15.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo15.setText("XX:XX:XXX");
        jPanel2.add(txttempo15, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 460, 130, 20));
        jPanel2.add(separador15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 460, 10));

        txtp16.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp16.setText("PILOTO 16");
        jPanel2.add(txtp16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 150, 20));

        txtep16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep16.setText("EQUIPE 8");
        jPanel2.add(txtep16, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, 100, 20));

        txttempo16.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo16.setText("XX:XX:XXX");
        jPanel2.add(txttempo16, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 130, 20));
        jPanel2.add(separador16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 460, 10));

        txtp17.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp17.setText("PILOTO 17");
        jPanel2.add(txtp17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 500, 150, 20));

        txtep17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep17.setText("EQUIPE 9");
        jPanel2.add(txtep17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 100, 20));

        txttempo17.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo17.setText("XX:XX:XXX");
        jPanel2.add(txttempo17, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 500, 130, 20));
        jPanel2.add(separador17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 460, 10));

        txtp18.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp18.setText("PILOTO 18");
        jPanel2.add(txtp18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 150, 20));

        txtep18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep18.setText("EQUIPE 9");
        jPanel2.add(txtep18, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 520, 100, 20));

        txttempo18.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo18.setText("XX:XX:XXX");
        jPanel2.add(txttempo18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 520, 130, 20));
        jPanel2.add(separador18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 460, 10));

        txtp19.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp19.setText("PILOTO 19");
        jPanel2.add(txtp19, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 540, 150, 20));

        txtep19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep19.setText("EQUIPE 10");
        jPanel2.add(txtep19, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, 100, 20));

        txttempo19.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo19.setText("XX:XX:XXX");
        jPanel2.add(txttempo19, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 540, 130, 20));
        jPanel2.add(separador19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 460, 10));

        txtp20.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp20.setText("PILOTO 20");
        jPanel2.add(txtp20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 150, 20));

        txtep20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep20.setText("EQUIPE 10");
        jPanel2.add(txtep20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 560, 100, 20));

        txttempo20.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo20.setText("XX:XX:XXX");
        jPanel2.add(txttempo20, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 560, 130, 20));
        jPanel2.add(separador20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 460, 10));

        txtp21.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp21.setText("PILOTO 21");
        jPanel2.add(txtp21, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 580, 150, 20));

        txtep21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep21.setText("EQUIPE 11");
        jPanel2.add(txtep21, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 580, 100, 20));

        txttempo21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo21.setText("XX:XX:XXX");
        jPanel2.add(txttempo21, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 580, 130, 20));
        jPanel2.add(separador21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 460, 10));

        txtp22.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp22.setText("PILOTO 22");
        jPanel2.add(txtp22, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 600, 150, 20));

        txtep22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep22.setText("EQUIPE 11");
        jPanel2.add(txtep22, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, 100, 20));

        txttempo22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo22.setText("XX:XX:XXX");
        jPanel2.add(txttempo22, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 600, 130, 20));
        jPanel2.add(separador22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 460, 10));

        txtp23.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp23.setText("PILOTO 23");
        jPanel2.add(txtp23, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 620, 150, 20));

        txtep23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep23.setText("EQUIPE 12");
        jPanel2.add(txtep23, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 620, 100, 20));

        txttempo23.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo23.setText("XX:XX:XXX");
        jPanel2.add(txttempo23, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 620, 130, 20));
        jPanel2.add(separador23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 460, 10));

        txtp24.setFont(new java.awt.Font("Tahoma", 1, 10)); // NOI18N
        txtp24.setText("PILOTO 24");
        jPanel2.add(txtp24, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 640, 150, 20));

        txtep24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep24.setText("EQUIPE 12");
        jPanel2.add(txtep24, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 640, 100, 20));

        txttempo24.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo24.setText("XX:XX:XXX");
        jPanel2.add(txttempo24, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 640, 130, 20));
        jPanel2.add(separador24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 660, 460, 10));

        txtep13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtep13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtep13.setText("EQUIPE 6");
        jPanel2.add(txtep13, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, 100, 20));

        txttempo13.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txttempo13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txttempo13.setText("XX:XX:XXX");
        jPanel2.add(txttempo13, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 130, 20));

        txtposi1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi1.setForeground(new java.awt.Color(51, 51, 51));
        txtposi1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi1.setText("1");
        jPanel2.add(txtposi1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 21, 20));

        txtposi2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi2.setForeground(new java.awt.Color(51, 51, 51));
        txtposi2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi2.setText("2");
        jPanel2.add(txtposi2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 21, 20));

        txtposi3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi3.setForeground(new java.awt.Color(51, 51, 51));
        txtposi3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi3.setText("3");
        jPanel2.add(txtposi3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 21, 20));

        txtposi4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi4.setForeground(new java.awt.Color(51, 51, 51));
        txtposi4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi4.setText("4");
        jPanel2.add(txtposi4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 21, 20));

        txtposi5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi5.setForeground(new java.awt.Color(51, 51, 51));
        txtposi5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi5.setText("5");
        jPanel2.add(txtposi5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, 21, 20));

        txtposi6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi6.setForeground(new java.awt.Color(51, 51, 51));
        txtposi6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi6.setText("6");
        jPanel2.add(txtposi6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 21, 20));

        txtposi7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi7.setForeground(new java.awt.Color(51, 51, 51));
        txtposi7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi7.setText("7");
        jPanel2.add(txtposi7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 21, 20));

        txtposi8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi8.setForeground(new java.awt.Color(51, 51, 51));
        txtposi8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi8.setText("8");
        jPanel2.add(txtposi8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 21, 20));

        txtposi9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi9.setForeground(new java.awt.Color(51, 51, 51));
        txtposi9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi9.setText("9");
        jPanel2.add(txtposi9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 21, 20));

        txtposi10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi10.setForeground(new java.awt.Color(51, 51, 51));
        txtposi10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi10.setText("10");
        jPanel2.add(txtposi10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 21, 20));

        txtposi11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi11.setForeground(new java.awt.Color(51, 51, 51));
        txtposi11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi11.setText("11");
        jPanel2.add(txtposi11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 21, 20));

        txtposi12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi12.setForeground(new java.awt.Color(51, 51, 51));
        txtposi12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi12.setText("12");
        jPanel2.add(txtposi12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 21, 20));

        txtposi13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi13.setForeground(new java.awt.Color(51, 51, 51));
        txtposi13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi13.setText("13");
        jPanel2.add(txtposi13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 21, 20));

        txtposi14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi14.setForeground(new java.awt.Color(51, 51, 51));
        txtposi14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi14.setText("14");
        jPanel2.add(txtposi14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 21, 20));

        txtposi15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi15.setForeground(new java.awt.Color(51, 51, 51));
        txtposi15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi15.setText("15");
        jPanel2.add(txtposi15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, 21, 20));

        txtposi16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi16.setForeground(new java.awt.Color(51, 51, 51));
        txtposi16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi16.setText("16");
        jPanel2.add(txtposi16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 21, 20));

        txtposi17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi17.setForeground(new java.awt.Color(51, 51, 51));
        txtposi17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi17.setText("17");
        jPanel2.add(txtposi17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 21, 20));

        txtposi18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi18.setForeground(new java.awt.Color(51, 51, 51));
        txtposi18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi18.setText("18");
        jPanel2.add(txtposi18, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, 21, 20));

        txtposi19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi19.setForeground(new java.awt.Color(51, 51, 51));
        txtposi19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi19.setText("19");
        jPanel2.add(txtposi19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 540, 21, 20));

        txtposi20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi20.setForeground(new java.awt.Color(51, 51, 51));
        txtposi20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi20.setText("20");
        jPanel2.add(txtposi20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 21, 20));

        txtposi21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi21.setForeground(new java.awt.Color(51, 51, 51));
        txtposi21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi21.setText("21");
        jPanel2.add(txtposi21, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 580, 21, 20));

        txtposi22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi22.setForeground(new java.awt.Color(51, 51, 51));
        txtposi22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi22.setText("22");
        jPanel2.add(txtposi22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 600, 21, 20));

        txtposi23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi23.setForeground(new java.awt.Color(51, 51, 51));
        txtposi23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi23.setText("23");
        jPanel2.add(txtposi23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 620, 21, 20));

        txtposi24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtposi24.setForeground(new java.awt.Color(51, 51, 51));
        txtposi24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtposi24.setText("24");
        jPanel2.add(txtposi24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 640, 21, 20));

        txtpneu1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu1.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 180, 30, 20));

        txtpneu2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu2.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 30, 20));

        txtpneu3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu3.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 30, 20));

        txtpneu4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu4.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 30, 20));

        txtpneu5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu5.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 30, 20));

        txtpneu6.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu6.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 30, 20));

        txtpneu24.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu24.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 640, 30, 20));

        txtpneu23.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu23.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 620, 30, -1));

        txtpneu22.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu22.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 30, 20));

        txtpneu21.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu21.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 580, 30, 20));

        txtpneu20.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu20.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 30, -1));

        txtpneu18.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu18.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 30, 20));

        txtpneu17.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu17.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 30, 20));

        txtpneu16.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu16.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 30, 20));

        txtpneu15.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu15.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 30, -1));

        txtpneu14.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu14.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, 30, 20));

        txtpneu13.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu13.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 30, 20));

        txtpneu19.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu19.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 30, 20));

        txtpneu12.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu12.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 30, 20));

        txtpneu11.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu11.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 30, 20));

        txtpneu10.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu10.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 30, 20));

        txtpneu9.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu9.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 30, 20));

        txtpneu8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu8.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 30, 20));

        txtpneu7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtpneu7.setForeground(new java.awt.Color(255, 255, 255));
        txtpneu7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu3.png"))); // NOI18N
        jPanel2.add(txtpneu7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 30, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 480, 670));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point.x = evt.getX();
        point.y = evt.getY();   
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MousePressed
        point.x = evt.getX();
        point.y = evt.getY();   
    }//GEN-LAST:event_jPanel2MousePressed

    private void jPanel2MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel2MouseDragged

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void selecaocompostos1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaocompostos1ActionPerformed
        int index = selecaocompostos1.getSelectedIndex();
        index++;
        try {
            int pneu1 = Integer.parseInt(FimSemana.retornaRelacao(savee, idp11, index));
            txtpneu1comdesgaste.setText("("+desgastepneup11+"%) "+Pneu.getNome(dbb, pneu1, savee));
            imgpneu1.setIcon(Pneu.getImagem(dbb, pneu1, savee));
        } catch (IOException ex) {
            Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selecaocompostos1ActionPerformed

    private void selecaocompostos2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaocompostos2ActionPerformed
        int index = selecaocompostos2.getSelectedIndex();
        index++;
        try {
            int pneu2 = Integer.parseInt(FimSemana.retornaRelacao(savee, idp22, index));
            txtpneu2comdesgaste.setText("("+desgastepneup22+"%) "+Pneu.getNome(dbb, pneu2, savee));
            imgpneu2.setIcon(Pneu.getImagem(dbb, pneu2, savee));
        } catch (IOException ex) {
            Logger.getLogger(FDSTreino.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selecaocompostos2ActionPerformed

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
            java.util.logging.Logger.getLogger(FDSTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FDSTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FDSTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FDSTreino.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FDSTreino().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbandonar;
    private javax.swing.JButton btnAvancar;
    private javax.swing.JButton btnGaragem1;
    private javax.swing.JButton btnGaragem2;
    private javax.swing.JButton btnMandaPista1;
    private javax.swing.JButton btnMandaPista2;
    private javax.swing.JButton btnVoltas1;
    private javax.swing.JButton btnVoltas2;
    private javax.swing.JLabel imgbarrap1;
    private javax.swing.JLabel imgbarrap2;
    private javax.swing.JLabel imgpneu1;
    private javax.swing.JLabel imgpneu2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> selecaocompostos1;
    private javax.swing.JComboBox<String> selecaocompostos2;
    private javax.swing.JComboBox<String> selecaopilotagem1;
    private javax.swing.JComboBox<String> selecaopilotagem2;
    private javax.swing.JSeparator separador1;
    private javax.swing.JSeparator separador10;
    private javax.swing.JSeparator separador11;
    private javax.swing.JSeparator separador12;
    private javax.swing.JSeparator separador13;
    private javax.swing.JSeparator separador14;
    private javax.swing.JSeparator separador15;
    private javax.swing.JSeparator separador16;
    private javax.swing.JSeparator separador17;
    private javax.swing.JSeparator separador18;
    private javax.swing.JSeparator separador19;
    private javax.swing.JSeparator separador2;
    private javax.swing.JSeparator separador20;
    private javax.swing.JSeparator separador21;
    private javax.swing.JSeparator separador22;
    private javax.swing.JSeparator separador23;
    private javax.swing.JSeparator separador24;
    private javax.swing.JSeparator separador3;
    private javax.swing.JSeparator separador4;
    private javax.swing.JSeparator separador5;
    private javax.swing.JSeparator separador6;
    private javax.swing.JSeparator separador7;
    private javax.swing.JSeparator separador8;
    private javax.swing.JSeparator separador9;
    private javax.swing.JLabel txdtultimavolta2;
    private javax.swing.JLabel txtbarrap1;
    private javax.swing.JLabel txtbarrap2;
    private javax.swing.JLabel txtep1;
    private javax.swing.JLabel txtep10;
    private javax.swing.JLabel txtep11;
    private javax.swing.JLabel txtep12;
    private javax.swing.JLabel txtep13;
    private javax.swing.JLabel txtep14;
    private javax.swing.JLabel txtep15;
    private javax.swing.JLabel txtep16;
    private javax.swing.JLabel txtep17;
    private javax.swing.JLabel txtep18;
    private javax.swing.JLabel txtep19;
    private javax.swing.JLabel txtep2;
    private javax.swing.JLabel txtep20;
    private javax.swing.JLabel txtep21;
    private javax.swing.JLabel txtep22;
    private javax.swing.JLabel txtep23;
    private javax.swing.JLabel txtep24;
    private javax.swing.JLabel txtep3;
    private javax.swing.JLabel txtep4;
    private javax.swing.JLabel txtep5;
    private javax.swing.JLabel txtep6;
    private javax.swing.JLabel txtep7;
    private javax.swing.JLabel txtep8;
    private javax.swing.JLabel txtep9;
    private javax.swing.JLabel txtp1;
    private javax.swing.JLabel txtp10;
    private javax.swing.JLabel txtp11;
    private javax.swing.JLabel txtp12;
    private javax.swing.JLabel txtp13;
    private javax.swing.JLabel txtp14;
    private javax.swing.JLabel txtp15;
    private javax.swing.JLabel txtp16;
    private javax.swing.JLabel txtp17;
    private javax.swing.JLabel txtp18;
    private javax.swing.JLabel txtp19;
    private javax.swing.JLabel txtp2;
    private javax.swing.JLabel txtp20;
    private javax.swing.JLabel txtp21;
    private javax.swing.JLabel txtp22;
    private javax.swing.JLabel txtp23;
    private javax.swing.JLabel txtp24;
    private javax.swing.JLabel txtp3;
    private javax.swing.JLabel txtp4;
    private javax.swing.JLabel txtp5;
    private javax.swing.JLabel txtp6;
    private javax.swing.JLabel txtp7;
    private javax.swing.JLabel txtp8;
    private javax.swing.JLabel txtp9;
    private javax.swing.JLabel txtpneu1;
    private javax.swing.JLabel txtpneu10;
    private javax.swing.JLabel txtpneu11;
    private javax.swing.JLabel txtpneu12;
    private javax.swing.JLabel txtpneu13;
    private javax.swing.JLabel txtpneu14;
    private javax.swing.JLabel txtpneu15;
    private javax.swing.JLabel txtpneu16;
    private javax.swing.JLabel txtpneu17;
    private javax.swing.JLabel txtpneu18;
    private javax.swing.JLabel txtpneu19;
    private javax.swing.JLabel txtpneu1comdesgaste;
    private javax.swing.JLabel txtpneu2;
    private javax.swing.JLabel txtpneu20;
    private javax.swing.JLabel txtpneu21;
    private javax.swing.JLabel txtpneu22;
    private javax.swing.JLabel txtpneu23;
    private javax.swing.JLabel txtpneu24;
    private javax.swing.JLabel txtpneu2comdesgaste;
    private javax.swing.JLabel txtpneu3;
    private javax.swing.JLabel txtpneu4;
    private javax.swing.JLabel txtpneu5;
    private javax.swing.JLabel txtpneu6;
    private javax.swing.JLabel txtpneu7;
    private javax.swing.JLabel txtpneu8;
    private javax.swing.JLabel txtpneu9;
    private javax.swing.JLabel txtpneuatual1;
    private javax.swing.JLabel txtpneuatual2;
    private javax.swing.JLabel txtposi1;
    private javax.swing.JLabel txtposi10;
    private javax.swing.JLabel txtposi11;
    private javax.swing.JLabel txtposi12;
    private javax.swing.JLabel txtposi13;
    private javax.swing.JLabel txtposi14;
    private javax.swing.JLabel txtposi15;
    private javax.swing.JLabel txtposi16;
    private javax.swing.JLabel txtposi17;
    private javax.swing.JLabel txtposi18;
    private javax.swing.JLabel txtposi19;
    private javax.swing.JLabel txtposi2;
    private javax.swing.JLabel txtposi20;
    private javax.swing.JLabel txtposi21;
    private javax.swing.JLabel txtposi22;
    private javax.swing.JLabel txtposi23;
    private javax.swing.JLabel txtposi24;
    private javax.swing.JLabel txtposi3;
    private javax.swing.JLabel txtposi4;
    private javax.swing.JLabel txtposi5;
    private javax.swing.JLabel txtposi6;
    private javax.swing.JLabel txtposi7;
    private javax.swing.JLabel txtposi8;
    private javax.swing.JLabel txtposi9;
    private javax.swing.JLabel txttempo1;
    private javax.swing.JLabel txttempo10;
    private javax.swing.JLabel txttempo11;
    private javax.swing.JLabel txttempo12;
    private javax.swing.JLabel txttempo13;
    private javax.swing.JLabel txttempo14;
    private javax.swing.JLabel txttempo15;
    private javax.swing.JLabel txttempo16;
    private javax.swing.JLabel txttempo17;
    private javax.swing.JLabel txttempo18;
    private javax.swing.JLabel txttempo19;
    private javax.swing.JLabel txttempo2;
    private javax.swing.JLabel txttempo20;
    private javax.swing.JLabel txttempo21;
    private javax.swing.JLabel txttempo22;
    private javax.swing.JLabel txttempo23;
    private javax.swing.JLabel txttempo24;
    private javax.swing.JLabel txttempo3;
    private javax.swing.JLabel txttempo4;
    private javax.swing.JLabel txttempo5;
    private javax.swing.JLabel txttempo6;
    private javax.swing.JLabel txttempo7;
    private javax.swing.JLabel txttempo8;
    private javax.swing.JLabel txttempo9;
    private javax.swing.JLabel txtultimavolta1;
    // End of variables declaration//GEN-END:variables
}
