package sistemadealunos.telas;

import sistemadealunos.entidades.Aluno;
import sistemadealunos.entidades.Disciplina;
import javax.swing.JOptionPane;
import sistemadealunos.conexao.AlunoDAO;
import sistemadealunos.conexao.CursoDAO;
import sistemadealunos.conexao.DisciplinaDAO;
import sistemadealunos.entidades.Curso;

public class SistemaDeAlunos {

    public static void cadastrarCurso() {
        String id = JOptionPane.showInputDialog("Informe Id do Curso");
        String nome = JOptionPane.showInputDialog("Informe nome do curso");
        Curso curso = new Curso(Integer.parseInt(id), nome);
        CursoDAO cursoDao = new CursoDAO();
        cursoDao.cadastrarNocvoCurso(curso);
    }

    public static void cadastrarDisciplina() {
        String id = JOptionPane.showInputDialog("Informe Id da Diciplina");
        String idCurso = JOptionPane.showInputDialog("Informe Id do Curso");
        String nome = JOptionPane.showInputDialog("Informe nome da Diciplina");
        Disciplina disciplina = new Disciplina(Integer.parseInt(id), Integer.parseInt(idCurso), nome);
        DisciplinaDAO disciplinaDao = new DisciplinaDAO();
        disciplinaDao.cadastrarNovaDisciplina(disciplina);
    }

    public static void cadastrarAluno() {
        String registroAluno = JOptionPane.showInputDialog("Informe Matricula do Aluno");
        String nomeAluno = JOptionPane.showInputDialog("Informe nome do Aluno");

        Aluno aluno = new Aluno(Integer.parseInt(registroAluno), nomeAluno);
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.cadastrarNovoAluno(aluno);
    }

    public static void cadastrarAlunoDisciplina() {
        String registroAluno = JOptionPane.showInputDialog("Informe Matricula do Aluno");
        String id = JOptionPane.showInputDialog("Informe Id da Diciplina");

        Aluno aluno1 = new Aluno(Integer.parseInt(registroAluno));
        Disciplina disciplina1 = new Disciplina(Integer.parseInt(id));

        AlunoDAO alunoDao1 = new AlunoDAO();
        alunoDao1.cadastrarDisciplina(aluno1, disciplina1);
    }

    public static void cadastrarNotasAluno() {
        String n1 = JOptionPane.showInputDialog("Informe Nota 1 do Aluno");
        String n2 = JOptionPane.showInputDialog("Informe Nota 2 do Aluno");
        String n3 = JOptionPane.showInputDialog("Informe Nota 3 do Aluno");

        String status = null;
        String registroAluno = JOptionPane.showInputDialog("Informe Matricula do Aluno");
        Aluno aluno2 = new Aluno(Float.parseFloat(n1), Float.parseFloat(n2), Float.parseFloat(n3),
                status, Integer.parseInt(registroAluno));

        if (aluno2.testaAprovacao() == true) {
            status = "Aprovado";
        } else {
            status = "Reprovado";
        }
        float media = aluno2.calcularMedia();
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.cadastrarNotas(aluno2);
    }

    public static void mostarInformacoes() {
        String registroAluno = JOptionPane.showInputDialog("Informe Matricula do Aluno");
        String idDisciplina = JOptionPane.showInputDialog("Informe Id da Diciplina");

        Aluno a = new Aluno(Integer.parseInt(registroAluno));
        Disciplina d = new Disciplina(Integer.parseInt(idDisciplina));
        AlunoDAO alunoDao = new AlunoDAO();
        alunoDao.mostarInformacoes(a, d);
    }

    public static void deletarAluno() {
        String idDisciplina = JOptionPane.showInputDialog("Informe Id da Diciplina");
        String registroAluno = JOptionPane.showInputDialog("Informe Matricula do Aluno");

        Aluno a = new Aluno(Integer.parseInt(registroAluno));
        Disciplina d = new Disciplina(Integer.parseInt(idDisciplina));
        AlunoDAO alunoDao = new AlunoDAO();

        alunoDao.deletarAlunoDisciplina(d);
        alunoDao.deletarAluno(a);
    }

    public static void main(String[] args) {

        int escolha1;
        String escolha;
        boolean sair = true;

        while (sair) {
            escolha = JOptionPane.showInputDialog("\n1- Cadastrar Curso \n2- Cadastrar Disciplina \n3- CadastrarAluno "
                    + "\n4- Matricular Aluno na Disciplina \n5- Cadastrar Notas aos Alunos \n6- Mostar Informações Alunos"
                    + "\n7- Deletar Aluno \n8- Sair");
            escolha1 = Integer.parseInt(escolha);

            switch (escolha1) {
                case 1:
                    //cadastrar curso
                    JOptionPane.showMessageDialog(null, "Cadastar Curso \n Id curso \nNome Curso");
                    cadastrarCurso();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 2:
                    //cadastrar disciplina
                    JOptionPane.showMessageDialog(null, "Cadastar Disciplina \nId Disciplina \nID Curso \nNome Disciplina");
                    cadastrarDisciplina();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 3:
                    //cadastrar aluno
                    JOptionPane.showMessageDialog(null, "Cadastar Aluno \nMatricula Aluno \nNome Aluno");
                    cadastrarAluno();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 4:
                    //cadastrar aluno na disciplina
                    JOptionPane.showMessageDialog(null, "Cadastar Aluno na Disciplina \nMatricula Aluno "
                            + "\nId Disciplina ");
                    cadastrarAlunoDisciplina();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 5:
                    //cadastrar notas
                    JOptionPane.showMessageDialog(null, "Cadastar Notas \nNota1 \nNota2 \nNota3 \nMatricula Aluno");
                    cadastrarNotasAluno();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 6:
                    //mostrar informações
                    JOptionPane.showMessageDialog(null, "Mostar Informações \nMatricula Aluno \nID Disciplina");
                    mostarInformacoes();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 7:
                    //deletar aluno
                    JOptionPane.showMessageDialog(null, "Deletar Aluno \nId Disciplina \nMatricula Aluno");
                    deletarAluno();
                    //escolha = JOptionPane.showInputDialog("Digite s para cadastrar novamente");
                    break;

                case 8:
                    sair = false;
                    break;
                    
                default:
                    JOptionPane.showMessageDialog(null, "Comando Inválido");
                    break;
            }
        }
    }
}
