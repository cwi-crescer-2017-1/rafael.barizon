/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.pais;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PaisDaoImpl implements PaisDao {
    
    private static final String INSERT_PAIS = "INSERT INTO PAIS (ID, NOME, SIGLA) VALUES (?,?,?)";
    private static final String UPDATE_PAIS = "UPDATE PAIS SET NOME = ? , SIGLA = ? WHERE ID = ?";
    private static final String DELETE_PAIS = "DELETE FROM PAIS WHERE ID = ?";
    private static final String LOAD_PAIS = "SELECT * FROM PAIS WHERE ID = ?";

    @Override
    public void insert(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(INSERT_PAIS)) {
            preparedStatement.setLong(1, pais.getId());
            preparedStatement.setString(2, pais.getNome());
            preparedStatement.setString(3, pais.getSigla());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(UPDATE_PAIS)) {
            preparedStatement.setString(1, pais.getNome());
            preparedStatement.setString(2, pais.getSigla());
            preparedStatement.setLong(3, pais.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(DELETE_PAIS)) {
            preparedStatement.setLong(1, pais.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PaisDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Pais loadBy(Long id) {
        final Pais pais = new Pais();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(LOAD_PAIS)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    pais.setId(resultSet.getLong("ID"));
                    pais.setNome(resultSet.getString("NOME"));
                    pais.setSigla(resultSet.getString("SIGLA"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pais;

    }
}
