package test;

import dao.UsuarioDao;
import java.sql.SQLException;
import usuarios.Usuario;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
 */

public class testUpdate {
     public static void main(String[] args) throws SQLException{
         //ready to record
         Usuario usuario = new Usuario();
         usuario.setLogin("nilok");
         usuario.setCpf("1238129731");
         usuario.setNome("nilo");
         usuario.setSenha("12345");
         usuario.setEmail("AAAAAAAAAAA@gmail.com");
         usuario.setTelefone("213123123");
         usuario.setCidade("Los Angeles");
         usuario.setEstado("California");
         
         UsuarioDao dao = new UsuarioDao();
         dao.altera(usuario);
         
         System.out.println("Recorded");
         
         
     }
}
