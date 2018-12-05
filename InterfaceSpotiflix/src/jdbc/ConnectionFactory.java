package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
 */

public class ConnectionFactory {
    private static final String URL = "jdbc:Mysql://localhost:3306/spotiflix?useTimezone=true&serverTimezone=UTC&useSSL=false";
    private static final String USER = "root";
    private static final String PASS = "12d21m95";
    
        public static Connection getConnection() {
          try {
              return DriverManager.getConnection(
                  URL,USER,PASS);
              } catch (SQLException e) {
             throw new RuntimeException(e);
             }
        }
        
        public static String getPass(){
            return PASS;
        }
        
}
