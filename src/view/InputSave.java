/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import automanager.Automanager;
import classes.FuncoesGerais;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Bergson
 */
public class InputSave extends javax.swing.JFrame {
    private static Point point = new Point();
    private static JFrame frame = new JFrame();
    private static JFrame framee = new JFrame();
    private static String cor = null;
    private static String nomee = null;
    private static String sexoo = null;
    private static String idequipee = null;
    private static String savee = null;
    private static String dbb = null;
    
    public void mousedrag(JFrame fram){
        frame = fram;
    }
    public void mousedragg(MouseEvent evt){
        Point p = frame.getLocation();
        frame.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
    public void preparasave(String nome, String sexo, String idequipe, String save, String db){
        nomee = nome;
        sexoo = sexo;
        idequipee = idequipe;
        savee = save;
        dbb = db;
    }
    /**
     * Creates new form Input
     */
    public InputSave() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        
    }

    public void mensagem(String mensagem, String corr){
        jLabel1.setText(mensagem);
        cor = corr;
        jPanel1.setBackground(Color.decode(cor));
        jTextField1.setForeground(Color.decode(cor));
        jButton1.setForeground(Color.decode(cor));
    }
    
    public void atualizadbparasave(JFrame fram){
        framee = fram;
    }
    
    public void salvarjogo(){
        String save = jTextField1.getText();
        String sav = null;
        if(savee == "0"){
            sav = "db";
        }else{
            sav = "saves";
        }
        File origem = new File("C:/automanager/db/temp/");
        File destino = new File("C:/automanager/saves/"+save);
        
        if(destino.exists()){
            Mensagem msg = new Mensagem();
            msg.mensagem("Save já existe!", cor);
            msg.mousedrag(msg);
        }else{
            try {
            Automanager.copyAll(origem, destino, true);
                File f = new File("C:/automanager/saves/"+save+"/save.ams");
                //File f2 = new File("C:/automanager/saves/saves.amsdb");
                //FileWriter fw2 = new FileWriter(f2);
                //BufferedWriter bw2 = new BufferedWriter(fw2);
                //FileReader fr = new FileReader(f2);
                //BufferedReader br = new BufferedReader(fr);
                //String[] arrayx = null;
                //int b = Integer.parseInt(br.readLine());
                //int a = 0;
                //int c = 0;
                
                //salva
                //while(a < b){
                 //   aux[a] = br.readLine();
                //    a++;
                //}
                /*a = 0;
                //grava
                bw2.write(b++);
                while(a < b-1){
                    bw2.write(aux[a]);
                    a++;
                }
                bw2.write(save);
                bw2.close();*/
                FileWriter fw = new FileWriter(f);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(idequipee);
                bw.newLine();
                bw.write(nomee);
                bw.newLine();
                bw.write(sexoo);
                bw.newLine();
                bw.write(dbb);
                bw.newLine();
                bw.close();
                fw.close();
                if(savee == "0"){
                    framee.dispose();
                    FuncoesGerais fg = new FuncoesGerais();
                    fg.carregajogo(save);
                }
                
                /*JOptionPane.showMessageDialog(null, f);
                JOptionPane.showMessageDialog(null, idequipee);
                JOptionPane.showMessageDialog(null, nomee);
                JOptionPane.showMessageDialog(null, sexoo);*/
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedOperationException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
            MensagemSucesso msg = new MensagemSucesso();
            msg.mensagem("Jogo Salvo com Sucesso!!", cor);
            msg.mousedrag(msg);
            dispose();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));
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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("MENSAGEM BLABLABLABLABLABLALBLABA");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 290, 50));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("x");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 0, 19, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 220, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 50, 60, 30));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/duvida.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 5, 70, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point.x = evt.getX();
        point.y = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        if(jTextField1.getText().equals(null)){
            Mensagem msg = new Mensagem();
            msg.mensagem("Digite alguma coisa!",cor);
        }else{
            salvarjogo();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(InputSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputSave.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputSave().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
