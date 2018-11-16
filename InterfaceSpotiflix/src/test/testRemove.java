/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import dao.UsuarioDao;
import java.sql.SQLException;
import jdbc.Usuario;

/**
 *
 * @author danil
 */
public class testRemove {
    public static void main(String[] args) throws SQLException{
         UsuarioDao dao = new UsuarioDao();
         
         for(Usuario user: dao.getList()){
            if(user.getNome().equals("Peter Quill")){
                dao.remove(user);
            }
         }
         
         System.out.println("Removido");
    }
}
