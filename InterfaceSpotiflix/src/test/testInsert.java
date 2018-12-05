package test;

import dao.UsuarioDao;
import java.sql.SQLException;
import usuarios.Usuario;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
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
         usuario.setTelefone("19823484835");
         usuario.setCidade("Los Angeles");
         usuario.setEstado("California");
         
         UsuarioDao dao = new UsuarioDao();
         dao.adiciona(usuario);
         
         System.out.println("Recorded");
         
         
     }
}
