/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula2exec;

import br.com.crescer.aula1exec.MeuStringUtils;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WriterUtilsImpl implements WriterUtils {

    @Override
    public void write(String file, String conteudo) {
        /*
O método write recebe o nome do arquivo e o conteúdo que deve ser gravado.
O arquivo deve ser apenas do tipo .txt, caso contrário exibir lançar um exception.
Caso não localize-o, então deve lançar um exception.
         */

        String retorno = "";
        if (new MeuStringUtils().isEmpty(conteudo)) {
            retorno = "Arquivo nao existe";
        } else if (!file.contains(".txt")) {
            retorno = "arquivo nao eh .txt";
        } else {
            File f = new File(file);
            if (!f.isFile()) {
                retorno = "arquivo nao encontrado";
            } else {
                BufferedWriter bufferWriter = null;
                try {
                    final Writer writer = new FileWriter(f, true);
                    bufferWriter = new BufferedWriter(writer);
                    bufferWriter.newLine();
                    bufferWriter.append(conteudo);
                    bufferWriter.flush();
                } catch (IOException ex) {
                    retorno = "nao foi possivel escrever";
                } finally {
                    try {
                        if (bufferWriter != null) {
                            bufferWriter.close();
                        }
                    } catch (Exception e) {
                        retorno = "nao foi possivel escrever";
                    }
                }
            }
        }
        if (!retorno.equals("")) {
            throw new UnsupportedOperationException(retorno);
        }

    }
    
    
    public static void main(String[] args) {
        ReaderUtils readerUtils = new ReaderUtilsImpl();
        System.out.println("Read: ");
        System.out.println(readerUtils.read("TestDir\\1.txt"));
        WriterUtils writerUtils = new WriterUtilsImpl();
        System.out.println("Write: ");
        writerUtils.write("TestDir\\1.txt", "new message");
        System.out.println("Read: ");
        System.out.println(readerUtils.read("TestDir\\1.txt"));
    }

}
