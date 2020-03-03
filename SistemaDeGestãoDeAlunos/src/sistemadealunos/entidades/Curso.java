
package sistemadealunos.entidades;

import java.util.Collection;

public class Curso {
    private int idCurso;
    private String nome;
    private Collection<Aluno> alunosCurso;
    private Collection<Disciplina> disciplinasCurso;

    public Curso(int idCurso) {
        this.idCurso = idCurso;
    }

    public Curso(int idCurso, String nome) {
        this.idCurso = idCurso;
        this.nome = nome;
    }
    
    public Curso(){
        
    }

    
    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Aluno> getAlunosCurso() {
        return alunosCurso;
    }

    public void setAlunosCurso(Collection<Aluno> alunosCurso) {
        this.alunosCurso = alunosCurso;
    }

    public Collection<Disciplina> getDisciplinasCurso() {
        return disciplinasCurso;
    }

    public void setDisciplinasCurso(Collection<Disciplina> disciplinasCurso) {
        this.disciplinasCurso = disciplinasCurso;
    }
    
    
    
    
}
