package act.arquivos.trabalholab.Dados;

public class Disciplina {
    private String nome;
    private int horas;
    private String curso;

    public Disciplina() {
    }

    public Disciplina(String nome, int horas, String curso) {
        this.nome = nome;
        this.horas = horas;
        this.curso = curso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
