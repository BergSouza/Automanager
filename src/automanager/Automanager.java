/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package automanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import view.Inicio;
/**
 *
 * @author Bergson
 */
public class Automanager {
    
    
    public static void copy(File origem, File destino, boolean overwrite) throws IOException {
        if (destino.exists() && !overwrite) {
            return;
        }
        FileInputStream source = new FileInputStream(origem);
        FileOutputStream destination = new FileOutputStream(destino);
        FileChannel sourceFileChannel = source.getChannel();
        FileChannel destinationFileChannel = destination.getChannel();
        long size = sourceFileChannel.size();
        sourceFileChannel.transferTo(0, size, destinationFileChannel);
    }
    /**
     * Copia todos os arquivos que tenham uma determinada extensão de uma pasta de origem para outra de destino.
     * @param origem - Diretório onde estão os arquivos a serem copiados
     * @param destino - Diretório onde os arquivos serão copiados
     * @param extensao - <i>String</i> Extensão do arquivo que deve ser copiada. Você pode inserir a extensão no formato: ".doc" ou "doc" (por exemplo)
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException, UnsupportedOperationException
     */
    public static void copyAll(File origem, File destino, String extensao, boolean overwrite) throws IOException, UnsupportedOperationException {
        if (!destino.exists()) {
            destino.mkdir();
        }
        if (!origem.isDirectory()) {
            throw new UnsupportedOperationException("Origem deve ser um diretório");
        }
        if (!destino.isDirectory()) {
            throw new UnsupportedOperationException("Destino deve ser um diretório");
        }
        File[] files = origem.listFiles();
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory()) {
                copyAll(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
            } else {
                if (files[i].getName().endsWith(extensao)) {
                    copy(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
                }
            }
        }
    }
    /**
     * Copia todos os arquivos de dentro de uma pasta para outra.
     * @param origem - Diretório onde estão os arquivos a serem copiados
     * @param destino - Diretório onde os arquivos serão copiados
     * @param overwrite - Confirmação para sobrescrever os arquivos
     * @throws IOException, UnsupportedOperationException
     */
    public static void copyAll(File origem, File destino, boolean overwrite) throws IOException, UnsupportedOperationException {
        if (!destino.exists()) {
            destino.mkdir();
        }
        if (!origem.isDirectory()) {
            throw new UnsupportedOperationException("Origem deve ser um diretório");
        }
        if (!destino.isDirectory()) {
            throw new UnsupportedOperationException("Destino deve ser um diretório");
        }
        File[] files = origem.listFiles();
        for (int i = 0; i < files.length; ++i) {
            if (files[i].isDirectory()) {
                copyAll(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
            } else {
                System.out.println("Copiando arquivo: " + files[i].getName());
                copy(files[i], new File(destino + "\\" + files[i].getName()), overwrite);
            }
        }
    }
    /**
     * Copia arquivos de um local para o outro
     * *** Versão antiga - substitui esse método pelo uso da classe FileChannel - não sei ainda se é mais eficiente ***
     */
/*
    public static void copy_versaoantiga(File origem, File destino, boolean overwrite) throws IOException {
        if (destino.exists() && !overwrite) {
            return;
        }
        final int BUFFER_SIZE = 1 * 1024 * 1024;
        BufferedReader in = null;
        BufferedWriter out = null;
        try {
        in = new BufferedReader(new FileReader(origem), BUFFER_SIZE);
        out = new BufferedWriter(new FileWriter(destino), BUFFER_SIZE);
        String line;
        while ((line = in.readLine()) != null) {
        out.write(line);
        }
        } finally {
        if (in != null) {
        in.close();
        }
        if (out != null) {
        out.close();
        }
        }
    }
    */
    public static String getVersao(){
        String versao = "Pre-Alpha 0.0.3"; 
        return versao;
    }
   
   
    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        inicio.setVisible(true);
        inicio.setLocationRelativeTo(null);
        inicio.mousedrag(inicio);
    }
    
}
