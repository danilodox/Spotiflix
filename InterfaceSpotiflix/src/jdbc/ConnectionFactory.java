/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author danil
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
}