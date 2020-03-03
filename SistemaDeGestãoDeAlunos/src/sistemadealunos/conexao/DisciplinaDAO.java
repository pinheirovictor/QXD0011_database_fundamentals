
package sistemadealunos.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistemadealunos.entidades.Disciplina;

public class DisciplinaDAO {
    private Connection conection;
    Disciplina disciplina;

    public DisciplinaDAO(Connection conection, Disciplina disciplina) {
        this.conection = conection;
        this.disciplina = disciplina;
    }

    public DisciplinaDAO() {
    }
    
     public boolean cadastrarNovaDisciplina(Disciplina disciplina) {
        String sql = "INSERT INTO disciplina(id_disciplina,id_curso,nome_disciplina) VALUES (?, ?, ?)";
        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, disciplina.getId());
             stmt.setInt(2, disciplina.getCodCurso());
            stmt.setString(3, disciplina.getNome());
            
            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Diciplina Adicionado");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Essa Diciplina ja esta no Banco de Dados " +e);
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
