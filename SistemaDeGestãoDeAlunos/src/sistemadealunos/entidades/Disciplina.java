package sistemadealunos.entidades;

public class Disciplina {
    private int id;
    private int codCurso;
    private String nome;

    public Disciplina() {
    }

    public Disciplina(int id) {
        this.id = id;
    }

    
    
    public Disciplina(int id, int codCurso, String nome) {
        this.id = id;
        this.codCurso = codCurso;
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodCurso() {
        return codCurso;
    }

    public void setCodCurso(int codCurso) {
        this.codCurso = codCurso;
    }
}
