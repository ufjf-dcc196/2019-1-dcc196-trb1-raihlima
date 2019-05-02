package act.arquivos.trabalholab.Dados;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nome;
    private int horas;
    private int horasPorcentagem;
    private int horasComputadas;
    private int getHorasComputadasPorcentagem;
    private List <Disciplina> disciplinas = new ArrayList<>();

    public Curso() {
    }

    public Curso(String nome, int horas, int horasPorcentagem) {
        this.nome = nome;
        this.horas = horas;
        this.horasPorcentagem = horasPorcentagem;
        this.horasComputadas =0;
        this.horasPorcentagem = 0;

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

    public int getHorasComputadas() {
        return horasComputadas;
    }

    public void setHorasComputadas(int horasComputadas) {
        this.horasComputadas = horasComputadas;
    }

    public int getGetHorasComputadasPorcentagem() {
        return getHorasComputadasPorcentagem;
    }

    public void setGetHorasComputadasPorcentagem(int getHorasComputadasPorcentagem) {
        this.getHorasComputadasPorcentagem = getHorasComputadasPorcentagem;
    }
}
