package act.arquivos.trabalholab.Dados;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private int horas;
    private int horasPorcentagem;
    List <Disciplina> disciplinas = new ArrayList<>();

    public Curso() {
    }

    public Curso(String nome, int horas, int horasPorcentagem) {
        this.nome = nome;
        this.horas = horas;
        this.horasPorcentagem = horasPorcentagem;

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

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }

    public void addDisciplinas(Disciplina disciplina){
        this.disciplinas.add(disciplina);
    }

    public int getHorasPorcentagem() {
        return horasPorcentagem;
    }

    public void setHorasPorcentagem(int horasPorcentagem) {
        this.horasPorcentagem = horasPorcentagem;
    }
}
