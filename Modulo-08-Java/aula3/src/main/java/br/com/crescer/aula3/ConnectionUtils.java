package br.com.crescer.aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author rafael.barizon
 */
public final class ConnectionUtils {

    static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    static final String USER = "JavaCrescer";
    static final String PASS = "JavaCrescer";

    private ConnectionUtils() {

    }
    
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }

}
