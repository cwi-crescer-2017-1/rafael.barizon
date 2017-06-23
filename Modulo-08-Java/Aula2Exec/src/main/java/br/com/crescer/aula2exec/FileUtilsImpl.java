/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2exec;

import br.com.crescer.aula1exec.MeuStringUtils;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FileUtilsImpl implements FileUtils {

    @Override
    public boolean mk(String string) {
        //O método mk deve criar um arquivo ou diretório.
        if (new MeuStringUtils().isEmpty(string)) {
            return false;
        }

        try {
            File f = new File(string);
            boolean b = false;
            if (!f.exists()) {
                if (string.contains(".")) {
                    f.getParentFile().mkdirs(); 
                    b = f.createNewFile();
                    
                } else {
                    if(f.getParentFile() != null)
                        f.getParentFile().mkdirs(); 
                    b = f.mkdir();
                }
            }

            return b;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public boolean rm(String string) {
        //O método rm deve excluir o arquivo, caso for um diretório deve 
        //exibir uma mensagem que o arquivo é invalido.
        
        if(new MeuStringUtils().isEmpty(string)){
                return false;                
        }
        if(!string.contains(".")){
            try {
                throw new Exception();
            } catch (Exception ex) {
                Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return new File(string).delete();
    }

    @Override
    public String ls(String string) {
        if(new MeuStringUtils().isEmpty(string)){
                return "nao existe";                
        }
        File f = new File(string);
        return f.isDirectory()? Arrays.toString(new File(string+".").list()) : f.getAbsolutePath();
        //O método ls deve mostra o caminho absoluto, se for um diretório listar o nome dos arquivos internos.
        
    }

    @Override
    public boolean mv(String in, String out) {
        //O método mv deve mover o arquivo, caso for um diretório deve exibir uma mensagem que o arquivo é invalido.
        System.out.println("in "+ in);
        System.out.println("out " + out);
        if(!in.contains(".txt") || !out.contains(".txt"))
            System.out.println("entro pra da exception");
            try {
                throw new RuntimeException();
        } catch (RuntimeException ex) {
            Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File fIn = new File(in);
        if(fIn.exists()){
            System.out.println("Entro pra muda");
            File fOut = new File(out);
            return fIn.renameTo(fOut);
        }else{
            System.out.println("entro no lugar errado");
            try {
                throw new RuntimeException();
        } catch (RuntimeException ex) {
            Logger.getLogger(FileUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
            
        
        return false;
    }
    
//    public static void main(String[] args) {
//        FileUtils fileUtils = new FileUtilsImpl();
////        System.out.println("criar: " + fileUtils.mk("DIretorioNaoExistia\\1.txt"));
////        System.out.println("criar: " + fileUtils.mk("TestDir\\1.txt"));
////        System.out.println("criar: " + fileUtils.mk("TestDir1"));
////        System.out.println("criar: " + fileUtils.mk("TestDir\\dir\\outro2"));
////        System.out.println("listar: " + fileUtils.ls("TestDir"));
////        System.out.println("listar: " + fileUtils.ls("TestDir\\dir\\outro\\1.txt"));
//        System.out.println("mover: " + fileUtils.mv("TestDir\\1.txt", "TestDir\\dir\\1.txt"));
//        
//    }
    
}
