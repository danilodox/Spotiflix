package test;

import dao.UsuarioDao;
import java.sql.SQLException;
import usuarios.Usuario;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
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
