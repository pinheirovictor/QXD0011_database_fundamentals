
package sistemadealunos.entidades;
import java.util.ArrayList;
import java.util.Collection;

public class Aluno {
    private int registroAluno;
    private String nome;
    private float nota1;
    private float nota2;
    private float nota3;
    private float media;
    private String status;

    private Collection<Disciplina> disciplinas;

    public Aluno(int registroAluno) {
        this.registroAluno = registroAluno;
    }

    public Aluno(){
        
    }

    public Aluno(float nota1, float nota2, float nota3, String status, int registroAluno) {
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.status = status;
        this.registroAluno = registroAluno;
    }

    public Aluno(int registroAluno, String nome) {
        this.registroAluno = registroAluno;
        this.nome = nome;
     }
    
    
    public Collection<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(Collection<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
    
    public double getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }
    
    public int getRegistroAluno() {
        return registroAluno;
    }

    public void setRegistroAluno(int registroAluno) {
        this.registroAluno = registroAluno;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(float nota1) {
        this.nota1 = nota1;
    }

    public float getNota2() {
        return nota2;
    }

    public void setNota2(float nota2) {
        this.nota2 = nota2;
    }

    public float getNota3() {
        return nota3;
    }

    public void setNota3(float nota3) {
        this.nota3 = nota3;
    }
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public float calcularMedia(){
         media = (nota1+ nota2 + nota3) / 3;
         if(media >= 7)
             status = "Aprovado";
         else
             status = "Reprovado";
         return (float) media;
    }
    
    public void addDisciplina(Disciplina d){
        this.disciplinas.add(d);
    }
    
    public boolean testaAprovacao(){
        if(calcularMedia() >= 7)
            return true;
        return false;
    }
    
    
}
