/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula3.cidade;

import br.com.crescer.aula3.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CidadeDaoImpl implements CidadeDao {

    private static final String INSERT_CIDADE = "INSERT INTO CIDADE (ID, NOME, ESTADO) VALUES (?,?,?)";
    private static final String UPDATE_CIDADE = "UPDATE CIDADE SET NOME = ?, ESTADO = ? WHERE ID = ?";
    private static final String DELETE_CIDADE = "DELETE FROM CIDADE WHERE ID = ?";
    private static final String LOAD_CIDADE = "SELECT * FROM CIDADE WHERE ID = ?";

    @Override
    public void insert(Cidade cidade) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(INSERT_CIDADE)) {
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.setString(2, cidade.getNome());
            preparedStatement.setLong(3, cidade.getEstado());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(Cidade cidade) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(UPDATE_CIDADE)) {
            preparedStatement.setString(1, cidade.getNome());
            preparedStatement.setLong(2, cidade.getEstado());
            preparedStatement.setLong(3, cidade.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(Cidade cidade) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(DELETE_CIDADE)) {
            preparedStatement.setLong(1, cidade.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CidadeDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cidade loadBy(Long id) {
        final Cidade cidade = new Cidade();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.connect().prepareStatement(LOAD_CIDADE)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    cidade.setId(resultSet.getLong("ID"));
                    cidade.setNome(resultSet.getString("NOME"));
                    cidade.setEstado(resultSet.getLong("ESTADO"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return cidade;

    }

}
