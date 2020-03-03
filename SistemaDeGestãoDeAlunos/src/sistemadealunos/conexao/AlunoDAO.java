package sistemadealunos.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sistemadealunos.entidades.Aluno;
import sistemadealunos.entidades.Curso;
import sistemadealunos.entidades.Disciplina;

public class AlunoDAO {

    private Connection conection;
    Aluno aluno = new Aluno();
    Curso curso = new Curso();
    Disciplina disciplina = new Disciplina();

    public AlunoDAO(Connection conection) {
        this.conection = conection;
    }

    public AlunoDAO() {

    }

    public boolean cadastrarNovoAluno(Aluno aluno) {
        String sql = "INSERT INTO aluno(registro_aluno,nome_aluno) VALUES (?, ?)";
        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, aluno.getRegistroAluno());
            stmt.setString(2, aluno.getNome());

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno Adicionado");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao adicionar");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse aluno ja estar no Banco de Dados " + e);
        } finally {
            try {
                this.conection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean cadastrarDisciplina(Aluno aluno, Disciplina disciplina) {
        String sql = "INSERT INTO cursarDisciplina(registro_aluno, id_disciplina) VALUES (?, ?)";
        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, aluno.getRegistroAluno());
            stmt.setInt(2, disciplina.getId());

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Aluno Adicionado a Disciplina");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao adicionar na Disciplina");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse aluno nao esta no Banco de Dados " + e);
        } finally {
            try {
                this.conection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean cadastrarNotas(Aluno aluno) {
        String sql = "UPDATE aluno SET nota1 = ?, nota2 = ?, nota3 = ?, media = ?, status = ? WHERE registro_aluno = ?";
        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setFloat(1, (float) aluno.getNota1());
            stmt.setFloat(2, (float) aluno.getNota2());
            stmt.setFloat(3, (float) aluno.getNota3());
            stmt.setFloat(4, (float) aluno.calcularMedia());
            stmt.setString(5, aluno.getStatus());
            stmt.setInt(6, (int) aluno.getRegistroAluno());

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Notas Adicionada ao Aluno");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao adicionar Notas");
            return false;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Esse aluno nao esta no Banco de Dados " + e);
        } finally {
            try {
                this.conection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public void mostarInformacoes(Aluno aluno, Disciplina disciplina) {
        String sql = "select a.registro_aluno, a.nome_aluno, d.nome_disciplina, a.nota1, a.nota2, a.nota3, a.media, a.status "
                + "from aluno a, disciplina d, cursardisciplina cd where a.registro_aluno = ? and cd.id_disciplina = ? ";
        this.conection = new ConnectionFactory().getConnection();

        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            stmt.setInt(1, (int) aluno.getRegistroAluno());
            stmt.setInt(2, (int) disciplina.getId());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                do {
                    String str = null;
                    int registro_aluno = rs.getInt("registro_aluno");
                    String nomeAluno = rs.getString("nome_aluno");
                    String nomeDisciplina = rs.getString("nome_disciplina");
                    float n1 = rs.getFloat("nota1");
                    float n2 = rs.getFloat("nota2");
                    float n3 = rs.getFloat("nota3");
                    float media = rs.getFloat("media");
                    String status = rs.getString("status");

                    str = ("Matricula: " + registro_aluno + "\nNome: " + nomeAluno + "\nDisciplina: " + nomeDisciplina + " \n Ap1: " + n1
                            + " Ap2: " + n2 + " Ap3: " + n3 + "\nMedia: " + media + " Status: " + status);
                    JOptionPane.showMessageDialog(null, str);
                    //System.out.println(str);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "Erro || nao Encontrado");
                //System.out.println("Erro || nao Encontrado");
            }
            //Connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

public boolean deletarAlunoDisciplina(Disciplina disciplina) {
        String sql = "Delete from  cursardisciplina where id_disciplina = ?";
        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            
            stmt.setInt(1, disciplina.getId());

            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0) {
                //System.out.println("Aluno Removido");
                return true;
            }
            //System.out.println("Erro ao Remover, aluno nao encontrado no Banco");
            return false;
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            try {
                this.conection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    
    public boolean deletarAluno(Aluno aluno) {
        String sql = "Delete from  aluno where registro_aluno = ?";

        this.conection = new ConnectionFactory().getConnection();
        try {
            PreparedStatement stmt = conection.prepareStatement(sql);
            
            stmt.setInt(1, aluno.getRegistroAluno());
            
            int qtdRowsAffected = stmt.executeUpdate();
            stmt.close();
            if (qtdRowsAffected > 0 ) {
                JOptionPane.showMessageDialog(null, "Aluno Removido");
                return true;
            }
            JOptionPane.showMessageDialog(null, "Erro ao Remover, aluno nao encontrado no Banco");
            return false;
        } catch (SQLException e) {
            System.out.println(e);
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
