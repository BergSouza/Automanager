/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import automanager.Automanager;
import classes.Equipe;
import classes.Corrida;
import classes.Motor;
import classes.Patrocinio;
import classes.Piloto;
import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
/**
 *
 * @author Bergson
 */
public class Principal extends javax.swing.JFrame {
    private static Point point = new Point();
    private static JFrame frame = new JFrame();
    private static String cor = null;
    private static String dbb = null;
    private static String nomee = null;
    private static String sexoo = null;
    private static String idequipee = null;
    private static String savee = null;
    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }
    
    public void temp(String db){
        File origem = new File("C:/automanager/"+savee+"/"+db);
        File destino = new File("C:/automanager/"+savee+"/temp");
        this.db.setText("temp");
        dbb = "temp";
        try {
            Automanager.copyAll(origem, destino, true);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedOperationException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void excluirtemp(File arq){
        if(arq.isDirectory()){
            File[] arquivos = arq.listFiles();
            for(int i=0;i<arquivos.length;i++){
               excluirtemp(arquivos[0]);
            }
         }
        arq.delete();
    }
    
    public void mousedrag(JFrame fram){
        frame = fram;
    }
    public void mousedragg(MouseEvent evt){
        Point p = frame.getLocation();
        frame.setLocation(p.x + evt.getX() - point.x, p.y + evt.getY() - point.y);
    }
        
    public void recebedados(String nome,String sexo,String db,int idequipe, String save) throws IOException{
        String dbb = db;
        nomee = nome;
        sexoo = sexo;
        idequipee = Integer.toString(idequipe);
        dbb = db;
        this.idequipe.setText(Integer.toString(idequipe));
        savee = save;
        txtChefe.setText(nome);
        imgEquipe.setIcon(Equipe.getImagem(dbb, idequipe, savee));
        int idp1 = Equipe.getIdP1(dbb, idequipe, savee);
        int idp2 = Equipe.getIdP2 (dbb, idequipe, savee);
        int idpa1 = Equipe.getIdPA1(dbb, idequipe, savee);
        int idpa2 = Equipe.getIdPA2(dbb, idequipe, savee);
        int idpa3 = Equipe.getIdPA3(dbb, idequipe, savee);
        imgPiloto1.setIcon(Piloto.getImagem(dbb, idp1,savee));
        txtP1.setText(Piloto.getLetraNome(dbb, idp1,savee)+Piloto.getSobrenome(dbb, idp1,savee));
        imgPiloto2.setIcon(Piloto.getImagem(dbb, idp2,savee));
        txtP2.setText(Piloto.getLetraNome(dbb, idp2,savee)+Piloto.getSobrenome(dbb, idp2,savee));
        imgPa1.setIcon(Patrocinio.getImagem(dbb, idpa1,savee));
        imgPa2.setIcon(Patrocinio.getImagem(dbb, idpa2,savee));
        imgPa3.setIcon(Patrocinio.getImagem(dbb, idpa3,savee));
        txtPa1.setText(Patrocinio.getNome(dbb, idpa1,savee));
        txtPa2.setText(Patrocinio.getNome(dbb, idpa2,savee));
        txtPa3.setText(Patrocinio.getNome(dbb, idpa3,savee));
        txtCaixa.setText(Equipe.getCaixa(dbb, idequipe, savee));
        
        int proxcorrida = 1;
        String proxicorrida = Integer.toString(proxcorrida);
        proximacorrida.setText(proxicorrida);
        txtGP.setText("Próxima Corrida: GP "+Corrida.baseP(dbb, proxicorrida, 1, savee)+" - "+Corrida.baseP(dbb, proxicorrida, 2,savee));
        txtGPinfo.setText(proxicorrida+"/"+Corrida.getTotalCorridas(dbb,savee)+" - "+Corrida.baseP(dbb, proxicorrida, 3,savee)+" Voltas");
        btnCorrida.setText("Viajar a "+Corrida.baseP(dbb, proxicorrida, 2,savee));
        txtBandeira.setIcon(Corrida.getBandeira(dbb, proxicorrida,savee));
        
        String idmotor = Motor.getId(dbb, idequipe, savee);
        txtMotor.setText(Motor.baseM(dbb, Integer.parseInt(idmotor), 1, savee));
        txtImagemMotor.setIcon(Motor.getImagemMotor(dbb, idequipe, savee));
        
        FileReader fr;
        fr = new FileReader("C:/automanager/"+savee+"/"+dbb+"/dbinfo.amdi");
        BufferedReader br = new BufferedReader(fr);
        String anoo = br.readLine();
        
        int dia = 1;
        String diastring = Integer.toString(dia);
        char[] diachar = diastring.toCharArray();
        if(diachar.length == 1){
            diastring = "0"+diastring;
        }
        int mes = 1;
        String messtring = Integer.toString(mes);
        char[] meschar = messtring.toCharArray();
        if(meschar.length == 1){
            messtring = "0"+messtring;
        }
        int ano = Integer.parseInt(anoo);
        txtData.setText(diastring+" / "+messtring+" / "+ano);
        
        setacores(dbb, idequipe);
        temp(dbb);
    }
    
    public void setacores(String db, int idequipe){
        try {
            String cor1 = Equipe.getCor1(db, idequipe, savee);
            cor = cor1;
            String cor2 = Equipe.getCor2(db, idequipe, savee);
            
            txtData.setBackground(Color.decode(cor2));
            jLabel2.setForeground(Color.decode(cor1));
            txtP1.setForeground(Color.decode(cor1));
            txtP2.setForeground(Color.decode(cor1));
            jLabel4.setForeground(Color.decode(cor1));
            txtPa1.setForeground(Color.decode(cor1));
            txtPa2.setForeground(Color.decode(cor1));
            txtPa3.setForeground(Color.decode(cor1));
            jLabel1.setForeground(Color.decode(cor1));
            txtMotor.setForeground(Color.decode(cor1));
            txtGP.setForeground(Color.decode(cor1));
            txtGPinfo.setForeground(Color.decode(cor1));
            btnCorrida.setBackground(Color.decode(cor1));
            jButton1.setBackground(Color.decode(cor1));
            //btnCorrida.setForeground(Color.decode(cor2));
            
            jButton2.setBackground(Color.decode(cor1));
            jPanel2.setBackground(Color.decode(cor1));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
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

        proximacorrida = new javax.swing.JTextField();
        db = new javax.swing.JTextField();
        idequipe = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnCorrida = new javax.swing.JButton();
        imgEquipe = new javax.swing.JLabel();
        imgPiloto1 = new javax.swing.JLabel();
        imgPiloto2 = new javax.swing.JLabel();
        txtChefe = new javax.swing.JLabel();
        txtP1 = new javax.swing.JLabel();
        txtP2 = new javax.swing.JLabel();
        imgPa1 = new javax.swing.JLabel();
        imgPa2 = new javax.swing.JLabel();
        imgPa3 = new javax.swing.JLabel();
        txtPa1 = new javax.swing.JLabel();
        txtPa2 = new javax.swing.JLabel();
        txtPa3 = new javax.swing.JLabel();
        txtCaixa = new javax.swing.JLabel();
        txtData = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtBandeira = new javax.swing.JLabel();
        txtGPinfo = new javax.swing.JLabel();
        txtGP = new javax.swing.JLabel();
        txtImagemMotor = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMotor = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        proximacorrida.setText("jTextField1");

        db.setText("jTextField1");

        idequipe.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBounds(new java.awt.Rectangle(2, 0, 0, 0));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
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

        btnCorrida.setBackground(new java.awt.Color(102, 102, 102));
        btnCorrida.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnCorrida.setForeground(new java.awt.Color(255, 255, 255));
        btnCorrida.setText("Viajar a Melbourne");
        btnCorrida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCorridaActionPerformed(evt);
            }
        });
        jPanel1.add(btnCorrida, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 360, 130, 40));

        imgEquipe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/equipe.png"))); // NOI18N
        jPanel1.add(imgEquipe, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        imgPiloto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/piloto1.png"))); // NOI18N
        jPanel1.add(imgPiloto1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        imgPiloto2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/piloto2.png"))); // NOI18N
        jPanel1.add(imgPiloto2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, -1, -1));

        txtChefe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtChefe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/chefe2.png"))); // NOI18N
        txtChefe.setText("Chefe");
        jPanel1.add(txtChefe, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, 218, 29));

        txtP1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtP1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtP1.setText("Piloto 1");
        jPanel1.add(txtP1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 245, 100, 30));

        txtP2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtP2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtP2.setText("Piloto 2");
        jPanel1.add(txtP2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 245, 100, 30));

        imgPa1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/p1.png"))); // NOI18N
        jPanel1.add(imgPa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 80, -1));

        imgPa2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/p2.png"))); // NOI18N
        jPanel1.add(imgPa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, -1, -1));

        imgPa3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/p3.png"))); // NOI18N
        jPanel1.add(imgPa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 300, 80, -1));

        txtPa1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPa1.setText("Patrocinio 1");
        jPanel1.add(txtPa1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 80, -1));

        txtPa2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPa2.setText("Patrocinio 2");
        jPanel1.add(txtPa2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 80, -1));

        txtPa3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtPa3.setText("Patrocinio 3");
        jPanel1.add(txtPa3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 390, 80, -1));

        txtCaixa.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCaixa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/novojogo/caixa2.png"))); // NOI18N
        txtCaixa.setText("R$ XXXX");
        jPanel1.add(txtCaixa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, -1, -1));

        txtData.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        txtData.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtData.setText("00 / 00 / 0000");
        jPanel1.add(txtData, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, 130, 30));

        jButton2.setBackground(new java.awt.Color(102, 102, 102));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/cancelar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("MOTOR");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 280, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("PILOTOS");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        txtBandeira.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/bcorrida.png"))); // NOI18N
        jPanel1.add(txtBandeira, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 330, -1, 70));

        txtGPinfo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtGPinfo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGPinfo.setText("1/21 - 58 VOLTAS");
        jPanel1.add(txtGPinfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 130, 30));

        txtGP.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtGP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtGP.setText("Próxima Corrida: GP Austrália - Melbourne");
        jPanel1.add(txtGP, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 300, 270, 30));

        txtImagemMotor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/principal/motor.png"))); // NOI18N
        jPanel1.add(txtImagemMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel4.setText("PATROCÍNIOS");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        txtMotor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txtMotor.setText("Motor");
        jPanel1.add(txtMotor, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 390, 80, -1));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SALVAR JOGO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(493, 10, 110, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 682, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCorridaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCorridaActionPerformed
        FimDeSemana fds = new FimDeSemana();
        fds.setVisible(true);
        fds.setLocationRelativeTo(null);
        setVisible(false);
        fds.frame(frame);
        fds.mousedrag(fds);
        try {
            fds.pegadados(db.getText(),Integer.parseInt(idequipe.getText()),proximacorrida.getText(),savee);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCorridaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File file = new File("C:/automanager/"+savee+"/temp");
        excluirtemp(file);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        point.x = evt.getX();
        point.y = evt.getY();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        mousedragg(evt);
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        InputSave input = new InputSave();
        input.mensagem("Digite um nome para salvar", cor);
        input.mousedrag(input);
        input.preparasave(nomee, sexoo, idequipee, dbb, "0");
        input.atualizadbparasave(frame);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnCorrida;
    private javax.swing.JTextField db;
    private javax.swing.JTextField idequipe;
    private javax.swing.JLabel imgEquipe;
    private javax.swing.JLabel imgPa1;
    private javax.swing.JLabel imgPa2;
    private javax.swing.JLabel imgPa3;
    private javax.swing.JLabel imgPiloto1;
    private javax.swing.JLabel imgPiloto2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField proximacorrida;
    private javax.swing.JLabel txtBandeira;
    private javax.swing.JLabel txtCaixa;
    private javax.swing.JLabel txtChefe;
    private javax.swing.JLabel txtData;
    private javax.swing.JLabel txtGP;
    private javax.swing.JLabel txtGPinfo;
    private javax.swing.JLabel txtImagemMotor;
    private javax.swing.JLabel txtMotor;
    private javax.swing.JLabel txtP1;
    private javax.swing.JLabel txtP2;
    private javax.swing.JLabel txtPa1;
    private javax.swing.JLabel txtPa2;
    private javax.swing.JLabel txtPa3;
    // End of variables declaration//GEN-END:variables
}
