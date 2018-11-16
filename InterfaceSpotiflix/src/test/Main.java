/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.sql.Connection;
import java.sql.SQLException;
import jdbc.ConnectionFactory;

/**
 *
 * @author danil
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        
        
        try(Connection connection = new ConnectionFactory().getConnection()){
          
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}
