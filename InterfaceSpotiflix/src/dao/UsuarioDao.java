/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import jdbc.Usuario;

/**
 *
 * @author danil
 */
public class UsuarioDao {

    private Connection connection;

    public UsuarioDao() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public List<Usuario> getList() throws SQLException {
        try {
            List<Usuario> usuarios = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from usuario");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Usuario
                Usuario usuario = new Usuario();
                usuario.setLogin(rs.getString("login"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setCidade(rs.getString("cidade"));
                usuario.setEstado(rs.getString("estado"));
                usuarios.add(usuario);
            }
            rs.close();
            stmt.close();
            return usuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void adiciona(Usuario usuario) throws SQLException {
        String sql = "insert into usuario "
                + "(login, cpf, nome, senha, email, telefone, cidade, estado)"
                + "values (?,?,?,?,?,?,?,?)";

        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getCidade());
            stmt.setString(8, usuario.getEstado());

            //executa
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuario salvo com sucesso");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            throw new RuntimeException(e);
        }

    }

    public void remove(Usuario usuario) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete "
                    + "from usuario where nome=?");
            stmt.setString(1, usuario.getNome());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Usuario não pode ser deletado!");
            throw new RuntimeException(e);
        }
    }

    public void altera(Usuario usuario) {
        
        String sql = "update usuario set login=?, cpf=?," 
                + "nome=?, senha=?, email=?, telefone=?, cidade=?, estado=? where login=?";
        

        try {
            PreparedStatement stmt = connection
                    .prepareStatement(sql);
            stmt.setString(1, usuario.getLogin());
            stmt.setString(2, usuario.getCpf());
            stmt.setString(3, usuario.getNome());
            stmt.setString(4, usuario.getSenha());
            stmt.setString(5, usuario.getEmail());
            stmt.setString(6, usuario.getTelefone());
            stmt.setString(7, usuario.getCidade());
            stmt.setString(8, usuario.getEstado());
            stmt.setString(9, usuario.getLogin());
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            throw new RuntimeException(e);
        }
    }
}
