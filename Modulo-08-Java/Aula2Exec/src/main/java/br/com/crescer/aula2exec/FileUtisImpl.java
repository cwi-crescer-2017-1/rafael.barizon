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


public class FileUtisImpl implements FileUtis {

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
                System.out.println("Nao existe");
                if (string.contains(".")) {
                    f.getParentFile().mkdirs(); 
                    b = f.createNewFile();
                    
                } else {
                    b = f.mkdir();
                }
            }else System.out.println("ja Existe");

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
        File f = new File(string);
        
        return f.isDirectory()? false : f.delete();
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
        File fIn = new File(in);
        
        if(fIn.isFile()){
            File fOut = new File(out);
            return fIn.renameTo(fOut);
        }
        System.out.println("Arquivo invalido");
        return false;
    }
    
    public static void main(String[] args) {
        FileUtis fileUtils = new FileUtisImpl();
        //System.out.println("criar: " + fileUtils.mk("TestDir\\1.txt"));
        //System.out.println("criar: " + fileUtils.mk("TestDir\\dir"));
        System.out.println("criar: " + fileUtils.mk("TestDir\\dir\\outro2"));
        System.out.println("listar: " + fileUtils.ls("TestDir"));
        System.out.println("listar: " + fileUtils.ls("TestDir\\dir\\outro\\1.txt"));
        System.out.println("mover: " + fileUtils.mv("TestDir\\dir", "TestDir\\1.txt"));
        
    }
    
}
