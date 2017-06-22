package br.com.crescer.aula3;

import static br.com.crescer.aula3.ConnectionUtils.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.LongStream;

/**
 * @author rafael.barizon
 */
public class TesteDao {
    static final String DROP_TABLE = "DROP TABLE TESTE";
    static final String CREATE_TABLE = "CREATE TABLE TESTE ( \n"
                + "  ID NUMBER(8) NOT NULL,\n"
                + "  NOME VARCHAR2(60) DEFAULT NULL, \n"
                + "  CONSTRAINT TESTE_PK PRIMARY KEY (ID)  ENABLE \n"
                + ")";
    static final String INSERT_TESTE = " INSERT INTO TESTE (ID, NOME) VALUES (?,?)";
    
    public static void drop(Connection connection) throws SQLException {
        connection.createStatement().executeQuery(DROP_TABLE);
    }

    public static void create(Connection connection) throws SQLException {
        
        connection.createStatement().executeQuery(CREATE_TABLE);
    }

    public static void insert(Connection connection) throws SQLException {
        final PreparedStatement preparedStatement = connection.prepareStatement(INSERT_TESTE);
        final List<Long> list = LongStream.range(1, 1000).boxed().collect(toList());

        for (Long id : list) {
            preparedStatement.setLong(1, id);
            preparedStatement.setString(2, String.format("%s pessoa de 999", id));
            preparedStatement.executeUpdate();
        }
    }

    public static void main(String[] args) {

        try (final Connection connection = connect()) {
            // DROP
            drop(connection);
            // CREATE
            create(connection);
            // INSERT
            insert(connection);
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }
}
