/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.pessoa;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PessoaDaoImpl implements PessoaDao {

    private static final String INSERT_PESSOA = "INSERT INTO PESSOA (ID, NOME) VALUES (?,?)";
    private static final String UPDATE_PESSOA = "UPDATE PESSOA SET NOME = ? WHERE ID = ?";
    private static final String DELETE_PESSOA = "DELETE FROM PESSOA WHERE ID = ?";
    private static final String LOAD_PESSOA = "SELECT * FROM PESSOA WHERE ID = ?";
    @Override
    public void insert(Pessoa pessoa) {
        try(final PreparedStatement preparedStatement =
                  ConnectionUtils.connect().prepareStatement(INSERT_PESSOA)){
            
            preparedStatement.setLong(1, pessoa.getId());
            preparedStatement.setString(2, pessoa.getNome());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Pessoa pessoa) {
        try(final PreparedStatement preparedStatement =
                  ConnectionUtils.connect().prepareStatement(UPDATE_PESSOA)){
            
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setLong(2, pessoa.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        try(final PreparedStatement preparedStatement =
                  ConnectionUtils.connect().prepareStatement(DELETE_PESSOA)){
            
            preparedStatement.setLong(1, pessoa.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pessoa loadBy(Long id) {
        final Pessoa pessoa = new Pessoa();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(LOAD_PESSOA)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    pessoa.setId(resultSet.getLong("ID"));
                    pessoa.setNome(resultSet.getString("NOME"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pessoa;
    }
}
