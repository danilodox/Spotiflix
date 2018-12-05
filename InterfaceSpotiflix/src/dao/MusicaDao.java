package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import musicas.Musica;
import usuarios.Usuario;

/**
 *
 * @author Danilo
 * https://github.com/danilodox/Spotiflix
 */

public class MusicaDao {
    private Connection connection;

    public MusicaDao() {
        //cria a conexão
        this.connection = new ConnectionFactory().getConnection();
    }
    // método que retorna a lista de todos os usuarios inseridos
    public List<Musica> getList() throws SQLException {
        try {
            List<Musica> musicas = new ArrayList<>();
            PreparedStatement stmt = this.connection.prepareStatement("select * from musica");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                //criando o objeto Usuario
                Musica musica = new Musica();
                musica.setCod(rs.getInt("cod"));
                musica.setNomeCantor(rs.getString("nomeCantor"));
                musica.setNomeMusica(rs.getString("nomeMusica"));
                musica.setAno(rs.getInt("ano"));
                
                musicas.add(musica);
            }
            rs.close();
            stmt.close();
            return musicas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //método para adicionar usuários, passando como parâmetro um objeto do tipo Usuario
    public void adiciona(Musica musica) throws SQLException {
        String sql = "insert into musica "
                + "(cod, nomeCantor, nomeMusica, ano)"
                + "values (?,?,?,?)";

        try {
            //prepared statement para inserção
            PreparedStatement stmt = connection.prepareStatement(sql);

            // seta os valores
            stmt.setInt(1, musica.getCod());
            stmt.setString(2, musica.getNomeCantor());
            stmt.setString(3, musica.getNomeMusica());
            stmt.setInt(4, musica.getAno());
            
            //executa
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Musica salva com sucesso");
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            throw new RuntimeException(e);
        }

    }
    //método para remover o usuário
    public void remove(Musica musica) {
        try {
            PreparedStatement stmt = connection.prepareStatement("delete "
                    + "from musica where cod=?");
            stmt.setInt(1, musica.getCod());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Musica removida com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Musica não pode ser deletada!");
            throw new RuntimeException(e);
        }
    }
    
    //método para alterar os dados do usuário
    public void altera(Musica musica) {
        
        String sql = "update musica set cod=?, nomeCantor=?," 
                + "nomeMusica=?, ano=? where cod=?";
        

        try {
            PreparedStatement stmt = connection
                    .prepareStatement(sql);
            stmt.setInt(1, musica.getCod());
            stmt.setString(2, musica.getNomeCantor());
            stmt.setString(3, musica.getNomeMusica());
            stmt.setInt(4, musica.getAno());
            stmt.executeUpdate();
            stmt.close();
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar!");
            throw new RuntimeException(e);
        }
    }
}
