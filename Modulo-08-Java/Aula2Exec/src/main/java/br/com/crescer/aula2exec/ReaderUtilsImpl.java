/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2exec;

import br.com.crescer.aula1exec.MeuStringUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReaderUtilsImpl implements ReaderUtils {

    @Override
    public String read(String string) {
        String retorno = "";
        if (new MeuStringUtils().isEmpty(string)) {
            retorno = "Arquivo nao existe";
        }
        if (!string.contains(".txt")) {
            retorno = "arquivo nao eh .txt";
        }
        File f = new File(string);

        if (!f.isFile()) {
            retorno = "arquivo nao encontrado";
        }

        try {
            final Reader reader = new FileReader(f);
            final BufferedReader bufferReader = new BufferedReader(reader);
            while (true) {
                String readLine = bufferReader.readLine();
                if (new MeuStringUtils().isEmpty(readLine)) {
                    break;
                }
                retorno = retorno + readLine + '\n';
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReaderUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return retorno;
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void main(String[] args) {
        ReaderUtils readerUtils = new ReaderUtilsImpl();
        System.out.println("Read: ");
        System.out.println(readerUtils.read("TestDir\\1.txt"));

    }

}
