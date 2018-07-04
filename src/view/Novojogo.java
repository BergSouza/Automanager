/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import classes.Equipe;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;

/**
 *
 * @author Bergson
 */
public class Novojogo extends javax.swing.JFrame {
    private static Point point = new Point();
    private static JFrame frame = new JFrame();
    
    public void mousedrag(JFrame fram){
        frame = fram;
    }
    public void mousedragg(MouseEvent evt){
        Point p = frame.getLocation();
        frame.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
    /**
     * Creates new form Novojogo
     */
    public Novojogo() throws IOException {
        initComponents();
        pegadb(1);
        resetacaixas(1);
    }
    
    public void atualiza(String db, int a) throws IOException{
        imgequipe.setIcon(Equipe.getImagem(db, a));
        int b = 1;
        while(b < 1000){
            txtp1.setText(Equipe.getP1(db, a, 9));
            txtp2.setText(Equipe.getP2(db, a, 10));
            imgp1.setIcon(Equipe.getImagemP1(db, a));
            imgp2.setIcon(Equipe.getImagemP2(db, a));
            
            //Pega Dados do Carro
            
            try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/carros/"+a+".amc");
                BufferedReader br = new BufferedReader(fr);
                int total = 0;
                txtCarro.setText(" "+br.readLine());
                total++;
                String aerodinamica = br.readLine();
                total++;
                String suspensao = br.readLine();
                total++;
                String refrigeracao = br.readLine();
                total++;
                String desgastepneus = br.readLine();
                total++;
                String direcao = br.readLine();
                total++;
                String freio = br.readLine();
                total++;
                String confiabilidade = br.readLine();
                total++;
                String sistemaeletrico = br.readLine();
                total++;
                int media = (Integer.parseInt(aerodinamica) + Integer.parseInt(suspensao) + Integer.parseInt(refrigeracao) + Integer.parseInt(desgastepneus) + Integer.parseInt(direcao) + Integer.parseInt(freio) + Integer.parseInt(confiabilidade) + Integer.parseInt(sistemaeletrico))/total;
                int avaliacaocarro = media/10;
                String acarro = Integer.toString(avaliacaocarro);
                char[] avcarro = acarro.toCharArray();
                ImageIcon avcar = new ImageIcon(getClass().getResource("/img/novojogo/estrela"+avcarro[0]+".png"));
                avaliacaoCarro.setIcon(avcar);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Pega Dados da Equipe
            try {
                FileReader fr = new FileReader("c:/automanager/db/"+db+"/equipes/"+a+".amt");
                BufferedReader br = new BufferedReader(fr);
                br.readLine();
                String idmotor = br.readLine();
                FileReader fr2 = new FileReader("c:/automanager/db/"+db+"/motores/"+idmotor+".amm");
                BufferedReader br2 = new BufferedReader(fr2);
                int total = 0;
                txtMotor.setText(" "+br2.readLine()+" ( "+br.readLine()+" )");
                String confiabilidade = br2.readLine();
                total++;
                String velocidade = br2.readLine();
                total++;
                String aceleracao = br2.readLine();
                total++;
                int media = (Integer.parseInt(confiabilidade)+Integer.parseInt(velocidade)+Integer.parseInt(aceleracao))/total;
                int amotor = media/10;
                String avmotor = Integer.toString(amotor);
                char[] finalmotor = avmotor.toCharArray();
                ImageIcon avaliacaomotor = new ImageIcon(getClass().getResource("/img/novojogo/estrela"+finalmotor[0]+".png"));
                avaliacaoMotor.setIcon(avaliacaomotor);
                //txtProprio.setText(" "+br.readLine());
                txtTitulos.setText(" "+br.readLine());
                br.readLine();
                txtCaixa.setText(" R$ "+br.readLine());
                txtChefe.setText(" "+br.readLine());
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
            }
            b = 1000;
        }
    }
    
    public void setacores(int idequipe){
        try {
            String cor1 = Equipe.getCor1((String) selectDB.getSelectedItem(), idequipe);
            String cor2 = Equipe.getCor2((String) selectDB.getSelectedItem(), idequipe);
            jPanel2.setBackground(Color.decode(cor1));
            checkHomem.setBackground(Color.decode(cor1));
            checkMulher.setBackground(Color.decode(cor1));
            btnCancelar.setForeground(Color.decode(cor1));
            btnContinuar.setForeground(Color.decode(cor1));
            txtp1.setForeground(Color.decode(cor1));
            txtp2.setForeground(Color.decode(cor1));
            campoNome.setForeground(Color.decode(cor1));
            cb1.setForeground(Color.decode(cor1));
            cb2.setForeground(Color.decode(cor1));
            cb3.setForeground(Color.decode(cor1));
            cb4.setForeground(Color.decode(cor1));
            cb5.setForeground(Color.decode(cor1));
            cb6.setForeground(Color.decode(cor1));
            cb7.setForeground(Color.decode(cor1));
            cb8.setForeground(Color.decode(cor1));
            cb9.setForeground(Color.decode(cor1));
            cb10.setForeground(Color.decode(cor1));
            cb11.setForeground(Color.decode(cor1));
            cb12.setForeground(Color.decode(cor1));
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void resetacaixas(int a) throws IOException{
        setacores(a);
        cb1.setSelected(false);
        cb2.setSelected(false);
        cb3.setSelected(false);
        cb4.setSelected(false);
        cb5.setSelected(false);
        cb6.setSelected(false);
        cb7.setSelected(false);
        cb8.setSelected(false);
        cb9.setSelected(false);
        cb10.setSelected(false);
        cb11.setSelected(false);
        cb12.setSelected(false);
        
        String db = (String) selectDB.getSelectedItem();
        if(a == 1){
            cb1.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 2){
            cb2.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 3){
            cb3.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 4){
            cb4.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 5){
            cb5.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 6){
            cb6.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 7){
            cb7.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 8){
            cb8.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 9){
            cb9.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 10){
            cb10.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        if(a == 11){
            cb11.setSelected(true);
            campoEquipe.setText(Integer.toString(a));
            atualiza(db, a);
        }
        if(a == 12){
            cb12.setSelected(true);
            atualiza(db, a);
            campoEquipe.setText(Integer.toString(a));
        }
        
    }
    
    public void pegadb(int aa) throws IOException{
        if(aa == 1){
        FileReader fr1 = new FileReader("C:/automanager/db/dbs.amdb");
        BufferedReader br1 = new BufferedReader(fr1);
        for (String linha = br1.readLine(); linha != null; linha = br1.readLine()) {
            selectDB.addItem(linha);
        }
        }
        int a = 1;
        while(a < 13){
                FileReader fr;
            try {
                fr = new FileReader("C:/automanager/db/"+(String) selectDB.getSelectedItem()+"/equipes/"+a+".amt");
                BufferedReader br = new BufferedReader(fr);
                String nomeequipe = br.readLine();
                String motor = br.readLine();
                String proprio = br.readLine();
                String titulos = br.readLine();
                String titulosp = br.readLine();
                String caixa = br.readLine();
                String chefe = br.readLine();
                String sexochefe = br.readLine();
                if(a == 1){
                    cb1.setText(nomeequipe);
                    cb1.setVisible(true);
                }if(a == 2){
                    cb2.setText(nomeequipe);
                    cb2.setVisible(true);
                }if(a == 3){
                    cb3.setText(nomeequipe);
                    cb3.setVisible(true);
                }if(a == 4){
                    cb4.setText(nomeequipe);
                    cb4.setVisible(true);
                }if(a == 5){
                    cb5.setText(nomeequipe);
                    cb5.setVisible(true);
                }if(a == 6){
                    cb6.setText(nomeequipe);
                    cb6.setVisible(true);
                }if(a == 7){
                    cb7.setText(nomeequipe);
                    cb7.setVisible(true);
                }if(a == 8){
                    cb8.setText(nomeequipe);
                    cb8.setVisible(true);
                }if(a == 9){
                    cb9.setText(nomeequipe);
                    cb9.setVisible(true);
                }if(a == 10){
                    cb10.setText(nomeequipe);
                    cb10.setVisible(true);
                }if(a == 11){
                    cb11.setText(nomeequipe);
                    cb11.setVisible(true);
                }if(a == 12){
                    cb12.setText(nomeequipe);
                    cb12.setVisible(true);
                }
            } catch (FileNotFoundException ex) {
                if(a == 1){
                cb1.setVisible(false);
                }if(a == 2){
                    cb2.setVisible(false);
                }if(a == 3){
                    cb3.setVisible(false);
                }if(a == 4){
                    cb4.setVisible(false);
                }if(a == 5){
                    cb5.setVisible(false);
                }if(a == 6){
                    cb6.setVisible(false);
                }if(a == 7){
                    cb7.setVisible(false);
                }if(a == 8){
                    cb8.setVisible(false);
                }if(a == 9){
                    cb9.setVisible(false);
                }if(a == 10){
                    cb10.setVisible(false);
                }if(a == 11){
                    cb11.setVisible(false);
                }if(a == 12){
                    cb12.setVisible(false);
                }
            }
            a++;
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

        jLabel1 = new javax.swing.JLabel();
        txtProprio = new javax.swing.JLabel();
        campoEquipe = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cb7 = new javax.swing.JCheckBox();
        cb10 = new javax.swing.JCheckBox();
        cb8 = new javax.swing.JCheckBox();
        cb2 = new javax.swing.JCheckBox();
        cb11 = new javax.swing.JCheckBox();
        cb9 = new javax.swing.JCheckBox();
        cb12 = new javax.swing.JCheckBox();
        cb4 = new javax.swing.JCheckBox();
        cb6 = new javax.swing.JCheckBox();
        cb5 = new javax.swing.JCheckBox();
        cb1 = new javax.swing.JCheckBox();
        cb3 = new javax.swing.JCheckBox();
        imgequipe = new javax.swing.JLabel();
        imgp1 = new javax.swing.JLabel();
        imgp2 = new javax.swing.JLabel();
        txtp1 = new javax.swing.JLabel();
        txtp2 = new javax.swing.JLabel();
        txtCarro = new javax.swing.JLabel();
        txtTitulos = new javax.swing.JLabel();
        txtCaixa = new javax.swing.JLabel();
        txtChefe = new javax.swing.JLabel();
        selectDB = new javax.swing.JComboBox<>();
        avaliacaoMotor = new javax.swing.JLabel();
        avaliacaoCarro = new javax.swing.JLabel();
        txtMotor = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        campoNome = new javax.swing.JTextField();
        imgchefe = new javax.swing.JLabel();
        checkHomem = new javax.swing.JCheckBox();
        checkMulher = new javax.swing.JCheckBox();
        btnCancelar = new javax.swing.JButton();
        btnContinuar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 204, 255));
        jLabel1.setText("Equipe:");

        txtProprio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/motor3.png"))); // NOI18N
        txtProprio.setText(" Fornecedor/Cliente");

        campoEquipe.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel3MouseDragged(evt);
            }
        });
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel3MousePressed(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        cb7.setBackground(new java.awt.Color(255, 255, 255));
        cb7.setForeground(new java.awt.Color(102, 153, 255));
        cb7.setText("Equipe 7");
        cb7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb7ActionPerformed(evt);
            }
        });
        jPanel1.add(cb7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 140, -1));

        cb10.setBackground(new java.awt.Color(255, 255, 255));
        cb10.setForeground(new java.awt.Color(102, 153, 255));
        cb10.setText("Equipe 10");
        cb10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb10ActionPerformed(evt);
            }
        });
        jPanel1.add(cb10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 140, -1));

        cb8.setBackground(new java.awt.Color(255, 255, 255));
        cb8.setForeground(new java.awt.Color(102, 153, 255));
        cb8.setText("Equipe 8");
        cb8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb8ActionPerformed(evt);
            }
        });
        jPanel1.add(cb8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 130, -1));

        cb2.setBackground(new java.awt.Color(255, 255, 255));
        cb2.setForeground(new java.awt.Color(102, 153, 255));
        cb2.setText("Equipe 2");
        cb2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb2ActionPerformed(evt);
            }
        });
        jPanel1.add(cb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 130, -1));

        cb11.setBackground(new java.awt.Color(255, 255, 255));
        cb11.setForeground(new java.awt.Color(102, 153, 255));
        cb11.setText("Equipe 11");
        cb11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb11ActionPerformed(evt);
            }
        });
        jPanel1.add(cb11, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 130, -1));

        cb9.setBackground(new java.awt.Color(255, 255, 255));
        cb9.setForeground(new java.awt.Color(102, 153, 255));
        cb9.setText("Equipe 9");
        cb9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb9ActionPerformed(evt);
            }
        });
        jPanel1.add(cb9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, 120, -1));

        cb12.setBackground(new java.awt.Color(255, 255, 255));
        cb12.setForeground(new java.awt.Color(51, 153, 255));
        cb12.setText("Equipe 12");
        cb12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb12ActionPerformed(evt);
            }
        });
        jPanel1.add(cb12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 120, 20));

        cb4.setBackground(new java.awt.Color(255, 255, 255));
        cb4.setForeground(new java.awt.Color(102, 153, 255));
        cb4.setText("Equipe 4");
        cb4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb4ActionPerformed(evt);
            }
        });
        jPanel1.add(cb4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 140, -1));

        cb6.setBackground(new java.awt.Color(255, 255, 255));
        cb6.setForeground(new java.awt.Color(102, 153, 255));
        cb6.setText("Equipe 6");
        cb6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb6ActionPerformed(evt);
            }
        });
        jPanel1.add(cb6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, 120, -1));

        cb5.setBackground(new java.awt.Color(255, 255, 255));
        cb5.setForeground(new java.awt.Color(102, 153, 255));
        cb5.setText("Equipe 5");
        cb5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb5ActionPerformed(evt);
            }
        });
        jPanel1.add(cb5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 130, -1));

        cb1.setBackground(new java.awt.Color(255, 255, 255));
        cb1.setForeground(new java.awt.Color(102, 153, 255));
        cb1.setText("Equipe1");
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        jPanel1.add(cb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 140, -1));

        cb3.setBackground(new java.awt.Color(255, 255, 255));
        cb3.setForeground(new java.awt.Color(102, 153, 255));
        cb3.setText("Equipe 3");
        cb3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb3ActionPerformed(evt);
            }
        });
        jPanel1.add(cb3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 260, 120, -1));

        imgequipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/equipe.png"))); // NOI18N
        jPanel1.add(imgequipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        imgp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/piloto1.png"))); // NOI18N
        jPanel1.add(imgp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 132, -1, 88));

        imgp2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/piloto2.png"))); // NOI18N
        jPanel1.add(imgp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, 88));

        txtp1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp1.setText("Piloto 1");
        jPanel1.add(txtp1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 90, -1));

        txtp2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtp2.setText("Piloto 2");
        jPanel1.add(txtp2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 230, 100, -1));

        txtCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/carro3.png"))); // NOI18N
        txtCarro.setText("Carro");
        jPanel1.add(txtCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, 30));

        txtTitulos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/titulos3.png"))); // NOI18N
        txtTitulos.setText(" Títulos");
        jPanel1.add(txtTitulos, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 160, -1, 30));

        txtCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/caixa3.png"))); // NOI18N
        txtCaixa.setText("R$ XXX");
        jPanel1.add(txtCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, -1, -1));

        txtChefe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/chefe3.png"))); // NOI18N
        txtChefe.setText("Chefe");
        jPanel1.add(txtChefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 210, -1, 30));

        selectDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectDBActionPerformed(evt);
            }
        });
        jPanel1.add(selectDB, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 140, -1));

        avaliacaoMotor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/estrela10.png"))); // NOI18N
        jPanel1.add(avaliacaoMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 120, 30));

        avaliacaoCarro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/estrela10.png"))); // NOI18N
        jPanel1.add(avaliacaoCarro, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 80, 120, 30));

        txtMotor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/motor3.png"))); // NOI18N
        txtMotor.setText(" Motor");
        jPanel1.add(txtMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, -1, 30));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, 440, 380));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        campoNome.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        campoNome.setForeground(new java.awt.Color(153, 204, 255));
        jPanel2.add(campoNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 234, 222, 32));

        imgchefe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/chefe-m.png"))); // NOI18N
        jPanel2.add(imgchefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        checkHomem.setBackground(new java.awt.Color(153, 204, 255));
        checkHomem.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkHomem.setForeground(new java.awt.Color(255, 255, 255));
        checkHomem.setSelected(true);
        checkHomem.setText("Homem");
        checkHomem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkHomemActionPerformed(evt);
            }
        });
        jPanel2.add(checkHomem, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, -1));

        checkMulher.setBackground(new java.awt.Color(153, 204, 255));
        checkMulher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        checkMulher.setForeground(new java.awt.Color(255, 255, 255));
        checkMulher.setText("Mulher");
        checkMulher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkMulherActionPerformed(evt);
            }
        });
        jPanel2.add(checkMulher, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        btnCancelar.setBackground(new java.awt.Color(255, 255, 255));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnCancelar.setForeground(new java.awt.Color(153, 204, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 329, 105, 40));

        btnContinuar.setBackground(new java.awt.Color(255, 255, 255));
        btnContinuar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnContinuar.setForeground(new java.awt.Color(153, 204, 255));
        btnContinuar.setText("Continuar");
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        jPanel2.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 327, 105, 41));

        jPanel3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 250, 380));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 690, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkHomemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkHomemActionPerformed
        checkMulher.setSelected(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/chefe-m.png"));
        imgchefe.setIcon(icon);
    }//GEN-LAST:event_checkHomemActionPerformed

    private void checkMulherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkMulherActionPerformed
        checkHomem.setSelected(false);
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/chefe-f.png"));
        imgchefe.setIcon(icon);
    }//GEN-LAST:event_checkMulherActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Inicio i = new Inicio();
        i.setVisible(true);
        i.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        try {
            resetacaixas(1);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb1ActionPerformed

    private void cb2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb2ActionPerformed
        try {
            resetacaixas(2);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb2ActionPerformed

    private void cb3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb3ActionPerformed
        try {
            resetacaixas(3);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb3ActionPerformed

    private void cb4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb4ActionPerformed
        try {
            resetacaixas(4);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb4ActionPerformed

    private void cb5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb5ActionPerformed
        try {
            resetacaixas(5);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb5ActionPerformed

    private void cb6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb6ActionPerformed
        try {
            resetacaixas(6);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb6ActionPerformed

    private void cb7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb7ActionPerformed
        try {
            resetacaixas(7);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb7ActionPerformed

    private void cb8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb8ActionPerformed
        try {
            resetacaixas(8);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb8ActionPerformed

    private void cb9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb9ActionPerformed
        try {
            resetacaixas(9);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb9ActionPerformed

    private void cb10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb10ActionPerformed
        try {
            resetacaixas(10);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb10ActionPerformed

    private void cb11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb11ActionPerformed
        try {
            resetacaixas(11);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb11ActionPerformed

    private void cb12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb12ActionPerformed
        try {
            resetacaixas(12);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cb12ActionPerformed

    private void selectDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectDBActionPerformed
        try {
            resetacaixas(1);
            atualiza((String) selectDB.getSelectedItem(), 1);
            pegadb(2);
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_selectDBActionPerformed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        if(campoNome.getText().equals("")){
            Mensagem msg = new Mensagem();
            msg.mousedrag(msg);
            try {
                msg.mensagem("Digite o seu nome para continuar!", Equipe.getCor1((String) selectDB.getSelectedItem(), Integer.parseInt(campoEquipe.getText())));
            } catch (IOException ex) {
                Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            
        Principal p = new Principal();
        String sexo = null;
        if(checkHomem.isSelected()){
            sexo = "Homem";
        }if(checkMulher.isSelected()){
            sexo = "Mulher";
        }
        p.setVisible(true);
        p.setLocationRelativeTo(null);
        try {
            p.recebedados(campoNome.getText(), sexo,Integer.parseInt((String) selectDB.getSelectedItem()), Integer.parseInt(campoEquipe.getText()));
            p.mousedrag(p);
            dispose();
        } catch (IOException ex) {
            Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point.x = evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MousePressed
        point.x = evt.getX();
        point.y = evt.getY();        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel3MousePressed

    private void jPanel3MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel3MouseDragged

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
            java.util.logging.Logger.getLogger(Novojogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Novojogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Novojogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Novojogo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Novojogo().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(Novojogo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel avaliacaoCarro;
    private javax.swing.JLabel avaliacaoMotor;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnContinuar;
    private javax.swing.JTextField campoEquipe;
    private javax.swing.JTextField campoNome;
    private javax.swing.JCheckBox cb1;
    private javax.swing.JCheckBox cb10;
    private javax.swing.JCheckBox cb11;
    private javax.swing.JCheckBox cb12;
    private javax.swing.JCheckBox cb2;
    private javax.swing.JCheckBox cb3;
    private javax.swing.JCheckBox cb4;
    private javax.swing.JCheckBox cb5;
    private javax.swing.JCheckBox cb6;
    private javax.swing.JCheckBox cb7;
    private javax.swing.JCheckBox cb8;
    private javax.swing.JCheckBox cb9;
    private javax.swing.JCheckBox checkHomem;
    private javax.swing.JCheckBox checkMulher;
    private javax.swing.JLabel imgchefe;
    private javax.swing.JLabel imgequipe;
    private javax.swing.JLabel imgp1;
    private javax.swing.JLabel imgp2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JComboBox<String> selectDB;
    private javax.swing.JLabel txtCaixa;
    private javax.swing.JLabel txtCarro;
    private javax.swing.JLabel txtChefe;
    private javax.swing.JLabel txtMotor;
    private javax.swing.JLabel txtProprio;
    private javax.swing.JLabel txtTitulos;
    private javax.swing.JLabel txtp1;
    private javax.swing.JLabel txtp2;
    // End of variables declaration//GEN-END:variables
}
