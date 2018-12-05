package test;

import dao.UsuarioDao;
import java.sql.SQLException;
import java.util.List;
import usuarios.Usuario;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
 */

public class testList {
    public static void main(String[] args) throws SQLException{
        UsuarioDao dao = new UsuarioDao();
        List<Usuario> usuarios = dao.getList();
        for (Usuario usuario : usuarios) {
            System.out.println("Login: " + usuario.getLogin());
            System.out.println("CPF: " + usuario.getCpf());
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Senha: " + usuario.getSenha());
            System.out.println("Email: " + usuario.getEmail());
            System.out.println("Telefone: " + usuario.getTelefone());
            System.out.println("Cidade: " + usuario.getCidade());
            System.out.println("Estado: " + usuario.getEstado());
            
        }
        
    }
}
