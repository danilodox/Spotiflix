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
public class testInsert {
     public static void main(String[] args) throws SQLException{
         //ready to record
         Usuario usuario = new Usuario();
         usuario.setLogin("lordStar");
         usuario.setCpf("10020101323");
         usuario.setNome("Peter Quill");
         usuario.setSenha("gamora");
         usuario.setEmail("senhordasestrelas@gmail.com");
         usuario.setTelefone("09823484835");
         usuario.setCidade("Los Angeles");
         usuario.setEstado("California");
         
         UsuarioDao dao = new UsuarioDao();
         dao.adiciona(usuario);
         
         System.out.println("Recorded");
         
         
     }
}
