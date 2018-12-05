package test;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.ConnectionFactory;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
 */
public class testConnection {
    public static void main(String[] args) throws SQLException {
        
        
        try(Connection connection = new ConnectionFactory().getConnection()){
            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
