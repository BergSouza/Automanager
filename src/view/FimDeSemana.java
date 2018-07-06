/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import classes.Corrida;
import classes.Equipe;
import classes.FimSemana;
import classes.Piloto;
import classes.Pneu;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Bergson
 */
public class FimDeSemana extends javax.swing.JFrame {
    private static Point point = new Point();
    private static JFrame frame = new JFrame();
    private static String savee = null;
    private static int idequipee = 0;
    private static String dbb = null;
    private static int idcorridaa = 0;
    
    private static int max_pneusp1 = 13;
    private static int max_pneusp2 = 13;
    private static int quantidade_p11 = 1;
    private static int quantidade_p21 = 1;
    private static int quantidade_p31 = 1;
    private static int quantidade_p12 = 1;
    private static int quantidade_p22 = 1;
    private static int quantidade_p32 = 1;
    
    
    private static String nomepn1 = null;
    private static String nomepn2 = null;
    private static String nomepn3 = null;
    
    JFrame f = new JFrame();
    public void frame(JFrame frame){
        f = frame;
    }
    public void mousedrag(JFrame fram){
        frame = fram;
    }
    public void mousedragg(MouseEvent evt){
        Point p = frame.getLocation();
        frame.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
    public void pegadados(String db,int idequipe,String idcorrida,String save) throws IOException{
        idequipee = idequipe;
        dbb = db;
        idcorridaa = Integer.parseInt(idcorrida);
        savee = save;
        setacores(db,idequipe);
        String p1sobrenome = Piloto.getSobrenome(db, Equipe.getIdP1(db, idequipe, savee),savee);
        String p2sobrenome = Piloto.getSobrenome(db, Equipe.getIdP2(db, idequipe, savee),savee);
        String pais = Corrida.getPais(db, idcorrida,savee);
        String pista = Corrida.getPista(db, idcorrida,savee);
        String voltas = Corrida.getVoltas(db, idcorrida,savee);
        String distancia = Corrida.getDistancia(db, idcorrida,savee);
        txtBandeira.setIcon(Corrida.getBandeira(db, idcorrida,savee));
        jLabel1.setText("FIM DE SEMANA GP "+pais.toUpperCase()+" - "+pista.toUpperCase()+" - "+voltas+" VOLTAS");
        txtLocal.setText("Local: "+pista);
        txtDistancia.setText("Distancia: "+distancia);
        txtpneusp1.setText("SELEÇÃO DE PNEUS - "+p1sobrenome.toUpperCase());
        txtpneusp2.setText("SELEÇÃO DE PNEUS - "+p2sobrenome.toUpperCase());
        setapneus(db, idequipe, idcorrida);
   }
    
   public void setapneus(String db, int idequipe, String idcorrida){
       int idpneu1 = Integer.parseInt(Corrida.getPneu1(db, idcorrida,savee));
       int idpneu2 = Integer.parseInt(Corrida.getPneu2(db, idcorrida,savee));
       int idpneu3 = Integer.parseInt(Corrida.getPneu3(db, idcorrida,savee));
        try {
            pneu11.setIcon(Pneu.getImagem(db, idpneu1, savee));
            pneu12.setIcon(Pneu.getImagem(db, idpneu1, savee));
            pneu21.setIcon(Pneu.getImagem(db, idpneu2, savee));
            pneu22.setIcon(Pneu.getImagem(db, idpneu2, savee));
            pneu31.setIcon(Pneu.getImagem(db, idpneu3, savee));
            pneu32.setIcon(Pneu.getImagem(db, idpneu3, savee));
            nomepn1 = Pneu.getNome(db, idpneu1, savee);
            nomepn2 = Pneu.getNome(db, idpneu2, savee);
            nomepn3 = Pneu.getNome(db, idpneu3, savee);
            atualizapneus();
        } catch (IOException ex) {
            Logger.getLogger(FimDeSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    
    public void setacores(String db, int idequipe){
        try {
            String cor1 = Equipe.getCor1(db, idequipe, savee);
            String cor2 = Equipe.getCor2(db, idequipe, savee);
            jPanel2.setBackground(Color.decode(cor1));
            jButton1.setBackground(Color.decode(cor1));
            txtLocal.setForeground(Color.decode(cor1));
            txtDistancia.setForeground(Color.decode(cor1));
            txtpneusp1.setForeground(Color.decode(cor1));
            txtpneusp2.setForeground(Color.decode(cor1));
            txtpneu11.setForeground(Color.decode(cor1));
            txtpneu21.setForeground(Color.decode(cor1));
            txtpneu31.setForeground(Color.decode(cor1));
            txtpneu12.setForeground(Color.decode(cor1));
            txtpneu22.setForeground(Color.decode(cor1));
            txtpneu32.setForeground(Color.decode(cor1));
            selecaopneu11.setBackground(Color.decode(cor1));
            selecaopneu11.setForeground(Color.decode("#ffffff"));
            selecaopneu21.setBackground(Color.decode(cor1));
            selecaopneu21.setForeground(Color.decode("#ffffff"));
            selecaopneu31.setBackground(Color.decode(cor1));
            selecaopneu31.setForeground(Color.decode("#ffffff"));
            selecaopneu12.setBackground(Color.decode(cor1));
            selecaopneu12.setForeground(Color.decode("#ffffff"));
            selecaopneu22.setBackground(Color.decode(cor1));
            selecaopneu22.setForeground(Color.decode("#ffffff"));
            selecaopneu32.setBackground(Color.decode(cor1));
            selecaopneu32.setForeground(Color.decode("#ffffff"));
            jButton2.setBackground(Color.decode(cor1));
        } catch (IOException ex) {
            Logger.getLogger(FimDeSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void atualizapneus(){
        txtpneu11.setText(nomepn1/*+" [ "+quantidade_p11+" ]"*/);
        txtpneu21.setText(nomepn2/*+" [ "+quantidade_p21+" ]"*/);
        txtpneu31.setText(nomepn3/*+" [ "+quantidade_p31+" ]"*/);
        txtpneu12.setText(nomepn1/*+" [ "+quantidade_p12+" ]"*/);
        txtpneu22.setText(nomepn2/*+" [ "+quantidade_p22+" ]"*/);
        txtpneu32.setText(nomepn3/*+" [ "+quantidade_p32+" ]"*/);
        
        
        int o = 0;
        
        String abc = (max_pneusp1-quantidade_p11-quantidade_p21-quantidade_p31)+" Restantes ";
        if((max_pneusp1-quantidade_p11-quantidade_p21-quantidade_p31) < 0){
            pneusrestantesp1.setText((abc)+" Número NEGATIVO!");
            o = 0;
        }else if((max_pneusp1-quantidade_p11-quantidade_p21-quantidade_p31) == 0){
            pneusrestantesp1.setText((abc));
            o = 1;
        }else{
            pneusrestantesp1.setText((abc));
            o = 0;
        }
        
        int p = 0;
        String abc2 = (max_pneusp2-quantidade_p12-quantidade_p22-quantidade_p32)+" Restantes ";
        if((max_pneusp2-quantidade_p12-quantidade_p22-quantidade_p32) < 0){
            pneusrestantesp2.setText((abc2)+" Número NEGATIVO!");
            p = 0;
        }else if((max_pneusp2-quantidade_p12-quantidade_p22-quantidade_p32) == 0){
            pneusrestantesp2.setText((abc2));
            p = 1;
        }else{
            pneusrestantesp2.setText((abc2));
            p = 0;
        }
        
        if(o == 0 || p == 0){
            jButton2.setEnabled(false);
        }
        if(o == 1 && p == 1){
            jButton2.setEnabled(true);
        }
    }/*
    public void atualizatxtpneusmenos(JLabel label){
        int num = (max_pneus-quantidade_p11+quantidade_p21+quantidade_p31);
        label.setText(num+" Restantes");
        atualizapneus();
            btnmaisp11.setEnabled(true);
            btnmaisp21.setEnabled(true);
            btnmaisp31.setEnabled(true);
    }
    public void atualizatxtpneusmais(JLabel label){
        int num = (max_pneus-quantidade_p11+quantidade_p21+quantidade_p31);
        label.setText(num+" Restantes");
        if(num >= 13){
            btnmaisp11.setEnabled(false);
            btnmaisp21.setEnabled(false);
            btnmaisp31.setEnabled(false);
        }/*else{
            btnmaisp11.setEnabled(true);
            btnmaisp21.setEnabled(true);
            btnmaisp31.setEnabled(true);
        }
        atualizapneus();
    }*/
    
    public FimDeSemana() {
        initComponents();
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
        txtBandeira = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtLocal = new javax.swing.JLabel();
        txtDistancia = new javax.swing.JLabel();
        txtpneusp2 = new javax.swing.JLabel();
        pneu12 = new javax.swing.JLabel();
        pneu22 = new javax.swing.JLabel();
        pneu32 = new javax.swing.JLabel();
        txtpneusp1 = new javax.swing.JLabel();
        pneu11 = new javax.swing.JLabel();
        pneu21 = new javax.swing.JLabel();
        pneu31 = new javax.swing.JLabel();
        txtpneu11 = new javax.swing.JLabel();
        txtpneu21 = new javax.swing.JLabel();
        txtpneu31 = new javax.swing.JLabel();
        txtpneu12 = new javax.swing.JLabel();
        txtpneu22 = new javax.swing.JLabel();
        txtpneu32 = new javax.swing.JLabel();
        pneusrestantesp2 = new javax.swing.JLabel();
        pneusrestantesp1 = new javax.swing.JLabel();
        selecaopneu11 = new javax.swing.JComboBox<>();
        selecaopneu21 = new javax.swing.JComboBox<>();
        selecaopneu31 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        selecaopneu12 = new javax.swing.JComboBox<>();
        selecaopneu22 = new javax.swing.JComboBox<>();
        selecaopneu32 = new javax.swing.JComboBox<>();

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("FIM DE SEMANA GP AUSTRÁLIA - MELBOURNE - 58 VOLTAS");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 550, 50));

        txtBandeira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/bcorrida.png"))); // NOI18N
        jPanel1.add(txtBandeira, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Voltar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 110, 40));

        txtLocal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtLocal.setText("Local: Albert Park");
        jPanel1.add(txtLocal, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 70, 410, 30));

        txtDistancia.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtDistancia.setText("Distância: xxx km");
        jPanel1.add(txtDistancia, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 410, 30));

        txtpneusp2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpneusp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneusp2.setText("SELEÇÃO DE PNEUS - PILOTO 2");
        jPanel1.add(txtpneusp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, 260, 30));

        pneu12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(pneu12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, -1, -1));

        pneu22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(pneu22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, -1, -1));

        pneu32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(pneu32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        txtpneusp1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtpneusp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneusp1.setText("SELEÇÃO DE PNEUS - PILOTO 1");
        jPanel1.add(txtpneusp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 260, 30));

        pneu11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(pneu11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, -1, -1));

        pneu21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(pneu21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, -1, -1));

        pneu31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/pneu.png"))); // NOI18N
        jPanel1.add(pneu31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 190, -1, -1));

        txtpneu11.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu11.setText("Ultra Soft [ 0 ]");
        jPanel1.add(txtpneu11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 80, -1));

        txtpneu21.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu21.setText("Ultra Soft [ 0 ]");
        jPanel1.add(txtpneu21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 280, 80, -1));

        txtpneu31.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu31.setText("Ultra Soft [ 0 ]");
        jPanel1.add(txtpneu31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 280, 80, -1));

        txtpneu12.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu12.setText("Ultra Soft [ 0 ]");
        jPanel1.add(txtpneu12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 280, 80, -1));

        txtpneu22.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu22.setText("Ultra Soft [ 0 ]");
        jPanel1.add(txtpneu22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 280, 80, -1));

        txtpneu32.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        txtpneu32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtpneu32.setText("Ultra Soft [ 0 ]");
        jPanel1.add(txtpneu32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, 80, -1));

        pneusrestantesp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pneusrestantesp2.setText("13 Restantes");
        jPanel1.add(pneusrestantesp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 270, -1));

        pneusrestantesp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pneusrestantesp1.setText("13 Restantes");
        jPanel1.add(pneusrestantesp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 280, -1));

        selecaopneu11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selecaopneu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaopneu11ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaopneu11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 80, -1));

        selecaopneu21.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selecaopneu21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaopneu21ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaopneu21, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 80, -1));

        selecaopneu31.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selecaopneu31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaopneu31ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaopneu31, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 80, -1));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Continuar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 340, 110, 40));

        selecaopneu12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selecaopneu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaopneu12ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaopneu12, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 80, -1));

        selecaopneu22.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selecaopneu22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaopneu22ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaopneu22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 300, 80, -1));

        selecaopneu32.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        selecaopneu32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selecaopneu32ActionPerformed(evt);
            }
        });
        jPanel1.add(selecaopneu32, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 80, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point.x = evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
        f.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void selecaopneu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaopneu11ActionPerformed
        quantidade_p11 = Integer.parseInt((String) selecaopneu11.getSelectedItem());
        atualizapneus();
    }//GEN-LAST:event_selecaopneu11ActionPerformed

    private void selecaopneu21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaopneu21ActionPerformed
        quantidade_p21 = Integer.parseInt((String) selecaopneu21.getSelectedItem());
        atualizapneus();
    }//GEN-LAST:event_selecaopneu21ActionPerformed

    private void selecaopneu31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaopneu31ActionPerformed
        quantidade_p31 = Integer.parseInt((String) selecaopneu31.getSelectedItem());
        atualizapneus();
    }//GEN-LAST:event_selecaopneu31ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        FimSemana fs = new FimSemana();
        try {
            fs.salvaPneus(dbb,idequipee,savee, quantidade_p11,quantidade_p21,quantidade_p31,quantidade_p12,quantidade_p22,quantidade_p32,Integer.toString(idcorridaa));
        } catch (IOException ex) {
            Logger.getLogger(FimDeSemana.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void selecaopneu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaopneu12ActionPerformed
        quantidade_p12 = Integer.parseInt((String) selecaopneu12.getSelectedItem());
        atualizapneus();
    }//GEN-LAST:event_selecaopneu12ActionPerformed

    private void selecaopneu22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaopneu22ActionPerformed
        quantidade_p22 = Integer.parseInt((String) selecaopneu22.getSelectedItem());
        atualizapneus();
    }//GEN-LAST:event_selecaopneu22ActionPerformed

    private void selecaopneu32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selecaopneu32ActionPerformed
        quantidade_p32 = Integer.parseInt((String) selecaopneu32.getSelectedItem());
        atualizapneus();
    }//GEN-LAST:event_selecaopneu32ActionPerformed

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
            java.util.logging.Logger.getLogger(FimDeSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FimDeSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FimDeSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FimDeSemana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FimDeSemana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel pneu11;
    private javax.swing.JLabel pneu12;
    private javax.swing.JLabel pneu21;
    private javax.swing.JLabel pneu22;
    private javax.swing.JLabel pneu31;
    private javax.swing.JLabel pneu32;
    private javax.swing.JLabel pneusrestantesp1;
    private javax.swing.JLabel pneusrestantesp2;
    private javax.swing.JComboBox<String> selecaopneu11;
    private javax.swing.JComboBox<String> selecaopneu12;
    private javax.swing.JComboBox<String> selecaopneu21;
    private javax.swing.JComboBox<String> selecaopneu22;
    private javax.swing.JComboBox<String> selecaopneu31;
    private javax.swing.JComboBox<String> selecaopneu32;
    private javax.swing.JLabel txtBandeira;
    private javax.swing.JLabel txtDistancia;
    private javax.swing.JLabel txtLocal;
    private javax.swing.JLabel txtpneu11;
    private javax.swing.JLabel txtpneu12;
    private javax.swing.JLabel txtpneu21;
    private javax.swing.JLabel txtpneu22;
    private javax.swing.JLabel txtpneu31;
    private javax.swing.JLabel txtpneu32;
    private javax.swing.JLabel txtpneusp1;
    private javax.swing.JLabel txtpneusp2;
    // End of variables declaration//GEN-END:variables
}
