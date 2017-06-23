/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3;

import br.com.crescer.aula1exec.MeuStringUtils;
import static br.com.crescer.aula3.ConnectionUtils.connect;
import br.com.crescer.aula3.cidade.Cidade;
import br.com.crescer.aula3.cidade.CidadeDaoImpl;
import br.com.crescer.aula3.estado.Estado;
import br.com.crescer.aula3.estado.EstadoDaoImpl;
import br.com.crescer.aula3.pais.Pais;
import br.com.crescer.aula3.pais.PaisDaoImpl;
import br.com.crescer.aula3.pessoa.PessoaDaoImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLUtilsImpl implements SQLUtils {
    @Override
    public void runFile(String filename) {
        //Deve possuir um metodo que execute as instruções contidas dentro de um arquivo, o mesmo tem que ser um ".sql".
        if (filename.contains(".sql")) {
            File f = new File(filename);
            if (f.exists()) {
                try {
                    final Reader reader = new FileReader(f);
                    final BufferedReader bufferReader = new BufferedReader(reader);
                    
                     
                    String leitura= "";
                    
                    ArrayList<String> comandosSql = new ArrayList<>();
                    
                    while(true){
                        String linha =  bufferReader.readLine();
                        if(linha == null)
                            break;
                        leitura = leitura + linha;
                        if(leitura.contains(";")){
                            leitura = leitura.replace(";", "");
                            comandosSql.add(leitura);
                            leitura = "";
                        }
                    }
                    //System.out.println(leitura);
                    
                    try(final Connection connection = connect()){
                        PreparedStatement preparedStatement;
                        for (String s: comandosSql){
                            preparedStatement = connection.prepareStatement(s);
                            preparedStatement.executeUpdate();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    @Override
    public String executeQuery(String query) {
        //Deve receber uma instrução sql (query) e retorna uma tabela com o nome das colunas e linhas.
        String retorno = "";
        if(!new MeuStringUtils().isEmpty(query)){
            try(final Connection connection = connect()){
                ResultSet rs = connection.createStatement().executeQuery(query);
                int colQtd = rs.getMetaData().getColumnCount();
                while(rs.next()){
                    retorno = retorno + rs.getString(1);
                    for(int i = 2; i <= colQtd; i++){
                        retorno = retorno +"," + rs.getString(i);
                    }
                    retorno = retorno + System.getProperty("line.separator");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return retorno;
    }

    @Override
    public void importCSV(File file) {
        //Deve possuir um metodo onde possa ser importado um arquivo ".csv".
        
        if(file.isFile() && file.getAbsolutePath().contains(".csv")){
            
            try {
                final Reader reader = new FileReader(file);
                final BufferedReader bufferReader = new BufferedReader(reader);
                String[] cabecalho = bufferReader.readLine().split(",");
                int tipo;
                if(cabecalho.length == 3){
                    if(cabecalho[2]=="SIGLA"){
                        tipo = 1;
                    }
                    else {
                        tipo = 2;
                    }
                }else {
                    tipo = 3;
                }
                                
                while(true){
                    String linha = bufferReader.readLine();
                    if(linha == null){
                        break;
                    }
                    String[] row = linha.split(",");
                    switch (tipo) {
                        case 1:
                            Pais pais = new Pais();
                            pais.setId(Long.parseLong(row[0]));
                            pais.setNome(row[1]);
                            pais.setSigla(row[2]);
                            new PaisDaoImpl().insert(pais);
                            break;
                        case 2:
                            Cidade cidade = new Cidade();
                            cidade.setId(Long.parseLong(row[0]));
                            cidade.setNome(row[1]);
                            cidade.setEstado(Long.parseLong(row[2]));
                            new CidadeDaoImpl().insert(cidade);
                            break;
                        default:
                            Estado estado = new Estado();
                            estado.setId(Long.parseLong(row[0]));
                            estado.setNome(row[1]);
                            estado.setUf(row[2]);
                            estado.setPais(Long.parseLong(row[3]));
                            new EstadoDaoImpl().insert(estado);
                            break;
                    }
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public File importCSV(String query) {
        //Deve possuir um metodo onde possa ser exportado um arquivo ".csv".
        String retorno = executeQuery(query);
        File file = new File("export.csv");
        try {
            file.createNewFile();
            if(file.exists()){
                try (Writer writer = new FileWriter(file)) {
                    writer.append(retorno);
                    writer.flush();
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(SQLUtilsImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return file;
    }

    
    public static void main(String[] args){
        //String file = "C:\\Users\\rafael.barizon\\Documents\\sql.sql";
        SQLUtils t = new SQLUtilsImpl();
        //t.runFile(file);
        
        System.out.println(t.executeQuery("SELECT * FROM CIDADE WHERE ID = 3000"));  
        
        System.out.println("termino");
    }
}
