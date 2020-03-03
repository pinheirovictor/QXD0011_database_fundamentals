package sistemadealunos.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistemadealunos.entidades.Curso;

public class CursoDAO {

    private Connection conection;
    Curso curso;

    public CursoDAO(){
        
    }
    
    public CursoDAO(Connection conection, Curso curso) {
        this.conection = conection;
        this.curso = curso;
    }
    
    
    public boolean cadastrarNocvoCurso(Curso curso) {
        String sql = "INSERT INTO curso(id_curso,nome_curso) VALUES (?, ?)";
        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, curso.getIdCurso());
            stmt.setString(2, curso.getNome());
            
            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Curso Adicionado");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse curso ja estar no Banco de Dados " +e);
        } finally {
            try {
                this.conection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
